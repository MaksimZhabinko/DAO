package edu.epam.carshop.service;

import edu.epam.carshop.dao.impl.ShopDaoImpl;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class CarSortService {
    private static final Logger logger = LogManager.getLogger(CarSortService.class);
    private static final ShopDaoImpl dao = new ShopDaoImpl();

    public List<Car> sortByBrand() {
        List<Car> cars = null;
        try {
            cars = dao.findAll();
        } catch (DaoException e) {
            logger.error(e);
        }
        Comparator<Car> comparator = Comparator.comparing(el -> el.getBrand());
        cars.sort(comparator);
        logger.info("cars were sorted by brand: {}", cars);
        return cars;
    }

    public List<Car> sortById() {
        List<Car> cars = null;
        try {
            cars = dao.findAll();
        } catch (DaoException e) {
            logger.error(e);
        }
        Comparator<Car> comparator = Comparator.comparing(Car::getId);
        cars.sort(comparator);
        logger.info("cars were sorted by id: {}", cars);
        return cars;
    }

    public List<Car> sortByModel() {
        List<Car> cars = null;
        try {
            cars = dao.findAll();
        } catch (DaoException e) {
            logger.error(e);
        }
        Comparator<Car> comparator = Comparator.comparing(Car::getModel);
        cars.sort(comparator);
        logger.info("cars were sorted by model: {}", cars);
        return cars;
    }

    public List<Car> sortByPrice() {
        List<Car> cars = null;
        try {
            cars = dao.findAll();
        } catch (DaoException e) {
            logger.error(e);
        }
        Comparator<Car> comparator = Comparator.comparing(Car::getPrice);
        cars.sort(comparator);
        logger.info("cars were sorted by price: {}", cars);
        return cars;
    }

    public List<Car> sortByPriceAndBrand() {
        List<Car> cars = null;
        try {
            cars = dao.findAll();
        } catch (DaoException e) {
            logger.error(e);
        }
        Comparator<Car> comparator = Comparator.comparing(Car::getPrice).thenComparing(Car::getBrand);
        cars.sort(comparator);
        logger.info("cars were sorted by price and brand: {}", cars);
        return cars;
    }

    public List<Car> sortByYearOfManufactured() {
        List<Car> cars = null;
        try {
            cars = dao.findAll();
        } catch (DaoException e) {
            logger.error(e);
        }
        Comparator<Car> comparator = Comparator.comparing(Car::getYearOfManufactured);
        cars.sort(comparator);
        logger.info("cars were sorted by year Of Manufactured: {}", cars);
        return cars;
    }
}
