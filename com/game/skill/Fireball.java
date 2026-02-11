package com.game.skill;

/**
 * DESIGN PATTERN: Decorator
 * Peran: ConcreteComponent
 * 
 * Fireball adalah concrete implementation dari Skill
 * yang merepresentasikan serangan skill khusus.
 */
public class Fireball implements Skill {
    private int baseDamage;
    
    public Fireball(int baseDamage) {
        this.baseDamage = baseDamage;
    }
    
    @Override
    public int execute() {
        return (int)(baseDamage * 1.5); // Fireball deals 1.5x base damage
    }
    
    @Override
    public String getDescription() {
        return "Fireball";
    }
}
