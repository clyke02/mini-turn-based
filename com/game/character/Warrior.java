package com.game.character;

/**
 * Concrete Product: Warrior
 * Peran: ConcreteProduct dalam Factory Method Pattern
 */
public class Warrior extends Character {
    private static final int WARRIOR_HP = 150;
    private static final int WARRIOR_ATTACK = 20;
    
    public Warrior(String name) {
        super(name, WARRIOR_HP, WARRIOR_ATTACK);
    }
    
    @Override
    public CharacterType getCharacterType() {
        return CharacterType.WARRIOR;
    }
}
