/*
 * © 2015 Jan Abelmann
 */

package main;

import Config.Config;
import gui.Window;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;


/**
 * Main Method
 */
public class Main{
  
  public static void main(String[] args){
    try{
      AppGameContainer app = new AppGameContainer(new Engine(Config.GameName));
      app.setDisplayMode(Window.WWIDTH, Window.WHEIGHT, Config.Fullscreen); // false == no fullscreen
      app.start();
    }
    catch (SlickException ex){
      Logger.getLogger(Engine.class.getName()).log(Level.SEVERE, null, ex);
    }

  }
}