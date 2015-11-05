/*
 * © 2015 Jan Abelmann
 */

package Entity;

/**
 *
 * 
 */
public class EntityManager {

  public static Player player = new Player();
  
  
  public static float applyGravity(float velY) {
    if(velY < 7) {
      velY = velY + 0.15f;
    }
    return velY;
  }
  
}
