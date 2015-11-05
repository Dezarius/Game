/*
 * © 2015 Jan Abelmann
 */

package states;

import Entity.EntityManager;
import Entity.Player;
import Input.Keyboard;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import world.World;
import world.WorldManager;

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
    g.drawString("Game", 50, 50);
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
    Keyboard.playerInput(gc);
    EntityManager.player.move();
  }

}
