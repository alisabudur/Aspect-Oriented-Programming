package models;

import lombok.*;
import models.observer.Observer;
import models.observer.Subject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alisa on 3/13/2017.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Blogs")
public class Blog extends Subject<Blog> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "blog", cascade = CascadeType.ALL)
    private Set<Comment> comments;

    public void addComment(Comment comment) {
        try {
            logger.info("started for comment " + comment.getText() + ".");
            if (comments == null) {
                comments = new HashSet<>();
            }
            comment.setBlog(this);
            comments.add(comment);
            notifyObservers();
        } catch (Exception e) {
            logger.info("failed for comment " + comment.getText() + " " + e.getStackTrace() + ".");
            throw e;
        } finally {
            logger.info("ended for comment " + comment.getText() + ".");
        }
    }

    @Override
    public void addObserver(Observer<Blog> observer) {
        try {
            logger.info("started.");
            observer.setSubject(this);
            observers.add(observer);
        }catch (Exception e){
            logger.info("failed "+ e.getStackTrace() +".");
            throw e;
        }finally {
            logger.info("ended.");
        }
    }

    @Override
    public void removeObserver(Observer<Blog> observer) {
        try {
            logger.info("started.");
            observers.remove(observer);
        }catch (Exception e){
            logger.info("failed "+ e.getStackTrace() +".");
            throw e;
        }finally {
            logger.info("ended.");
        }
    }

    @Override
    public void notifyObservers() {
        try{
            logger.info("started.");
            observers.forEach(blogObserver -> blogObserver.update(this));
        }
        catch (Exception e){
            logger.info("failed "+ e.getStackTrace() +".");
            throw e;
        }finally {
            logger.info("ended.");
        }
    }
}
