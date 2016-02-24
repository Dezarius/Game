/*
 * © 2015 Jan Abelmann
 */
package world;

import Bullets.BulletManager;
import Config.Config;
import Entity.EntityManager;
import gui.Resources;
import gui.Window;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import states.StateManager;

/**
 *
 *
 */
public class World {

    public static TiledMap map = null;
    private static int loadedMap = -1;

    //private static int[][] interactives;
    /**
     * Loads all Maps to an TiledMap array
     *
     * @param ID The Map ID found in Worldmanager
     * @throws SlickException
     */
    private static void loadMap(int ID) throws SlickException {
        if (ID > -1 && ID != loadedMap) {
            map = new TiledMap(WorldManager.maps[ID]);
            mapX = 0;
            mapY = 0;
            for (int i = 0; i < map.getWidth(); i++) {
                for (int j = 0; j < map.getHeight(); j++) {
                    int id = map.getTileId(i, j, map.getLayerIndex("interactives"));
                    if (id == 9) {
                        EntityManager.player.setSpawn(i, j);
                    }
                }
            }
        } else {
            map = null;
        }
    }

    public static int mapX = 0;
    public static int mapY = 0;
    //public static int velMapX

    /**
     * Renders the current map
     */
    public static void renderCurrentMap() {
        Resources.getImage("Background6").draw(mapX * Config.BackgroundMovement - Config.BackgroundX, mapY * Config.BackgroundMovement - Config.BackgroundY, Config.BackgroundScale);
        if (map != null) {
            if (StateManager.currentstate == StateManager.GAME) {
                //Kamerabewegung links
                if(mapX < -6 && EntityManager.player.getX() + mapX < Window.WWIDTH / 2 - 110) {
                    mapX = mapX - (int) EntityManager.player.getVelX();
                    if(EntityManager.player.getX() + mapX < Window.WWIDTH / 2 - 110)
                        EntityManager.player.setX(1 - EntityManager.player.getX() % 1);
                }
                //Kamerabewegung rechts
                else if(mapX + World.map.getWidth() * 32 - 6 > Window.WWIDTH && EntityManager.player.getX() + mapX > Window.WWIDTH / 2 + 80) {
                    mapX = mapX - (int) (EntityManager.player.getVelX());
                    if(EntityManager.player.getX() + mapX > Window.WWIDTH / 2 + 80)
                        EntityManager.player.setX(- EntityManager.player.getX() % 1);
                }
                
                //Kamerabewegung oben
                if(mapY < -6 && EntityManager.player.getY() + mapY < Window.WHEIGHT / 2 - 100 && EntityManager.player.getVelY() != 0) {
                    mapY = mapY - (int) EntityManager.player.getVelY();
                }
                else if(mapY < -6 && EntityManager.player.getY() + mapY < Window.WHEIGHT / 2 - 100) {
                    mapY += 5;
                }
                //Kamerabewegung unten
                else if(mapY + World.map.getHeight() * 32 - 6 > Window.WHEIGHT && EntityManager.player.getY() + mapY > Window.WHEIGHT / 2 + 100 && EntityManager.player.getVelY() != 0) {
                    mapY = mapY - (int) EntityManager.player.getVelY();
                }
                else if(mapY + World.map.getHeight() * 32 - 6 > Window.WHEIGHT && EntityManager.player.getY() + mapY > Window.WHEIGHT / 2 + 100) {
                    mapY -= 5;
                }

                
            }
            map.render((int)mapX, (int) mapY, map.getLayerIndex("solids")); 
        }
    }

    /**
     * Changes the current map to MapID
     *
     * @param MapID between 0-0 * @throws org.newdawn.slick.SlickException
     */
    public static void changeCurrentMap(int MapID) throws SlickException {
        if (MapID > -1) {
            loadedMap = -1;
            loadMap(MapID);
            loadedMap = MapID;
            BulletManager.deleteBullets();
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
        if (loadedMap > -1 && (x < 0 || x > map.getWidth() || y < 0 || y > map.getHeight())) {
            return false;
        }
        if (loadedMap > -1 && (map.getTileId(x, y, map.getLayerIndex("solids")) != 0)) {
            return true;
        }
        return false;
    }

    public static boolean collision(int x, int y, int endx, int endy) {
        if (map == null) {
            return false;
        } else if (endx + 1 > map.getWidth()) {
            return true;
        }
        for (int i = x; i <= endx; i++) {
            for (int j = y; j <= endy; j++) {
                if (isSolid(i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

}
