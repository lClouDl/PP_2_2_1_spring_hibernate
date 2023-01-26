package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

   //Создал метод, для поиска User по марке и серийному номеру его автомобиля
   User getUser(String model, int series);
}
