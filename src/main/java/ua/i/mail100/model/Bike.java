package ua.i.mail100.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Bike {
    protected BikeType type;
    protected String brand;
    protected Integer weightInGrams;
    protected Boolean isLights;
    protected String color;
    protected Integer price;

    public abstract String toStringForWrite();
    public abstract boolean similar(Bike bike);

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = type.hashCode();
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = brand.hashCode();
        result = prime * result + (int) (temp ^ (temp >>> 32));

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
        Bike other = (Bike) obj;
        if (!type.equals(other.type)) return false;
        if (!brand.equals(other.brand)) return false;

        if ((weightInGrams != null) && (!weightInGrams.equals(other.weightInGrams))) return false;
        if ((weightInGrams == null) && (other.weightInGrams != null)) return false;

        if ((isLights != null) && (!isLights.equals(other.isLights))) return false;
        if ((isLights == null) && (other.isLights != null)) return false;

        if (!color.equals(other.color)) return false;

        if ((price != null) && (!price.equals(other.price))) return false;
        if ((price == null) && (other.price != null)) return false;
        return true;
    }

}
