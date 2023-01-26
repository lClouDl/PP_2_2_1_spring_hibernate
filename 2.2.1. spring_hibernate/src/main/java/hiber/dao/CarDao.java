package hiber.dao;

import hiber.model.Car;
//Создал интерфейс для CarDaoImp для реализации слабого связывания
public interface CarDao {
    void add(Car car);
}
