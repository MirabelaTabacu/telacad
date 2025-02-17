import controller.ConnectionController;
import dao.UserDao;
import model.User;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ConnectionController controller = new ConnectionController();
        UserDao userDao = new UserDao(controller);
        Optional<User> user = userDao.getUserByCredentials("maria@yahoo.com", "1234");
        System.out.println(user.get());
    }
}