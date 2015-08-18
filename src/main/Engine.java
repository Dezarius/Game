/*
 * © 2015 Jan Abelmann
 */

package main;

import gui.Resources;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import states.*;

/**
 * Engine of the Game
 */
public class Engine extends StateBasedGame{
  
  /**
   * Creates a Window with the given Name
   * @param gamename 
   */
  public Engine(String gamename)
  {
    super(gamename);
  }

  @Override
  public void initStatesList(GameContainer gc) throws SlickException {
    //Some Framerate and logic stuff
    gc.setTargetFrameRate(60);
    gc.setAlwaysRender(true);
    gc.setMaximumLogicUpdateInterval(60);
    gc.setVSync(true);
    gc.setShowFPS(false);
    
    //loads all Recourses
    new Resources();
    
    //adds all GameStates
    this.addState(new MenuState());
    this.addState(new GameState()); 
  }
}