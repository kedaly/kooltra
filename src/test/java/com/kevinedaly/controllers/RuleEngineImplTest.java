package com.kevinedaly.controllers;

import com.kevinedaly.ruleengine.RuleEngine;
import junit.runner.BaseTestRunner;
import org.junit.Test;

import static org.junit.Assert.*;

public class RuleEngineImplTest {

    private final RuleEngineImpl engine = new RuleEngineImpl();

    @Test
    public void perfect() {

        final boolean isPerfect = engine.perfect().apply(TestModels.getPerfectBasket());

        assertTrue(isPerfect);


        final boolean isNotPerfect = engine.perfect().apply(TestModels.getWeightBasket());

        assertFalse(isNotPerfect);

    }

    @Test
    public void weight() {
        final boolean isWeight = engine.weight().apply(TestModels.getWeightBasket());

        assertTrue(isWeight);

        final boolean isNotWeight = engine.weight().apply(TestModels.getPerfectBasket());

        assertFalse(isNotWeight);

    }

    @Test
    public void shape() {
        final boolean isShape = engine.shape().apply(TestModels.getShapeBasket());

        assertTrue(isShape);

        final boolean isNotShape = engine.shape().apply(TestModels.getPerfectBasket());

        assertFalse(isNotShape);

    }

}