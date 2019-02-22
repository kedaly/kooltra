package com.kevinedaly.ruleengine;

import com.kevinedaly.models.Basket;

import java.util.List;

/**
 * A rule engine that can process a Basket and tell us which rules it matches
 */
public interface RuleEngine {


    /**
     * What rules does a basket match
     * @return
     */
    List<RuleResult> match(final Basket basket);

    /**
     * Only get the first matched rule
     * @param basket
     * @return
     */
    RuleResult matchFirst(final Basket basket);

}
