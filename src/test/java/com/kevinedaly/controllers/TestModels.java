package com.kevinedaly.controllers;

import com.kevinedaly.models.Basket;
import com.kevinedaly.models.Shape;
import com.kevinedaly.models.Weight;

public class TestModels {

    public static Basket getPerfectBasket() {
        return Basket.builder("Perfect Variety",1)
                .addGift(Shape.Circle, Weight.FIFTY)
                .addGift(Shape.Square,Weight.ONEHUNDRED)
                .addGift(Shape.Triangle,Weight.ONEHUNDRED50)
                .addGift(Shape.Rectangle,Weight.TWOHUNDRED)
                .addGift(Shape.Oval,Weight.TWOHUNDRED50)
                .build();
    }

    public static Basket getWeightBasket() {
        return Basket.builder("Weight Variety",2)
                .addGift(Shape.Circle, Weight.FIFTY)
                .addGift(Shape.Circle,Weight.ONEHUNDRED)
                .addGift(Shape.Circle,Weight.ONEHUNDRED50)
                .addGift(Shape.Circle,Weight.TWOHUNDRED)
                .addGift(Shape.Circle,Weight.TWOHUNDRED50)
                .build();

    }

    public static Basket getShapeBasket() {
        return Basket.builder("Shape Variety",3)
                .addGift(Shape.Circle, Weight.FIFTY)
                .addGift(Shape.Square,Weight.FIFTY)
                .addGift(Shape.Triangle,Weight.FIFTY)
                .addGift(Shape.Rectangle,Weight.FIFTY)
                .addGift(Shape.Oval,Weight.FIFTY)
                .build();

    }
}
