package ua.i.mail100.service.m;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class InterruptThread extends Thread{
    private List<ThreadItemI> threads;


    @Override
    public void run() {
        threads.forEach(it -> it.interrupt());
    }
}
