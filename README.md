# GameManager

CS-151-Fall2026 Project 3: a JavaFX game manager with three games (Blackjack, Snake, Connect Four), user accounts, and persistent high scores.

## Overview

GameManager lets a user create an account, log in, and play any of three games. High scores are saved per user across sessions. A persistent toolbar with a "Main Menu" button appears on every screen after login.

## Design

- `com.gamemanager` - `App` entry point; owns the persistent toolbar and swaps the center scene.
- `com.gamemanager.ui` - screens and the toolbar (JavaFX only).
- `com.gamemanager.model` - `User` and `HighScore` data classes (private fields).
- `com.gamemanager.storage` - all file I/O (`user_accounts.txt`, `high_scores.txt`).
- `com.gamemanager.util` - shared cipher helpers.
- `com.gamemanager.games` - `Game` interface and `AbstractGame` base class.
- `com.gamemanager.games.blackjack`, `.snake`, `.connectfour` - each game's logic class (no JavaFX) and scene class (JavaFX only).

## Installation Instructions

Requirements: JDK 21 and Maven 3.9+.

```bash
git clone <repo-url>
cd GameManager
mvn clean test
```

## Usage

```bash
mvn clean javafx:run
```

1. Create an account or log in.
2. Choose a game from the main menu, or use the toolbar's "Main Menu" button at any time.

Video walkthrough: _TODO: add link (must be viewable by anyone with the link)_

## Contributions

_TODO: fill in each member's area of ownership and commit focus._

| Member | Area |
|--------|------|
| _name_ | Game Manager (login, storage, toolbar) |
| _name_ | Blackjack |
| _name_ | Snake |
| _name_ | Connect Four |
