package edu.epam.carshop.service;

import edu.epam.carshop.dao.impl.ShopDaoImpl;
import edu.epam.carshop.entity.Brand;
import edu.epam.carshop.entity.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CarShopService {

    private static final Logger logger = LogManager.getLogger(CarShopService.class);
    private static final ShopDaoImpl dao = new ShopDaoImpl();

    public List<Car> readCarsFromFile(String path) {
        List<Car> cars = dao.readCarsFromFile(path);
        return cars;
    }

    public List<Car> findAll() {
        List<Car> cars = dao.findAll();
        return cars;
    }

    public Car findById(Integer id) {
        Car car = dao.findEntityById(id);
        return car;
    }

    public boolean createCar(Car car) {
        boolean isCreate = dao.create(car);
        return isCreate;
    }

    public boolean delete(Integer id) {
        boolean isDelete = dao.delete(id);
        return isDelete;
    }

    public Car update(Car car) {
        Car update = dao.update(car);
        logger.info("update car: " + update);
        return update;
    }

    public List<Car> findByBrand(Brand brand) {
        List<Car> currentCars = new ArrayList<>();
        List<Car> cars = dao.findAll();
        for (Car car : cars) {
            if (brand.equals(car.getBrand())) {
                currentCars.add(car);
            }
        }
        return currentCars;
    }

    public List<Car> findByModelAndAge(String model, int age) {
        List<Car> currentCars = new ArrayList<>();
        List<Car> cars = dao.findAll();
        for (Car car : cars) {
            if (model.equals(car.getModel()) && age == car.getYearOfManufactured()) {
                currentCars.add(car);
            }
        }
        return currentCars;
    }

    public List<Car> findByPriceAndAge(Double price, int age) {
        List<Car> currentCars = new ArrayList<>();
        List<Car> cars = dao.findAll();
        for (Car car : cars) {
            if (price.equals(car.getPrice()) && age == car.getYearOfManufactured()) {
                currentCars.add(car);
            }
        }
        return currentCars;
    }
}
