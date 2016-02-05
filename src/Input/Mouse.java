/*
 * Copyright 2016 Jan Abelmann
 */
package Input;

import org.newdawn.slick.GameContainer;

/**
 *
 * @author Jan
 */
public class Mouse {
    
    
    public static float[] getPosition(GameContainer gc) {
        float[] mouse = {gc.getInput().getMouseX(), gc.getInput().getMouseY()};
        return mouse;
    }
    
    
}
