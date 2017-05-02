package models;

import models.observer.Observer;

import javax.persistence.*;

/**
 * Created by Alisa on 3/6/2017.
 */
public class User extends Observer<Blog> {

    private Integer id;

    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    @Override
    public void update(Blog blog) {
        try {
            subject.setComments(blog.getComments());
        } catch (Exception e) {
            throw e;
        } finally {
        }
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
