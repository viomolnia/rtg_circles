package circles.utils;

import java.awt.Color;

public class Circle {

    public double x;
    public double y;
    public double radius;
    public Speed speed;
    public Color color;
    public boolean minimize;
    public double mass;

    public Circle() {
        this.speed = new Speed();
        this.minimize = false;
    }
}
