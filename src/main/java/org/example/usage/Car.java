package org.example.usage;

/**
 * This class is created for the sole purpose of demonstrating how to use
 * the GenericBuilder class and the Initializer interface.
 */
public abstract class Car {

    protected int numWheels;
    protected int horsePower;

    protected String brand;
    protected String modelName;

    public int numWheels() {
        return numWheels;
    }

    public void numWheels(int numWheels) {
        this.numWheels = numWheels;
    }

    public int horsePower() {
        return horsePower;
    }

    public void horsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String brand() {
        return brand;
    }

    public void brand(String brand) {
        this.brand = brand;
    }

    public String modelName() {
        return modelName;
    }

    public void modelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numWheels=" + numWheels +
                ", horsePower=" + horsePower +
                ", brand='" + brand + '\'' +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
