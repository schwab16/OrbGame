package com.jordan.tunnelgame;

import com.jordan.framework.Image;

/**
 * Created by Owner on 7/19/13.
 */
public class TileBasic extends Tile {
    public TileBasic(Coord coord) {
        super(coord);
    }

    @Override
    public void collision(Chaser chaser) {

    }

    @Override
    public void update() {

    }

    @Override
    public Image getImage() {
        return Assets.iBasicTile;
    }
}
