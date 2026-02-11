package com.game.skill;

/**
 * DESIGN PATTERN: Decorator (Structural)
 * Peran: Component interface
 * 
 * Interface Skill mendefinisikan operasi yang bisa didekorasi.
 * Baik concrete skill maupun decorator mengimplementasi interface ini.
 */
public interface Skill {
   
    int execute();
    
    String getDescription();
}
