/*
 * © 2015 Jan Abelmann
 */

package Input;

import Entity.EntityManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import states.StateManager;
import world.Tile;
import world.World;

/**
 *
 * 
 */
public class KeyboardOld {
  
  public static void input(GameContainer gc,StateBasedGame s) {
    changeState(gc,s);

  }
  
  public static void changeMap(GameContainer gc) throws SlickException {
    if(gc.getInput().isKeyPressed(Input.KEY_0)) {
      World.changeCurrentMap(0);
    }
    else if(gc.getInput().isKeyPressed(Input.KEY_1)) {
      World.changeCurrentMap(1);
    }
    if(gc.getInput().isKeyDown(Input.KEY_LEFT)) {
      World.mapX--;
    }
    if(gc.getInput().isKeyDown(Input.KEY_RIGHT)) {
      World.mapX++;
    }
    if(gc.getInput().isKeyDown(Input.KEY_UP)) {
      World.mapY--;
    }
    if(gc.getInput().isKeyDown(Input.KEY_DOWN)) {
      World.mapY++;
    }
    
    
  }
  
  public static void playerInput(GameContainer gc) {
    if(gc.getInput().isKeyPressed(Input.KEY_W)) {
      if(World.collision((int)(EntityManager.player.getX()+1 - World.mapX) / Tile.SIZE,(int) (EntityManager.player.getY()+33 - World.mapY) / Tile.SIZE,(int) (EntityManager.player.getX()+31-World.mapX) / Tile.SIZE,(int) (int) (EntityManager.player.getY()+ 33-World.mapY) / Tile.SIZE))
        EntityManager.player.setY(-2);
      EntityManager.player.setVelY(-6);
    }
    if(gc.getInput().isKeyDown(Input.KEY_D)) {
      EntityManager.player.moveX(true);
    }
    else if(gc.getInput().isKeyDown(Input.KEY_A)) {
      EntityManager.player.moveX(false);
    } 
    else{
      int mapx = World.mapX;
      int mapy = World.mapY;
      if(World.collision( (int) (EntityManager.player.getX() - mapx) / Tile.SIZE,
              (int) (EntityManager.player.getY() + EntityManager.player.getVelY() - mapy) / Tile.SIZE + 1 ,
              (int) (EntityManager.player.getX() - mapx) / Tile.SIZE + 1,
              (int) (EntityManager.player.getY() + EntityManager.player.getVelY() - mapy) / Tile.SIZE + 1 )) {
        EntityManager.player.slowX();
      }
    }
  }
  
  private static void changeState(GameContainer gc,StateBasedGame s) {
    //MENU -> GAME
    if(gc.getInput().isKeyPressed(Input.KEY_G) && StateManager.currentstate == StateManager.MENU) {
      s.enterState(StateManager.GAME);
      StateManager.currentstate = StateManager.GAME;
    }
    else if(gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
      //INGAMEMENU -> GAME
      if(StateManager.currentstate == StateManager.INGAMEMENU) {
        s.enterState(StateManager.GAME);
        StateManager.currentstate = StateManager.GAME;  
      }
      //GAME -> INGAMEMENU
      else if(StateManager.currentstate == StateManager.GAME) {
        s.enterState(StateManager.INGAMEMENU);
        StateManager.currentstate = StateManager.INGAMEMENU;
      }
    }
    //INGAMEMENU -> MENU
    else if(gc.getInput().isKeyPressed(Input.KEY_M) && StateManager.currentstate == StateManager.INGAMEMENU) {
      s.enterState(StateManager.MENU);
      StateManager.currentstate = StateManager.MENU;
    }
  }
  
}