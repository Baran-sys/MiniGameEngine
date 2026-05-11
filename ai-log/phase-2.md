# Phase 2 AI Log: Structural Design Patterns

**1. Prompt:** I implemented the new factory logic but realized creating a second `Scanner` in the `Main` class could cause resource leak issues since `Game` also used one. I also needed a way to add dynamic stats (like a DMG Buff or HP Buff) to my character without creating dozens of new subclasses (avoiding Class Explosion).

**2. AI Response:**
The AI agreed with my observation about the `Scanner` and suggested a simple Dependency Injection approach: instantiate the `Scanner` once in `Main` and pass it as a parameter to `Game.play()`.
To solve the item/buff problem, the AI introduced the **Decorator Pattern**. It explained that a Decorator must inherit from the base `Player` class to fool the game engine, while also wrapping an instance of a `Player` inside itself to remember the original stats.

**3. Implementation:**
I refactored the `Scanner` to be created only once in `Main.java` and passed it to `Game.play(p, input)`. I created an abstract `PlayerDecorator` class extending `Player`, and then implemented `DMGBuff` and `HPBuff` classes. In `Main`, I used a `switch` statement to dynamically wrap the base `Player` object with the chosen buff before passing it to the game logic.