package pl.edu.wat.wcy.isi.GUI;

import pl.edu.wat.wcy.isi.Model.SplayTreeContainer;
import pl.edu.wat.wcy.isi.Model.SplayTreeNode;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class TreeJPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        SplayTreeNode node = SplayTreeContainer.get().getTree().getRoot();

        if(node != null) paintNode(node, g2d, 50.0,getWidth()/2.0, 3.0, getWidth() /2.0 - 20);
    }

    private void paintNode (SplayTreeNode node, Graphics2D g2d, double radius, double w, double h, double sw) {

        double halfRadius = radius/2.0;
        double spacing = getHeight()/15.0;

        drawCircle(g2d, radius, w, h, node.getColor());
        drawString(node, g2d, w, h, halfRadius);
        drawLines(g2d, radius, w, h, sw, spacing);

        h+=spacing+radius;
        radius-=5;
        sw/=2.0;

        if (node.getLeft() != null)
            paintNode(node.getLeft(), g2d, radius, w-sw, h, sw);
        if (node.getRight() != null)
            paintNode(node.getRight(), g2d, radius, w+sw, h, sw);
    }

    private void drawLines(Graphics2D g2d, double radius, double w, double h, double sw, double spacing) {
        g2d.setPaint(Color.BLACK);

        double halfRadius = radius/2.0;
        double x1  = w+halfRadius;
        double y1  = h+radius;
        double x2l = (w+halfRadius-2.5)-sw/2.0;
        double x2r = (w+halfRadius-2.5)+sw/2.0;
        double y2  = h+spacing+radius;

        g2d.draw(new Line2D.Double(x1,y1,x2l,y2));
        g2d.draw(new Line2D.Double(x1,y1,x2r,y2));
    }

    private void drawString(SplayTreeNode node, Graphics2D g2d, double w, double h, double halfRadius) {
        g2d.setFont(new Font("Serif", Font.BOLD, (int)halfRadius));
        g2d.setPaint(Color.WHITE);
        FontMetrics fm = g2d.getFontMetrics();

        int x = (int)(w+halfRadius) - (fm.stringWidth(node.getValue().toString()) / 2);
        int y = (int)(h+ halfRadius) + (fm.getAscent() / 4);

        g2d.drawString(node.getValue().toString(), x,y);
    }

    private void drawCircle(Graphics2D g2d, double radius, double w, double h, Color color) {
        Ellipse2D circle = new Ellipse2D.Double(w, h, radius, radius);
        g2d.setPaint(color);
        g2d.fill(circle);
        g2d.draw(circle);
    }
}
