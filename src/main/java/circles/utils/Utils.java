package circles.utils;

import static javax.swing.JFrame.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import circles.panels.Panel;

public class Utils {

    public static int random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }


    public static <T extends Panel> void setTimer(T panel) {
        Timer timer = new Timer(50, panel);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Flying circles");
            frame.setContentPane(panel);
            frame.pack();
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.setVisible(true);

            timer.start();
        });
    }


    public static Color color(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    public static void paint(Graphics graphics, Circle c) {
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setStroke(new BasicStroke(10F));
        g2d.setColor(c.color);
        g2d.drawOval(toInt(c.x - c.radius), toInt(c.y - c.radius), toInt(c.radius * 2), toInt(c.radius * 2));
    }

    public static int toInt(double d) {
        return Double.valueOf(d).intValue();
    }

    public static void setAntiAliasing(Graphics2D graphics2D) {
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public static boolean randomBoolean() {
        return new Random().nextBoolean();
    }
}
