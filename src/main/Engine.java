/*
 * © 2015 Jan Abelmann
 */

package main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import states.*;

/**
 *
 * 
 */
public class Engine extends StateBasedGame{
  
  public Engine(String gamename)
  {
    super(gamename);
  }

  @Override
  public void initStatesList(GameContainer gc) throws SlickException {
    gc.setTargetFrameRate(60);
    gc.setAlwaysRender(true);
    gc.setMaximumLogicUpdateInterval(60);
    gc.setVSync(true);
    gc.setShowFPS(false);
    
    this.addState(new MenuState());
    this.addState(new GameState()); 
  }
  
  
}
