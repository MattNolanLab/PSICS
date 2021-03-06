

package org.catacomb.graph.gui;

import org.catacomb.be.Position;
import org.catacomb.datalish.Box;

import javax.swing.JFrame;



public class ZoneDemo implements BuildPaintInstructor, PickListener {

   PickablePoint[] points;

   public ZoneDemo() {
      points = new PickablePoint[10];
      for (int i = 0; i < points.length; i++) {
	 points[i] = new PickablePoint(10. * Math.random(),
				       10. * Math.random());
      }

   }


   public void init() {
      JFrame f = new JFrame();
      DataDisplay wc = new DataDisplay(500, 300);

      wc.setBuildPaintInstructor(this);

      wc.setPickListener(this);

      f.getContentPane().add(wc);
      f.pack();
      f.setVisible(true);
   }



   public static void main(String[] argv) {
      ZoneDemo zd = new ZoneDemo();

      zd.init();

   }



   public boolean antialias() {
      return true;
   }


   // for BuildPaintInstructure
   public void instruct(Painter p, Builder b) {
      // do the painting...;
      p.drawLine(0.5, 0.5, 1.5, 1.5);

      for (int i = 0; i < points.length; i++) {
	 b.addPickablePoint(points[i]);
      }

   }


   public void backgroundPressed(int i, int x, int y) {

   }


   // for PickListener
   public void pickPressed(Pickable pbl, int button, int ix, int iy) {

   }

   public void pickReleased(Pickable pbl, int button) {

   }

   public void pickDragged(Pickable pbl, Position pos, int button, int ix, int iy) {

      if (pbl instanceof PickablePoint) {
	 if (button == Mouse.LEFT) {
	    ((PickablePoint)pbl).moveTo(pos);
	 }
      }
   }

   public void pickEnteredTrash(Pickable pbl) {
   }

    public void pickLeftTrash(Pickable pbl) {
    }

    public void pickTrashed(Pickable pbl) {
    }


   public void trashPressed() {
      // TODO Auto-generated method stub

   }


   public void pickHovered(Pickable hoverItem) {
      // TODO Auto-generated method stub

   }


public Box getLimitBox() {
	// TODO Auto-generated method stub
	return null;
}


public Box getLimitBox(Painter p) {
	// TODO Auto-generated method stub
	return null;
}





}
