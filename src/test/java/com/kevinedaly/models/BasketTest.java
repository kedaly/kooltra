package com.kevinedaly.models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class BasketTest {

    @Test(expected = IllegalArgumentException.class)
    public void compareLessThan5() {

        final Basket basket = Basket.builder("test",1)
                .addGift(Shape.Circle,Weight.FIFTY)
                .build();




    }

    @Test(expected = IllegalArgumentException.class)
    public void compareGreaterThan5() {

        final Basket basket = Basket.builder("test",1)
                .addGift(Shape.Circle,Weight.FIFTY)
                .addGift(Shape.Square,Weight.ONEHUNDRED50)
                .addGift(Shape.Triangle,Weight.TWOHUNDRED)
                .addGift(Shape.Oval,Weight.FIFTY)
                .addGift(Shape.Rectangle,Weight.FIFTY)
                .addGift(Shape.Oval,Weight.ONEHUNDRED)
                .build();
    }

    @Test
    public void testValidObject() {
        final Basket basket = Basket.builder("test",1)
                .addGift(Shape.Circle,Weight.FIFTY)
                .addGift(Shape.Square,Weight.ONEHUNDRED50)
                .addGift(Shape.Triangle,Weight.TWOHUNDRED)
                .addGift(Shape.Oval,Weight.FIFTY)
                .addGift(Shape.Rectangle,Weight.FIFTY)
                .build();
    }

    @Test
    public void testSort() {
        final List<Basket> baskets = new ArrayList<>();


        final Basket basket2 = Basket.builder("test2",2)
                .addGift(Shape.Circle,Weight.FIFTY)
                .addGift(Shape.Square,Weight.ONEHUNDRED50)
                .addGift(Shape.Triangle,Weight.TWOHUNDRED)
                .addGift(Shape.Oval,Weight.FIFTY)
                .addGift(Shape.Rectangle,Weight.FIFTY)
                .build();

        baskets.add(basket2);

        final Basket basket1 = Basket.builder("test1",1)
                .addGift(Shape.Circle,Weight.FIFTY)
                .addGift(Shape.Square,Weight.ONEHUNDRED50)
                .addGift(Shape.Triangle,Weight.TWOHUNDRED)
                .addGift(Shape.Oval,Weight.FIFTY)
                .addGift(Shape.Rectangle,Weight.FIFTY)
                .build();

        baskets.add(basket1);

        final Basket basket4 = Basket.builder("test4",4)
                .addGift(Shape.Circle,Weight.FIFTY)
                .addGift(Shape.Square,Weight.ONEHUNDRED50)
                .addGift(Shape.Triangle,Weight.TWOHUNDRED)
                .addGift(Shape.Oval,Weight.FIFTY)
                .addGift(Shape.Rectangle,Weight.FIFTY)
                .build();

        baskets.add(basket4);

        final Basket basket3 = Basket.builder("test3",3)
                .addGift(Shape.Circle,Weight.FIFTY)
                .addGift(Shape.Square,Weight.ONEHUNDRED50)
                .addGift(Shape.Triangle,Weight.TWOHUNDRED)
                .addGift(Shape.Oval,Weight.FIFTY)
                .addGift(Shape.Rectangle,Weight.FIFTY)
                .build();

        baskets.add(basket3);


        Collections.sort(baskets);

        assertEquals(baskets.get(0),basket1);
        assertEquals(baskets.get(1),basket2);
        assertEquals(baskets.get(2),basket3);
        assertEquals(baskets.get(3),basket4);


    }
}