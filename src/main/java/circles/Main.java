package circles;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import static circles.Randomizer.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Main {

    static final Integer CIRCLES_COUNT = 7;
    static final Integer MIN_RADIUS = 10;
    static final Integer MAX_RADIUS = 50;

    static final Integer MAX_WIDTH = 800;
    static final Integer MIN_WIDTH = MAX_RADIUS;

    static final Integer MAX_HEIGHT = 600;
    static final Integer MIN_HEIGHT = MAX_RADIUS;


    public static void main(String[] args) {
        final MainPanel panel = new MainPanel();

        addCirclesToPanel(panel);

        setTimer(panel);
    }

    private static void addCirclesToPanel(MainPanel panel) {

        //Placing circles randomly
//        for (int n = 0; n < CIRCLES_COUNT; n++) {
//            int minX = MIN_WIDTH + MAX_RADIUS;
//            int maxX = MAX_WIDTH - MAX_RADIUS;
//
//            int minY = MIN_HEIGHT + MAX_RADIUS;
//            int maxY = MAX_HEIGHT - MAX_RADIUS;
//
//            Circle circle = new Circle(randomInt(minX, maxX), randomInt(minY, maxY), randomInt(MIN_RADIUS, MAX_RADIUS), randomInt(0, 360));
//            panel.addCircle(circle);
//
//        }

        //Placing circles in defined positions, so that they are not overlapped
//        panel.addCircle(new Circle(randomInt(70, 170), randomInt(70, 170), randomInt(MIN_RADIUS, MAX_RADIUS), randomInt(0, 360)));
//        panel.addCircle(new Circle(randomInt(270, 370), randomInt(70, 170), randomInt(MIN_RADIUS, MAX_RADIUS), randomInt(0, 360)));
//        panel.addCircle(new Circle(randomInt(470, 570), randomInt(70, 170), randomInt(MIN_RADIUS, MAX_RADIUS), randomInt(0, 360)));
//
//        panel.addCircle(new Circle(randomInt(70, 170), randomInt(270, 370), randomInt(MIN_RADIUS, MAX_RADIUS), randomInt(0, 360)));
//        panel.addCircle(new Circle(randomInt(270, 370), randomInt(270, 370), randomInt(MIN_RADIUS, MAX_RADIUS), randomInt(0, 360)));
//        panel.addCircle(new Circle(randomInt(470, 570), randomInt(270, 370), randomInt(MIN_RADIUS, MAX_RADIUS), randomInt(0, 360)));


        //Placing circles in defined positions, so that they are not overlapped through cycle
        int minY = MAX_RADIUS + 20;
        int maxY = minY + MAX_RADIUS * 2;
        for (int i = 0; i < 2; i++) {

            int minX = MAX_RADIUS + 20;
            int maxX = minX + MAX_RADIUS * 2;
            for (int j = 0; j < 3; j++) {
                panel.addCircle(new Circle(randomInt(minX, maxX), randomInt(minY, maxY), randomInt(MIN_RADIUS, MAX_RADIUS), randomInt(0, 360)));
                minX += MAX_RADIUS * 4;
                maxX += MAX_RADIUS * 4;
            }
            minY += MAX_RADIUS * 4;
            maxY += MAX_RADIUS * 4;
        }
    }

    private static void setTimer(MainPanel panel) {
        Timer timer = new Timer(50, panel);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Flying balls");
            frame.setContentPane(panel);
            frame.pack();
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.setVisible(true);

            timer.start();
        });
    }

}
