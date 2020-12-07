package edu.epam.carshop.dao;

import edu.epam.carshop.entity.Car;

import java.util.List;

public interface ShopDao extends BaseDao<Integer, Car> {

    List<Car> readCarsFromFile(String path);
}
