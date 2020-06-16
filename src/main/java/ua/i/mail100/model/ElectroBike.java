package ua.i.mail100.model;

import lombok.Data;
import ua.i.mail100.settings.Settings;

@Data
public class ElectroBike extends Bike {
    private Integer speedMaxInKmInHour;
    private Integer batteryCapacityInMAh;

    public ElectroBike(BikeType type, String brand, Integer weightInGrams, Boolean isLights, String color, Integer price, Integer speedMaxInKmInHour, Integer batteryCapacityInMAh) {
        super(type, brand, weightInGrams, isLights, color, price);
        this.speedMaxInKmInHour = speedMaxInKmInHour;
        this.batteryCapacityInMAh = batteryCapacityInMAh;
    }

    public String toString() {
        String lightsInfo = (isLights != null) ? (isLights ? " and head/tail light" : " and no head/tail light") : "";
        String brandInfo = (brand != null) ? brand : "";
        String batteryCapacityInMAhInfo = (batteryCapacityInMAh != null) ? (" with " + batteryCapacityInMAh + " mAh battery") : "";
        String priceInfo = (price != null) ? (Settings.LINE_SEP + "Price: " + price + " euros." ) : "";

        return type.toString() + " " +
                brandInfo +
                batteryCapacityInMAhInfo +
                lightsInfo +
                "." +
                priceInfo;
    }


    public String toStringForWrite() {
        String speedMaxInKmInHourStr = (speedMaxInKmInHour != null) ? (speedMaxInKmInHour.toString()) : "";
        String weightInGramsStr = (weightInGrams != null) ? (weightInGrams.toString()) : "";
        String isLightsStr = (isLights != null) ? (isLights.toString()) : "";
        String batteryCapacityInMAhStr = (batteryCapacityInMAh != null) ? (batteryCapacityInMAh.toString()) : "";
        String colorStr = (color != null) ? (color) : "";
        String priceStr = (price != null) ? (price.toString()) : "";

        return type.toString() + " " +
                brand + "; " +
                speedMaxInKmInHourStr + "; " +
                weightInGramsStr  + "; " +
                isLightsStr + "; " +
                batteryCapacityInMAhStr + "; " +
                colorStr + "; " +
                priceStr;
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
        if (speedMaxInKmInHour != null) {
            temp = speedMaxInKmInHour;
            result = prime * result + (int) (temp ^ (temp >>> 32));
        }
        if (batteryCapacityInMAh != null) {
            temp = batteryCapacityInMAh;
            result = prime * result + (int) (temp ^ (temp >>> 32));
        }
        if (weightInGrams != null) {
            temp = weightInGrams;
            result = prime * result + (int) (temp ^ (temp >>> 32));
        }
        if (isLights != null) {
            temp = isLights.hashCode();
            result = prime * result + (int) (temp ^ (temp >>> 32));
        }
        if (!color.isEmpty()) {
            temp = color.hashCode();
            result = prime * result + (int) (temp ^ (temp >>> 32));
        }
        if (price != null) {
            temp = price;
            result = prime * result + (int) (temp ^ (temp >>> 32));
        }
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

        if ((speedMaxInKmInHour != null) && (!speedMaxInKmInHour.equals(other.speedMaxInKmInHour))) return false;
        if ((speedMaxInKmInHour == null) && (other.speedMaxInKmInHour != null)) return false;

        if ((batteryCapacityInMAh != null) && (!batteryCapacityInMAh.equals(other.batteryCapacityInMAh))) return false;
        if ((batteryCapacityInMAh == null) && (other.batteryCapacityInMAh != null)) return false;

        if ((weightInGrams != null) && (!weightInGrams.equals(other.weightInGrams))) return false;
        if ((weightInGrams == null) && (other.weightInGrams != null)) return false;

        if ((isLights != null) && (!isLights.equals(other.isLights))) return false;
        if ((isLights == null) && (other.isLights != null)) return false;

        if (!color.equals(other.color)) return false;

        if ((price != null) && (!price.equals(other.price))) return false;
        if ((price == null) && (other.price != null)) return false;
        return true;
    }

    @Override
    public boolean similar(Bike bike) {
        if (this == bike)
            return true;
        if (bike == null)
            return false;
        if (getClass() != bike.getClass())
            return false;
        ElectroBike other = (ElectroBike) bike;
        if (!type.equals(other.type)) return false;
        if (!brand.equals(other.brand)) return false;
        if ((speedMaxInKmInHour != null)
                && (other.speedMaxInKmInHour != null)
                && (!speedMaxInKmInHour.equals(other.speedMaxInKmInHour))) return false;
        if ((batteryCapacityInMAh != null)
                && (other.batteryCapacityInMAh != null)
                && (!batteryCapacityInMAh.equals(other.batteryCapacityInMAh))) return false;
        if ((weightInGrams != null)
                && (other.weightInGrams != null)
                && (!weightInGrams.equals(other.weightInGrams))) return false;
        if ((isLights != null)
                && (other.isLights != null)
                && (!isLights.equals(other.isLights))) return false;
        if ((!color.isEmpty())
                && (!other.color.isEmpty())
                && (!color.equals(other.color))) return false;
        if ((price != null)
                && (other.price != null)
                && (!price.equals(other.price))) return false;
        return true;
    }
}
