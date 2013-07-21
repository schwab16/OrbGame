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

    public abstract void collision(Chaser chaser, CollisionType type);
    public abstract void update();
    public abstract Image getImage(Level level);

    public void basicTopCollision(Chaser chaser)
    {
        if (chaser.upwardVelocity < 0)
            chaser.upwardVelocity = 0;
        chaser.coord.y = coord.y - C.blocksSize + 1;
        GameRunner.message += "TOP";
    }

    public void basicLeftCollision(Chaser chaser)
    {
        if (chaser.sideVelocity > 0)
            chaser.sideVelocity = 0;
        chaser.coord.x = coord.x - C.blocksSize + 1;
        GameRunner.message += "LEFT";
    }

    public void basicRightCollision(Chaser chaser)
    {
        if (chaser.sideVelocity < 0)
            chaser.sideVelocity = 0;
        chaser.coord.x = coord.x + C.blocksSize - 1;
        GameRunner.message += "RIGHT";
    }

    public void basicBottomCollision(Chaser chaser)
    {
        if (chaser.upwardVelocity > 0)
            chaser.upwardVelocity = -chaser.upwardVelocity/2;
        chaser.coord.y = coord.y + C.blocksSize - 1;
        GameRunner.message += "BOTTOM";
    }

    public static ArrayList<Tile> getAdjacentTiles(Tile[][] tiles, Coord c)
    {
        ArrayList<Tile> closeTiles = new ArrayList<Tile>();
        int x = (int)c.x/C.blocksSize;
        int y = (int)c.y/C.blocksSize;

        int adjArea = C.adjacentArea;

        for (int offX = -adjArea; offX < adjArea+1; offX++)
            for (int offY = -adjArea; offY < adjArea+1; offY++)
                if (offX >= 0 && offY >= 0 && offX < C.xBlocks && offY < C.yBlocks)
                    if (!(tiles[x+offX][y+offY] instanceof TileEmpty))
                        closeTiles.add(tiles[x+offX][y+offY]);

        return closeTiles;
    }

    public CollisionType checkForCollision(Chaser chaser)
    {
        int x = (int) chaser.coord.x - (int) coord.x;
        int y = (int) coord.y - (int) chaser.coord.y;

        if (Math.abs(y) < C.blockInsideRatio*C.blocksSize && Math.abs(x) < C.blockInsideRatio*C.blocksSize)
            return CollisionType.IN;
        if (Math.abs(y) < C.blocksSize && Math.abs(x) < C.blocksSize)
        {
            if (x>y && x>0)
                return CollisionType.RIGHT;
            if (x>y && !(x>0))
                return CollisionType.LEFT;
            if (!(x>y) && y>0)
                return CollisionType.TOP;
            if (!(x>y) && !(y>0))
                return CollisionType.BOTTOM;
        }

        return CollisionType.NONE;
    }

    public enum CollisionType {
        TOP, LEFT, RIGHT, BOTTOM, IN, NONE;
    }
}
