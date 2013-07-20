package com.jordan.tunnelgame;

/**
 * Created by Owner on 6/29/13.
 */
public class Coord {

    public double x, y;

    public Coord(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Coord() {
        x = 0;
        y = 0;
    }

    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
}