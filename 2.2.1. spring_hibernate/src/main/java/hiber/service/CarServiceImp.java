package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//В слое Service создал класс для управления бд cars
@Service
public class CarServiceImp implements CarService {

    private CarDao carDao;

    public CarServiceImp(){}

    @Autowired
    public CarServiceImp(CarDao carDao){
        this.carDao = carDao;
    }

    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    }
}
