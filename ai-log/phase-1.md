# Phase 1 AI Log: Creational Design Patterns

**1. Prompt:** I asked the AI how to solve the object creation problem in my initial code, where the `Player` class constructor had a massive, hardcoded `if-else` block to create different character types (Knight, Archer, Tank). I also pointed out that giving all stats (like `shield` and `leftArrow`) to every character was a bad design.

**2. AI Response:**
The AI suggested applying the **Factory Method** design pattern. It recommended breaking down the monolithic `Player` class by:
* Making `Player` an `abstract` class containing only shared attributes (health, damage, etc.).
* Creating specific subclasses (`Knight`, `Archer`, `Tank`) that inherit from `Player` and hold their own unique attributes.
* Creating a `PlayerFactory` class to handle the instantiation logic, removing this responsibility from the `Player` class to adhere to the Open/Closed Principle.
* The AI also warned me about "Type Casting" issues in the `Game` class and "fallthrough" errors in `switch-case` blocks.

**3. Implementation:**
I implemented the AI's suggestions by creating the `PlayerFactory` with a `createPlayer()` method. I successfully refactored `Player` into an abstract class and created the `Knight`, `Archer`, and `Tank` subclasses. I moved the user input (`Scanner`) to the `Main` class so the factory only focuses on object creation. Finally, I fixed the `switch-case` fallthrough bugs in `Game.java` by adding `break;` statements and temporarily handled specific class attributes using Type Casting (e.g., `((Archer)p).leftArrow`), which I plan to refactor in the Behavioral phase.