package com.game.character;

/**
 * DESIGN PATTERN: Factory Method
 * Peran: ConcreteCreator untuk Warrior
 * 
 * WarriorCreator mengimplementasi factory method untuk membuat Warrior.
 * Class ini menentukan tipe konkret dari Character yang akan dibuat.
 */
public class WarriorCreator extends CharacterCreator {
    
    @Override
    public Character createCharacter(String name) {
        return new Warrior(name);
    }
}
