package models.observer;

import models.BaseEntity;

/**
 * Created by Alisa on 3/15/2017.
 */
public abstract class Observer<TSubject> extends BaseEntity{
    protected TSubject subject;

    public abstract void update(TSubject subject);

    public TSubject getSubject() {
        return subject;
    }

    public void setSubject(TSubject subject) {
        this.subject = subject;
    }
}
