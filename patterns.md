# Design Patterns Documentation

## Phase 1: Creational Patterns

**Pattern Used:** Factory Method
**Implemented in:** `PlayerFactory.java`

### 1. The Problem (Phase 0)
In the initial spaghetti code, the `Player` class was responsible for creating different character types (Knight, Archer, Tank) using a massive, hardcoded `if-else` block inside its constructor. This violated the **Single Responsibility Principle** (a class should only have one reason to change) and the **Open/Closed Principle** (adding a new "Mage" class would require modifying the core `Player` constructor). Additionally, all characters carried unnecessary attributes (like a Knight having a `leftArrow`), leading to a bloated state.

### 2. The Solution
We implemented the **Factory Method** pattern to centralize and encapsulate the object creation logic.
* **Abstract Product:** We refactored `Player` into an abstract class containing only shared attributes.
* **Concrete Products:** We created `Knight`, `Archer`, and `Tank` subclasses that extend `Player`.
* **Creator (Factory):** We created `PlayerFactory` with a `createPlayer()` method.

Now, the `Main` class simply asks the factory for a specific character, and the factory handles the instantiation. This makes the system easily extensible; if we want to add a new character class later, we only need to create a new subclass and add one line to the factory, without touching the existing game logic.

### 3. UML Class Diagram

```mermaid
classDiagram
    class Player {
        <<abstract>>
        +String nickname
        +String className
        +int health
        +int maxHealth
        +int damage
    }

    class Knight {
        +Knight(String nickname)
    }

    class Archer {
        +int leftArrow
        +Archer(String nickname)
    }

    class Tank {
        +int shield
        +int maxShield
        +Tank(String nickname)
    }

    class PlayerFactory {
        +createPlayer(String nickname, int Class) Player
    }

    class Main {
        +main(String[] args)
    }

    Player <|-- Knight : extends
    Player <|-- Archer : extends
    Player <|-- Tank : extends
    
    PlayerFactory ..> Player : creates
    Main ..> PlayerFactory : uses

## Phase 2: Structural Patterns

**Pattern Used:** Decorator
**Implemented in:** `PlayerDecorator.java`, `DMGBuff.java`, `HPBuff.java`

### 1. The Problem
Adding items or buffs (like a sword or shield) to characters by creating new subclasses (e.g., `KnightWithSword`, `ArcherWithShield`) would lead to a "Class Explosion." We needed a way to dynamically add responsibilities to individual objects at runtime without altering the structure of the existing `Player` classes.

### 2. The Solution
We used the **Decorator Pattern**. We created an abstract `PlayerDecorator` that both `extends Player` (to be compatible with the game engine) and holds a reference to a `Player` object (composition). Specific buffs like `DMGBuff` and `HPBuff` extend this decorator, modifying the stats (like `damage` or `health`) and the `className` before passing the calls to the wrapped object. This allows us to stack multiple buffs easily if needed.

### 3. UML Class Diagram Update

```mermaid
classDiagram
    class Player {
        <<abstract>>
        +String nickname
        +String className
        +int health
        +int damage
    }

    class PlayerDecorator {
        <<abstract>>
        #Player wrappedPlayer
        +PlayerDecorator(Player p)
    }

    class DMGBuff {
        +DMGBuff(Player p)
    }
    
    class HPBuff {
        +HPBuff(Player p)
    }

    Player <|-- PlayerDecorator : extends
    PlayerDecorator o-- Player : wraps
    PlayerDecorator <|-- DMGBuff : extends
    PlayerDecorator <|-- HPBuff : extends

## Phase 3: Behavioral Patterns

**Pattern Used:** Strategy / Polymorphism (Tell, Don't Ask Principle)
**Implemented in:** `Game.java`, `Player.java` and its subclasses.

### 1. The Problem
The `Game` class was acting as a micromanager. It used large `switch-case` blocks and type casting (e.g., `((Archer)p).leftArrow`) to determine how each character should attack or take damage. This made the `Game` class tightly coupled to every specific character class, violating the Single Responsibility Principle.

### 2. The Solution
We refactored the system using Polymorphism and the "Tell, Don't Ask" principle. We introduced an `Enemy` class to represent the opponent. We moved the combat logic (`attack`, `heal`, `getHit`) directly into the specific subclasses (`Knight`, `Archer`, `Tank`). Now, the `Game` class simply issues a command (`p.attack(enemy)`), and each character executes its own specific strategy (e.g., the Knight sharpens his sword, the Archer uses arrows). We also implemented getter methods to ensure dynamic stats from Decorators are read correctly.