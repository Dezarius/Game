/*
 * Copyright 2016 Jan Abelmann
 */
package Config;

import org.newdawn.slick.Input;

/**
 *
 * @author Jan
 */
public class Config {
    
    public static String GameName = "SuperDuperShooter";
    
    //Player
    public static int AmountOFJumps = 3;
    public static float PMoveSpeed = 0.2f;
    public static float PSlowSpeed = 0.25f; 
    public static int PWidth = 32;
    public static int PHeight = 32;
    public static float JumpHeight = 6;
    
    //Input
    public static int PRight = Input.KEY_D;
    public static int PLeft = Input.KEY_A;
    public static int PUp = Input.KEY_W;
    public static int PUp2 = Input.KEY_SPACE;
    public static int StateGame = Input.KEY_G;
    public static int StateMenu = Input.KEY_M;
    public static int StateInGameMenu = Input.KEY_ESCAPE;
    
    //Gravity
    public static float Gravity = 0.1f;
    public static float MaxGravity = 9;
    public static float GravityRate = 0.002f;

    //Window
    public static boolean Fullscreen = true;
    public static int WindowWidth = 1280;
    public static int WindowHeight = 720;
    public static int Framerate = 60;
    public static int LogicRate = 60;
    public static boolean VSync = true;
    public static boolean showFPS = true;
 
    //World
    public static float BackgroundMovement = 0.2f;
    public static float BackgroundScale = 1.2f;
    public static float BackgroundX = 200;
    public static float BackgroundY = 100;
    
}
