package ua.i.mail100.service.multisearch;

import ua.i.mail100.model.Bike;
import ua.i.mail100.representative.BikeCollection;
import ua.i.mail100.service.LinearSearch;

public class ThreadItem extends Thread {
    BikeCollection bikes;
    Bike criterion;
    Bike result;
    Dispatcher dispatcher;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = bikes.hashCode();
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = criterion.hashCode();
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = dispatcher.hashCode();
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
        ThreadItem other = (ThreadItem) obj;
        if (!bikes.equals(other.bikes)) return false;
        if (!criterion.equals(other.criterion)) return false;
        if (!dispatcher.equals(other.dispatcher)) return false;
        return true;
    }
}

