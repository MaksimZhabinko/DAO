package edu.epam.carshop.dao.impl;

import edu.epam.carshop.dao.ShopDao;
import edu.epam.carshop.entity.Brand;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.entity.CarShop;
import edu.epam.carshop.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ShopDaoImpl implements ShopDao {

    private static final Logger logger = LogManager.getLogger(ShopDaoImpl.class);
    private final CarShop carShop = CarShop.getInstance();

    @Override
    public List<Car> findAll() throws DaoException {
        List<Car> cars = carShop.getCars();
        if (cars.size() == 0) {
            throw new DaoException("shop is empty");
        }
        logger.info("cars : " + cars);
        return cars;
    }

    @Override
    public Car findEntityById(Integer id) throws DaoException {
        Car car = carShop.getCar(id);
        if (car == null) {
            throw new DaoException("car not found");
        }
        logger.info("car : " + car);
        return car;
    }

    @Override
    public boolean create(Car car) throws DaoException {
        List<Car> cars = carShop.getCars();
        if (cars.contains(car)) {
            throw new DaoException("the car exist");
        }
        carShop.addCar(car);
        return true;
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        boolean flag = false;
        List<Car> cars = carShop.getCars();
        for (Car car : cars) {
            if (car.getId() == id) {
                carShop.removeCar(car);
                logger.info("car delete: " + car);
                flag = true;
            }
        }
        if (!flag) {
            throw new DaoException("This car in not found");
        }
        return flag;
    }

    @Override
    public Car update(Car car) throws DaoException {
        if (carShop.getCar(car.getId()) == null) {
            throw new DaoException("car not found");
        }
        carShop.getCar(car.getId()).setBrand(car.getBrand());
        carShop.getCar(car.getId()).setModel(car.getModel());
        carShop.getCar(car.getId()).setYearOfManufactured(car.getYearOfManufactured());
        carShop.getCar(car.getId()).setColor(car.getColor());
        carShop.getCar(car.getId()).setPrice(car.getPrice());
        carShop.getCar(car.getId()).setRegisterNumber(car.getRegisterNumber());
        return carShop.getCar(car.getId());
    }

    @Override
    public List<Car> findByBrand(Brand brand) throws DaoException {
        List<Car> currentCars = new ArrayList<>();
        List<Car> cars = carShop.getCars();
        if (cars.size() == 0) {
            throw new DaoException("shop is empty");
        }
        for (Car car : cars) {
            if (brand.equals(car.getBrand())) {
                currentCars.add(car);
            }
        }
        if (currentCars.size() == 0) {
            throw new DaoException("brand not found");
        }
        return currentCars;
    }

    @Override
    public List<Car> findByModelAndAge(String model, int age) throws DaoException {
        List<Car> currentCars = new ArrayList<>();
        List<Car> cars = carShop.getCars();
        if (cars.size() == 0) {
            throw new DaoException("shop is empty");
        }
        for (Car car : cars) {
            if (model.equals(car.getModel()) && age == car.getYearOfManufactured()) {
                currentCars.add(car);
            }
        }
        if (currentCars.size() == 0) {
            throw new DaoException("model and age not found");
        }
        return currentCars;
    }

    @Override
    public List<Car> findByPriceAndAge(Double price, int age) throws DaoException {
        List<Car> currentCars = new ArrayList<>();
        List<Car> cars = carShop.getCars();
        if (cars.size() == 0) {
            throw new DaoException("shop is empty");
        }
        for (Car car : cars) {
            if (price.equals(car.getPrice()) && age == car.getYearOfManufactured()) {
                currentCars.add(car);
            }
        }
        if (currentCars.size() == 0) {
            throw new DaoException("model and age not found");
        }
        return currentCars;
    }
}
