/*
 * Copyright 2016 Jan Abelmann
 */
package Bullets;

import Entity.EntityManager;

/**
 *
 * @author Jan
 */
public class BulletManager {
    
    public static PistolBullet b = null;
    
    public static void newBullet(float x, float y, float vectorX, float vectorY, float DrawRotation) {
        createPistolBullet(x, y, vectorX, vectorY, DrawRotation);
    }
    
    
    private static void createPistolBullet(float x, float y, float vectorX, float vectorY, float DrawRotation) { 
        b = new PistolBullet(x, y, vectorX, vectorY, DrawRotation);
    }
    
    
}
