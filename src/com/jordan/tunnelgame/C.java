package com.jordan.tunnelgame;

/**
 * Created by Owner on 7/6/13.
 */
public class C {

    public static boolean cheats = true;
    public static float maxDeltaTime = 3.15f;

    //size of tiles array
    public static int xBlocks = 32;
    public static int yBlocks = 20;
    public static int blocksSize = 40;

    //return codes for gamestate
    public static int running = 17, fail = 49, finished = 53;

    //size of pause area
    public static int pauseArea = 40;

    //movement speed of chasers, buffer of orbs/chasers
    public static int movement = 1, buffer = 25;
    //chaser gravity
    public static double chaserGravity = 0.1;



}
