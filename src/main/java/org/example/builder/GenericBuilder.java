package org.example.builder;


import java.util.function.BooleanSupplier;

public class GenericBuilder<T> {

    private T instance;
    private boolean condition = true;

    public static <T> GenericBuilder<T> builder(Class<T> clazz) {
        return new GenericBuilder<>(clazz);
    }

    public GenericBuilder(Class<T> clazz) {
        try {
            instance = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public GenericBuilder<T> with(Initializer<T> initializer) {
        if (condition) {
            initializer.init(instance);
        }

        return this;
    }

    public GenericBuilder<T> If(BooleanSupplier condition) {

        this.condition = condition.getAsBoolean();

        return this;
    }

    public GenericBuilder<T> endIf() {

        this.condition = true;

        return this;
    }

    public T build() {
        return instance;
    }
}
