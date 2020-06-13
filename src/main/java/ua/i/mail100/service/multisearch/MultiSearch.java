package ua.i.mail100.service.multisearch;

import lombok.AllArgsConstructor;
import ua.i.mail100.model.Bike;
import ua.i.mail100.util.DivideUtil;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class MultiSearch {
    List<Bike> bikes;
    int parts;

    public Bike findOneSimilarTo(Bike criterion) {
        List<ThreadItem> threads = new ArrayList<>();
        Dispatcher dispatcher = new Dispatcher(threads);

        int size = bikes.size();
        int[][] indexesOfParts = DivideUtil.getIndexesPerParts(size, parts);
        for (int i = 0; i < parts; i++) {
            ThreadItem threadItem = new ThreadItem(bikes.subList(indexesOfParts[i][0], indexesOfParts[i][1] + 1),
                    criterion, dispatcher);
            threads.add(threadItem);
        }
        threads.forEach(it -> it.start());
        return dispatcher.getResult();
    }

}
