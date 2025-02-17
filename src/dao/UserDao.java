package dao;

import controller.ConnectionController;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDao {

    private Connection connection;
    private PreparedStatement getUserByCredentials;

    public UserDao(ConnectionController controller) {
        this.connection = controller.getConnection();

        try {
            getUserByCredentials = connection.prepareStatement("SELECT * FROM Users WHERE email = ?" +
                    " AND password = ?  ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> getUserByCredentials(String email, String password){
        try {
            getUserByCredentials.setString(1, email);
            getUserByCredentials.setString(2,password);
            ResultSet rs = getUserByCredentials.executeQuery();

            if(rs.next()){
                User user = new User(rs.getInt(1),
                                        rs.getString("LastName"),
                                        rs.getString("FirstName"),
                                        rs.getString("email"),
                                        rs.getString("password"));
                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();

    }

    //public boolean addUser(){}
    //public boolean signInUser(String email, String password){}
}
