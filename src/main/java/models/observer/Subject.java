package models.observer;

import models.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alisa on 3/15/2017.
 */
public abstract class Subject<TSubject> extends BaseEntity {
    protected List<Observer<TSubject>> observers;

    public Subject(){
        observers = new ArrayList<>();
    }

    public abstract void addObserver(Observer<TSubject> observer);

    public abstract void removeObserver(Observer<TSubject> observer);

    public abstract void notifyObservers();

    public List<Observer<TSubject>> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer<TSubject>> observers) {
        this.observers = observers;
    }
}
