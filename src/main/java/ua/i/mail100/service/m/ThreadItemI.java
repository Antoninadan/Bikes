package ua.i.mail100.service.m;

import ua.i.mail100.util.TimeFixUtil;

import java.util.List;

public class ThreadItemI extends Thread {
    List<Integer> list;
    Integer criterion;
    Integer result;
    DispatcherI dispatcherI;

    //    public ThreadItemI( List<Bike> list, Bike criterion, DispatcherI dispatcherI) {
    public ThreadItemI(List<Integer> list, Integer criterion, DispatcherI dispatcherI) {
        this.list = list;
        this.criterion = criterion;
        this.dispatcherI = dispatcherI;
    }

    @Override
    public void run() {
        TimeFixUtil timeFixUtil2 = new TimeFixUtil();


        LinearSearchI linearSearchI = new LinearSearchI(list);

        result = linearSearchI.findOneSimilarTo(criterion);
        if (result != null) {
            dispatcherI.saveResult(result);
        }

        timeFixUtil2.elapsedTimePrint();
    }
}

