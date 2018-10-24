package pl.edu.wat.wcy.isi.GUI;

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

        SplayTreeNode node = SplayTreeNode.getRoot();

        if(node != null) paintNode(node, g2d, 50.0,getWidth()/2.0, 3.0, getWidth() /2.0 - 20, false);
    }

    private void paintNode (SplayTreeNode node, Graphics2D g2d, double radius, double w, double h, double sw, boolean isRight) {

        double halfRadius = radius/2.0;
        double spacing = getHeight()/15.0;
        // kolo
        Ellipse2D circle = new Ellipse2D.Double(w, h, radius, radius);

        g2d.setPaint(new Color(255, 255, 255)); // a dull blue-green
        g2d.fill(circle);
        g2d.draw(circle);

        g2d.setFont(new Font("Serif", Font.BOLD, (int)halfRadius));
        g2d.setPaint(new Color(0, 0, 0)); // a dull blue-green
        FontMetrics fm = g2d.getFontMetrics();
        int fontW = fm.stringWidth(node.getValue().toString());
        int fontH = fm.getAscent();
        g2d.drawString(node.getValue().toString(), (int)(w+halfRadius) - (fontW / 2), (int)(h+ halfRadius) + (fontH / 4));
        Line2D leftLine, rightLine;

        if(isRight) {
            leftLine =  new Line2D.Double(w+halfRadius, h+radius, (w+halfRadius-2.5)- sw/2.0, h+spacing+ radius);
            rightLine = new Line2D.Double(w+halfRadius, h+radius, (w+halfRadius-2.5)+ sw/2.0, h+spacing+ radius);
        }else {
            leftLine = new Line2D.Double(w + halfRadius, h + radius, (w + halfRadius-2.5) - sw / 2.0, h+spacing+ radius);
            rightLine = new Line2D.Double(w + halfRadius, h + radius, (w + halfRadius-2.5) + sw / 2.0, h+spacing+ radius);
        }


        g2d.draw(leftLine);
        g2d.draw(rightLine);

        if (node.getLeft() != null)  paintNode(node.getLeft() , g2d, radius -5, w- sw/2.0, h+spacing+ radius, sw / 2.0, false);
        if (node.getRight() != null) paintNode(node.getRight(), g2d, radius -5, w+ sw/2.0, h+spacing+ radius,  sw / 2.0, true);
    }
}
