/*
 * © 2015 Jan Abelmann
 */
package main;

import Config.Config;
import Entity.EntityManager;
import gui.Resources;
import world.World;
import Input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author janabelmann
 */
public class Debug {

    public static boolean debugMode = false;

    public static void toggleDebug() {
        debugMode = !debugMode;
    }

    public static void render(GameContainer gc, StateBasedGame s, Graphics g) {
        if (debugMode) {
            g.drawString("DEBUGMODE", 0, 0);
            g.drawString(String.valueOf("FPS:" + gc.getFPS()), 0, 14);
            g.drawString("Player:" + String.valueOf((int) EntityManager.player.getX()) +  "|" + String.valueOf((int)EntityManager.player.getY()), 0, 28);
            g.drawString("Map:" + String.valueOf((int) World.mapX) +  "|" + String.valueOf((int) World.mapY), 0, 42);
            g.drawString("Mouse:" +  (int) Mouse.getPosition()[0] + "|" + (int) Mouse.getPosition()[1] , 0, 56);
            g.drawString("MouseMap:" + (int) (Mouse.getPosition()[0] - World.mapX) + "|" + (int) (Mouse.getPosition()[1] - World.mapY) ,0,70);
            drawDirection();
        }
    }

    private static void drawDirection() {
        Resources.getImage("direction").setCenterOfRotation(0, 1);
        Resources.getImage("direction").setRotation(EntityManager.player.getAngle());
        Resources.getImage("direction").draw(EntityManager.player.getX() + Config.PWidth / 2 + World.mapX, EntityManager.player.getY() + World.mapY + Config.PHeight / 2);
    }

    public static void update() {
        if (debugMode) {

        }
    }
}
