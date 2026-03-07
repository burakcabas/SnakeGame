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

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

