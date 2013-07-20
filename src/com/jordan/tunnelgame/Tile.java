package com.jordan.tunnelgame;

import com.jordan.framework.Image;

import java.util.ArrayList;

/**
 * Created by Owner on 7/19/13.
 */
public abstract class Tile {

    public Coord coord;

    public Tile(Coord coord)
    {
        this.coord = coord;
    }

    public static ArrayList<Tile> getAdjacentTiles(Tile[][] tiles, Coord c)
    {
        //TODO: get adjacent tiles
        return null;
    }

    public abstract void collision(Chaser chaser);
    public abstract void update();
    public abstract Image getImage();
}
