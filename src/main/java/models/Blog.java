package models;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Alisa on 3/13/2017.
 */
public class Blog {

    private Integer id;

    private String name;

    private Set<Comment> comments;

    private List<User> users;

    public Blog(Integer id, String name, Set<Comment> comments) {
        this.id = id;
        this.name = name;
        this.comments = comments;
        this.users = new ArrayList<>();
    }

    public Blog() {
        this.users = new ArrayList<>();
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

    @UpdateSubject
    public void addComment(Comment comment) {
        try {
            if (comments == null) {
                comments = new HashSet<>();
            }
            comment.setBlog(this);
            comments.add(comment);
//            notifyObservers();
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        users.remove(user);
    }
}
