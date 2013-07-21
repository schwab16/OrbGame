package com.jordan.tunnelgame;

import com.jordan.framework.Image;

/**
 * Created by Owner on 7/19/13.
 */
public class TileSnow extends Tile {
    public TileSnow(Coord coord) {
        super(coord);
    }

    @Override
    public void collision(Chaser chaser, CollisionType type) {
        switch (type) {
            case TOP: basicTopCollision(chaser);
                break;
            case LEFT: basicLeftCollision(chaser);
                break;
            case RIGHT: basicRightCollision(chaser);
                break;
            case BOTTOM: basicBottomCollision(chaser);
                break;
            case IN:
                break;
            case NONE:
                break;
        }
    }

    @Override
    public void update() {

    }

    @Override
    public Image getImage(Level level) {
        return Assets.iSnowTile;
    }

}
