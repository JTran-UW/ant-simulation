// Joshua T
// Period 8
// Final Project
// Simulation of the behavior of ants in finding and returning food
// Simulation
// 5/23/2021

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Simulation
{
   /**
   * Framerate of simulation
   */
   private static final int FRAMERATE = 100;
   
   /**
   * Number of frames in simulation
   */
   private static final int FRAMES = 4000;
   
   /**
   * Width of panel
   */
   private static final int WIDTH = 1000;
   
   /**
   * Height of panel
   */
   private static final int HEIGHT = 500;
   
   /**
   * Radius of ant
   */
   private static final int RADIUS = 5;
   
   /**
   * Speed of ant
   */
   private static final int SPEED = 2;
   
   /**
   * Number of ants
   */
   private static final int NUM = 350;
   
   /**
   * Radius of food
   */
   private static final int FOOD_RADIUS = 5;
   
   /**
   * Opens ant simulation
   *
   * @param args console input
   */
   public static void main(String[] args)
   {
      DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
      Graphics g = panel.getGraphics();
      
      Colony colony = new Colony(NUM, WIDTH/2, HEIGHT/2, RADIUS);
      FoodManager fm = new FoodManager(FOOD_RADIUS);
      
      DrawingMouseListener dml = new DrawingMouseListener(panel, g, fm);
      panel.addMouseListener(dml);
      
      AntKeyListener akl = new AntKeyListener(panel, g, colony, fm);
      panel.addKeyListener(akl);
      
      // Wait for space to go.
      while (!akl.getRun())
      {
         panel.sleep(100);
      }
      runSimulation(panel, g, colony, fm);
   }
   
   /**
   * Runs simulation
   *
   * @param panel DrawingPanel to draw to
   * @param g Graphics of panel
   * @param colony Colony object containing ants
   * @param fm FoodManager of simulation food
   */
   public static void runSimulation(DrawingPanel panel, Graphics g, Colony colony, FoodManager fm)
   {
      for (int frame = 0; frame < FRAMES; frame++)
      {
         for (int i = 0; i < NUM; i++)
         {
            Ant ant = colony.getAnt(i);
            colony.drawAnt(g, i, SPEED, WIDTH, HEIGHT);
            if (fm.checkForContact(g, ant.getX(), ant.getY(), ant.getRadius(), true))
            {
               ant.setFoodFound(true);
            }
         }
         panel.sleep(1000 / FRAMERATE);
      }
   }
}
