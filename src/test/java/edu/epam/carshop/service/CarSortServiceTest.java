package edu.epam.carshop.service;

import edu.epam.carshop.entity.Brand;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.entity.CarShop;
import edu.epam.carshop.entity.Color;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class CarSortServiceTest {

    private static final CarSortService service = new CarSortService();
    private static final List<Car> expected = new ArrayList<>();
    private static final CarShop carshop = CarShop.getInstance();
    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeMethod
    public void init() {
        car1 = new Car(0, Brand.OPEL, "vectra", 2000,
                Color.GREY, 1000.0, "6959EX-7");
        car2 = new Car(1, Brand.BMW, "X5", 2020,
                Color.BLACK, 30000.0, "5550HH-7");
        car3 = new Car(2, Brand.OPEL, "astra", 2004,
                Color.GREY, 1500.0, "5500PP-7");
        List<Car> cars = Arrays.asList(car1, car2, car3);
        carshop.setCars(cars);
    }

    @Test
    public void testSortByBrand() {
        List<Car> actual = service.sortByBrand();
        expected.add(car2);
        expected.add(car1);
        expected.add(car3);
        assertEquals(actual, expected);
    }

    @Test
    public void testSortById() {
        List<Car> actual = service.sortById();
        expected.add(car1);
        expected.add(car2);
        expected.add(car3);
        assertEquals(actual, expected);
    }

    @Test
    public void testSortByModel() {
        List<Car> actual = service.sortByModel();
        expected.add(car2);
        expected.add(car3);
        expected.add(car1);
        assertEquals(actual, expected);
    }

    @Test
    public void testSortByPrice() {
        List<Car> actual = service.sortByPrice();
        expected.add(car1);
        expected.add(car3);
        expected.add(car2);
        assertEquals(actual, expected);
    }

    @Test
    public void testSortByPriceAndBrand() {
        List<Car> actual = service.sortByPriceAndBrand();
        expected.add(car1);
        expected.add(car3);
        expected.add(car2);
        assertEquals(actual, expected);
    }

    @Test
    public void testSortByYearOfManufactured() {
        List<Car> actual = service.sortByYearOfManufactured();
        expected.add(car1);
        expected.add(car3);
        expected.add(car2);
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void clean() {
        expected.clear();
    }
}
