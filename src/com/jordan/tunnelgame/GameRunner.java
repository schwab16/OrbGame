package com.jordan.tunnelgame;

import com.jordan.framework.Input;

import java.util.ArrayList;
import java.util.List;
import com.jordan.framework.Input.TouchEvent;

/**
 * Created by Owner on 7/6/13.
 */
public class GameRunner {

    public static String message = "";

    public static int update(List<TouchEvent> touchEvents, float deltaTime, Level level)
    {
        message = "";

        if (touchEvents.size() > 0)
            orbsByTouch(touchEvents,level.orbs);

        chasersFollowOrbs(level.chasers, level.orbs, deltaTime);

        chasersFallDown(level.chasers);

        chasersCollide(level.chasers, level.tiles);

        return C.running;

    }

    private static void chasersCollide(ArrayList<Chaser> chasers, Tile[][] tiles) {
        for (Chaser c: chasers)
        {
            for (Tile t: Tile.getAdjacentTiles(tiles,c.coord))
            {

            }
        }
    }

    private static void chasersFallDown(ArrayList<Chaser> chasers)
    {
        for (Chaser c: chasers)
        {
            c.upwardVelocity += c.gravity;
            c.coord.y += c.upwardVelocity;
        }
    }

    private static void chasersFollowOrbs(ArrayList<Chaser> chasers, ArrayList<Orb> orbs, float deltaTime) {
        for (Chaser c: chasers)
            for (Orb o: orbs)
                if (c.color == o.color)
                {
                    if (c.coord.x > o.coord.x + C.buffer)
                        c.coord.x -= deltaTime * C.movement;
                    if (c.coord.x + C.buffer < o.coord.x)
                        c.coord.x += deltaTime * C.movement;
                }
    }

    private static void orbsByTouch(List<TouchEvent> touchEvents, ArrayList<Orb> orbs) {
        for (Input.TouchEvent event: touchEvents) {
            switch(event.type)
            {
                case Input.TouchEvent.TOUCH_DOWN:
                    double distance = Assets.iOrb.getWidth();
                    Orb closest = null;
                    for (Orb o: orbs)
                    {
                        double orbDistance = Assets.distance(o.coord, new Coord(event.x, event.y));
                        if (orbDistance < distance)
                        {
                            distance = orbDistance;
                            closest = o;
                        }
                    }
                    if (closest != null)
                    {
                        closest.pointerID = event.pointer;
                        closest.coord = new Coord(event.x, event.y);
                        closest.trackable = true;
                    }
                    break;
                case Input.TouchEvent.TOUCH_DRAGGED:
                    for (Orb o: orbs)
                    {
                        if (event.pointer == o.pointerID)
                        {
                            o.coord = new Coord(event.x, event.y);
                        }
                    }
                    break;
                case Input.TouchEvent.TOUCH_UP:
                    for (Orb o: orbs)
                    {
                        if (event.pointer == o.pointerID)
                        {
                            o.coord = new Coord(event.x, event.y);
                            o.pointerID = -1;
                        }
                    }
            }
        }
    }


}
