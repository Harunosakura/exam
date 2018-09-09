package challenge.booking;


import java.awt.*;
import javax.swing.*;
import java.applet.*;
/**
 *
 * @author Nesrin
 */
public class PolyGUI extends JApplet {

// called when applet is started
    public void init() {
        // set the size of applet to 300, 300
        setSize(900, 900);
        show();
    }

    // invoked when applet is started
    public void start() {
    }

    // invoked when applet is closed
    public void stop() {
    }

    public void paint(Graphics g) {
        // x coordinates of vertices
//        int x[] = {-19,-21,-21,-20,-18,-16,19,20,24,26,27,27,26,22,21,17,15,10,7,4,-1,-6,-11,-16};
//
//        // y coordinates of vertices
//        int y[] = {0,-5,-8,-13,-17, -19,-26,-26,-25,-21, -18,-16,-14,-10,-9, -6,-5,-3,-2,-1, 0,1,1,1};
//        int x2[] = {-17, -22, -27, -32, -36, -40, -43, -44, -44, -41, -38, -34, -32, -2, 2, 4, 5, 5, 4, 2, -2, -5, -9, -11, -12};
//        int y2[] = {-39,-41,-44,-48,-52,-57,-62,-67,-72,-74,-76,-78,-77,-61,-57,-53,-49,-48,-46,-42,-39,-38,-38,-38,-38};
//
//        // number of vertices
//        int numberofpoints = 6;
//
//        // set the color of line drawn to blue
//        g.setColor(Color.blue);
//
//        // draw the polygon using drawPolygon function
//        g.drawPolygon(x, y, 24);
        int [] px = {150,169,256,196,300,196,256,169,150,131,44,104,0,104,44,150,150};
    int [] py = {0,103,44,131,150,169,256,196,300,196,256,169,150,131,44,103,150};
    g.drawPolygon(px, py, 14);
     //   g.drawPolygon(x2, y2, 25);
    }
}
