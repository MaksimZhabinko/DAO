package edu.epam.carshop.reader;

import edu.epam.carshop.entity.Brand;
import edu.epam.carshop.entity.Car;
import edu.epam.carshop.entity.Color;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static final Logger logger = LogManager.getLogger(DataReader.class);

    public List<Car> readFile(String path) {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            while (line != null) {
                String[] strings = line.split(" ");
                int i = 0;
                Car car = new Car();
                car.setId(Integer.parseInt(strings[i++]));
                car.setBrand(Brand.valueOf(strings[i++]));
                car.setModel(strings[i++]);
                car.setYearOfManufactured(Integer.parseInt(strings[i++]));
                car.setColor(Color.valueOf(strings[i++]));
                car.setPrice(Double.parseDouble(strings[i++]));
                car.setRegisterNumber(strings[i]);
                cars.add(car);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            logger.error("File not found");
        } catch (IOException e) {
            logger.error("File input error occurred");
        }
        logger.info("Read cars from file: " + cars);
        return cars;
    }

}
