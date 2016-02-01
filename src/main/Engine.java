/*
 * © 2015 Jan Abelmann
 */

package main;

import Input.Keyboard;
import gui.Resources;
import gui.Window;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import states.*;

/**
 * Engine of the Game
 */
public class Engine extends StateBasedGame{
  
    
    public static GameContainer gamec;
  
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
    gamec = gc;
    gc.setTargetFrameRate(60);
    gc.setAlwaysRender(true);
    gc.setMaximumLogicUpdateInterval(60);
    gc.setVSync(true);
    gc.setShowFPS(true);
    
    //loads all Recourses
    new Resources();
    
    //Keyboard
    Thread keyboard = new Thread(new Keyboard());
    keyboard.start();
    
    //adds all GameStates
    this.addState(new MenuState());
    this.addState(new GameState()); 
    this.addState(new InGameMenuState());
  }
}