// Joshua T
// Period 8
// Final Project
// Simulation of the behavior of ants in finding and returning food
// Colony
// 5/23/2021

import java.awt.*;

public class Colony
{
   private Ant[] ants;
   private int antRadius;
   
   /**
   * A collection of Ants in a colony
   *
   * @param n number of ants
   * @param initX initial x of all ants
   * @param initY initial y of all ants
   * @param antRadius radius of ants
   */
   public Colony(int n, int initX, int initY, int antRadius)
   {
      this.antRadius = antRadius;
      this.ants = getAnts(n, initX, initY);
   }
   
   /**
   * Draw an ant given its index in this.ants
   *
   * @param g Graphics for simulation
   * @param index index of ant in this.ants
   * @param speed speed of ant
   * @param width width of panel
   * @param height height of panel
   */
   public void drawAnt(Graphics g, int index, int speed, int width, int height)
   {
      // Erase previous location
      Ant ant = this.getAnt(index);
      g.setColor(Color.WHITE);
      g.fillRect(ant.getX(), ant.getY(), ant.getRadius(), ant.getRadius());
      
      // Draw ant in new location
      ant.move(speed);
      if (ant.getX() > width || 
          ant.getX() < 0 || 
          ant.getY() > height || 
          ant.getY() < 0) // Check if ant is out of bounds
      {
         ant.outOfBounds(speed, width, height);
      }
      
      if (ant.getFoodFound())
      {
         g.setColor(Color.RED);
      }
      else
      {
         g.setColor(Color.BLACK);
      }
      g.fillOval(ant.getX(), ant.getY(), ant.getRadius(), ant.getRadius());
   }
   
   /**
   * Get array of Ants in colony
   *
   * @return all ants in colony in ant array
   */
   public Ant[] getColony()
   {
      return this.ants;
   }
   
   /**
   * Get ant in colony by index
   *
   * @param index index of ant in this.ants
   * @return an ant at given index
   */
   public Ant getAnt(int index)
   {
      return this.ants[index];
   }
   
   /**
   * Fills ant array with new ants
   *
   * @param num number of ants
   * @param x x-coordinate of ants
   * @param y y-coordinate of ants
   * @return ant array
   */
   private Ant[] getAnts(int num, int x, int y)
   {
      Ant[] antArr = new Ant[num];
   
      for (int i = 0; i < num; i++)
      {
         antArr[i] = new Ant(x, y, this.antRadius);
      }
      
      return antArr;
   }
}
