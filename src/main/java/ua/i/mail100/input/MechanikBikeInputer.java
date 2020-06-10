package ua.i.mail100.input;

import ua.i.mail100.model.bikes.BikeType;
import ua.i.mail100.model.bikes.MechanicBike;

import java.io.IOException;

public class MechanikBikeInputer {

    public static MechanicBike inputFoldingBike() throws IOException {
        MechanicBike mechanicBike = input();
        mechanicBike.setType(BikeType.FOLDING_BIKE);
        return mechanicBike;
    }

    private static MechanicBike input() throws IOException {
        MechanicBike mechanicBike = null;
        String brand = new Inputer("Input brand", InputedType.STRING).input();
        Integer weightInGrams = new Inputer("Input weightInGrams", InputedType.INTEGER).input();
        Boolean isLights = new Inputer("Input isLights: true = 1, false = 0", InputedType.BOOLEAN).input();
        String color = new Inputer("Input color", InputedType.STRING).input();
        Integer price = new Inputer("Input price", InputedType.INTEGER).input();
        Integer wheelSizeInInch = new Inputer("Input wheelSizeInInch", InputedType.INTEGER).input();
        Integer gearNumber = new Inputer("Input gearNumber", InputedType.INTEGER).input();
        return new MechanicBike(null, brand, weightInGrams, isLights, color, price, wheelSizeInInch, gearNumber);
    }
}
