package com.game.skill;

/**
 * DESIGN PATTERN: Decorator (Structural)
 * Peran: Abstract Decorator
 * 
 * SkillDecorator adalah abstract class yang mengimplementasi Skill interface
 * dan menyimpan reference ke objek Skill lain (composition).
 * 
 * Decorator Pattern memungkinkan penambahan behavior baru ke objek
 * secara dinamis tanpa mengubah class aslinya.
 */
public abstract class SkillDecorator implements Skill {
    protected Skill wrappedSkill;
    
    public SkillDecorator(Skill skill) {
        this.wrappedSkill = skill;
    }
    
    @Override
    public int execute() {
        return wrappedSkill.execute();
    }
    
    @Override
    public String getDescription() {
        return wrappedSkill.getDescription();
    }
}
