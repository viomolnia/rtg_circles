package circles.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

import circles.utils.Circle;
import circles.utils.Const;
import circles.utils.Utils;

public class Panel extends JPanel implements ActionListener {

    protected final List<Circle> circles = new ArrayList<>();

    public Panel() {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(Const.MAX_WIDTH, Const.MAX_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Utils.setAntiAliasing((Graphics2D) graphics);

        paintCircles(graphics);
    }

    protected void paintCircles(Graphics graphics) {
        for (Circle circle : circles) {
            Utils.paint(graphics, circle);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }

    public void addCircle(Circle shape) {
        circles.add(shape);
    }
}
