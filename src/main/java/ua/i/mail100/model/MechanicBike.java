package ua.i.mail100.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ua.i.mail100.settings.Settings;

@Data
@AllArgsConstructor
public class MechanicBike extends Bike {
    private Integer wheelSizeInInch;
    private Integer gearNumber;

    public MechanicBike(BikeType type, String brand, Integer weightInGrams, Boolean isLights, String color, Integer price, Integer wheelSizeInInch, Integer gearNumber) {
        super(type, brand, weightInGrams, isLights, color, price);
        this.wheelSizeInInch = wheelSizeInInch;
        this.gearNumber = gearNumber;
    }

    public String toString() {
        String lightsInfo = (isLights != null) ? (isLights ? " and head/tail light" : " and no head/tail light") : "";
        String brandInfo = (brand != null) ? brand : "";
        String gearNumberInfo = (gearNumber != null) ? (" with " + gearNumber + " gear(s)") : "";
        String priceInfo = (price != null) ? (Settings.LINE_SEP + "Price: " + price + " euros.") : "";

        return type.toString() + " " +
                brandInfo +
                gearNumberInfo +
                lightsInfo +
                "." +
                priceInfo;
    }

    public String toStringForWrite() {
        String wheelSizeInInchStr = (wheelSizeInInch != null) ? (wheelSizeInInch.toString()) : "";
        String gearNumberStr = (gearNumber != null) ? (gearNumber.toString()) : "";
        String weightInGramsStr = (weightInGrams != null) ? (weightInGrams.toString()) : "";
        String isLightsStr = (isLights != null) ? (isLights.toString()) : "";
        String colorStr = (color != null) ? (color) : "";
        String priceStr = (price != null) ? (price.toString()) : "";

        return type.toString() + " " +
                brand + "; " +
                wheelSizeInInchStr + "; " +
                gearNumberStr + "; " +
                weightInGramsStr + "; " +
                isLightsStr + "; " +
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
        if (wheelSizeInInch != null) {
            temp = wheelSizeInInch;
            result = prime * result + (int) (temp ^ (temp >>> 32));
        }
        if (gearNumber != null) {
            temp = gearNumber;
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
        MechanicBike other = (MechanicBike) obj;
        if (!type.equals(other.type)) return false;
        if (!brand.equals(other.brand)) return false;

        if ((wheelSizeInInch != null) && (!wheelSizeInInch.equals(other.wheelSizeInInch))) return false;
        if ((wheelSizeInInch == null) && (other.wheelSizeInInch != null)) return false;

        if ((gearNumber != null) && (!gearNumber.equals(other.gearNumber))) return false;
        if ((gearNumber == null) && (other.gearNumber != null)) return false;

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
        MechanicBike other = (MechanicBike) bike;
        if (!type.equals(other.type)) return false;
        if (!brand.equals(other.brand)) return false;
        if ((wheelSizeInInch != null)
                && (other.wheelSizeInInch != null)
                && (!wheelSizeInInch.equals(other.wheelSizeInInch))) return false;
        if ((gearNumber != null)
                && (other.gearNumber != null)
                && (!gearNumber.equals(other.gearNumber))) return false;
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
