/*
 * Copyright 2016 Jan Abelmann
 */
package Bullets;

import Config.Config;
import gui.Resources;
import world.World;

/**
 *
 * @author Jan Abelmann
 */
public class Bullet {
    private float x;
    private float y;
    private float v1;
    private float v2;
    private float angle;
    
    public Bullet(float x, float y, float v1, float v2, float angle) {
        this.x = x;
        this.y = y;
        this.v1 =(float) ((v1-15) / Math.sqrt(v1*v1+v2*v2));
        this.v2 = (float) ((v2-10) / Math.sqrt(v1*v1+v2*v2));
        this.angle = angle;
    }
       
    public void move() {      
        x += v1 * Config.Bullet_PistolSpeed;
        y += v2 * Config.Bullet_PistolSpeed;

    }
    
    public void draw() {
        Resources.getImage("Bullet_Pistol").setRotation(angle);
        Resources.getImage("Bullet_Pistol").draw(x+ World.mapX,y + World.mapY,Config.Bullet_PistolScale);
    }
    
    public float getAngle() {
        return angle;
    }
    
    public float getX() {
        return this.x;
    }
    
    public float getY() {
        return this.y;
    }
    public float nextX() {
        return x + v1 * Config.Bullet_PistolSpeed;
    }
    public float nextY() {
        return y + v2 * Config.Bullet_PistolSpeed;
    }
}
