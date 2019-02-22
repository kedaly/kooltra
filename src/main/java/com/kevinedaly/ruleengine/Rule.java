package com.kevinedaly.ruleengine;

import com.kevinedaly.models.Basket;

/**
 * Rule
 */
public interface Rule {
    /**
     * The name of this rule
     * @return
     */
    String getName();

    /**
     * The Rank of this rule
     * @return
     */
    Integer getRank();

    /**
     * Match this rule to a basket
     * @return
     */
    boolean match(final Basket basket);
}
