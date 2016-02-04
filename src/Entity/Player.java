/*
 * © 2015 Jan Abelmann
 */

package Entity;

import gui.Resources;
import world.Tile;
import world.World;
import world.WorldManager;

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
    x = 100.0f;
    y = 5.0f;
    velX = 0f;
    velY = 0f;
  }
  
  public void move() {
    
      if(WorldManager.movingMap) {
        //COLLISION UP/BOT
        if(World.collision((int)(x+1 - World.mapX) / Tile.SIZE,(int) (y+velY+ 32 - World.mapY) / Tile.SIZE,(int) (x+31-World.mapX) / Tile.SIZE,(int) (int) (y+velY + 32-World.mapY) / Tile.SIZE)) {
          while(!World.collision((int)(x+1 - World.mapX) / Tile.SIZE,(int) (y+33 - World.mapY) / Tile.SIZE,(int) (x+31-World.mapX) / Tile.SIZE,(int) (int) (y+ 33-World.mapY) / Tile.SIZE)) {
            y++;
          }
            //y = (y + velY) - ((y + velY) % Tile.SIZE);
          velY = 0;
        }
        else if(World.collision((int)(x+1-World.mapX) / Tile.SIZE,(int) (y+velY-World.mapY) / Tile.SIZE,(int) (x+31-World.mapX) / Tile.SIZE,(int) (int) (y+velY-World.mapY) / Tile.SIZE)) {
          while(!World.collision((int)(x+1-World.mapX) / Tile.SIZE,(int) (y-1-World.mapY) / Tile.SIZE,(int) (x+31-World.mapX) / Tile.SIZE,(int) (int) (y-1-World.mapY) / Tile.SIZE)) {
            y--;
          }
        //y = y = (y + velY) + (Tile.SIZE - (y + velY) % Tile.SIZE);
          velY = 0;
        }
        else {
          velY = EntityManager.applyGravity(velY);
          y = y + velY;
        }
        
        
        //COLLISION LEFT/RIGHT
        if(x + velX < -1 || World.collision((int) (x + velX-World.mapX) / Tile.SIZE, (int) (y + 1-World.mapY) / Tile.SIZE,(int) (x + velX-World.mapX) / Tile.SIZE, (int) (y + 31-World.mapY) / Tile.SIZE)) {
          while( x > 0 && !World.collision((int) (x -1 -World.mapX) / Tile.SIZE, (int) (y + 1-World.mapY) / Tile.SIZE,(int) (x -1-World.mapX) / Tile.SIZE, (int) (y + 31-World.mapY) / Tile.SIZE)) {
            x--;
          }
          velX = 0;
        }
        else if(World.collision((int) (x + velX + 32-World.mapX) / Tile.SIZE, (int) (y + 1-World.mapY) / Tile.SIZE,(int) (x + velX + 32 - World.mapX) / Tile.SIZE, (int) (y + 31-World.mapY) / Tile.SIZE)) {
          while(!World.collision((int) (x + 33-World.mapX) / Tile.SIZE, (int) (y + 1-World.mapY) / Tile.SIZE,(int) (x + 33 - World.mapX) / Tile.SIZE, (int) (y + 31-World.mapY) / Tile.SIZE)) {
            x++;
          }
          velX = 0;
        }
        else {
          x = x + velX;
        }
      } 
  }
  
  public void moveX(boolean right) {
    if(right && velX < 5) {
      velX = velX + 0.2f;
    } else if(!right && velX > -5) {
      velX = velX - 0.2f;
    } 
  }
  public void slowX() {
    if(velX < -0.2) {
      velX = velX + 0.2f;
    } else if(velX > 0.2) {
      velX = velX - 0.2f;
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
  
  public float getVelY() {
    return velY;
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
  
  public void setX(float dx) {
      x = x + dx;
  }
  
  
  public void setSpawn(float a, float b)
  {
    this.x = a * Tile.SIZE + World.mapX;
    this.y = b * Tile.SIZE + World.mapY;
    this.velX = 0;
    this.velY = 0;
  }  
  public void draw() {
    Resources.getImage("player").draw(x,y);
  }
  
}
