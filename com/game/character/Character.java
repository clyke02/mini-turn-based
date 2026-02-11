package com.game.character;

/**
 * Abstract class untuk Character
 * Peran: Product dalam Factory Method Pattern
 */
public abstract class Character {
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int attackPower;
    
    public Character(String name, int hp, int attackPower) {
        validateName(name);
        validateHp(hp);
        validateAttackPower(attackPower);
        
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attackPower = attackPower;
    }
    
    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Character name cannot be null or empty");
        }
    }
    
    private void validateHp(int hp) {
        if (hp <= 0) {
            throw new IllegalArgumentException("HP must be positive, got: " + hp);
        }
    }
    
    private void validateAttackPower(int attackPower) {
        if (attackPower <= 0) {
            throw new IllegalArgumentException("Attack power must be positive, got: " + attackPower);
        }
    }
    
    public String getName() {
        return name;
    }
    
    public int getHp() {
        return hp;
    }
    
    public int getMaxHp() {
        return maxHp;
    }
    
    public int getAttackPower() {
        return attackPower;
    }
    
    public void takeDamage(int damage) {
        this.hp = Math.max(0, this.hp - damage);
    }
    
    public boolean isAlive() {
        return hp > 0;
    }
    
    public abstract CharacterType getCharacterType();
    
    @Override
    public String toString() {
        return String.format("%s (%s) - HP: %d/%d, Attack: %d", 
            name, getCharacterType().getDisplayName(), hp, maxHp, attackPower);
    }
}
