package ua.i.mail100.service;

import ua.i.mail100.model.Bike;
import ua.i.mail100.representative.BikeCollection;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LinearSearch {
    private List<Bike> bikeList;

    public LinearSearch(BikeCollection bikes) {
        this.bikeList = bikes.getBikes();
    }

    public Bike findOneSimilarTo(Bike criterion) {
        Optional<Bike> bike = bikeList.stream()
                .filter(x -> (x.getType() == criterion.getType()))
                .filter(x -> x.similar(criterion)).findFirst();
        if (bike.isPresent()) {
            return bike.get();
        }
        return null;
    }

    public BikeCollection findAllSimilarTo(Bike criterion) {
        BikeCollection result = null;

        List<Bike> findedBikes = bikeList.stream()
                .filter(x -> (x.getType() == criterion.getType()))
                .filter(x -> x.similar(criterion))
                .collect(Collectors.toList());
        if (!bikeList.isEmpty()) result = new BikeCollection(findedBikes);

        return result;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = bikeList.hashCode();
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
        LinearSearch other = (LinearSearch) obj;
        if (!bikeList.equals(other.bikeList)) return false;
        return true;
    }
}

