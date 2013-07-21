package com.jordan.tunnelgame;

import com.jordan.framework.Image;

import java.util.ArrayList;

public class Chaser {

    public Coord coord;
    public final char color;
    public double upwardVelocity = 0;
    public double gravity = C.chaserGravity;
    public double sideVelocity = 0;
    public double momentum = C.chaserMomentum;
    public double resistance = C.chaserResistance;
    public double maxVelocity = C.maxVelocity;

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
