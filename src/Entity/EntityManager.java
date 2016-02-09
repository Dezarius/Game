/*
 * © 2015 Jan Abelmann
 */

package Entity;

import Config.Config;

/**
 *
 * 
 */
public class EntityManager {

  public static Player player = new Player();
  
  public static boolean firstGravity = true;
  
  private static float currentGravity = 0; 
  public static float applyGravity(float velY) {
    if(velY < Config.MaxGravity) {
      if(firstGravity) {
          currentGravity = Config.Gravity;
          firstGravity = false;
      }
      currentGravity += Config.GravityRate;
      velY = velY + currentGravity;
    }
    return velY;
  }
  
}
