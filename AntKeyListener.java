 // Joshua T
// Period 8
// Final Project
// Simulation of the behavior of ants in finding and returning food
// AntKeyListener
// 5/23/2021

import java.awt.event.*;
import java.awt.*;

public class AntKeyListener extends KeyAdapter 
{
   private DrawingPanel panel;
   private Graphics graphics;
   private Colony colony;
   private FoodManager fm;
   private boolean run = false;
   
   /**
   * Constructs a KeyListener
   *
   * @param panel the DrawingPanel to draw onto
   * @param g Graphics of panel
   * @param colony Colony object of all ants
   * @param fm FoodManager object for simulation
   */
   public AntKeyListener(DrawingPanel panel, Graphics g, Colony colony, FoodManager fm) 
   {
      this.panel = panel;
      this.graphics = g;
      this.colony = colony;
      this.fm = fm;
   }
   
   @Override
   public void keyPressed(KeyEvent event) 
   {
      int code = event.getKeyCode();
      
      if (code == KeyEvent.VK_SPACE)
      {
         run = true; // Run the simulation
      }
   }
   
   /**
   * Get run variable
   *
   * @return run boolean
   */
   public boolean getRun()
   {
      return run;
   }
}
