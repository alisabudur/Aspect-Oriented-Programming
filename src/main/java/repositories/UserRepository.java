package repositories;

import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alisa on 5/2/2017.
 */
public class UserRepository {

    public void save(User user) throws Exception {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DbConnection.openConnection();
            statement = connection.prepareStatement(
                    "INSERT INTO Users(Name) VALUES (?)");
            statement.setString(1, user.getName());

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

    public void update(User user) throws Exception {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = DbConnection.openConnection();
            statement = connection.prepareStatement(
                    "UPDATE Users SET Name = ?");
            statement.setString(1, user.getName());
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

    public List<User> findAll() throws Exception {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DbConnection.openConnection();

            String sql = "SELECT Id, Name FROM Users";
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            List<User> users = new ArrayList<>();
            while (result.next()) {
                User user = new User();
                user.setId(result.getInt("Id"));
                user.setName(result.getString("Name"));
                users.add(user);
            }
            return users;
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

    public User findOne(Integer id) throws Exception {

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = DbConnection.openConnection();

            String sql = "SELECT id, name FROM Users WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            User user = null;
            if (result.next()) {
                user = new User();
                user.setId(result.getInt("Id"));
                user.setName(result.getString("Name"));
            }
            return user;
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
        return new User();
    }
}
