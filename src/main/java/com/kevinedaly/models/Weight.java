package com.kevinedaly.models;

/**
 * Possible Weights that we can have
 */
public enum Weight {
    FIFTY(50),
    ONEHUNDRED(100),
    ONEHUNDRED50(150),
    TWOHUNDRED(200),
    TWOHUNDRED50(250);

    private final int weight;

    private Weight(final int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
