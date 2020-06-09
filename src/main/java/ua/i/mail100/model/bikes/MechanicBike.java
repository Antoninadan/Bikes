package ua.i.mail100.model.bikes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MechanicBike extends Bike{
    private Integer wheelSizeInInch;
    private Integer gearNumber;

    public MechanicBike(BikeTypeEnum type, String brand, Integer weightInGrams, Boolean isLights, String color, Integer price, Integer wheelSizeInInch, Integer gearNumber) {
        super(type, brand, weightInGrams, isLights, color, price);
        this.wheelSizeInInch = wheelSizeInInch;
        this.gearNumber = gearNumber;
    }

    @Override
    public String toString() {
        String lightsInfo = (isLights != null) ? (isLights ? " and head/tail light" : " and no head/tail light") : "";
        String brandInfo = (brand != null) ? brand : "";
        String gearNumberInfo = (gearNumber != null) ? (" with " + gearNumber + " gear(s)") : "";
        String priceInfo = (price != null) ? ("Price: " + price + " euros.") : "";

        return type.toString() + " " +
                brandInfo +
                gearNumberInfo +
                lightsInfo +
                "." + "\n" +
                priceInfo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = type.hashCode();
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = brand.hashCode();
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = wheelSizeInInch;
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = gearNumber;
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = weightInGrams;
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = isLights.hashCode();
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = color.hashCode();
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = price;
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MechanicBike other = (MechanicBike) obj;
        if (!type.equals(other.type)) return false;
        if (!brand.equals(other.brand)) return false;
        if (!wheelSizeInInch.equals(other.wheelSizeInInch)) return false;
        if (!gearNumber.equals(other.gearNumber)) return false;
        if (!weightInGrams.equals(other.weightInGrams)) return false;
        if (!isLights.equals(other.isLights)) return false;
        if (!color.equals(other.color)) return false;
        if (!price.equals(other.price)) return false;
        return true;
    }
}
