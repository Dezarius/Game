/*
 * © 2015 Jan Abelmann
 */

package Input;

import Entity.EntityManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Engine;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import states.MenuState;
import states.StateManager;
import world.Tile;
import world.World;

/**
 *
 * 
 */
public class KeyboardThreat implements Runnable {

    GameContainer gc;
    StateBasedGame s;
    
    
    @Override
    public void run() {
        
        gc = Engine.gamec;
        while(true) {
            try {
                keyRequest();
            } catch (SlickException ex) {
                Logger.getLogger(KeyboardThreat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void keyRequest() throws SlickException {
        if(s == null) {
           s = MenuState.sbg;
        }
        changeMap();
        playerInput();
        changeState();
    }
    
    private void changeMap() throws SlickException {
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
    
    private void playerInput() {
        if(gc.getInput().isKeyPressed(Input.KEY_W)) {
            if(World.collision((int)(EntityManager.player.getX()+1 - World.mapX) / Tile.SIZE,(int) (EntityManager.player.getY()+33 - World.mapY) / Tile.SIZE,(int) (EntityManager.player.getX()+31-World.mapX) / Tile.SIZE,(int) (int) (EntityManager.player.getY()+ 33-World.mapY) / Tile.SIZE))
                EntityManager.player.setY(0);
                EntityManager.player.setVelY(-6);
            }
            if(gc.getInput().isKeyDown(Input.KEY_D)) {
                EntityManager.player.moveX(true);
            }
            else if(gc.getInput().isKeyDown(Input.KEY_A)) {
                EntityManager.player.moveX(false);
        } else {
            float mapx = World.mapX;
            float mapy = World.mapY;
            if (World.collision((int) (EntityManager.player.getX() - mapx) / Tile.SIZE,
                    (int) (EntityManager.player.getY() + EntityManager.player.getVelY() - mapy) / Tile.SIZE + 1,
                    (int) (EntityManager.player.getX() - mapx) / Tile.SIZE + 1,
                    (int) (EntityManager.player.getY() + EntityManager.player.getVelY() - mapy) / Tile.SIZE + 1)) {
                EntityManager.player.slowX(false);
            }
        }
    }
    
    private void changeState() {
        //MENU -> GAME
    if(gc.getInput().isKeyPressed(Input.KEY_G) && StateManager.currentstate == StateManager.MENU) {
      StateManager.currentstate = StateManager.GAME;
    }
    else if(gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
      //INGAMEMENU -> GAME
      if(StateManager.currentstate == StateManager.INGAMEMENU) {
        StateManager.currentstate = StateManager.GAME;  
      }
      //GAME -> INGAMEMENU
      else if(StateManager.currentstate == StateManager.GAME) {
        StateManager.currentstate = StateManager.INGAMEMENU;
      }
    }
    //INGAMEMENU -> MENU
    else if(gc.getInput().isKeyPressed(Input.KEY_M) && StateManager.currentstate == StateManager.INGAMEMENU) {
      StateManager.currentstate = StateManager.MENU;
    }
    }
}