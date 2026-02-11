package com.game.character;

/**
 * Enum untuk tipe character
 * Menghindari penggunaan string literal dan magic strings
 */
public enum CharacterType {
    WARRIOR("Warrior"),
    MAGE("Mage");
    
    private final String displayName;
    
    CharacterType(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    @Override
    public String toString() {
        return displayName;
    }
}
