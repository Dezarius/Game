/*
 * © 2015 Jan Abelmann
 */

package world;

import Entity.EntityManager;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;


/**
 *
 * 
 */
public class World {
  
  private static TiledMap map = null;
  private static int loadedMap = -1;
  
  //private static int[][] interactives;
  
  /**
   * Loads all Maps to an TiledMap array
   * @param ID The Map ID found in Worldmanager
   * @throws SlickException 
   */
  private static void loadMap(int ID) throws SlickException{
    if(ID > -1 && ID != loadedMap) {
      map = new TiledMap(WorldManager.maps[ID]);
      for(int i = 0; i < map.getWidth(); i++) {
        for(int j = 0; j < map.getHeight(); j++)
        {
          int id = map.getTileId(i, j, map.getLayerIndex("interactives"));
          if(id == 9) {
            //System.out.println(id);
            EntityManager.player.setSpawn(i, j);
          }
        }
      }
    }
    else {
      map = null;
    }
  }
  
  public static int mapX = 50;
  public static int mapY = 50;
  //public static int velMapX
  
  /**
   * Renders the current map
   */
  public static void renderCurrentMap(){
    if(map != null) {
      if(WorldManager.movingMap) {
        map.render(mapX, mapY, map.getLayerIndex("solids"));
      } else {
        map.render(0, 0, map.getLayerIndex("solids"));
      }
    }
  }
  
  /**
   * Changes the current map to MapID
   * @param MapID between 0-0
   * @throws org.newdawn.slick.SlickException
   */
  public static void changeCurrentMap(int MapID) throws SlickException {
    if(MapID > -1) {
      loadedMap = -1;
      loadMap(MapID);
      loadedMap = MapID;
    }
  }
   
  /**
   * Returns, if the Block at x|y is solid
   * 
   * @param x coordinate
   * @param y coordinate
   * @return 
   */
  public static boolean isSolid(int x, int y) {
    if(loadedMap > -1 && (x < 0 || x > map.getWidth() || y < 0 || y > map.getHeight() )){
      return false;
    }
    if(loadedMap > -1 && (map.getTileId(x, y, map.getLayerIndex("solids")) != 0)) {
      return true;
    }
    return false;
  }
  
  public static boolean collision(int x, int y, int endx, int endy) {
    for(int i = x; i <= endx; i++) {
      for(int j = y; j <= endy; j++) {
        if(isSolid(i,j)) {
          return true;
        }
      }
    }
    
    
    return false;
  }
  
}