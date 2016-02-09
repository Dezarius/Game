/*
 * Copyright 2016 Jan Abelmann
 */
package Input;

import main.Engine;
import org.newdawn.slick.GameContainer;

/**
 *
 * @author Jan
 */
public class Mouse {
    
    
    public static float[] getPosition() {
        float[] mouse = {Engine.gamec.getInput().getMouseX(), Engine.gamec.getInput().getMouseY()};
        return mouse;
    }
    
    
}
