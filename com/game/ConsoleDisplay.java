package com.game;

import com.game.character.Character;

/**
 * Class untuk menangani semua console output
 * Memisahkan presentation logic dari business logic
 * Mengikuti Single Responsibility Principle
 */
public class ConsoleDisplay {
    
    private static final String HORIZONTAL_LINE = "========================================";
    private static final String BOX_TOP = "╔════════════════════════════════════════════╗";
    private static final String BOX_BOTTOM = "╚════════════════════════════════════════════╝";
    
    public void displayGameHeader() {
        System.out.println(BOX_TOP);
        System.out.println("║  MINI ONLINE MULTIPLAYER TURN-BASED GAME  ║");
        System.out.println("║         Design Patterns Demo              ║");
        System.out.println(BOX_BOTTOM + "\n");
    }
    
    public void displayPhaseHeader(String phaseName) {
        System.out.println("\n>>> " + phaseName + " <<<\n");
    }
    
    public void displayTurnHeader(int turnNumber) {
        System.out.println("\n" + BOX_TOP);
        System.out.println(String.format("║              TURN %-2d                         ║", turnNumber));
        System.out.println(BOX_BOTTOM);
    }
    
    public void displayBattleStatus(Character player1, Character player2) {
        System.out.println("\n" + HORIZONTAL_LINE);
        System.out.println("           BATTLE STATUS");
        System.out.println(HORIZONTAL_LINE);
        System.out.println(player1.toString());
        System.out.println(player2.toString());
        System.out.println(HORIZONTAL_LINE);
    }
    
    public void displayBattleEnd() {
        System.out.println("\n\n" + BOX_TOP);
        System.out.println("║            BATTLE ENDED!                   ║");
        System.out.println(BOX_BOTTOM);
    }
    
    public void displayWinner(Character winner) {
        if (winner != null) {
            System.out.println("\n🏆 WINNER: " + winner.getName() + 
                " (" + winner.getCharacterType().getDisplayName() + ")");
        } else {
            System.out.println("\n⚔️  DRAW!");
        }
    }
    
    public void displayCommandCount(int count) {
        System.out.println("\nTotal commands executed: " + count);
    }
    
    public void displayMaxTurnsReached() {
        System.out.println("\n[SYSTEM] Battle reached maximum turns!");
    }
    
    public void displayBattleStartMessage() {
        System.out.println("Battle akan berjalan otomatis sampai salah satu HP <= 0\n");
    }
}
