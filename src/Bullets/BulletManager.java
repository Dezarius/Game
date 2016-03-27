/*
 * Copyright 2016 Jan Abelmann
 */
package Bullets;

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
            if(b.getX() > 5 && b.getX() < World.map.getWidth() * Tile.SIZE - 10 && b.getY() > 5 && b.getY() < World.map.getHeight() * 32 - 10) {
                if(!World.collision(((int) b.nextX()) / Tile.SIZE, ((int) b.nextY()) / Tile.SIZE, ((int) b.nextX() + 4)/ Tile.SIZE, ((int) b.nextY() + 4)/ Tile.SIZE)) {
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
    
    public static int amountOfBullets() {
        return bullets.size();
    }
}
