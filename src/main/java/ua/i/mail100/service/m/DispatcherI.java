package ua.i.mail100.service.m;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class DispatcherI {
    private Integer result = null;
    private List<ThreadItemI> threads;
    private ReentrantLock locker;
    private Condition conditionFinishSearch;

    public DispatcherI(List<ThreadItemI> threads) {
        this.threads = threads;
        locker = new ReentrantLock();
        conditionFinishSearch = locker.newCondition();
    }

    public synchronized Integer saveResult(Integer searchedBike) {
        locker.lock();
        this.result = searchedBike;

        conditionFinishSearch.signalAll();
        locker.unlock();
        return result;
    }

    public Integer getResult() {
        locker.lock();
        try {
            while ((result == null && isRunningThreads())) {
                conditionFinishSearch.await();
            }
//            InterruptThread interruptThread = new InterruptThread(threads);
//            interruptThread.start();
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
