package states;

/*
 * © 2015 Jan Abelmann
 */

import gui.Resources;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import world.World;

/**
 * Menu-State
 * 
 * Renders and updates the menu
 */
public class InGameMenuState extends BasicGameState {
  
  /**
   * Returns the ID of the State
   * @return StateId
   */
  @Override
  public int getID() {
    return StateManager.INGAMEMENU;
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
    World.renderCurrentMap();
    Resources.getImage("MapOverlay").draw(0, 0);
    g.drawString("InGameMenu", 50, 50);
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
    if(gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
      s.enterState(StateManager.GAME);
    }
    else if(gc.getInput().isKeyPressed(Input.KEY_M)) {
      s.enterState(StateManager.MENU);
    }
  }

}