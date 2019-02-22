package com.kevinedaly.controllers;

import com.google.common.collect.ImmutableList;
import com.kevinedaly.models.Basket;
import com.kevinedaly.models.Gift;
import com.kevinedaly.models.Shape;
import com.kevinedaly.models.Weight;
import com.kevinedaly.ruleengine.Rule;
import com.kevinedaly.ruleengine.RuleEngine;
import com.kevinedaly.ruleengine.RuleResult;

import javax.inject.Singleton;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * An implementation of a rule engine that is based on hard coded rules
 */
@Singleton
public class RuleEngineImpl implements RuleEngine {

    final List<Rule> matchers;

    public RuleEngineImpl() {
        this.matchers = init();
    }

    /**
     * Load all the hard coded rules
     * @return
     */
    private List<Rule> init() {
        final ImmutableList.Builder<Rule> builder = new ImmutableList.Builder<>();
        builder.add(new RuleImpl("Perfect Variety",1,perfect()));
        builder.add(new RuleImpl("Weight Variety",2,weight()));
        builder.add(new RuleImpl("Shape Variety",3,shape()));
        builder.add(new RuleImpl("Perfect Pairing",4,perfectPair()));
        builder.add(new RuleImpl("Shape Pairing",5,shapePairing()));
        builder.add(new RuleImpl("Discount",6,discount()));
        return builder.build();

    }

    @Override
    public List<RuleResult> match(final Basket basket) {
        return null;
    }

    @Override
    public RuleResult matchFirst(final Basket basket) {
        return null;
    }


    /**
     1: Perfect Variety:
     Example: 50g Square, 100g Circle, 150g Rectangle, 200g Triangle, 250g Oval
     Five gifts all with different weights and shapes.
     * @return
     */
    public Function<Basket,Boolean> perfect() {
        return (basket -> {
            final Set<Weight> weightsSeen = new HashSet<>();
            final Set<Shape> shapesSeen = new HashSet<>();
            basket.getGiftList().forEach( (it) -> {
                weightsSeen.add(it.getWeight());
                shapesSeen.add(it.getShape());
            });

            if ((weightsSeen.size() == basket.size()) && (shapesSeen.size() == basket.size())) {
                return true;
            } else {
                return false;
            }
        });

    }

    /**
     2: Weight Variety:
     Example: 50g Square, 100g Square, 150g Square, 200g Square, 250g Square
     Five gifts with different weights of the same shape.
     *
     * @return
     */
    public Function<Basket,Boolean> weight() {
        return (basket -> {

            //TODO: Break into an analyze function
            final Set<Weight> weightsSeen = new HashSet<>();
            final Set<Shape> shapesSeen = new HashSet<>();
            basket.getGiftList().forEach( (it) -> {
                weightsSeen.add(it.getWeight());
                shapesSeen.add(it.getShape());
            });
            if ((weightsSeen.size() == basket.size()) && (shapesSeen.size() == 1)) {
                return true;
            } else {
                return false;
            }

        });
    }

    /**
     *         3: Shape Variety:
     *         Example: 150g Square, 150g Circle, 150g Rectangle, 150g Triangle, 150g Oval
     *         Five gifts with different shapes of all the same weight.
     * @return
     */
    public Function<Basket,Boolean> shape() {
        return (basket -> {
            //TODO: Break into an analyze function
            final Set<Weight> weightsSeen = new HashSet<>();
            final Set<Shape> shapesSeen = new HashSet<>();
            basket.getGiftList().forEach( (it) -> {
                weightsSeen.add(it.getWeight());
                shapesSeen.add(it.getShape());
            });

            if ((weightsSeen.size() == 1) && (shapesSeen.size() == basket.size())) {
                return true;
            } else {
                return false;
            }
        });
    }

    /**
     4: Perfect Pairing:
     Example: 50g Square, 50g Square, 200g Circle, 200g Circle, 200g Circle
     Three gifts of one shape and two of another. Each with consistent weights.
     *
     * @return
     */
    public Function<Basket,Boolean> perfectPair() {
        return (basket -> {
            return false;
        });
    }

    /**
     5: Shape Pairing:
     Example: 150g Square, 50g Square, 50g Circle, 200g Circle, 200g Circle
     Three gifts of one shape and two of another but with different weights
     *
     * @return
     */
    public Function<Basket,Boolean> shapePairing() {
        return (basket -> {
            return false;
        });
    }

    /**
     6: Discount Basket:
     Example: 150g Square, 50g Triangle, 50g Rectangle, 200g Circle, 200g Circle
     A basket that doesn’t fall into the above categories
     *
     * @return
     */
    public Function<Basket,Boolean> discount() {
        return (basket -> {
            return false;
        });
    }


    public class RuleImpl implements Rule {
        private final String name;
        private final Integer rank;
        private final Function<Basket,Boolean> matchFunction;

        public RuleImpl(final String name, final Integer rank, final Function<Basket, Boolean> matchFunction) {
            this.name = name;
            this.rank = rank;
            this.matchFunction = matchFunction;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public Integer getRank() {
            return rank;
        }

        @Override
        public boolean match(final Basket basket) {
            return matchFunction.apply(basket);
        }
    }

}


