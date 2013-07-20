package com.jordan.tunnelgame;

import com.jordan.framework.Image;

import java.util.ArrayList;

/**
 * Created by Owner on 7/3/13.
 */
public class Chaser {

    public Coord coord;
    public final char color;
    public double upwardVelocity = 0;
    public double gravity = C.chaserGravity;

    public Chaser(Coord start, char color)
    {
        this.color = color;
        this.coord = start;
    }

    public Image getImage()
    {
        switch(color)
        {
            case 'a': break;
            default:
        }
        return Assets.iChaser;
    }

}