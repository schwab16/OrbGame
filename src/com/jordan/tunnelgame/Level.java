package com.jordan.tunnelgame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Owner on 7/3/13.
 */
public class Level {

    public ArrayList<Chaser> chasers = new ArrayList<Chaser>();
    public ArrayList<Orb> orbs = new ArrayList<Orb>();
    public Tile[][] tiles = new Tile[C.xBlocks][C.yBlocks];

    public int packID;
    public int levelNum;

    public Level(int packID, int levelNum)
    {
        this.packID = packID;
        this.levelNum = levelNum;
    }

    public void load()
    {
        Scanner sc = new Scanner(Assets.getLevelString(packID, levelNum));
        sc.useDelimiter("#");

        String peachyDandy = sc.next();
        String levelString = sc.next();

        for (int y = 0; y < C.yBlocks; y++) {
            for (int x = 0; x < C.xBlocks; x++) {
                char c = levelString.charAt(x + C.xBlocks*y);
                int pix = C.blocksSize;
                switch(c)
                {
                    case ' ': tiles[x][y] = new TileEmpty(new Coord(x*pix,y*pix)); break;
                    case '+': tiles[x][y] = new TileBasic(new Coord(x*pix,y*pix)); break;
                    case '-': tiles[x][y] = new TileMid(new Coord(x*pix,y*pix)); break;
                    case '/': tiles[x][y] = new TileStone(new Coord(x*pix,y*pix)); break;
                    case '*': tiles[x][y] = new TileFire(new Coord(x*pix,y*pix)); break;
                    case '_': tiles[x][y] = new TileIce(new Coord(x*pix,y*pix)); break;
                    case '&': tiles[x][y] = new TileMetal(new Coord(x*pix,y*pix)); break;
                    case '^': tiles[x][y] = new TileSnow(new Coord(x*pix,y*pix)); break;

                    case 'a': tiles[x][y] = new TileEmpty(new Coord(x*pix,y*pix));
                    chasers.add(new Chaser(new Coord(x*pix,y*pix),'a')); break;

                    case 'A': tiles[x][y] = new TileEmpty(new Coord(x*pix,y*pix));
                        orbs.add(new Orb(new Coord(x*pix+C.blocksSize/2,y*pix+C.blocksSize/2),'a',true)); break;
                }
            }
        }

        /*String temp = sc.next();

        Scanner sFinish = new Scanner(sc.next());
        int fx = Integer.parseInt(sFinish.next());
        int fy = Integer.parseInt(sFinish.next());
        finish = new Coord(fx,fy);

        Scanner sChaser = new Scanner(sc.next());
        while (sChaser.hasNext())
        {
            int x = Integer.parseInt(sChaser.next());
            int y = Integer.parseInt(sChaser.next());
            Coord c = new Coord(x,y);
            int color = Integer.parseInt(sChaser.next(),16);
            chasers.add(new Chaser(c,color));
        }

        Scanner sOrb = new Scanner(sc.next());
        while (sOrb.hasNext())
        {
            int x = Integer.parseInt(sOrb.next());
            int y = Integer.parseInt(sOrb.next());
            Coord c = new Coord(x,y);
            int color = Integer.parseInt(sOrb.next(),16);
            int ip = Integer.parseInt(sOrb.next());
            orbs.add(new Orb(c,color,ip));
        }

        Scanner sPlatform = new Scanner(sc.next());
        while (sPlatform.hasNext())
        {
            int x1 = Integer.parseInt(sPlatform.next());
            int x2 = Integer.parseInt(sPlatform.next());
            int y = Integer.parseInt(sPlatform.next());
            Coord c1 = new Coord(x1,y);
            Coord c2 = new Coord(x2,y);
            platforms.add(new Platform(c1,c2));
        }

        Scanner sTun = new Scanner(sc.next());
        int id = -1;
        while (sTun.hasNext())
        {
            id++;
            int x = Integer.parseInt(sTun.next());
            int y = Integer.parseInt(sTun.next());
            Coord c = new Coord(x,y);
            int targetID = Integer.parseInt(sTun.next());
            tunnels.add(new Tunnel(c,id,targetID));
        }*/
    }

    /*first ignored, delimited by #, $. (1280, 800)
    levelpack free, level 1 #
    //TUNNEL: x y targetid $(first is 0)
    100 200 1$
    200 200 0
    #
    //CHASER: x y colorid (roygbv 0,5)
    100 100 0$
    #
    //ORB: x y colorid inplay(1 true, 0 false)
    400 100 0 0
    #
    //PLATFORM: x1 x2 y
    100 100 200*/

}
