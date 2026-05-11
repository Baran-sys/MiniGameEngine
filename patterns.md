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