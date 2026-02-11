package com.game.character;

/**
 * DESIGN PATTERN: Factory Method (Creational)
 * Peran: Creator (abstract class)
 * 
 * CharacterCreator adalah abstract class yang mendefinisikan factory method
 * untuk membuat objek Character tanpa menentukan class konkretnya.
 * 
 * Factory Method Pattern memungkinkan subclass memutuskan class mana yang akan diinstansiasi.
 */
public abstract class CharacterCreator {
    
    public abstract Character createCharacter(String name);
    
    public Character orderCharacter(String name) {
        Character character = createCharacter(name);
        System.out.println("[FACTORY] Character created: " + character.toString());
        return character;
    }
}
