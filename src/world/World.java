/*
 * © 2015 Jan Abelmann
 */

package world;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;


/**
 *
 * 
 */
public class World {
  
  private static TiledMap[] maps = new TiledMap[2];
  
  private static int currentmap = -1;

  private static String[] mapPaths = {"/testmap.tmx"};
  
  
  /**
   * Loads all Maps to an TiledMap array
   * @throws SlickException 
   */
  public static void loadAllMaps() throws SlickException{
    for(int i = 0; i < mapPaths.length; i++) {
      maps[i] = new TiledMap(mapPaths[i]);
    }
  }
  
  /**
   * Renders the current map
   */
  public static void renderCurrentMap(){
    if(currentmap != -1) {
      if(currentmap < maps.length) {
        maps[currentmap].render(0, 0);
      }
    }
    
  }
  
  /**
   * Changes the current map to MapID
   * @param MapID between 0-0
   */
  public static void changeCurrentMap(int MapID) {
    if(MapID < maps.length) {
      currentmap = MapID;
    }
  }
          
}