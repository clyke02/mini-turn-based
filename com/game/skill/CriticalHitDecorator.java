package com.game.skill;

import java.util.Random;

/**
 * DESIGN PATTERN: Decorator
 * Peran: ConcreteDecorator
 * 
 * CriticalHitDecorator menambahkan functionality berupa critical hit chance
 * ke skill yang di-wrap. Jika critical hit terjadi, damage akan digandakan.
 */
public class CriticalHitDecorator extends SkillDecorator {
    private double critChance;
    private Random random;
    
    public CriticalHitDecorator(Skill skill, double critChance) {
        super(skill);
        this.critChance = critChance;
        this.random = new Random();
    }
    
    @Override
    public int execute() {
        int originalDamage = super.execute();
        
        if (random.nextDouble() < critChance) {
            int critDamage = originalDamage * 2;
            System.out.println("[DECORATOR] CRITICAL HIT! Damage doubled!");
            return critDamage;
        }
        
        return originalDamage;
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + " + Critical Chance";
    }
}
