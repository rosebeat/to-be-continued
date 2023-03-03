package com.example.designpattern.observer.impl;

import com.example.designpattern.observer.Observer;
import com.example.designpattern.observer.Subject;

import java.util.HashSet;

/**
 * @author kai·yang
 * @Date 2023/3/3 11:32
 */
public class ConcreteSubject implements Subject {



    private HashSet<Observer> observers = new HashSet<>(16);

    @Override
    public void attach(Observer obs) {
        this.observers.add(obs);
    }

    @Override
    public void detach(Observer obs) {
        this.observers.remove(obs);
    }

    @Override
    public void sNotify() {

    }

    @Override
    public int getSate() {
        return 0;
    }

    @Override
    public void setSate(int state) {

    }
}
