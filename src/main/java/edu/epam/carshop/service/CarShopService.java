package edu.epam.carshop.service;

import edu.epam.carshop.dao.impl.ShopDaoImpl;
import edu.epam.carshop.entity.Brand;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CarShopService {

    private static final Logger logger = LogManager.getLogger(CarShopService.class);
    private static final ShopDaoImpl dao = new ShopDaoImpl();

    public List<Car> findAll() {
        List<Car> cars = null;
        try {
            cars = dao.findAll();
        } catch (DaoException e) {
            logger.error(e);
        }
        return cars;
    }

    public Car findById(Integer id) {
        Car car = null;
        try {
            car = dao.findEntityById(id);
        } catch (DaoException e) {
            logger.error(e);
        }
        return car;
    }

    public boolean createCar(Car car) {
        boolean isCreate = false;
        try {
            isCreate = dao.create(car);
        } catch (DaoException e) {
            logger.error(e);
        }
        return isCreate;
    }

    public boolean delete(Integer id) {
        boolean isDelete = false;
        try {
            isDelete = dao.delete(id);
        } catch (DaoException e) {
            logger.error(e);
        }
        return isDelete;
    }

    public Car update(Car car) {
        Car update = null;
        try {
            update = dao.update(car);
            logger.info("update car: " + update);
        } catch (DaoException e) {
            logger.error(e);
        }
        return update;
    }

    public List<Car> findByBrand(Brand brand) {
        List<Car> cars = null;
        try {
            cars = dao.findByBrand(brand);
        } catch (DaoException e) {
            logger.error(e);
        }
        return cars;
    }

    public List<Car> findByModelAndAge(String model, int age) {
        List<Car> cars = null;
        try {
            cars = dao.findByModelAndAge(model, age);
        } catch (DaoException e) {
            logger.error(e);
        }
        return cars;
    }

    public List<Car> findByPriceAndAge(Double price, int age) {
        List<Car> cars = null;
        try {
            cars = dao.findByPriceAndAge(price, age);
        } catch (DaoException e) {
            logger.error(e);
        }
        return cars;
    }
}
