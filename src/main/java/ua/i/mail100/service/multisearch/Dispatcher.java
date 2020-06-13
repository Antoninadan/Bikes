package ua.i.mail100.service.multisearch;

import ua.i.mail100.model.Bike;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Dispatcher {
    private Bike result = null;
    private List<ThreadItem> threads;
    private ReentrantLock locker;
    private Condition conditionFinishSearch;

    public Dispatcher(List<ThreadItem> threads) {
        this.threads = threads;
        locker = new ReentrantLock();
        conditionFinishSearch = locker.newCondition();
    }

    public synchronized Bike saveResult(Bike searchedBike) {
        locker.lock();
        this.result = searchedBike;

        conditionFinishSearch.signalAll();
        locker.unlock();
        return result;
    }

    public Bike getResult() {
        locker.lock();
        try {
            while ((result == null && isRunningThreads())) {
                conditionFinishSearch.await();
            }
            threads.forEach(it -> it.interrupt());
            return result;
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
        return null;
    }

    private boolean isRunningThreads() {
        if (threads.stream().filter(thread -> (thread.isAlive()
                || thread.getState() == Thread.State.NEW
                || thread.isInterrupted())).
                collect(Collectors.toList()).size() > 0)
            return true;
        else return false;
    }
}
