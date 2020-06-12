package ua.i.mail100.service;

import ua.i.mail100.model.Bike;
import ua.i.mail100.representative.BikeCollection;
import ua.i.mail100.model.BikeType;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchService {
    private BikeCollection bikes;

    public SearchService(BikeCollection bikes) {
        this.bikes = bikes;
    }

    public Bike findOneSimilarTo(Bike criterion) {
        HashSet<Bike> hashSet = new HashSet<>();
        if (criterion.getType() == BikeType.FOLDING_BIKE) {
            hashSet = new HashSet<Bike>(bikes.getFoldingBikeHashSet());
        }
        if (criterion.getType() == BikeType.SPEEDELEC) {
            hashSet = new HashSet<Bike>(bikes.getSpedelecBikeHashSet());
        }
        if (criterion.getType() == BikeType.E_BIKE) {
            hashSet = new HashSet<Bike>(bikes.getEBikeHashSet());
        }

        Optional<Bike> bike = hashSet.stream().filter(x -> x.similar(criterion)).findFirst();
        if (bike.isPresent()) {
            return bike.get();
        }
        return null;
    }

    public BikeCollection findAllSimilarTo(Bike criterion) {
        BikeCollection result = null;

        HashSet<Bike> hashSet = new HashSet<>();
        if (criterion.getType() == BikeType.FOLDING_BIKE) {
            hashSet = new HashSet<Bike>(bikes.getFoldingBikeHashSet());
        }
        if (criterion.getType() == BikeType.SPEEDELEC) {
            hashSet = new HashSet<Bike>(bikes.getSpedelecBikeHashSet());
        }
        if (criterion.getType() == BikeType.E_BIKE) {
            hashSet = new HashSet<Bike>(bikes.getEBikeHashSet());
        }

        List<Bike> bikeList = hashSet.stream().filter(x -> x.similar(criterion)).collect(Collectors.toList());
        if (!bikeList.isEmpty()) result = new BikeCollection(bikeList);

        return result;
    }
}
