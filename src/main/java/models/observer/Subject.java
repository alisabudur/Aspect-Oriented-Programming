package models.observer;

import lombok.Getter;
import lombok.Setter;
import models.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alisa on 3/15/2017.
 */
@Getter
@Setter
public abstract class Subject<TSubject> extends BaseEntity {
    protected List<Observer<TSubject>> observers;

    public Subject(){
        observers = new ArrayList<>();
    }

    public abstract void addObserver(Observer<TSubject> observer);

    public abstract void removeObserver(Observer<TSubject> observer);

    public abstract void notifyObservers();
}
