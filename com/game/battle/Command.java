package com.game.battle;

/**
 * DESIGN PATTERN: Command (Behavioral)
 * Peran: Command interface
 * 
 * Command interface mendefinisikan method execute() yang akan
 * diimplementasikan oleh semua concrete command.
 * 
 * Command Pattern mengenkapsulasi request sebagai objek,
 * sehingga memungkinkan parameterisasi client dengan berbagai request,
 * queue request, dan mendukung undo operation.
 */
public interface Command {
    /**
     * Eksekusi command
     */
    void execute();
}
