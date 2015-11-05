/*
 * © 2015 Jan Abelmann
 */

package states;

import Input.Keyboard;
import gui.Window;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Menu-State
 * 
 * Renders and updates the menu
 */
public class MenuState extends BasicGameState {

  /**
   * Returns the ID of the State
   * @return StateId
   */
  @Override
  public int getID() {
    return StateManager.MENU;
  }

  /**
   * Init the menu
   * 
   * @param gc
   * @param s
   * @throws SlickException 
   */
  @Override
  public void init(GameContainer gc, StateBasedGame s) throws SlickException {
    
  }

  /**
   * Renders the menu
   * 
   * @param gc
   * @param s
   * @param g
   * @throws SlickException 
   */
  @Override
  public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
    g.drawString("Menu", 50, 50);
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
  }

}