package ua.i.mail100.service.m;

import lombok.AllArgsConstructor;
import ua.i.mail100.model.Bike;
import ua.i.mail100.util.DivideUtil;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class MultiSearchI {
    List<Integer> list;
    int parts;

    public Integer findOneSimilarTo(Integer criterion) {
        List<ThreadItemI> threads = new ArrayList<>();
        DispatcherI dispatcherI = new DispatcherI(threads);

        int size = list.size();
        int[][] indexesOfParts = DivideUtil.getIndexesPerParts(size, parts);
        for (int i = 0; i < parts; i++) {
//            ThreadItemI threadItem = new ThreadItemI(list.subList(indexesOfParts[i][0], indexesOfParts[i][1] + 1),
//                    criterion, dispatcherI);
            ThreadItemI threadItem = new ThreadItemI(list.subList(indexesOfParts[i][0], indexesOfParts[i][1] + 1),
                    criterion, dispatcherI);
            threads.add(threadItem);
        }
        threads.forEach(it -> it.start());
        return dispatcherI.getResult();
    }

}
