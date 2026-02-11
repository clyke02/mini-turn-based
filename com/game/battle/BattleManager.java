package com.game.battle;

import com.game.character.Character;
import java.util.ArrayList;
import java.util.List;

/**
 * DESIGN PATTERN: Command
 * Peran: Invoker
 * 
 * BattleManager bertanggung jawab untuk menerima dan mengeksekusi commands.
 * Class ini tidak tahu detail implementasi command, hanya memanggil execute().
 * 
 * Invoker memisahkan objek yang menginvoke operasi dari objek yang
 * melakukan operasi tersebut.
 */
public class BattleManager {
    private List<Command> commandHistory;
    private Character player1;
    private Character player2;
    
    public BattleManager(Character player1, Character player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.commandHistory = new ArrayList<>();
    }
    
    /**
     * Set command dan eksekusi
     */
    public void executeCommand(Command command) {
        commandHistory.add(command);
        command.execute();
    }
    
    /**
     * Cek apakah battle masih berlangsung
     */
    public boolean isBattleOngoing() {
        return player1.isAlive() && player2.isAlive();
    }
    
    /**
     * Mendapatkan pemenang battle
     */
    public Character getWinner() {
        if (player1.isAlive()) {
            return player1;
        } else if (player2.isAlive()) {
            return player2;
        }
        return null;
    }
    
    /**
     * Mendapatkan player 1
     */
    public Character getPlayer1() {
        return player1;
    }
    
    /**
     * Mendapatkan player 2
     */
    public Character getPlayer2() {
        return player2;
    }
    
    /**
     * Mendapatkan total command yang sudah dieksekusi
     */
    public int getTotalCommands() {
        return commandHistory.size();
    }
}
