package ua.i.mail100.model.bikes;

import lombok.Data;

@Data
public class ElectroBike extends Bike{
    private Integer speedMaxInKmInHour;
    private Integer batteryCapacityInMAh;

    public ElectroBike(BikeType type, String brand, Integer weightInGrams, Boolean isLights, String color, Integer price, Integer speedMaxInKmInHour, Integer batteryCapacityInMAh) {
        super(type, brand, weightInGrams, isLights, color, price);
        this.speedMaxInKmInHour = speedMaxInKmInHour;
        this.batteryCapacityInMAh = batteryCapacityInMAh;
    }

    @Override
    public String toString() {
        String lightsInfo = (isLights != null) ? (isLights ? " and head/tail light" : " and no head/tail light") : "";
        String brandInfo = (brand != null) ? brand : "";
        String batteryCapacityInMAhInfo = (batteryCapacityInMAh != null) ? (" with " + batteryCapacityInMAh + " mAh battery") : "";
        String priceInfo = (price != null) ? ("Price: " + price + " euros.") : "";

        return type.toString() + " " +
                brandInfo +
                batteryCapacityInMAhInfo +
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
        temp = speedMaxInKmInHour;
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = batteryCapacityInMAh;
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
        ElectroBike other = (ElectroBike) obj;
        if (!type.equals(other.type)) return false;
        if (!brand.equals(other.brand)) return false;
        if (!speedMaxInKmInHour.equals(other.speedMaxInKmInHour)) return false;
        if (!batteryCapacityInMAh.equals(other.batteryCapacityInMAh)) return false;
        if (!weightInGrams.equals(other.weightInGrams)) return false;
        if (!isLights.equals(other.isLights)) return false;
        if (!color.equals(other.color)) return false;
        if (!price.equals(other.price)) return false;
        return true;
    }
}
