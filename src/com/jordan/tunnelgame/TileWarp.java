package com.jordan.tunnelgame;

import com.jordan.framework.Image;

import java.util.ArrayList;

public class TileWarp extends Tile {

    public static ArrayList<TileWarp> otherWarps;
    public int targetID;
    public boolean readyToWarp = true;

    public TileWarp(Coord coord, char id, char targetID) {
        super(coord, id);
        this.targetID = targetID - '0';
    }

    @Override
    public void collision(Chaser chaser, CollisionType type) {
        if (type == CollisionType.IN && readyToWarp)
        {
            chaser.coord.x = otherWarps.get(targetID).coord.x;
            chaser.coord.y = otherWarps.get(targetID).coord.y;
            otherWarps.get(targetID).readyToWarp = false;
        }
        else if (type != CollisionType.NONE && type != CollisionType.IN)
        {
            readyToWarp = true;
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void onTouch() {

    }

    @Override
    public Image getImage(Level level) {
        return Assets.iWarpTile;
    }
}
