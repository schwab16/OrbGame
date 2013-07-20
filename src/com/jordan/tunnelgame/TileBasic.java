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
    public void collision(Chaser chaser, CollisionType type) {
        chaser.coord.x = 450;
        chaser.coord.y = 150;
        chaser.upwardVelocity = 3;
    }

    @Override
    public void update() {

    }

    @Override
    public Image getImage(Level level) {
        return Assets.iBasicTile;
    }

}
