package edu.epam.carshop.dao;

import edu.epam.carshop.entity.Entity;
import edu.epam.carshop.exception.DaoException;

import java.util.List;

public interface BaseDao<T, K extends Entity> {
    List<K> findAll() throws DaoException;
    K findEntityById(T t) throws DaoException;
    boolean create(K k) throws DaoException;
    boolean delete(Integer id) throws DaoException;
    K update(K k) throws DaoException;
}
