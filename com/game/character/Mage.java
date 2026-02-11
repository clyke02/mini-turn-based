package com.game.character;

/**
 * Concrete Product: Mage
 * Peran: ConcreteProduct dalam Factory Method Pattern
 */
public class Mage extends Character {
    private static final int MAGE_HP = 100;
    private static final int MAGE_ATTACK = 30;
    
    public Mage(String name) {
        super(name, MAGE_HP, MAGE_ATTACK);
    }
    
    @Override
    public CharacterType getCharacterType() {
        return CharacterType.MAGE;
    }
}
