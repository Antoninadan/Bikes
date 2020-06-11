package ua.i.mail100.input;

import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;

import java.io.IOException;

public class ElectroBikeInputer {

    public static ElectroBike inputEBike() throws IOException {
        ElectroBike electroBike = input();
        electroBike.setType(BikeType.E_BIKE);
        return electroBike;
    }

    public static ElectroBike inputSpeedelec() throws IOException {
        ElectroBike electroBike = input();
        electroBike.setType(BikeType.SPEEDELEC);
        return electroBike;
    }

    private static ElectroBike input() throws IOException {
        String brand = new Inputer("Input brand", InputedType.STRING).input();
        Integer weightInGrams = new Inputer("Input weightInGrams", InputedType.INTEGER).input();
        Boolean isLights = new Inputer("Input isLights: true=1, false=0", InputedType.BOOLEAN).input();
        String color = new Inputer("Input color", InputedType.STRING).input();
        Integer price = new Inputer("Input price", InputedType.INTEGER).input();
        Integer speedMaxInKmInHour = new Inputer("Input speedMaxInKmInHour", InputedType.INTEGER).input();
        Integer batteryCapacityInMAh = new Inputer("Input batteryCapacityInMAh", InputedType.INTEGER).input();
        return new ElectroBike(null, brand, weightInGrams, isLights,
                color, price, speedMaxInKmInHour, batteryCapacityInMAh);
    }
}
