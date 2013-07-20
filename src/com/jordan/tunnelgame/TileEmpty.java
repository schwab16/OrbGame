package com.jordan.tunnelgame;

import com.jordan.framework.Image;

/**
 * Created by Owner on 7/19/13.
 */
public class TileEmpty extends Tile {

    public TileEmpty(Coord coord) {
        super(coord);
    }

    @Override
    public void collision(Chaser chaser) {

    }

    @Override
    public void update() {

    }

    @Override
    public Image getImage(Level level) {
        return Assets.iTile;
    }

    @Override
    public boolean checkForCollision(Chaser c) {
        return false;
    }
}
