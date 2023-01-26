package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();

    //Добавил метод для поиска User по марке и серийному номеру его автомобиля
    User getUser(String model, int series);
}
