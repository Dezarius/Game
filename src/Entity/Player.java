/*
 * © 2015 Jan Abelmann
 */

package Entity;

import gui.Resources;
import world.Tile;
import world.World;

/**
 *
 * 
 */
public class Player {

  private float x;
  private float y;
  
  private float velX;
  private float velY;
  
  public Player(){
    x = 5.0f;
    y = 5.0f;
    velX = 0f;
    velY = 0f;
  }
  
  public void move() {
    x = x + velX;
    if(!World.isSolid((int) x / Tile.SIZE, (int) y / Tile.SIZE + 1)) {
      velY = EntityManager.applyGravity(velY);
    } else {
      velY = 0;
      y = y - (y % Tile.SIZE);
    }
    
    y = y + velY;

  }
  
  public void moveX(boolean right) {
    if(right && velX < 5) {
      velX = velX + 0.1f;
    } else if(!right && velX > -5) {
      velX = velX - 0.1f;
    }
  }
  public void slowX() {
    if(velX < -0.2) {
      velX = velX + 0.1f;
    } else if(velX > 0.2) {
      velX = velX - 0.1f;
    }
    else {
      velX = 0;
    }
  }
  
  public void setVelX(float value) {
    velX = value;
  }
  public void setVelY(float value) {
    velY = value;
  }
  public float getVelX() {
    return velX;
  }
  
  public float getX() {
    return x;
  }
  public void setY(float value) {
    y = y + value;
  }

  public float getY() {
    return y;
  }
  
  public void setSpawn(float a, float b)
  {
    this.x = a * Tile.SIZE;
    this.y = b * Tile.SIZE;
    this.velX = 0;
    this.velY = 0;
  }  
  public void draw() {
    Resources.getImage("player").draw(x,y);
  }
  
}
