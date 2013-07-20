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
        ArrayList<Tile> a = new ArrayList<Tile>();
        int x = (int)c.x/C.blocksSize;
        int y = (int)c.y/C.blocksSize;

        int adjArea = C.adjacentArea;

        for (int offX = -adjArea; offX < adjArea+1; offX++)
            for (int offY = -adjArea; offY < adjArea+1; offY++)
                if (offX >= 0 && offY >= 0 && offX < C.xBlocks && offY < C.yBlocks)
                    if (!(tiles[x+offX][y+offY] instanceof TileEmpty))
                        a.add(tiles[x+offX][y+offY]);

        return a;
    }

    public abstract void collision(Chaser chaser, CollisionType type);
    public abstract void update();
    public abstract Image getImage(Level level);

    public CollisionType checkForCollision(Chaser chaser)
    {
        return CollisionType.NONE;
    }

    public enum CollisionType {
        TOP, LEFT, RIGHT, BOTTOM, IN, NONE;
    }
}
