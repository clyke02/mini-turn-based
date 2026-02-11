package com.game.skill;

/**
 * DESIGN PATTERN: Decorator (Structural)
 * Peran: Component interface
 * 
 * Interface Skill mendefinisikan operasi yang bisa didekorasi.
 * Baik concrete skill maupun decorator mengimplementasi interface ini.
 */
public interface Skill {
    /**
     * Eksekusi skill dan return damage yang dihasilkan
     */
    int execute();
    
    /**
     * Mendapatkan deskripsi skill
     */
    String getDescription();
}
