package edu.epam.carshop.dao;

import edu.epam.carshop.entity.Brand;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.exception.DaoException;

import java.util.List;

public interface ShopDao extends BaseDao<Integer, Car> {

    List<Car> findByBrand(Brand brand) throws DaoException;

    List<Car> findByModelAndAge(String model, int age) throws DaoException;

    List<Car> findByPriceAndAge(Double price, int age) throws DaoException;
}
