# Devil They Aren't 🌑

> *A shadow creature. A city that never goes dark. Survival is all that matters.*

---

## Overview

**Devil They Aren't** is a 2D side-scrolling survival platformer built with Java and the LibGDX framework. You play as a sentient shadow creature that has escaped a lab into a severely light-polluted dystopian city. The core twist flips the usual horror convention — here, **light is the enemy.**

The game shifts between two phases every level based on a day/night timer, each demanding a completely different playstyle.

---

## Story

Deep beneath a megacity choking on its own neon glow, a shadow organism gains sentience inside a government research lab. It escapes. Above ground, the city is an unrelenting sprawl of floodlights, surveillance grids, and artificial daylight — a world with almost no darkness left. The creature must navigate this hostile environment, surviving on whatever shadows the city leaves behind, one night at a time.

---

## Gameplay

### Day / Night Cycle
The core mechanic. A timer drives the world between two states each level:

| Phase | Conditions | Objective |
|---|---|---|
| 🌙 **Night** | Low ambient light, free movement | Navigate, explore, avoid guards |
| ☀️ **Day** | Sunlight is lethal | Hide in shadows cast by objects, survive until nightfall |

### Mechanics
- **Light damage** — Direct sunlight during the day drains your lives
- **Flashlight damage** — Guards (Steven) patrol and shine flashlights; getting caught costs a life
- **Shadow safety** — During the day, objects in the environment cast safe shadows to hide in
- **Lives system** — You have a limited number of lives per level; lose them all and restart

### Controls
| Key | Action |
|---|---|
| `A` / `←` | Move left |
| `D` / `→` | Move right |
| `W` / `↑` / `Space` | Jump |

---

## Levels

| Level | Setting | Description |
|---|---|---|
| 1 | The Lab | Tutorial. Learn movement and light avoidance. Mostly night. |
| 2 | City Outskirts | Longer day sections, more terrain complexity, more guards. |
| 3 | Deep City | Full dual-mode experience. Dense light pollution. Final challenge. |

---

## Enemies

### Steven 🔦
A patrolling city guard armed with a flashlight. Steven moves back and forth across his patrol route. His flashlight cone is a hitbox — step into it and you take damage. At night he is still dangerous; during the day the sun does his job for him.

---

## Technical Stack

| Tool | Purpose |
|---|---|
| Java | Core language |
| LibGDX | Game framework |
| Box2D | Physics and collision |
| FreeType | Custom font rendering |
| Gradle | Build system |
| Aseprite | Sprite editing |

---

## Project Structure

```
core/src/main/java/com/ciel/deviltheyarent/
├── DevilTheyArent.java       — Entry point, screen manager
├── screens/
│   ├── MenuScreen.java       — Main menu
│   └── GameScreen.java       — Core gameplay screen
├── entities/
│   ├── Player.java           — Player logic and movement
│   └── Guard.java            — Steven AI and flashlight
└── world/
    └── DayNightCycle.java    — Timer and phase management
```

---

## Running the Project

```bash
./gradlew lwjgl3:run
```

---

## Status
> 🚧 Currently in active prototype development — placeholder graphics, core mechanics in progress.

---

## Credits
- **Developer:** Ciel
- **Framework:** [LibGDX](https://libgdx.com)
- **Assets:** Various free sources via [itch.io](https://itch.io) and [OpenGameArt](https://opengameart.org)
A [libGDX](https://libgdx.com/) project generated with [gdx-liftoff](https://github.com/libgdx/gdx-liftoff).

This project was generated with a template including simple application launchers and an `ApplicationAdapter` extension that draws libGDX logo.

## Platforms

- `core`: Main module with the application logic shared by all platforms.
- `lwjgl3`: Primary desktop platform using LWJGL3; was called 'desktop' in older docs.

## Gradle

This project uses [Gradle](https://gradle.org/) to manage dependencies.
The Gradle wrapper was included, so you can run Gradle tasks using `gradlew.bat` or `./gradlew` commands.
Useful Gradle tasks and flags:

- `--continue`: when using this flag, errors will not stop the tasks from running.
- `--daemon`: thanks to this flag, Gradle daemon will be used to run chosen tasks.
- `--offline`: when using this flag, cached dependency archives will be used.
- `--refresh-dependencies`: this flag forces validation of all dependencies. Useful for snapshot versions.
- `build`: builds sources and archives of every project.
- `cleanEclipse`: removes Eclipse project data.
- `cleanIdea`: removes IntelliJ project data.
- `clean`: removes `build` folders, which store compiled classes and built archives.
- `eclipse`: generates Eclipse project data.
- `idea`: generates IntelliJ project data.
- `lwjgl3:jar`: builds application's runnable jar, which can be found at `lwjgl3/build/libs`.
- `lwjgl3:run`: starts the application.
- `test`: runs unit tests (if any).

Note that most tasks that are not specific to a single project can be run with `name:` prefix, where the `name` should be replaced with the ID of a specific project.
For example, `core:clean` removes `build` folder only from the `core` project.
