/*
 * Copyright 2016 Jan Abelmann
 */
package Input;

import Bullets.BulletManager;
import Config.Config;
import Entity.EntityManager;
import main.Engine;
import org.newdawn.slick.Input;
import world.World;

/**
 *
 * @author Jan
 */
public class Mouse {
    
    
    public static float[] getPosition() {
        float[] mouse = {Engine.gamec.getInput().getMouseX(), Engine.gamec.getInput().getMouseY()};
        return mouse;
    }
    
    public static void Input() {
        if(Engine.gamec.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            float[] mouse = {Engine.gamec.getInput().getMouseX(), Engine.gamec.getInput().getMouseY()};
            BulletManager.newBullet(EntityManager.player.getX() + Config.PWidth/2 
                                            , EntityManager.player.getY() + Config.PHeight/2,
                                            mouse[0] - EntityManager.player.getX() - World.mapX,
                                            mouse[1] - EntityManager.player.getY() - World.mapY,
                                            EntityManager.player.getAngle());
        }
    }
    
    
}
