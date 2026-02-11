package com.game.battle;

import com.game.character.Character;
import com.game.skill.Skill;

/**
 * DESIGN PATTERN: Command
 * Peran: ConcreteCommand untuk menggunakan skill
 * 
 * UseSkillCommand mengenkapsulasi action penggunaan skill.
 * Command ini menerima skill yang sudah bisa didekorasi dengan Decorator Pattern.
 */
public class UseSkillCommand implements Command {
    private Character attacker;
    private Character target;
    private Skill skill;
    
    public UseSkillCommand(Character attacker, Character target, Skill skill) {
        this.attacker = attacker;
        this.target = target;
        this.skill = skill;
    }
    
    @Override
    public void execute() {
        System.out.println("\n[COMMAND] Executing: " + attacker.getName() + " uses skill on " + target.getName());
        System.out.println("  → Skill: " + skill.getDescription());
        
        int damage = skill.execute();
        
        target.takeDamage(damage);
        
        System.out.println("  → Total damage dealt: " + damage);
        System.out.println("  → " + target.getName() + " HP: " + target.getHp() + "/" + target.getMaxHp());
    }
}
