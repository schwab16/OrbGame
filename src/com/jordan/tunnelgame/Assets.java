package com.jordan.tunnelgame;

import android.content.res.AssetFileDescriptor;
import android.util.Log;

import com.jordan.framework.Graphics;
import com.jordan.framework.Graphics.ImageFormat;
import com.jordan.framework.Image;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Assets {

    public static Image splash;
	public static Image packselect, levelselect, background;// character, character2, character3, heliboy, heliboy2, heliboy3, heliboy4, heliboy5;
	public static Image iChaser, iOrb, iTile, iBasicTile;

    public static String[] packNames = {"test"};
    public static String[][] levelStrings;
	//public static Sound click;
	//public static Music theme;
    //public static Image guy, basicplat, guye, guys, guyl, guyr, movingplat, vanishplat,superplat;
	
	public static void loadSplash(Graphics g) {
        splash = g.newImage("splash.png", ImageFormat.RGB565);
	}

    public static void load(Graphics g) {
       // Assets.menu = g.newImage("menubg.png", Graphics.ImageFormat.RGB565);

        background = g.newImage("background.png", ImageFormat.RGB565);
        packselect = g.newImage("packselect.png", ImageFormat.RGB565);
        levelselect = g.newImage("levelselect.png", ImageFormat.RGB565);

        iChaser = g.newImage("chaser.png", ImageFormat.RGB565);
        iOrb = g.newImage("orb.png", ImageFormat.RGB565);
        iTile = g.newImage("emptytile.png", ImageFormat.RGB565);
        iBasicTile = g.newImage("basictile.png", ImageFormat.RGB565);

    }

    public static double distance(Coord a, Coord b)
    {
        return Math.sqrt((a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y));
    }

    public static String getLevelString(int packID, int levelNum) {

        switch (packID * 100 + levelNum)
        {
            case 1:
                return "test1#" +
                        "                                " +
                        "                                " +
                        "      A                         " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                 +              " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                                " +
                        "                      a         " +
                        "                                " +
                        "++++++++++++++++++++++++++++++++";
            case 2:
                return " ";
            case 3:
                return " ";
            case 4:
                return " ";
            case 5:
                return " ";
            case 6:
                return " ";
            case 7:
                return " ";
            case 8:
                return " ";
            case 9:
                return " ";
            case 10:
                return " ";

        }

        return "";
    }

    /*pack ids:
    0: test
     */

     /*first ignored, delimited by #
    levelpack free, level 1 #
    //TUNNEL: x y targetid $(first is 0)
    100 200 1$
    200 200 0
    #
    //CHASER: x y colorid (roygbv 0,5)
    100 100 0$
    #
    //ORB: x y colorid
    400 100 0
    #
    //PLATFORM: x1 x2 y
    100 100 200*/
}
