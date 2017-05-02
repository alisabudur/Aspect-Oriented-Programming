package repositories;

import models.Blog;
import models.Comment;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Alisa on 5/2/2017.
 */
public class BlogRepository {

    public void save(Blog blog) throws Exception {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DbConnection.openConnection();
            statement = connection.prepareStatement(
                    "INSERT INTO Blogs(Name) VALUES (?)");
            statement.setString(1, blog.getName());

            statement.executeUpdate();

            addComments(blog.getComments());

        } catch (SQLException e) {
            throw new Exception("Error occurred!", e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Blog blog) throws Exception {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = DbConnection.openConnection();
            statement = connection.prepareStatement(
                    "UPDATE Blogs SET Name = ?");
            statement.setString(1, blog.getName());
            statement.executeUpdate();

        } catch (SQLException e) {

            throw new Exception("Error occurred!", e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Blog> findAll() throws Exception {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DbConnection.openConnection();

            String sql = "SELECT Id, Name FROM Blogs";
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            List<Blog> blogs = new ArrayList<>();
            while (result.next()) {
                Blog blog = new Blog();
                blog.setId(result.getInt("Id"));
                blog.setName(result.getString("Name"));
                blogs.add(blog);
            }
            return blogs;
        } catch (SQLException e) {

            throw new Exception("Error occurred!", e);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Blog findOne(Integer id) throws Exception {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = DbConnection.openConnection();

            String sql = "SELECT id, name FROM Blogs WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();

            Blog blog = null;
            if (result.next()) {
                blog = new Blog();
                blog.setId(result.getInt("Id"));
                blog.setName(result.getString("Name"));
            }
            return blog;
        } catch (SQLException e) {
            throw new Exception("Error occurred!", e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new Blog();
    }

    private void addComments(Set<Comment> comments) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DbConnection.openConnection();
            for (Comment comment: comments) {
                statement = connection.prepareStatement(
                        "INSERT INTO Comments(CommentText, BlogId) VALUES (?, ?)");
                statement.setString(1, comment.getText());
                statement.setString(2, comment.getBlog().getId().toString());
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new Exception("Error occurred!", e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
