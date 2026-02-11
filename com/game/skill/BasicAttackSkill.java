package com.game.skill;

/**
 * DESIGN PATTERN: Decorator
 * Peran: ConcreteComponent
 * 
 * BasicAttackSkill adalah concrete implementation dari Skill
 * yang bisa didekorasi dengan berbagai decorator.
 */
public class BasicAttackSkill implements Skill {
    private int baseDamage;
    
    public BasicAttackSkill(int baseDamage) {
        this.baseDamage = baseDamage;
    }
    
    @Override
    public int execute() {
        return baseDamage;
    }
    
    @Override
    public String getDescription() {
        return "Basic Attack";
    }
}
