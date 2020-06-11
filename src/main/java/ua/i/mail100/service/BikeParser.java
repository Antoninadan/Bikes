package ua.i.mail100.service;

import ua.i.mail100.modelcontainer.BikeCollection;
import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;
import ua.i.mail100.model.MechanicBike;

import java.util.List;

public class BikeParser {
    public static final String LINE_SEP = System.getProperty("line.separator");

    public static BikeCollection parse(List<String> strings) {
        BikeCollection result = new BikeCollection();
        BikeType type;
        String brand;
        Integer speedMaxInKmInHour;
        Integer batteryCapacityInMAh;
        Integer wheelSizeInInch;
        Integer gearNumber;
        Integer weightInGrams;
        Boolean isLights;
        String color;
        Integer price;

        for (String row : strings) {
            if (row.length() < 3) continue;
            String[] parts = row.split(";");

            type = parseBikeType(parts[0]);
            brand = parts[0].substring(type.toString().length() + 1);

            if ((type == BikeType.SPEEDELEC) || (type == BikeType.E_BIKE)) {
                speedMaxInKmInHour = Integer.valueOf(parts[1].trim());
                weightInGrams = Integer.valueOf(parts[2].trim());
                isLights = (parts[3].trim().equals("true")) ? true : false;
                batteryCapacityInMAh = Integer.valueOf(parts[4].trim());
                color = parts[5].trim();
                price = Integer.valueOf(parts[6].trim());
                result.append(new ElectroBike(type, brand, weightInGrams,
                        isLights, color, price, speedMaxInKmInHour, batteryCapacityInMAh));
            }
            if (type == BikeType.FOLDING_BIKE) {
                wheelSizeInInch = Integer.valueOf(parts[1].trim());
                gearNumber = Integer.valueOf(parts[2].trim());
                weightInGrams = Integer.valueOf(parts[3].trim());
                isLights = (parts[4].trim().equals("true")) ? true : false;
                color = parts[5].trim();
                price = Integer.valueOf(parts[6].trim());
                result.append(new MechanicBike(type, brand, weightInGrams,
                        isLights, color, price, wheelSizeInInch, gearNumber));
            }
        }
        return result;
    }


    private static BikeType parseBikeType(String part){
        int indexBrand = -1;
        for (BikeType bikeType : BikeType.values()) {
            indexBrand = part.indexOf(bikeType.toString());
            if (indexBrand == 0) {
                return bikeType;
            }
        }
        return null;
    }

}


