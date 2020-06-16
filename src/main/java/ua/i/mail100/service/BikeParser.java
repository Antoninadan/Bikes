package ua.i.mail100.service;

import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;
import ua.i.mail100.model.MechanicBike;
import ua.i.mail100.representative.BikeCollection;

import java.util.List;

public class BikeParser {

    public static BikeCollection parse(List<String> strings) {
        BikeCollection result = new BikeCollection();
        BikeType type = null;

        for (String row : strings) {
            if (row.length() < 3) continue;
            String[] parts = row.split(";");

            for (BikeType bikeType : BikeType.values()) {
                if (parts[0].contains(bikeType.toString())) type = bikeType;
            }

            String brand = parts[0].substring(type.toString().length() + 1);
            String color = parts[5].trim();
            Integer price = null;
            String priceStr = parts[6].trim();
            if (!priceStr.equals("")) {
                price = Integer.valueOf(priceStr);
            }

            if ((type == BikeType.SPEEDELEC) || (type == BikeType.E_BIKE)) {
                ElectroBike bike = electroParse(parts);
                bike.setType(type);
                bike.setBrand(brand);
                bike.setColor(color);
                bike.setPrice(price);
                result.append(bike);
            }
            if (type == BikeType.FOLDING_BIKE) {
                MechanicBike bike = mechanicParse(parts);
                bike.setType(type);
                bike.setBrand(brand);
                bike.setColor(color);
                bike.setPrice(price);
                result.append(bike);
            }
        }
        return result;
    }

    private static ElectroBike electroParse(String[] parts) {
        Integer speedMaxInKmInHour = null;
        String speedMaxInKmInHourStr = parts[1].trim();
        if (!speedMaxInKmInHourStr.equals("")) {
            speedMaxInKmInHour = Integer.valueOf(speedMaxInKmInHourStr);
        }
        Integer weightInGrams = null;
        String weightInGramsStr = parts[2].trim();
        if (!weightInGramsStr.equals("")) {
            weightInGrams = Integer.valueOf(weightInGramsStr);
        }
        Boolean isLights = null;
        String lightStr = parts[3].trim();
        if (lightStr.equals("true")) {
            isLights = true;
        } else if (lightStr.equals("false")) {
            isLights = false;
        }
        Integer batteryCapacityInMAh = null;
        String batteryCapacityInMAhStr = parts[4].trim();
        if (!batteryCapacityInMAhStr.equals("")) {
            batteryCapacityInMAh = Integer.valueOf(batteryCapacityInMAhStr);
        }
        return new ElectroBike(null, null, weightInGrams,
                isLights, null, null, speedMaxInKmInHour, batteryCapacityInMAh);
    }

    private static MechanicBike mechanicParse(String[] parts) {
        Integer wheelSizeInInch = null;
        String wheelSizeInInchStr = parts[1].trim();
        if (!wheelSizeInInchStr.equals("")) {
            wheelSizeInInch = Integer.valueOf(wheelSizeInInchStr);
        }
        Integer gearNumber = null;
        String gearNumberStr = parts[2].trim();
        if (!gearNumberStr.equals("")) {
            gearNumber = Integer.valueOf(gearNumberStr);
        }
        Integer weightInGrams = null;
        String weightInGramsStr = parts[3].trim();
        if (!weightInGramsStr.equals("")) {
            weightInGrams = Integer.valueOf(weightInGramsStr);
        }
        Boolean isLights = null;
        String lightStr = parts[4].trim();
        if (lightStr.equals("true")) {
            isLights = true;
        } else if (lightStr.equals("false")) {
            isLights = false;
        }
        return new MechanicBike(null, null, weightInGrams,
                isLights, null, null, wheelSizeInInch, gearNumber);
    }
}

