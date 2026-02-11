package com.game.character;

/**
 * DESIGN PATTERN: Factory Method
 * Peran: ConcreteCreator untuk Mage
 * 
 * MageCreator mengimplementasi factory method untuk membuat Mage.
 * Class ini menentukan tipe konkret dari Character yang akan dibuat.
 */
public class MageCreator extends CharacterCreator {
    
    @Override
    public Character createCharacter(String name) {
        return new Mage(name);
    }
}
