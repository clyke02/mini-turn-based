package com.game.skill;

import com.game.character.Character;
import com.game.character.CharacterType;
import static com.game.GameConstants.*;

/**
 * Builder class untuk membuat decorated skills
 * Memisahkan skill creation logic dari Main
 * Mengikuti Single Responsibility Principle
 */
public class SkillBuilder {
    
    /**
     * Build decorated skill berdasarkan character type
     */
    public Skill buildDecoratedSkill(Character character) {
        Skill baseSkill = createBaseSkill(character);
        return applyDecorators(baseSkill);
    }
    
    private Skill createBaseSkill(Character character) {
        if (character.getCharacterType() == CharacterType.MAGE) {
            return new Fireball(character.getAttackPower());
        } else {
            return new BasicAttackSkill(character.getAttackPower());
        }
    }
    
    private Skill applyDecorators(Skill baseSkill) {
        Skill decorated = new DamageBoostDecorator(baseSkill, DAMAGE_BOOST_AMOUNT);
        decorated = new CriticalHitDecorator(decorated, CRITICAL_HIT_CHANCE);
        return decorated;
    }
}
