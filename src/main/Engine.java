/*
 * © 2015 Jan Abelmann
 */

package main;

import Config.Config;
import gui.Resources;
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
    //Keyboard
    //Thread keyboard = new Thread(new KeyboardThreat());
    //keyboard.start();
    gc.setTargetFrameRate(Config.Framerate);
    gc.setAlwaysRender(true);
    gc.setMaximumLogicUpdateInterval(Config.LogicRate);
    gc.setVSync(Config.VSync);
    gc.setShowFPS(false);
    
    //loads all Recourses
    new Resources();
    

    
    //adds all GameStates
    this.addState(new MenuState());
    this.addState(new GameState()); 
    this.addState(new InGameMenuState());
  }
}