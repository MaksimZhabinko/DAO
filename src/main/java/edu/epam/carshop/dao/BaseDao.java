package edu.epam.carshop.dao;

import edu.epam.carshop.entity.Entity;

import java.util.List;

public interface BaseDao<T, K extends Entity> {
    List<K> findAll();
    K findEntityById(T t);
    boolean create(K k);
    boolean delete(Integer id);
    K update(K k);
}
