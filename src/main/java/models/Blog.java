package models;

import models.observer.Observer;
import models.observer.Subject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alisa on 3/13/2017.
 */
public class Blog extends Subject<Blog> {

    private Integer id;

    private String name;

    private Set<Comment> comments;

    public Blog(Integer id, String name, Set<Comment> comments) {
        this.id = id;
        this.name = name;
        this.comments = comments;
    }

    public Blog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        try {
            if (comments == null) {
                comments = new HashSet<>();
            }
            comment.setBlog(this);
            comments.add(comment);
            notifyObservers();
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Override
    public void addObserver(Observer<Blog> observer) {
        try {
            observer.setSubject(this);
            observers.add(observer);
        }catch (Exception e){
            throw e;
        }finally {
        }
    }

    @Override
    public void removeObserver(Observer<Blog> observer) {
        try {
            observers.remove(observer);
        }catch (Exception e){
            throw e;
        }finally {
        }
    }

    @Override
    public void notifyObservers() {
        try{
            observers.forEach(blogObserver -> blogObserver.update(this));
        }
        catch (Exception e){
            throw e;
        }finally {
        }
    }
}
