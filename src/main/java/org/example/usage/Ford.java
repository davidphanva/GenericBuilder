package org.example.usage;

/**
 * This class is created for the sole purpose of demonstrating how to use
 * the GenericBuilder class and the Initializer interface.
 */
public class Ford extends Car {

    private boolean hasLeatherSeats;

    private float bedLength;

    public boolean hasLeatherSeats() {
        return hasLeatherSeats;
    }

    public void hasLeatherSeats(boolean hasLeatherSeats) {
        this.hasLeatherSeats = hasLeatherSeats;
    }

    public float bedLength() {
        return bedLength;
    }

    public void bedLength(float bedLength) {
        this.bedLength = bedLength;
    }

    @Override
    public String toString() {
        return "Ford{" +
                "numWheels=" + numWheels +
                ", horsePower=" + horsePower +
                ", brand='" + brand + '\'' +
                ", modelName='" + modelName + '\'' +
                ", hasLeatherSeats=" + hasLeatherSeats +
                ", bedLength=" + bedLength +
                '}';
    }
}
