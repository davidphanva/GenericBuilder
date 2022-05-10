package org.example.usage;

import org.example.builder.Initializer;

/**
 * This class is created to demonstrate how the Initializer interface can be implemented
 * to provide default values.
 */
public class CarDefault implements Initializer<Car> {

    @Override
    public void init(Car car) {

        car.numWheels = 4;
    }
}
