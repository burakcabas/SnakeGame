# 🐍 Snake Game

A modern, feature-rich implementation of the classic Snake game built with Java Swing. Features include a polished menu system, customizable settings, sound effects, and smooth gameplay.

![Java](https://img.shields.io/badge/Java-17+-orange.svg)
![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Build](https://img.shields.io/badge/build-passing-brightgreen.svg)

## 🎮 Features

- **Classic Snake Gameplay** - Navigate the snake to eat apples and grow longer
- **Modern Menu System** - Professional UI with keyboard and mouse navigation
- **Customizable Settings** - Adjust game speed, volume, and sound preferences
- **Sound Effects** - Dynamic audio feedback for game events
- **Smooth Controls** - Responsive arrow key and WASD controls
- **Score Tracking** - Real-time score display during gameplay
- **Game Over Screen** - Restart functionality with final score display

## 📸 Screenshots

### Main Menu
The game features a clean, modern menu interface with easy navigation.

### Gameplay
Classic snake mechanics with smooth movement and collision detection.

### Settings Panel
Customize your gaming experience with adjustable speed and audio settings.

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- IntelliJ IDEA Community Edition (or any Java IDE)
- Git (for cloning the repository)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/burakcabas/SnakeGame.git
   cd SnakeGame
   ```

2. **Open in IntelliJ IDEA**
   - Open IntelliJ IDEA
   - Select `File > Open`
   - Navigate to the project directory
   - Click `OK`

3. **Run the game**
   - Navigate to `src/main/java/burak/SnakeGameMain.java`
   - Right-click and select `Run 'SnakeGameMain.main()'`

### Building a Standalone JAR

1. **Configure the artifact**
   - Go to `File > Project Structure > Artifacts`
   - Click `+` and select `JAR > From modules with dependencies`
   - Set Main Class to `burak.SnakeGameMain`
   - Click `OK`

2. **Build the JAR**
   - Go to `Build > Build Artifacts`
   - Select your artifact and click `Build`
   - Find the JAR in `out/artifacts/`

3. **Run the JAR**
   ```bash
   java -jar SnakeGame.jar
   ```

## 🎯 How to Play

### Controls

| Key | Action |
|-----|--------|
| **Arrow Keys** / **WASD** | Move the snake |
| **Space** | Restart game (when game over) |
| **Escape** | Return to menu |
| **Enter** | Select menu option |

### Gameplay

1. **Start the game** from the main menu
2. **Guide the snake** to eat red apples
3. **Grow longer** with each apple eaten
4. **Avoid collisions** with walls and yourself
5. **Beat your high score!**

### Settings

- **Sound Toggle** - Enable/disable sound effects
- **Volume Control** - Adjust audio volume (0-100%)
- **Game Speed** - Control snake movement speed (1-10)

## 🏗️ Project Structure

```
snake-game/
├── src/
│   └── main/
│       └── java/
│           └── burak/
│               ├── SnakeGameMain.java      # Entry point
│               ├── GameFrame.java          # Main window
│               ├── MenuPanel.java          # Menu interface
│               ├── SettingsPanel.java      # Settings screen
│               ├── GamePanel.java          # Game logic
│               ├── GameSettings.java       # Settings management
│               ├── SoundManager.java       # Audio system
│               ├── InputHandler.java       # Keyboard input
│               ├── Snake.java              # Snake entity
│               ├── Apple.java              # Apple entity
│               ├── Direction.java          # Direction enum
│               └── GameState.java          # Game state
├── README.md
└── LICENSE
```

## 🛠️ Technical Details

### Architecture

The game follows a **multi-class object-oriented design** with clear separation of concerns:

- **Model-View-Controller pattern** for game logic
- **Event-driven architecture** for user input
- **CardLayout** for screen management
- **Timer-based game loop** for smooth animation

### Key Components

- **Snake Class** - Manages snake movement, growth, and collision detection
- **Apple Class** - Handles apple positioning and rendering
- **GamePanel** - Core game loop and rendering engine
- **SoundManager** - Programmatic sound generation using Java Sound API
- **InputHandler** - Centralized keyboard event processing

### Technologies Used

- **Java Swing** - GUI framework
- **Java Sound API** - Audio generation
- **AWT Graphics2D** - 2D rendering
- **Timer** - Game loop management

## 🎨 Customization

### Changing Game Colors

Edit the color values in the respective classes:

```java
// Snake.java - Snake colors
g.setColor(Color.GREEN);              // Head
g.setColor(new Color(45, 180, 0));    // Body

// Apple.java - Apple color
g2d.setColor(Color.RED);
```

### Adjusting Game Speed

Modify the speed calculation in `GameSettings.java`:

```java
public int getGameDelay() {
    return 200 - (gameSpeed * 15);  // Adjust formula here
}
```

### Board Size

Change board dimensions in `GamePanel.java`:

```java
private static final int BOARD_WIDTH = 600;   // Width in pixels
private static final int BOARD_HEIGHT = 600;  // Height in pixels
private static final int UNIT_SIZE = 25;      // Grid unit size
```

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

