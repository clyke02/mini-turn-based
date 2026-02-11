package com.game;

/**
 * Central location untuk semua game constants
 * Menghindari magic numbers di seluruh codebase
 */
public final class GameConstants {
    
    // Battle constants
    public static final int MAX_TURNS = 20;
    
    // Skill decorator constants
    public static final int DAMAGE_BOOST_AMOUNT = 10;
    public static final double CRITICAL_HIT_CHANCE = 0.3; // 30%
    
    // Private constructor to prevent instantiation
    private GameConstants() {
        throw new AssertionError("GameConstants should not be instantiated");
    }
}
