/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erdrawer;
import java.awt.*;
/**
 *
 * @author Wayne
 */
public class Line {
    Point start,end;
    Color color;
    Line( Point s, Point e, Color c)
    {
        start=new Point(s);
        end=new Point(e);
        color=c;
    }

}
