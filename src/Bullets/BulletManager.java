/*
 * Copyright 2016 Jan Abelmann
 */
package Bullets;

import Entity.EntityManager;
import java.util.ArrayList;
import java.util.List;
import Config.Config;
import world.Tile;
import world.World;

/**
 *
 * @author Jan
 */
public class BulletManager {

    public static PistolBullet b = null;

    private static List bullets = new ArrayList();

    public static void newBullet(float x, float y, float vectorX, float vectorY, float DrawRotation) {
        createPistolBullet(x, y, vectorX, vectorY, DrawRotation);
    }

    private static void createPistolBullet(float x, float y, float vectorX, float vectorY, float DrawRotation) {

        bullets.add(new PistolBullet(x, y, vectorX, vectorY, DrawRotation));
    }

    public static void update() {
        List removeList = new ArrayList();
        for (Object o : bullets) {
            Bullet b = (Bullet) o;
            if(b.getX() > 10 && b.getX() < Config.WindowWidth - 10 && b.getY() > 10 && b.getY() < Config.WindowHeight - 10) {
                if(!World.collision(((int) b.getX() - 6 - World.mapX) / Tile.SIZE, ((int) b.getY() -6 -  World.mapY) / Tile.SIZE, ((int) b.getX() + 6 - World.mapX)/ Tile.SIZE, ((int) b.getY() + 6 - World.mapY)/ Tile.SIZE)) {
                    b.move();
                }
                else {
                    removeList.add(o);
                }
            }
            else {
                removeList.add(o);
            }
        }
        for(Object o : removeList) {
            bullets.remove(o);
            //System.out.println("löschen");
        }

    }

    public static void draw() {
        for (Object o : bullets) {
            ((Bullet) o).draw();
        }
    }

    public static void deleteBullets() {
        bullets.clear();
    }

    public static int returnSize() {
        return bullets.size();
    }
}
