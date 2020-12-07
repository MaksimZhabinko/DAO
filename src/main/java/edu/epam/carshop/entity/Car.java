package edu.epam.carshop.entity;

public class Car extends Entity {
    private int id;
    private Brand brand;
    private String model;
    private int yearOfManufactured;
    private Color color;
    private Double price;
    private String registerNumber;

    public Car() {
    }

    public Car(int id, Brand brand, String model, int yearOfManufactured, Color color, Double price, String registerNumber) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearOfManufactured = yearOfManufactured;
        this.color = color;
        this.price = price;
        this.registerNumber = registerNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfManufactured() {
        return yearOfManufactured;
    }

    public void setYearOfManufactured(int yearOfManufactured) {
        this.yearOfManufactured = yearOfManufactured;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (yearOfManufactured != car.yearOfManufactured) return false;
        if (brand != car.brand) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        if (color != car.color) return false;
        if (price != null ? !price.equals(car.price) : car.price != null) return false;
        return registerNumber != null ? registerNumber.equals(car.registerNumber) : car.registerNumber == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + yearOfManufactured;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (registerNumber != null ? registerNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("id=").append(id);
        sb.append(", brand=").append(brand);
        sb.append(", model='").append(model).append('\'');
        sb.append(", yearOfManufactured=").append(yearOfManufactured);
        sb.append(", color=").append(color);
        sb.append(", price=").append(price);
        sb.append(", registerNumber='").append(registerNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
