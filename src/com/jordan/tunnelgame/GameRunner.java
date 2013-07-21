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
        chasersFallDown(level.chasers, deltaTime);
        chasersCollide(level.chasers, level.tiles);
        chasersMove(level.chasers, deltaTime);

        message += (int)level.chasers.get(0).coord.x + " " + (int)level.chasers.get(0).coord.y;

        return C.running;
    }

    private static void chasersMove(ArrayList<Chaser> chasers, float deltaTime) {
        for(Chaser c: chasers)
        {
            c.coord.y -= c.upwardVelocity * deltaTime;
            c.coord.x += c.sideVelocity * deltaTime;
        }
    }

    private static void chasersCollide(ArrayList<Chaser> chasers, Tile[][] tiles) {
        for (Chaser c: chasers)
        {
            try{
                for (Tile t: Tile.getAdjacentTiles(tiles,c.coord))
                {
                    Tile.CollisionType type = t.checkForCollision(c);
                    if (type != Tile.CollisionType.NONE)
                        t.collision(c,type);
                }
            } catch(Exception e) {}
        }
    }

    private static void chasersFallDown(ArrayList<Chaser> chasers, float deltaTime)
    {
        for (Chaser c: chasers)
            c.upwardVelocity += c.gravity * deltaTime;
    }

    private static void chasersFollowOrbs(ArrayList<Chaser> chasers, ArrayList<Orb> orbs, float deltaTime) {
        for (Chaser c: chasers)
        {
            for (Orb o: orbs)
                if (c.color == o.color)
                {
                    if (c.coord.x > o.coord.x-C.blocksSize/2 + C.buffer)
                        c.sideVelocity -= deltaTime * c.momentum;
                    if (c.coord.x + C.buffer < o.coord.x-C.blocksSize/2)
                        c.sideVelocity += deltaTime * c.momentum;
                }

            if (c.sideVelocity > c.maxVelocity) c.sideVelocity = c.maxVelocity;
            if (c.sideVelocity < -c.maxVelocity) c.sideVelocity = -c.maxVelocity;

            c.sideVelocity *= c.resistance;
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
