package org.example.usage;

import org.example.builder.GenericBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

/**
 * This class is created to demonstrate how the GenericBuilder class and the
 * Initializer interface are used to create objects from a type, without
 * having to create a Builder class for that type.
 */
public class FordFactory {

    public static void main(String[] args) {

        for (Ford ford : FordFactory.produce()) {

            System.out.println(ford);
        }
    }
    public static List<Ford> produce() {

        List<Ford> production = new ArrayList<>();

        // Create a GenericBuilder object for the type Ford
        GenericBuilder<Ford> fordBuilder = GenericBuilder.builder(Ford.class);

        // Create a Ford prototype, which does not have any default values
        // (not even wheels)
        Ford prototype = fordBuilder.build();
        production.add(prototype);

        fordBuilder = GenericBuilder.builder(Ford.class);
        // Create a Ford object, which has default values provided by the FordDefault
        // class.
        Ford escape = fordBuilder.with(new FordDefault())
                .build();
        production.add(escape);

        fordBuilder = GenericBuilder.builder(Ford.class);
        // Create a mid-tier Ford vehicle - a Bronco.  This demonstrates the use of
        // an Initializer implementation that is different from FordDefault.
        Ford bronco = fordBuilder.with(new BroncoDefault())
                .build();
        production.add(bronco);

        fordBuilder = GenericBuilder.builder(Ford.class);
        // Do we have to create a class for each Initializer to provide default
        // implementation?  No.
        // Create a special Ford vehicle - a Mustang.  This demonstrates the use of conditional
        // statement and lambda.
        BooleanSupplier premiumPrice = () -> false;
        Ford regularMustang = fordBuilder.with(new MustangDefault())
                .If(premiumPrice)
                .with(mustang -> mustang.horsePower = 1000)
                .endIf()
                .build();
        production.add(regularMustang);

        fordBuilder = GenericBuilder.builder(Ford.class);
        // Same code as above, but with a different condition.  This time a mustang will have
        // 1000 horse power
        premiumPrice = () -> true;
        Ford fastMustang = fordBuilder.with(new MustangDefault())
                .If(premiumPrice)
                .with(mustang -> mustang.horsePower = 1000)
                .endIf()
                .build();
        production.add(fastMustang);

        fordBuilder = GenericBuilder.builder(Ford.class);
        // What about other attributes?  If this is a builder does it provide "fluent" (chaining) pattern?
        Ford f150 = fordBuilder
                .with(ford -> ford.numWheels(6))
                .with(ford -> ford.modelName("F150"))
                .with(ford -> ford.horsePower(600))
                .with(ford -> ford.brand("Ford"))
                .with(ford -> ford.hasLeatherSeats(true))
                .with(ford -> ford.bedLength(4.0f))
                .build();
        production.add(f150);

        return production;
    }
}
