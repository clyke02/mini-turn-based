# Mini Online Multiplayer Turn-Based Game

## 📋 Deskripsi Proyek

Game turn-based console berbasis Java yang mendemonstrasikan implementasi **3 Design Patterns** secara terintegrasi:

1. **Factory Method Pattern** (Creational) - Membuat objek character tanpa tight coupling
2. **Decorator Pattern** (Structural) - Menambahkan efek pada skill secara dinamis
3. **Command Pattern** (Behavioral) - Mengenkapsulasi aksi battle sebagai objek

**Fitur Game:**

- 2 Player dengan character berbeda (Warrior: HP 150, Attack 20 | Mage: HP 100, Attack 30)
- Aksi per turn: Basic Attack atau Use Skill (dengan decorator effects)
- Battle otomatis bergantian sampai salah satu HP ≤ 0
- Log detail menunjukkan setiap pattern dalam aksi

## 📁 Struktur Project

```
com.game/
├── character/
│   ├── Character.java
│   ├── CharacterType.java
│   ├── Warrior.java
│   ├── Mage.java
│   ├── CharacterCreator.java
│   ├── WarriorCreator.java
│   └── MageCreator.java
│
├── skill/
│   ├── Skill.java
│   ├── SkillBuilder.java
│   ├── BasicAttackSkill.java
│   ├── Fireball.java
│   ├── SkillDecorator.java
│   ├── DamageBoostDecorator.java
│   └── CriticalHitDecorator.java
│
├── battle/
│   ├── Command.java
│   ├── AttackCommand.java
│   ├── UseSkillCommand.java
│   └── BattleManager.java
│
├── GameConstants.java
├── ConsoleDisplay.java
└── Main.java
```

---

## 🔗 Bagaimana Ketiga Pattern Bekerja Bersama

### Alur Integrasi:

**1. Factory Method** membuat Characters

```java
CharacterCreator warriorFactory = new WarriorCreator();
Character player1 = warriorFactory.orderCharacter("Aragorn");
// Output: [FACTORY] Character created: Aragorn (Warrior) - HP: 150/150
```

**2. Decorator** menghias Skills secara dinamis

```java
Skill base = new Fireball(30);
Skill decorated = new DamageBoostDecorator(base, 10);
decorated = new CriticalHitDecorator(decorated, 0.3);
// Skill dapat di-chain dengan multiple effects
```

**3. Command** mengenkapsulasi aksi dan dieksekusi via Invoker

```java
Command skillCmd = new UseSkillCommand(attacker, target, decoratedSkill);
battleManager.executeCommand(skillCmd);
// Output: [COMMAND] Executing... [DECORATOR] Damage Boost applied...
```

### Flow Lengkap:

```
Factory Method → Character (Warrior/Mage)
                     ↓
Command → menggunakan Character sebagai Receiver
                     ↓
UseSkillCommand → menggunakan Decorated Skill
                     ↓
Decorator Chain → Fireball + DamageBoost + CriticalHit
                     ↓
BattleManager (Invoker) → execute & track history
```

---

## 🚀 Cara Menjalankan

### Compile:

```bash
javac com/game/Main.java com/game/**/*.java
```

### Run:

```bash
java com.game.Main
```

### Atau gunakan batch files:

```bash
compile.bat   # Windows
run.bat       # Windows
```

---

## 🎯 Output Contoh Game

```
╔════════════════════════════════════════════╗
║  MINI ONLINE MULTIPLAYER TURN-BASED GAME  ║
║         Design Patterns Demo              ║
╚════════════════════════════════════════════╝

>>> PHASE 1: CHARACTER CREATION (Factory Method Pattern) <<<

[FACTORY] Character created: Aragorn (Warrior) - HP: 150/150, Attack: 20
[FACTORY] Character created: Gandalf (Mage) - HP: 100/100, Attack: 30

>>> PHASE 2: BATTLE INITIALIZATION <<<

========================================
           BATTLE STATUS
========================================
Aragorn (Warrior) - HP: 150/150, Attack: 20
Gandalf (Mage) - HP: 100/100, Attack: 30
========================================

>>> PHASE 3: BATTLE START <<<

╔════════════════════════════════════════════╗
║              TURN 1                          ║
╚════════════════════════════════════════════╝

[COMMAND] Executing: Aragorn uses skill on Gandalf
  → Skill: Basic Attack + Damage Boost + Critical Chance
[DECORATOR] Damage Boost applied: +10 damage
  → Total damage dealt: 30
  → Gandalf HP: 70/100

[COMMAND] Executing: Gandalf uses skill on Aragorn
  → Skill: Fireball + Damage Boost + Critical Chance
[DECORATOR] Damage Boost applied: +10 damage
[DECORATOR] CRITICAL HIT! Damage doubled!
  → Total damage dealt: 110
  → Aragorn HP: 40/150

...

╔════════════════════════════════════════════╗
║            BATTLE ENDED!                   ║
╚════════════════════════════════════════════╝

🏆 WINNER: Gandalf (Mage)
```

---

## 📝 Catatan Implementasi

### Design Principles:

- **SOLID Principles**: Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion
- **Clean Code**: No magic numbers (semua di `GameConstants`), input validation lengkap, type-safe dengan enums
- **Separation of Concerns**: `ConsoleDisplay` untuk UI, `SkillBuilder` untuk skill creation, `BattleManager` untuk battle logic
- **No External Dependencies**: Hanya Java standard library
