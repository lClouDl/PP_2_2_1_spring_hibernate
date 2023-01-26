package hiber.service;

import hiber.model.Car;
//Создал интерфейс для CarServiceImp для реализации слабого связывания
public interface CarService {

    void add(Car car);
}
