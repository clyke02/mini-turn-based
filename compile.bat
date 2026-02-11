@echo off
echo ==========================================
echo  Compiling Mini Turn-Based Game...
echo ==========================================

javac com/game/Main.java com/game/character/*.java com/game/skill/*.java com/game/battle/*.java

if %ERRORLEVEL% EQU 0 (
    echo.
    echo ==========================================
    echo  Compilation SUCCESSFUL!
    echo ==========================================
    echo.
    echo Run the game with: run.bat
    echo Or manually: java com.game.Main
) else (
    echo.
    echo ==========================================
    echo  Compilation FAILED!
    echo ==========================================
)

pause
