package ua.i.mail100.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import ua.i.mail100.model.Bike;
import ua.i.mail100.representative.BikeCollection;
import ua.i.mail100.model.BikeType;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class SetSearch {
    private BikeCollection bikes;

    public SetSearch(BikeCollection bikes) {
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

        List<Bike> findedBikes = hashSet.stream().filter(x -> x.similar(criterion)).collect(Collectors.toList());
        if (!findedBikes.isEmpty()) result = new BikeCollection(findedBikes);

        return result;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = bikes.hashCode();
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
        SetSearch other = (SetSearch) obj;
        if (!bikes.equals(other.bikes)) return false;
        return true;
    }
}
