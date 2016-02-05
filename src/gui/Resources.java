/*
 * © 2015 Jan Abelmann
 */

package gui;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;
import world.Tile;

/**
 * Holds Maps of all images,sprites and sounds.
 */
public class Resources {

  private static Map<String, Image> images; 
  private static Map<String, SpriteSheet> sprites;
  private static Map<String, Sound> sounds;
  
  /**
   * Init all Maps and loads all images,sounds,sprites.
   */
  public Resources() {
    images = new HashMap<>();
    sprites = new HashMap<>();
    sounds = new HashMap<>();
    
    try {
      sprites.put("tileset", loadSprite("tilesheet.png",Tile.SIZE,Tile.SIZE));
      images.put("MapOverlay",loadImage("mapOverlay.png"));
      images.put("Background", loadImage("background.png"));
      images.put("player",loadImage("player.png"));
      images.put("menuPic", loadImage("menu.jpg"));
      images.put("direction", loadImage("Richtung.png"));
    } catch (SlickException ex) {
      System.out.println("FEHLER!");
      Logger.getLogger(Resources.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  //loads the image at "path"
  private Image loadImage(String path) throws SlickException {
    return new Image(path, false, Image.FILTER_NEAREST);
  }
  
  //loads the sprite at "path"
  private SpriteSheet loadSprite(String path, int spriteWidth, int spriteHeight) throws SlickException {
     return new SpriteSheet(loadImage(path), spriteWidth, spriteHeight);
  }
  
  /**
   * Returns a subimage of the SpriteSheet
   * 
   * @param getter Name of the SpriteSheet
   * @param x x-coordinate in the SpriteSheet
   * @param y y-coordinate in the SpriteSheet
   * @return the Image
   */
  public static Image getSpriteImage(String getter, int x, int y) {
    return sprites.get(getter).getSubImage(x, y);
  }
  
  /**
   * Returns the hole SpriteSheet
   * 
   * @param getter Name of the SpriteSheet
   * @return the hole SpriteSheet
   */
  public static SpriteSheet getSprite(String getter) {
    return sprites.get(getter);
  }
  
  /**
   * Returns an Image out of the Imagesmap
   * 
   * @param getter Name of the Image
   * @return the Image
   */
  public static Image getImage(String getter) {
    return images.get(getter);
  }
  
  /**
   * Returns an Sound out of the Soundsmap
   * 
   * @param getter
   * @return the Sound
   */
  public static Sound getSound(String getter) {
    return sounds.get(getter);
  }
} 
