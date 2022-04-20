// Joshua T
// Period 8
// Final Project
// Simulation of the behavior of ants in finding and returning food
// FoodManager
// 5/23/2021

import java.util.*;
import java.awt.*;

public class FoodManager
{
   private ArrayList<Food> foods;
   private int foodRadius;
   
   /**
   * Collection of all foods in simulation
   *
   * @param foodRadius radius of food
   */
   public FoodManager(int foodRadius)
   {
      this.foodRadius = foodRadius;
      this.foods = new ArrayList<Food>();
   }
   
   /**
   * Adds new food to panel
   *
   * @param x x-coordinate of food
   * @param y y-coordinate of food
   * @param g Graphics of panel
   */
   public void addFood(int x, int y, Graphics g)
   {
      this.foods.add(new Food(x, y, this.foodRadius));
      g.setColor(Color.GREEN);
      g.fillOval(x, y, this.foodRadius, this.foodRadius);
   }
   
   /**
   * Check if any foods are in contact with (x, y)
   *
   * @param g Graphics of panel
   * @param x x-coordinate of object
   * @param y y-coordinate of object
   * @param radius radius of object
   * @param eat whether or not food will be eaten on contact
   */
   public boolean checkForContact(Graphics g, int x, int y, int radius, boolean eat)
   {
      for (int f = 0; f < this.foods.size(); f++)
      {
         Food food = this.foods.get(f);
         
         if (food.checkContact(x, y, radius))
         {
            if (eat)
            {
               // Erase food
               g.setColor(Color.WHITE);
               g.fillRect(food.getX(), food.getY(), food.getRadius(), food.getRadius());
               foods.remove(f);
            }
            return true;
         }
      }
      
      return false;
   }
   
   /**
   * Get radius of food
   *
   * @return radius of food
   */
   public int getRadius()
   {
      return this.foodRadius;
   }
}
