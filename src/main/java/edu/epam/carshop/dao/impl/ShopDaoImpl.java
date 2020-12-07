package edu.epam.carshop.dao.impl;

import edu.epam.carshop.dao.ShopDao;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.entity.CarShop;
import edu.epam.carshop.exception.DaoException;
import edu.epam.carshop.reader.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ShopDaoImpl implements ShopDao {

    private static final Logger logger = LogManager.getLogger(ShopDaoImpl.class);
    private final CarShop carShop = CarShop.getInstance();

    @Override
    public List<Car> findAll() {
        List<Car> cars = carShop.getCars();
        logger.info("cars : " + cars);
        return cars;
    }

    @Override
    public Car findEntityById(Integer id) {
        Car car = carShop.getCar(id);
        logger.info("car : " + car);
        return car;
    }

    @Override
    public boolean create(Car car) {
        List<Car> cars = carShop.getCars();
        if (cars.contains(car)) {
            logger.error(new DaoException("the car exist"));
            return false;
        }
        carShop.addCar(car);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        List<Car> cars = carShop.getCars();
        for (Car car : cars) {
            if (car.getId() == id) {
                carShop.removeCar(car);
                logger.info("car delete: " + car);
                return true;
            }
        }
        return false;
    }

    @Override
    public Car update(Car car) {
        carShop.getCar(car.getId()).setBrand(car.getBrand());
        carShop.getCar(car.getId()).setModel(car.getModel());
        carShop.getCar(car.getId()).setYearOfManufactured(car.getYearOfManufactured());
        carShop.getCar(car.getId()).setColor(car.getColor());
        carShop.getCar(car.getId()).setPrice(car.getPrice());
        carShop.getCar(car.getId()).setRegisterNumber(car.getRegisterNumber());
        return carShop.getCar(car.getId());
    }

    @Override
    public List<Car> readCarsFromFile(String path) {
        DataReader reader = new DataReader();
        List<Car> cars = reader.readFile(path);
        carShop.setCars(cars);
        return cars;
    }
}
