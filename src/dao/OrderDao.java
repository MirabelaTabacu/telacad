package dao;

import controller.ConnectionController;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDao {
    private Connection connection;
    private PreparedStatement createOrderForUser;

    public OrderDao(ConnectionController controller) {
        this.connection = controller.getConnection();

        try {
            createOrderForUser = connection.prepareStatement(" INSERT INTO orders VALUES (?, ?, ?)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createOrder( int userID, Date orderDate ){
        //adaugati o comanda in baza de date si in trebuie adaugate si detaliile comenzii
        //
        return true;
    }


}
