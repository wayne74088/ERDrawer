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
    Undo(Page p,Point p2,Dimension d,Status s)
    {
        parent = p;
        p1 = p2;
        d1= d;
        if(s==Status.rect)
        {
            Entityset entity=new Entityset(this.parent.parent.color,this.parent);
            entity.setLocation(p1);
            entity.setSize(d1);
            entity.setVisible(false);
            Undo.this.parent.add(entity);
            Undo.this.parent.objects.setElementAt(entity, Undo.this.parent.objecttotal-1);
        }
        else if(s==Status.diamond)
        {
            Relationship relationship = new Relationship(this.parent.parent.color,this.parent);
            relationship.setLocation(p1);
            relationship.setSize(d1);
            relationship.setVisible(false);
            Undo.this.parent.add(relationship);
            Undo.this.parent.objects.setElementAt(relationship, Undo.this.parent.objecttotal-1);         
        }
        else if(s==Status.oval)
        {
            Attribute attribute=new Attribute(this.parent.parent.color,this.parent);
            attribute.setLocation(p1);
            attribute.setSize(d1);
            attribute.setVisible(false);
            Undo.this.parent.add(attribute);
            Undo.this.parent.objects.setElementAt(attribute, Undo.this.parent.objecttotal-1);
        }
        
    }
    /*void entitys()
    {
        Entityset entity=new Entityset(this.parent.parent.color,this.parent);
        entity.setLocation(p1);
        entity.setSize(d1);
        entity.setVisible(false);
        undo.this.parent.add(entity);
        undo.this.parent.objects.setElementAt(entity, undo.this.parent.objecttotal-1);
    }
    void attributes()
    {
        Attribute attribute=new Attribute(this.parent.parent.color,this.parent);
        attribute.setLocation(p1);
        attribute.setSize(d1);
        attribute.setVisible(false);
        undo.this.parent.add(attribute);
        undo.this.parent.objects.setElementAt(attribute, undo.this.parent.objecttotal-1);
    }
    void relationships()
    {
        Relationship relationship = new Relationship(this.parent.parent.color,this.parent);
        relationship.setLocation(p1);
        relationship.setSize(d1);
        relationship.setVisible(false);
        undo.this.parent.add(relationship);
        undo.this.parent.objects.setElementAt(relationship, undo.this.parent.objecttotal-1);         
    }*/
}
