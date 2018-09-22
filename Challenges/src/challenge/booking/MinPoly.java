package challenge.booking;

import java.awt.Polygon;
import java.awt.Point;
import java.awt.geom.PathIterator;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nesrin
 */
public class MinPoly {

    /**
     * The distance between two points squared
     *
     * @param v the first point
     * @param w the second point
     * @return the distance between v and w squared
     */
    static float dist2(Point v, Point w) {
        int xDiff = v.x - w.x;
        int yDiff = v.y - w.y;
        return xDiff * xDiff + yDiff * yDiff;
    }

    /**
     * Distance from a point to a line-segment squared
     *
     * @param p the point
     * @param v the 1st point of the segment
     * @param w the 2nd point of the segment
     * @return the distance as a float
     */
    static float distToSegmentSquared(Point p, Point v, Point w) {
        float l2 = dist2(v, w);
        if (l2 == 0.0f) {
            return dist2(p, v);
        }
        float t = ((p.x - v.x) * (w.x - v.x) + (p.y - v.y) * (w.y - v.y)) / l2;
        if (t < 0) {
            return dist2(p, v);
        }
        if (t > 1) {
            return dist2(p, w);
        }
        Point q = new Point(v.x + Math.round(t * (w.x - v.x)), v.y
                + Math.round(t * (w.y - v.y)));
        return dist2(p, q);
    }

    /**
     * Compute the distance from a point to a line segment
     *
     * @param p the point
     * @param v first point of the line
     * @param w second point of the line
     * @return the distance as a float
     */
    public static float distanceToSegment(Point p, Point v, Point w) {
        float squared = distToSegmentSquared(p, v, w);
        return (float) Math.sqrt(squared);
    }

    /**
     * Get the minimal separation between two polygons
     *
     * @param P the first polygon
     * @param Q the second polygon
     * @return the smallest distance between segments or vertices of P, Q
     */
    public static int distanceBetween(Polygon P, Polygon Q, int size) {
        float minDist = Float.MAX_VALUE;
        ArrayList<Point> points1 = polygonToPoints(P);
        ArrayList<Point> points2 = polygonToPoints(Q);
        Point last1 = null, last2 = null;
        for (int i = 0; i <size; i++) {
            Point p1 = points1.get(i);
            for (int j = 0; j < size; j++) {
                Point p2 = points2.get(j);
                int x = Math.abs(p1.x - p2.x);
                int y = Math.abs(p1.y - p2.y);
                // distance between vertices
                float dist = Math.round(Math.hypot(x, y));
                if (dist < minDist) {
                    minDist = dist;
                }
                // distance between p1 and a segment of Q
                if (last2 != null) {
                    float fDist2 = distanceToSegment(p1, last2, p2);
                    if (fDist2 < minDist) {
                        minDist = fDist2;
                    }
                }
                // distance between p2 and a segment of P
                if (last1 != null) {
                    float fDist1 = distanceToSegment(p2, last1, p1);
                    if (fDist1 < minDist) {
                        minDist = fDist1;
                    }
                }
                last2 = p2;
            }
            last1 = p1;
        }
        return Math.round(minDist);
    }

    /**
     * Convert a polygon to an array of points
     *
     * @param pg the poly
     * @return an arraylist of type Point
     */
    public static ArrayList<Point> polygonToPoints(Polygon pg) {
        ArrayList<Point> points = new ArrayList<>();
        PathIterator iter = pg.getPathIterator(null);
        float[] coords = new float[6];
        while (!iter.isDone()) {
            int step = iter.currentSegment(coords);
            switch (step) {
                case PathIterator.SEG_CLOSE:
                case PathIterator.SEG_LINETO:
                case PathIterator.SEG_MOVETO:
                    points.add(new Point(Math.round(coords[0]),
                            Math.round(coords[1])));
                    break;
                default:
                    break;
            }
            iter.next();
        }
        return points;
    }

    public static void main(String[] args) {
       
//        if (args.length == 2) {
            String[] coords1 ="-1000000,1000000,999999,-1000000,0,-5".split(",");// args[0].split(",");
            String[] coords2 = "0,0,0,5,5,5".split(",");// args[1].split(",");
            Polygon P = new Polygon();
            Polygon Q = new Polygon();
            for (int i = 0; i < coords1.length; i += 2) {
                P.addPoint(Integer.parseInt(coords1[i]), Integer.parseInt(coords1[i + 1]));
            }
            for (int i = 0; i < coords2.length; i += 2) {
                Q.addPoint(Integer.parseInt(coords2[i]), Integer.parseInt(coords2[i + 1]));
            }
            float dist = distanceBetween(P, Q, 3);
            System.out.println("dist=" + dist);
          //  Math.
//        } 
//        else {
//            System.out.println("usage: java Utils <x1,y1,x2,y2...> <x1,y1,x2,y2...>");
//        }
    }
}
