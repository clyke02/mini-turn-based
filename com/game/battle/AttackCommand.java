package com.game.battle;

import com.game.character.Character;
import com.game.skill.Skill;
import com.game.skill.BasicAttackSkill;

/**
 * DESIGN PATTERN: Command
 * Peran: ConcreteCommand untuk basic attack
 * 
 * AttackCommand mengenkapsulasi action basic attack.
 * Command ini menyimpan reference ke attacker dan target (receivers).
 */
public class AttackCommand implements Command {
    private Character attacker;
    private Character target;
    
    public AttackCommand(Character attacker, Character target) {
        this.attacker = attacker;
        this.target = target;
    }
    
    @Override
    public void execute() {
        System.out.println("\n[COMMAND] Executing: " + attacker.getName() + " attacks " + target.getName());
        
        Skill basicAttack = new BasicAttackSkill(attacker.getAttackPower());
        int damage = basicAttack.execute();
        
        target.takeDamage(damage);
        
        System.out.println("  → " + basicAttack.getDescription() + " deals " + damage + " damage!");
        System.out.println("  → " + target.getName() + " HP: " + target.getHp() + "/" + target.getMaxHp());
    }
}
