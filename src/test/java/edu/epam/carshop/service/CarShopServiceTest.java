package edu.epam.carshop.service;

import edu.epam.carshop.entity.Brand;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.entity.Color;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CarShopServiceTest {

    private static final CarShopService service = new CarShopService();
    private static final List<Car> expected = new ArrayList<>();
    private static final String PATH = "file/file";

    @BeforeClass
    public void init() {
        expected.add(new Car(15632, Brand.BMW, "X5",
                2018, Color.WHITE, 10000.0, "6959EX-7"));
        expected.add(new Car(23455, Brand.OPEL, "VECTRA",
                2000, Color.GREY, 1000.0, "3578HH-7"));
        expected.add(new Car(2145, Brand.AUDI, "A8",
                2015, Color.WHITE, 20000.0, "3856MM-7"));
        expected.add(new Car(46739, Brand.TOYOTA, "RAV4",
                2015, Color.GREEN, 13000.0, "5295PP-7"));
        expected.add(new Car(64832, Brand.BMW, "X5",
                2012, Color.BLUE, 10000.0, "9595TT-7"));
        expected.add(new Car(64832, Brand.BMW, "318",
                2004, Color.BLUE, 10000.0, "1234PE-7"));
        testReadCarsFromFile();
    }

    @Test
    public void testReadCarsFromFile() {
        List<Car> actual = service.readCarsFromFile(PATH);
        assertEquals(actual, expected);
    }

    @Test
    public void testFindAll() {
        List<Car> actual = service.findAll();
        assertEquals(actual, expected);
    }

    @Test
    public void testFindById() {
        Car actual = service.findById(2145);
        Car expected = new Car(2145, Brand.AUDI, "A8",
                2015, Color.WHITE, 20000.0, "3856MM-7");
        assertEquals(actual, expected);
    }

    @Test
    public void testCreateCar() {
        boolean condition = service.createCar(new Car(32, Brand.BMW, "X6", 2010,
                Color.BLACK, 10000.0, "3573EM-7"));
        assertTrue(condition);
    }

    @Test
    public void testDelete() {
        boolean condition = service.delete(32);
        assertTrue(condition);
    }

    @Test
    public void testUpdate() {
        Car expected = new Car(46739, Brand.OPEL, "VECTRA", 2000,
                Color.GREY, 1000.0, "2846PP-7");
        Car actual = service.update(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindByBrand() {
        List<Car> actual = service.findByBrand(Brand.BMW);
        List<Car> expected = new ArrayList<>();
        expected.add(new Car(15632, Brand.BMW, "X5",
                2018, Color.WHITE, 10000.0, "6959EX-7"));
        expected.add(new Car(64832, Brand.BMW, "X5",
                2012, Color.BLUE, 10000.0, "9595TT-7"));
        expected.add(new Car(64832, Brand.BMW, "318",
                2004, Color.BLUE, 10000.0, "1234PE-7"));
        assertEquals(actual, expected);
    }

    @Test
    public void testFindByModelAndAge() {
        List<Car> actual = service.findByModelAndAge("VECTRA", 2000);
        List<Car> expected = new ArrayList<>();
        expected.add(new Car(23455, Brand.OPEL, "VECTRA",
                2000, Color.GREY, 1000.0, "3578HH-7"));
        assertEquals(actual, expected);
    }

    @Test
    public void testFindByPriceAndAge() {
        List<Car> actual = service.findByPriceAndAge(10000.0, 2012);
        List<Car> expected = new ArrayList<>();
        expected.add(new Car(64832, Brand.BMW, "X5",
                2012, Color.BLUE, 10000.0, "9595TT-7"));
        assertEquals(actual, expected);
    }
}
