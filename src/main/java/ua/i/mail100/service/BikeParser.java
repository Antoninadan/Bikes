package ua.i.mail100.service;

import ua.i.mail100.representative.BikeCollection;
import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;
import ua.i.mail100.model.MechanicBike;

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
            Integer weightInGrams = null;
            Boolean isLights = null;
            String color = parts[5].trim();
            Integer price = Integer.valueOf(parts[6].trim());

            if ((type == BikeType.SPEEDELEC) || (type == BikeType.E_BIKE)) {
                Integer speedMaxInKmInHour = Integer.valueOf(parts[1].trim());
                weightInGrams = Integer.valueOf(parts[2].trim());
                isLights = (parts[3].trim().equals("true")) ? true : false;
                Integer batteryCapacityInMAh = Integer.valueOf(parts[4].trim());
                result.append(new ElectroBike(type, brand, weightInGrams,
                        isLights, color, price, speedMaxInKmInHour, batteryCapacityInMAh));
            }
            if (type == BikeType.FOLDING_BIKE) {
                Integer wheelSizeInInch = Integer.valueOf(parts[1].trim());
                Integer gearNumber = Integer.valueOf(parts[2].trim());
                weightInGrams = Integer.valueOf(parts[3].trim());
                isLights = (parts[4].trim().equals("true")) ? true : false;
                result.append(new MechanicBike(type, brand, weightInGrams,
                        isLights, color, price, wheelSizeInInch, gearNumber));
            }
        }
        return result;
    }
}


