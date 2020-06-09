package ua.i.mail100.model.bikes;

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
}
