package ua.i.mail100.service.multisearch;

import ua.i.mail100.model.Bike;
import ua.i.mail100.representative.BikeCollection;
import ua.i.mail100.service.LinearSearch;

public class ThreadItem extends Thread {
    BikeCollection bikes;
    //    List<Bike> bikes;
    Bike criterion;
    Bike result;
    Dispatcher dispatcher;

    //    public ThreadItemI( List<Bike> bikes, Bike criterion, DispatcherI dispatcher) {
    public ThreadItem(BikeCollection bikes, Bike criterion, Dispatcher dispatcher) {
        this.bikes = bikes;
        this.criterion = criterion;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
        LinearSearch linearSearch = new LinearSearch(bikes);

        result = linearSearch.findOneSimilarTo(criterion);
        if (result != null) {
            dispatcher.saveResult(result);
        }
    }
}

