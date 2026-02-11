package com.game.skill;

/**
 * DESIGN PATTERN: Decorator
 * Peran: ConcreteDecorator
 * 
 * DamageBoostDecorator menambahkan functionality berupa boost damage
 * ke skill yang di-wrap tanpa mengubah class skill aslinya.
 */
public class DamageBoostDecorator extends SkillDecorator {
    private int boostAmount;
    
    public DamageBoostDecorator(Skill skill, int boostAmount) {
        super(skill);
        this.boostAmount = boostAmount;
    }
    
    @Override
    public int execute() {
        int originalDamage = super.execute();
        int boostedDamage = originalDamage + boostAmount;
        System.out.println("[DECORATOR] Damage Boost applied: +" + boostAmount + " damage");
        return boostedDamage;
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + " + Damage Boost";
    }
}
