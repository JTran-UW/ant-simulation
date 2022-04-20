import java.util.*;

public class Ant
{
   private int x;
   private int y;
   private int radius;
   private Random rand;
   private boolean foodFound;
   
   private int left = 1;
   private int right = 1;
   private int up = 1;
   private int down = 1;
   private int count = 0;
   private Stack<Integer> vDirections = new Stack<>();
   private Stack<Integer> hDirections = new Stack<>();

   /**
   * Ant object
   *
   * @param initX initial x-coordinate of ant
   * @param initY initial y-coordinate of ant
   * @param antRadius radius of ant
   */
   public Ant(int initX, int initY, int antRadius)
   {
      this.x = initX;
      this.y = initY;
      this.radius = antRadius;
      this.rand = new Random();
      this.foodFound = false;
   }
   
   /**
   * Change x and y after move
   *
   * @param speed speed of ant
   */
   public void move(int speed)
   {
      // Check if food found
      if (this.foodFound)
      {
         try
         {
            this.x += hDirections.pop();
            this.y += vDirections.pop();
         }
         catch (EmptyStackException e)
         {
            setFoodFound(false);
         }
      }
      else
      {
         int nextVert = this.rand.nextInt(3 * (up + down) / 2) + 1; // +1 to make nextInt() 1-n inclusive.
         int nextHor = this.rand.nextInt(3 * (left + right) / 2) + 1;
         
         // Should it go up, down, or nowhere?
         if (nextVert <= up)
         {
            this.y -= speed;
            vDirections.push(new Integer(speed));
            up++;
         }
         else if (nextVert > up && nextVert <= up + down)
         {
            this.y += speed;
            vDirections.push(new Integer(-speed));
            down++;
         }
         else
         {
            vDirections.push(new Integer(0));
         }
         
         // Left, right or nowhere?
         if (nextHor <= right)
         {
            this.x += speed;
            hDirections.push(new Integer(-speed));
            right++;
         }
         else if (nextHor > right && nextHor <= left + right)
         {
            this.x -= speed;
            hDirections.push(new Integer(speed));
            left++;
         }
         else
         {
            hDirections.push(new Integer(0));
         }
      }
   }
   
   /**
   * Handle out-of-bounds ant
   *
   * @param speed speed of ant
   * @param width width of panel
   * @param height height of panel
   */
   public void outOfBounds(int speed, int width, int height)
   {
      if (this.x > width)
      {
         this.x -= speed;
      }
      if (this.x < 0)
      {
         this.x += speed;
      }
      if (this.y > height)
      {
         this.y -= speed;
      }
      if (this.y < 0)
      {
         this.y += speed;
      }
      
      reset();
   }
   
   /**
   * Get x-coordinate of ant
   *
   * @return x-coordinate of ant
   */
   public int getX()
   {
      return this.x;
   }
   
   /**
   * Get y-coordinate of ant
   *
   * @return y-coordinate of ant
   */
   public int getY()
   {
      return this.y;
   }
   
   /**
   * Get if ant has found food
   *
   * @return if ant has found food
   */
   public boolean getFoodFound()
   {
      return this.foodFound;
   }
   
   /**
   * Get radius of ant
   *
   * @return radius of ant
   */
   public int getRadius()
   {
      return this.radius;
   }
   
   /**
   * Set if ant has found food
   *
   * @param val new value of foodFound
   */
   public void setFoodFound(boolean val)
   {
      this.foodFound = val;
   }
   
   /**
   * Reset directional probabilities
   */
   private void reset()
   {
      left = 1;
      right = 1;
      up = 1;
      down = 1;
   }
}
