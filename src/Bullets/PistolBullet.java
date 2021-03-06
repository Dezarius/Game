/*
 * Copyright 2016 Jan Abelmann
 */
package Bullets;

import Config.Config;
import gui.Resources;
import world.World;

/**
 *
 * @author Jan
 */
public class PistolBullet extends Bullet {

    public PistolBullet(float x, float y, float v1, float v2, float angle) {
        super(x, y, v1, v2, angle);
    }

    public void draw() {
        Resources.getImage("Bullet_Pistol").setRotation(this.getAngle());
        Resources.getImage("Bullet_Pistol").draw(this.getX() + World.mapX ,this.getY() + World.mapY,Config.Bullet_PistolScale);
    }
    
}
