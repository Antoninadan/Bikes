package ua.i.mail100.modelcontainer;

import lombok.Data;
import lombok.NoArgsConstructor;
import ua.i.mail100.model.Bike;
import ua.i.mail100.model.BikeType;

import java.util.*;


//TODO  delete from model
@Data
@NoArgsConstructor
public class BikeCollection {
    List<Bike> bikes = new ArrayList<>();
    HashSet<Bike> foldingBikeHashSet = new HashSet<>();
    HashSet<Bike> spedelecBikeHashSet = new HashSet<>();
    HashSet<Bike> eBikeHashSet = new HashSet<>();

    public BikeCollection(Collection<Bike> bikeCollection){
        bikeCollection.forEach(x -> this.append(x));
    }

    public Bike get(int index){
        return bikes.get(index);
    }

    public BikeCollection append(Bike bike){
        bikes.add(bike);
        if (bike.getType() == BikeType.FOLDING_BIKE) {foldingBikeHashSet.add(bike);}
        if (bike.getType() == BikeType.SPEEDELEC) {spedelecBikeHashSet.add(bike);}
        if (bike.getType() == BikeType.E_BIKE) {eBikeHashSet.add(bike);}
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

    public BikeCollection union(BikeCollection other){
        BikeCollection result = new BikeCollection();

        Set<Bike> set = new HashSet<>();
        set.addAll(this.bikes);
        set.addAll(other.getBikes());

         result.setBikes(new ArrayList<Bike>(set));
        return result;
    }

    public void clear(){
        bikes.clear();
    }

    // TODO https://habr.com/ru/post/267389/
    public List<BikeCollection> dividePerParts(int parts) {
        int size = bikes.size();
        int[][] indexesOfParts = getIndexesPerParts(size, parts);
        List<BikeCollection> result = new ArrayList<>();

        for (int i = 0; i < parts; i++) {
            BikeCollection temp = new BikeCollection();
            for (int j = indexesOfParts[i][0]; j <= indexesOfParts[i][1]; j++) {
                temp.append(this.get(j));
            }
            result.add(temp);
        }
        return result;
    }

    public List<BikeCollection> divideListPerRecords(int records) {
        int size = bikes.size();
        int div = (size%records != 0)? (size / records +1) : (size / records);
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


    public static int[][] getIndexesPerParts(int size, int parts) {
        int[][] result = new int[parts][2];
        int remains = getRemainsOfDividing(size, parts);
        int m = 0;

        for (int i = 1; i <= parts; i++) {
            if (m != (parts - 1)) {
                result[i - 1][0] = m * (size / parts);
                result[i - 1][1] = ((m + 1) * (size / parts) - 1);
            } else {
                result[i - 1][0] = m * (size / parts);
                result[i - 1][1] = (m + 1) * (size / parts) + remains - 1;
            }
            m++;
        }
        return result;
    }

    public static int getRemainsOfDividing(int size, int parts) {
        if (parts * (size / parts) == size) {
            return 0;
        } else {
            return size - parts * (size / parts);
        }
    }

}
