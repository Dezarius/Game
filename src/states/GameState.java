/*
 * © 2015 Jan Abelmann
 */

package states;

import Bullets.BulletManager;
import Entity.EntityManager;
import Input.Keyboard;
import Input.Mouse;
import main.Debug;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import world.World;

/**
 * InGame-State
 * 
 * Renders and updates the game
 */
public class GameState extends BasicGameState {
  
  /**
   * Returns the Id of the State
   * 
   * @return StateId
   */
  @Override
  public int getID() {
    return StateManager.GAME;
  }

  /**
   * Init the Game
   * 
   * @param gc
   * @param s
   * @throws SlickException 
   */
  @Override
  public void init(GameContainer gc, StateBasedGame s) throws SlickException {
    World.changeCurrentMap(-1);
  }

  /**
   * Renders the Game
   * 
   * @param gc
   * @param s
   * @param g
   * @throws SlickException 
   */
  @Override
  public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
    World.renderCurrentMap();
    EntityManager.player.draw();
    BulletManager.draw();
    Debug.render(gc,s,g);
  }
  
  /**
   * Updates the logic
   * 
   * @param gc
   * @param s
   * @param delta
   * @throws SlickException 
   */
  @Override
  public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
    Keyboard.input(gc, s);
    Keyboard.changeMap(gc);
    Keyboard.playerInput(gc);
    Mouse.Input();
    World.cameraFollowsPlayer();
    BulletManager.update();
    EntityManager.player.move();
    Debug.update();
    if(StateManager.currentstate != StateManager.GAME) {
        s.enterState(StateManager.currentstate);
    }
  }
  
}
