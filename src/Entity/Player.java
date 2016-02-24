/*
 * © 2015 Jan Abelmann
 */

package Entity;

import Config.Config;
import Input.Mouse;
import gui.Resources;
import main.Debug;
import main.Utilities;
import states.StateManager;
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
    x = 100.0f;
    y = 100.0f;
    velX = 0f;
    velY = 0f;
  }
  
  public void move() {

      //COLLISION UP/BOT
      if (World.collision((int) (x + 1 /*- World.mapX*/) / Tile.SIZE, (int) (y + velY + Config.PHeight /*- World.mapY*/) / Tile.SIZE, (int) (x + Config.PWidth - 1 /*- World.mapX*/) / Tile.SIZE, (int) (int) (y + velY + Config.PHeight /*- World.mapY*/) / Tile.SIZE)) {
          while (!World.collision((int) (x + 1 /*- World.mapX*/) / Tile.SIZE, (int) (y + Config.PHeight + 1/* - World.mapY*/) / Tile.SIZE, (int) (x + Config.PWidth - 1 /*- World.mapX*/) / Tile.SIZE, (int) (int) (y + Config.PHeight + 1 /*- World.mapY*/) / Tile.SIZE)) {
              y++;
          }
          //y = (y + velY) - ((y + velY) % Tile.SIZE);
          velY = 0;
      } else if (World.collision((int) (x + 1 /*- World.mapX*/) / Tile.SIZE, (int) (y + velY /*- World.mapY*/) / Tile.SIZE, (int) (x + Config.PWidth - 1 /*- World.mapX*/) / Tile.SIZE, (int) (int) (y + velY /*- World.mapY*/) / Tile.SIZE)) {
          while (!World.collision((int) (x + 1 /*- World.mapX*/) / Tile.SIZE, (int) (y - 1 /*- World.mapY*/) / Tile.SIZE, (int) (x + Config.PWidth - 1 /*- World.mapX*/) / Tile.SIZE, (int) (int) (y - 1 /*- World.mapY*/) / Tile.SIZE)) {
              y--;
          }
          //y = y = (y + velY) + (Tile.SIZE - (y + velY) % Tile.SIZE);
          velY = 0;
      } else {
          velY = EntityManager.applyGravity(velY);
          y = y + velY;
      }

      //COLLISION LEFT/RIGHT
      if (x + velX < -1 || World.collision((int) (x + velX /*- World.mapX*/) / Tile.SIZE, (int) (y + 1 /*- World.mapY*/) / Tile.SIZE, (int) (x + velX /*- World.mapX*/) / Tile.SIZE, (int) (y + Config.PHeight - 1 /*- World.mapY*/) / Tile.SIZE)) {
          while (x > 0 && !World.collision((int) (x - 1 /*- World.mapX*/) / Tile.SIZE, (int) (y + 1 /*- World.mapY*/) / Tile.SIZE, (int) (x - 1 /*- World.mapX*/) / Tile.SIZE, (int) (y + Config.PHeight - 1/* - World.mapY*/) / Tile.SIZE)) {
              x--;
          }
          velX = 0;
      } else if (World.collision((int) (x + velX + Config.PWidth /*- World.mapX*/) / Tile.SIZE, (int) (y + 1 /*- World.mapY*/) / Tile.SIZE, (int) (x + velX + Config.PWidth /*- World.mapX */) / Tile.SIZE, (int) (y + Config.PHeight - 1/* - World.mapY*/) / Tile.SIZE)) {
          while (!World.collision((int) (x + Config.PWidth + 1 /*-World.mapX*/) / Tile.SIZE, (int) (y + 1 /*- World.mapY*/) / Tile.SIZE, (int) (x + Config.PWidth + 1 /*- World.mapX*/) / Tile.SIZE, (int) (y + Config.PHeight - 1/* - World.mapY*/) / Tile.SIZE)) {
              x++;
          }
          velX = 0;
      } else {
          x = x + velX;
      }
  }
  
  public void moveX(boolean right) {
    if(right && velX <= 5) {
      velX = velX + Config.PMoveSpeed;
    } else if(velX > 5) {
        velX = 5;
    }else if(!right && velX >= -5) {
      velX = velX - Config.PMoveSpeed;
    } else if(velX < -5) {
        velX = -5;
    }
  }
  public void slowX() {
    if(velX < - Config.PSlowSpeed) {
      velX = velX + Config.PSlowSpeed;
    } else if(velX > Config.PSlowSpeed) {
      velX = velX - Config.PSlowSpeed;
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
    Resources.getImage("player").draw(x + World.mapX,y + World.mapY);
  }
  
  public float getAngle() {
      float angle = 0;
      float[] position = Mouse.getPosition();
      if (StateManager.currentstate == StateManager.GAME) {
          if (position[1] >= y + Config.PHeight / 2 + World.mapY) {
              angle = Utilities.AngleBetweenVectors(position[0] - (x + Config.PWidth / 2 + World.mapX), position[1] - (y + Config.PHeight / 2 + World.mapY), 1, 0);
          } else {
              angle = 360 - Utilities.AngleBetweenVectors(position[0] - (x + Config.PWidth / 2 + World.mapX), position[1] - (y + Config.PHeight / 2 + World.mapY), 1, 0);
          }
      }
      return angle;
  }
  
  
}
