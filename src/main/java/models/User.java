package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import models.observer.Observer;

import javax.persistence.*;

/**
 * Created by Alisa on 3/6/2017.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Users")
public class User extends Observer<Blog> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Override
    public void update(Blog blog) {
        try {
            logger.info("started for blog " + blog.getName() + ".");
            subject.setComments(blog.getComments());
        } catch (Exception e) {
            logger.info("failed for blog " + blog.getName() + " " + e.getStackTrace().toString() + ".");
            throw e;
        } finally {
            logger.info("ended for blog " + blog.getName() + ".");
        }
    }

    @Override
    public String toString() {
        String str = "";
        str += "{";
        str += " name: " + name;
        str += "}";
        return str;
    }
}
