// Joshua T
// Period 8
// Final Project
// Simulation of the behavior of ants in finding and returning food
// Food
// 5/23/2021

public class Food
{
   private int x;
   private int y;
   private int radius;
   
   /**
   * Food object in simulation
   *
   * @param initX x-coordinate of food
   * @param initY y-coordinate of food
   * @param radius radius of food
   */
   public Food(int initX, int initY, int radius)
   {
      this.x = initX;
      this.y = initY;
      this.radius = radius;
   }
   
   /**
   * Check if food is contacting ant
   *
   * @param antX x-coordinate of x
   * @param antY y-coordinate of y
   * @return antRadius radius of ant
   */
   public boolean checkContact(int antX, int antY, int antRadius)
   {
      double diffX = (double) this.x - (double) antX;
      double diffY = (double) this.y - (double) antY;
      double distance = Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
      
      return !((double) antRadius + (double) this.radius < distance);
   }
   
   /**
   * Get x-coordinate of food
   *
   * @return x-coordinate of food
   */
   public int getX()
   {
      return this.x;
   }
   
   /**
   * Get y-coordinate of food
   *
   * @return y-coordinate of food
   */
   public int getY()
   {
      return this.y;
   }
   
   /**
   * Get radius of food
   *
   * @return radius of food
   */
   public int getRadius()
   {
      return this.radius;
   }
}
