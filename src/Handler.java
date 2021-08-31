import java.awt.*;
import java.io.*;
import java.util.*;

public class Handler {
    private Slopes[][] slopes;
    private Random r;
    private double t;
    private int rows;
    private int cols;


    public Handler(int xNum, int yNum){
        r = new Random();
        rows = yNum;
        cols = xNum;
        t = 0;
        slopes = new Slopes[rows][cols];

        for (int i = 0; i < xNum; i++){
            for (int j = 0; j < yNum; j++){
                slopes[j][i] = new Slopes(cols, rows);
            }
        }
    }

    public void tick(int width, int height){
        t -= .05;
    }

    public void render(Graphics g, int width, int height){
        g.setColor(Color.BLACK);
        g.fillRect(0,0, width, height);

        g.setColor(new Color(60,180, 255));
        for (int i = 0; i < cols; i++){
            double rand = r.nextDouble();
            for (int j = 0; j < rows; j++){
                /*
                int rightX = (i * 25 + 100) + (int) (13 * Math.sin(1.0 * i + t));
                int rightY = (j * 25 + 100)  + (int) (13 * Math.cos(1.0 * j + t));
                int leftX = (i * 25 + 100) - (int) (13 * Math.cos(1.0 * i + t));
                int leftY = (j * 25 + 100) - (int) (13 * Math.sin(1.0 * j + t));
                */

                int rightX = (i * 25 + 100) + (int) (10 * Math.cos(i / 1.5 + t)) - (int) (13 * Math.sin(j / 1.5 + t + rand));
                int rightY = (j * 25 + 100)  + (int) (13 * Math.sin(j / 1.5 + t)) - (int) (13 * Math.cos(i / 1.5 + t + rand));
                int leftX = (i * 25 + 100) - (int) (13 * Math.cos(i / 1.5 + t)) - (int) (6 * Math.sin(j / 1.5 + t));
                int leftY = (j * 25 + 100) - (int) (8 * Math.sin(j / 1.5 + t)) - (int) (13 * Math.cos(i / 1.5 + t));

                g.drawLine(rightX, rightY, leftX, leftY);
            }
        }
    }
}