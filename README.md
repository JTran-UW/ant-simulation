# Ant Simulation
This is simulation of an ant colony's behavior to retrieve food, inspired by [this video](https://github.com/ProfJAT/ant-simulation.git).  When an ant finds a selection of food, it backtracks to the colony, leaving a chemical trail that leads other ants to the spot.

## Quickstart
This project requires installation of the JDK.

Clone the project

```git clone https://github.com/ProfJAT/ant-simulation.git```

Compile it

```javac Simulation.java```

Run the program

```java Simulation.java```

## How To Use

When the window opens, click on the screen to place green dots, which represent food--you can continue creating food after the simulation begins.  Press space to begin the simulation, and press space again to pause/stop it.  It will automatically stop after 4000 frames.

Ants are color coded.  If they turn red, that means they are either backtracking or have encountered another ant's path and are following it.  A cool phenomenon is the paths and patterns that form from these simple rules--keep an eye out for them!
