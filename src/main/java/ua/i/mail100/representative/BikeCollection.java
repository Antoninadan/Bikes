package ua.i.mail100.representative;

import lombok.Data;
import lombok.NoArgsConstructor;
import ua.i.mail100.model.Bike;
import ua.i.mail100.model.BikeType;

import java.util.*;

@Data
@NoArgsConstructor
public class BikeCollection {
    private List<Bike> bikes = new ArrayList<>();
    private HashSet<Bike> foldingBikeHashSet = new HashSet<>();
    private HashSet<Bike> spedelecBikeHashSet = new HashSet<>();
    private HashSet<Bike> eBikeHashSet = new HashSet<>();

    public BikeCollection(Collection<Bike> bikeCollection) {
        bikeCollection.forEach(x -> this.append(x));
    }

    public Bike get(int index) {
        return bikes.get(index);
    }

    public BikeCollection append(Bike bike) {
        bikes.add(bike);
        if (bike.getType() == BikeType.FOLDING_BIKE) {
            foldingBikeHashSet.add(bike);
        }
        if (bike.getType() == BikeType.SPEEDELEC) {
            spedelecBikeHashSet.add(bike);
        }
        if (bike.getType() == BikeType.E_BIKE) {
            eBikeHashSet.add(bike);
        }
        return this;
    }

    public void print() {
        bikes.forEach(it -> System.out.println(it));
    }

    public List<String> getListForWrite() {
        List<String> result = new ArrayList<>();
        bikes.forEach(it -> result.add(it.toStringForWrite()));
        return result;
    }

    public BikeCollection union(BikeCollection other) {
        BikeCollection result = new BikeCollection();

        List<Bike> list = new ArrayList<>();
        list.addAll(this.bikes);
        list.addAll(other.getBikes());

        result.setBikes(new ArrayList<Bike>(list));
        return result;
    }

    public void clear() {
        bikes.clear();
    }

    public List<BikeCollection> divideListPerRecords(int records) {
        int size = bikes.size();
        int div = (size % records != 0) ? (size / records + 1) : (size / records);
        List<BikeCollection> result = new ArrayList<>();

        for (int i = 0; i < div; i++) {
            BikeCollection temp = new BikeCollection();
            for (int j = i * records; j < Math.min(size, i * records + records); j++) {
                temp.append(this.get(j));
            }
            result.add(temp);
        }
        return result;
    }
}


