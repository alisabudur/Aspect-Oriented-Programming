package models.observer;

import lombok.Getter;
import lombok.Setter;
import models.BaseEntity;

/**
 * Created by Alisa on 3/15/2017.
 */
@Getter
@Setter
public abstract class Observer<TSubject> extends BaseEntity{
    protected TSubject subject;

    public abstract void update(TSubject subject);
}
