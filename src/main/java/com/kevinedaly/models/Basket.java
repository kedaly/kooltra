package com.kevinedaly.models;


import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Represents A Basket of 5 Items
 */
public class Basket implements Comparable<Basket> {
    private final List<Gift> giftList;
    private final String name;
    private final Integer preference;
    private final static Integer MAX_BASKET_ITEMS = 5;

    private Basket(final List<Gift> giftList, final String name, final Integer preference) {
        this.giftList = giftList;
        this.name = name;
        this.preference = preference;
    }

    @Override
    public int compareTo(final Basket basket) {
        return preference.compareTo(basket.getPreference());
    }

    public List<Gift> getGiftList() {
        return giftList;
    }

    public String getName() {
        return name;
    }

    public Integer getPreference() {
        return preference;
    }

    public int size() {
        return giftList.size();
    }

    public static BasketBuilder builder(final String name, final Integer preference) {
        return new BasketBuilder(name,preference);
    }

    public static class BasketBuilder {
        private Integer currentItems = 0;
        private final String name;
        private final Integer preference;
        private final ImmutableList.Builder<Gift> builder = ImmutableList.builder();

        public BasketBuilder(final String name, final Integer preference) {
            this.name = name;
            this.preference = preference;
        }

        public Basket build() {
            if (currentItems != MAX_BASKET_ITEMS) {
                throw new IllegalArgumentException("Need to have exactly "+MAX_BASKET_ITEMS+" baskets");
            }
            return new Basket(builder.build(),name,preference);
        }

        public BasketBuilder addGift(final Shape shape, final Weight weight) {
            currentItems++;
            if (currentItems > MAX_BASKET_ITEMS) {
                throw new IllegalArgumentException("Cannot have more than "+MAX_BASKET_ITEMS+" baskets");
            }
            builder.add(new Gift(shape,weight));
            return this;
        }
    }
}
