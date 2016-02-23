/*
 * © 2015 Jan Abelmann
 */
package main;

import Config.Config;
import Entity.EntityManager;
import gui.Resources;
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
            g.drawString("DEBUGMODE", 50, 70);
            drawDirection();
        }
    }

    private static void drawDirection() {
        Resources.getImage("direction").setCenterOfRotation(0, 1);
        Resources.getImage("direction").setRotation(EntityManager.player.getAngle());
        Resources.getImage("direction").draw(EntityManager.player.getX() + Config.PWidth / 2, EntityManager.player.getY() + Config.PHeight / 2);
    }

    public static void update() {
        if (debugMode) {

        }
    }
}
