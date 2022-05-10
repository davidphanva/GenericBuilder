package org.example.usage;

import org.example.builder.Initializer;

/**
 * This class is created to demonstrate how the Initializer interface can be implemented
 * to provide default values.
 */
public class FordDefault implements Initializer<Ford> {

    @Override
    public void init(Ford ford) {

        // First we need to give the CarDefault a chance to provide
        // default values to the Car part
        CarDefault carDefault = new CarDefault();
        carDefault.init(ford);

        // Now we can add default values to Ford objects
        ford.brand = "Ford";
        ford.horsePower = 200;
    }
}
