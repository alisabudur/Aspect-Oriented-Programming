package models;

/**
 * Created by Alisa on 3/13/2017.
 */
public class Comment{

    private Integer id;

    private String Text;

    private Blog blog;

    public Comment(Integer id, String text, Blog blog) {
        this.id = id;
        Text = text;
        this.blog = blog;
    }

    public Comment() {
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return Text;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        Text = text;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
