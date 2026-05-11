# Phase 3 AI Log: Behavioral Design Patterns

**1. Prompt:** I wanted to refactor `Game.java` because it had too many `if-else` and `switch-case` blocks to check character types and their specific attributes (like arrows for Archer or shields for Tank). It was violating the "Tell, Don't Ask" principle.

**2. AI Response:**
The AI suggested using Behavioral principles (Polymorphism / Strategy) by distributing the combat logic to the subclasses. It recommended creating a standalone `Enemy` class to pass as an object, rather than just using `int` variables. It also pointed out that fields in Java are not polymorphic, so I needed to implement getter methods (like `getDamage()`) to properly display buffed stats in the menu.

**3. Implementation:**
I created the `Enemy` class. I added abstract `attack(Enemy e)`, `heal()`, `getHit(Enemy e)`, and `showProfile()` methods to the `Player` class. I overrode these methods in `Knight`, `Archer`, and `Tank` so each class handles its own logic (e.g., Archer tracking arrows, Tank calculating shield absorption). I also added `getDamage()` to fix the menu display issue with the `DMGBuff` decorator. Finally, `Game.java` was simplified to just call `p.attack(e)` and `p.showProfile()`.