package edu.epam.carshop.entity;

import java.util.ArrayList;
import java.util.List;

public class CarShop {
    private static CarShop instance;
    private List<Car> cars;

    private CarShop() {
        cars = new ArrayList<>();
    }

    public static CarShop getInstance() {
        if (instance == null) {
            instance = new CarShop();
        }
        return instance;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Car getCar(long id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarShop carShop = (CarShop) o;

        return cars != null ? cars.equals(carShop.cars) : carShop.cars == null;
    }

    @Override
    public int hashCode() {
        return cars != null ? cars.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CarShop{");
        sb.append("cars=").append(cars);
        sb.append('}');
        return sb.toString();
    }
}
