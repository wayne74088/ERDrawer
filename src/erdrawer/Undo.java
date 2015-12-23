/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erdrawer;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Wayne
 */
public class Undo {
    Page parent;
    Point p1;
    Dimension d1;
    Color c;
    Undo(Page p,Point p2,Dimension d,Status s,Color cc)
    {
        parent = p;
        p1=p2;
        d1=d;
        c=cc;
        if(s==Status.rect)
        {
            Entityset entity=new Entityset(c,this.parent);
            entity.setLocation(p1);
            entity.setSize(d1);
            entity.setVisible(true);
            Undo.this.parent.add(entity);
            Undo.this.parent.objects.add(entity);

        }
        else if(s==Status.diamond)
        {
            Relationship relationship = new Relationship(c,this.parent);
            relationship.setLocation(p1);
            relationship.setSize(d1);
            relationship.setVisible(true);
            Undo.this.parent.add(relationship);
            Undo.this.parent.objects.add(relationship);
 
        }
        else if(s==Status.oval)
        {
            Attribute attribute=new Attribute(c,this.parent);
            attribute.setLocation(p1);
            attribute.setSize(d1);
            attribute.setVisible(true);
            Undo.this.parent.add(attribute);
            Undo.this.parent.objects.add(attribute);

        }

    }
    void line(boolean b)
    {
        Line line=new Line(c,this.parent);
        line.setLocation(p1);
        line.setSize(d1);
        /*if(Undo.this.parent.activeOBJ.linestatus==true)
        {
            line.b1=true;
        }
        else if(Undo.this.parent.activeOBJ.linestatus==false)
        {
            line.b1=false;
        }*/
        line.b1=b;
        line.setVisible(true);
        Undo.this.parent.add(line);
        Undo.this.parent.objects.add(line);
    }
}
