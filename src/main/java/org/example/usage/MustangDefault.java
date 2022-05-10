package org.example.usage;

public class MustangDefault extends FordDefault {

    @Override
    public void init(Ford ford) {
        super.init(ford);

        // Add default values that are relevant to Mustang
        ford.horsePower = 500;
        ford.modelName = "Mustang";
    }
}
