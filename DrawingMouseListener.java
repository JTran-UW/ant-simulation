// Joshua T
// Period 8
// Final Project
// Simulation of the behavior of ants in finding and returning food
// DrawingMouseListener
// 5/23/2021

import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class DrawingMouseListener extends MouseInputAdapter 
{
   private DrawingPanel panel;
   private Graphics graphics;
   private FoodManager fm;
   
   /**
   * Constructs a Mouse Listener
   * @param panel the DrawingPanel to draw onto
   * @param Graphics of panel
   * @param fm FoodManager of simulation
   */
   public DrawingMouseListener(DrawingPanel panel, Graphics g, FoodManager fm) 
   {
      this.panel = panel;
      this.graphics = g;
      this.fm = fm;
   }
   
   /**
   * Handles mouse clicks.
   * @param event the MouseEvent representing the mouse click by the user
   */
   public void mousePressed(MouseEvent event) 
   {
      //Get the x and y coordinates of the mouse click, relative to the panel
      int x = event.getX() / panel.getZoom();
      int y = event.getY() / panel.getZoom();
   
      // Draw food in the area
      if (!fm.checkForContact(graphics, x, y, fm.getRadius(), false))
      {
         this.fm.addFood(x, y, graphics);
      }
   }
}
