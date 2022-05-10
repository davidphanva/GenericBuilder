package org.example.usage;

public class BroncoDefault extends FordDefault {

    @Override
    public void init(Ford ford) {
        super.init(ford);

        ford.horsePower = 300;
        ford.modelName = "Bronco";
    }
}
