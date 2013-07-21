package com.jerhis.orbgame;

import com.jerhis.framework.Image;

public class TileEmpty extends Tile {

    public TileEmpty(Coord coord, char id) {
        super(coord, id);
    }

    @Override
    public void collision(Chaser chaser, CollisionType type) {}

    @Override
    public void update() {}

    @Override
    public void onTouch() {}

    @Override
    public Image getImage(Level level) {
        return Assets.iTile;
    }

}
