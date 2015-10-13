/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erdrawer;
import java.util.Vector;
/**
 *
 * @author User
 */
public class ERDrawer {
    Vector<Page> pages;
    Page curPage;
    boolean isPen=false;
    boolean isLine=false;
    ERDrawer()
    {
     MyWindow mywin=new MyWindow(this);
     pages=new Vector<Page>();
     curPage=null;
    }
}
