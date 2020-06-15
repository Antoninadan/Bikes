package ua.i.mail100.service.multisearch;

import lombok.AllArgsConstructor;
import ua.i.mail100.model.Bike;
import ua.i.mail100.representative.BikeCollection;
import ua.i.mail100.util.DivideUtil;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class MultiSearch {
    BikeCollection bikes;
    int parts;

    public Bike findOneSimilarTo(Bike criterion) {
        List<ThreadItem> threads = new ArrayList<>();
        Dispatcher dispatcher = new Dispatcher(threads);

        int size = bikes.getBikes().size();
        int[][] indexesOfParts = DivideUtil.getIndexesPerParts(size, parts);
        for (int i = 0; i < parts; i++) {
            ThreadItem threadItem = new ThreadItem(bikes.getSubCollection(indexesOfParts[i][0], indexesOfParts[i][1] + 1),
                    criterion, dispatcher);
            threads.add(threadItem);
        }
        threads.forEach(it -> it.start());
        return dispatcher.getResult();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = bikes.hashCode();
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = parts;
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
        MultiSearch other = (MultiSearch) obj;
        if (!bikes.equals(other.bikes)) return false;
        if (parts != other.parts) return false;
        return true;
    }

}
