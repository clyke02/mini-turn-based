package com.game;

import com.game.character.Character;
import com.game.character.CharacterCreator;
import com.game.character.WarriorCreator;
import com.game.character.MageCreator;
import com.game.skill.*;
import com.game.battle.*;
import java.util.Random;

import static com.game.GameConstants.*;

/**
 * MINI ONLINE MULTIPLAYER TURN-BASED GAME
 * Demonstrasi 3 Design Patterns:
 * 1. Factory Method - untuk membuat character
 * 2. Decorator - untuk sistem skill
 * 3. Command - untuk battle actions
 * 
 * Refactored untuk Clean Code:
 * - Extracted methods untuk setiap responsibility
 * - Separated presentation logic (ConsoleDisplay)
 * - Removed magic numbers (GameConstants)
 * - Added input validation
 * - Improved readability dan maintainability
 */
public class Main {
    
    private final ConsoleDisplay display;
    private final SkillBuilder skillBuilder;
    private final Random random;
    
    public Main() {
        this.display = new ConsoleDisplay();
        this.skillBuilder = new SkillBuilder();
        this.random = new Random();
    }
    
    public static void main(String[] args) {
        Main game = new Main();
        game.run();
    }
    
    private void run() {
        display.displayGameHeader();
        
        // Phase 1: Character Creation (Factory Method Pattern)
        display.displayPhaseHeader("PHASE 1: CHARACTER CREATION (Factory Method Pattern)");
        Character[] players = createCharacters();
        Character player1 = players[0];
        Character player2 = players[1];
        
        // Phase 2: Battle Setup
        display.displayPhaseHeader("PHASE 2: BATTLE INITIALIZATION");
        BattleManager battleManager = new BattleManager(player1, player2);
        display.displayBattleStatus(player1, player2);
        
        // Phase 3: Battle Simulation
        display.displayPhaseHeader("PHASE 3: BATTLE START");
        display.displayBattleStartMessage();
        runBattle(battleManager);
        
        // Phase 4: Display Results
        displayBattleResults(battleManager);
    }
    
    /**
     * Create characters using Factory Method Pattern
     */
    private Character[] createCharacters() {
        CharacterCreator warriorFactory = new WarriorCreator();
        CharacterCreator mageFactory = new MageCreator();
        
        Character player1 = warriorFactory.orderCharacter("Aragorn");
        Character player2 = mageFactory.orderCharacter("Gandalf");
        
        return new Character[] { player1, player2 };
    }
    
    /**
     * Run the battle loop
     */
    private void runBattle(BattleManager battleManager) {
        int turnNumber = 0;
        
        while (battleManager.isBattleOngoing() && turnNumber < MAX_TURNS) {
            turnNumber++;
            display.displayTurnHeader(turnNumber);
            
            executeTurn(battleManager);
        }
        
        if (turnNumber >= MAX_TURNS) {
            display.displayMaxTurnsReached();
        }
    }
    
    /**
     * Execute one complete turn (both players)
     */
    private void executeTurn(BattleManager battleManager) {
        Character player1 = battleManager.getPlayer1();
        Character player2 = battleManager.getPlayer2();
        
        if (battleManager.isBattleOngoing()) {
            executePlayerTurn(player1, player2, battleManager);
        }
        
        if (battleManager.isBattleOngoing()) {
            executePlayerTurn(player2, player1, battleManager);
        }
    }
    
    /**
     * Execute one player's turn
     * Uses DECORATOR PATTERN and COMMAND PATTERN
     */
    private void executePlayerTurn(Character attacker, Character target, 
                                   BattleManager battleManager) {
        Command command = createCommand(attacker, target);
        battleManager.executeCommand(command);
    }
    
    /**
     * Create a command based on random action
     */
    private Command createCommand(Character attacker, Character target) {
        int action = random.nextInt(2);
        
        if (action == 0) {
            return new AttackCommand(attacker, target);
        } else {
            Skill decoratedSkill = skillBuilder.buildDecoratedSkill(attacker);
            return new UseSkillCommand(attacker, target, decoratedSkill);
        }
    }
    
    /**
     * Display battle results
     */
    private void displayBattleResults(BattleManager battleManager) {
        display.displayBattleEnd();
        display.displayBattleStatus(battleManager.getPlayer1(), battleManager.getPlayer2());
        display.displayWinner(battleManager.getWinner());
        display.displayCommandCount(battleManager.getTotalCommands());
    }
}
