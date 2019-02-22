package com.kevinedaly.models;


public class Gift {
    private final Shape shape;
    private final Weight weight;

    public Gift(final Shape shape, final Weight weight) {
        this.shape = shape;
        this.weight = weight;
    }

    public Shape getShape() {
        return shape;
    }

    public Weight getWeight() {
        return weight;
    }
}
