/*
 * © 2015 Jan Abelmann
 */
package Input;

import Bullets.BulletManager;
import Config.Config;
import Entity.EntityManager;
import gui.Resources;
import main.Debug;
import main.Utilities;
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
public class Keyboard {

    public static void input(GameContainer gc, StateBasedGame s) {
        changeState(gc, s);
        if (gc.getInput().isKeyPressed(Config.Debug)) {
            Debug.toggleDebug();
        }
    }

    public static void changeMap(GameContainer gc) throws SlickException {
        if (gc.getInput().isKeyPressed(Input.KEY_0)) {
            World.changeCurrentMap(0);
        } else if (gc.getInput().isKeyPressed(Input.KEY_1)) {
            World.changeCurrentMap(1);
        }
    }

    private static int jumpCounter = 0;

    public static void playerInput(GameContainer gc) {
        if (StateManager.currentstate == StateManager.GAME) {
            if (gc.getInput().isKeyPressed(Input.KEY_H)) {
                float[] pos = Mouse.getPosition();
                System.out.println("Maus: " + pos[0] + "|" + pos[1]);
                System.out.println("Spieler: " + EntityManager.player.getX() + "|" + EntityManager.player.getY());
                System.out.println("Winkel: " + Utilities.angle);
            }
            if (gc.getInput().isKeyPressed(Config.PUp) || gc.getInput().isKeyPressed(Config.PUp2)) {
                if (World.collision((int) (EntityManager.player.getX() + 1 - World.mapX) / Tile.SIZE, (int) (EntityManager.player.getY() + Config.PHeight + 1 - World.mapY) / Tile.SIZE, (int) (EntityManager.player.getX() + Config.PWidth-1 - World.mapX) / Tile.SIZE, (int) (int) (EntityManager.player.getY() + Config.PHeight + 1 - World.mapY) / Tile.SIZE)) {
                    EntityManager.player.setY(-2);
                    jumpCounter = 0;
                }
                if (jumpCounter < Config.AmountOFJumps) {
                    jumpCounter++;
                    EntityManager.player.setVelY(-Config.JumpHeight);
                    EntityManager.firstGravity = true;
                }
            }
            if (gc.getInput().isKeyDown(Config.PRight)) {
                EntityManager.player.moveX(true);
            } else if (gc.getInput().isKeyDown(Config.PLeft)) {
                EntityManager.player.moveX(false);
            } else {
                int mapx = World.mapX;
                int mapy = World.mapY;
                if (World.collision((int) (EntityManager.player.getX() - mapx) / Tile.SIZE,
                        (int) (EntityManager.player.getY() + EntityManager.player.getVelY() - mapy) / Tile.SIZE + 1,
                        (int) (EntityManager.player.getX() - mapx) / Tile.SIZE + 1,
                        (int) (EntityManager.player.getY() + EntityManager.player.getVelY() - mapy) / Tile.SIZE + 1)) {
                    EntityManager.player.slowX();
                }
            }
        }
    }

    private static void changeState(GameContainer gc, StateBasedGame s) {
        //MENU -> GAME
        if (gc.getInput().isKeyPressed(Config.StateGame) && StateManager.currentstate == StateManager.MENU) {
            s.enterState(StateManager.GAME);
            StateManager.currentstate = StateManager.GAME;
        } else if (gc.getInput().isKeyPressed(Config.StateInGameMenu)) {
            //INGAMEMENU -> GAME
            if (StateManager.currentstate == StateManager.INGAMEMENU) {
                gc.getInput().clearKeyPressedRecord();
                s.enterState(StateManager.GAME);
                StateManager.currentstate = StateManager.GAME;
            } //GAME -> INGAMEMENU
            else if (StateManager.currentstate == StateManager.GAME) {
                s.enterState(StateManager.INGAMEMENU);
                StateManager.currentstate = StateManager.INGAMEMENU;
            }
        } //INGAMEMENU -> MENU
        else if (gc.getInput().isKeyPressed(Config.StateMenu) && StateManager.currentstate == StateManager.INGAMEMENU) {
            s.enterState(StateManager.MENU);
            StateManager.currentstate = StateManager.MENU;
        }
    }

}
