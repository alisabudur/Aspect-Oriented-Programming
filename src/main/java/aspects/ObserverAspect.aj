package aspects;

import models.Blog;
import models.User;
import models.observer.Observer;
import models.observer.Subject;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Alisa on 5/3/2017.
 */
public aspect ObserverAspect {
//    declare parents:Blog implements Subject;
//    declare parents:User implements Observer;
//
//    pointcut toNotify(Blog blog):execution(@models.UpdateSubject * *(..)) && this(blog);
//    pointcut toAddObserver(Blog blog, User user):execution(* models.Blog.addUser(..)) && this(blog) && args(user);
//    pointcut tiRemoveObserver(Blog blog, User user):execution(* models.Blog.removeUser(..)) && this(blog) && args(user);
//
//    private List<Observer> Subject.observers = new ArrayList<>();
//
//    public void Subject.addObserver(Observer obs){
//        System.out.println("Adding observer");
//        observers.add(obs);
//    }
//    public void Subject.removeObserver(Observer obs){
//        System.out.println("Removing observer");
//        observers.remove(obs);
//
//    }
//    public void Subject.notifyObservers(Object o){
//        System.out.println("Notifying observers");
//        for(Observer ob:observers)
//            ob.update(o);
//    }
//
//    public void Observer.update(Object o){
//        System.out.println("Observer: update");
//    }
//
//    after(Blog blog) returning: toNotify(blog){
//        System.out.println("Subject: notifyObservers");
//        blog.notifyObservers(null);
//    }
//
//    after(Blog blog, User user): toAddObserver(blog, user){
//        System.out.println("Subject: add observer");
//        blog.addObserver(user);
//    }
//
//    after(Blog blog, User user): tiRemoveObserver(blog, user){
//        System.out.println("Subject: remove observer");
//        blog.removeObserver(user);
//    }
}
