/*
 * © 2015 Jan Abelmann
 */

package main;

/**
 *
 * 
 */
public class Utilities {
    public static float angle = 0;
    public static float AngleBetweenVectors(float x1, float y1, float x2, float y2) {
        angle = (float) (( 360/(2* Math.PI)) *  Math.acos( ( x1*x2+y1*y2)/(Math.sqrt(x1*x1+y1*y1) * Math.sqrt(x2*x2+y2*y2)) ));
        return angle;
    }
  
}
