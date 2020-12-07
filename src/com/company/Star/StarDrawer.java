package com.company.Star;

import com.company.ScreenConverter;
import com.company.line_drawer.CircleDrawer;
import com.company.line_drawer.LineDrawer;
import com.company.point.RealPoint;
import com.company.point.ScreenPoint;

import java.awt.*;

public class StarDrawer {
    public static void draw(ScreenConverter sc, LineDrawer ld, Star s, CircleDrawer cd) {//две стороны треугольника, complete = false
        RealPoint prev = null;
        for (RealPoint p : s.getList()) {
            if (prev != null) {
                ScreenPoint p1 = sc.r2s(prev);
                ScreenPoint p2 = sc.r2s(p);
                ld.drawLine(p1, p2, Color.BLUE);
                cd.drawCircle(p1.getX() - 5, p1.getY() - 5, 5);
            }
            prev = p;

        }
    }

    public static void drawFinal(ScreenConverter sc, LineDrawer ld, Star s, CircleDrawer cd) {//завершенный треугольник, complete = true
        draw(sc, ld, s, cd);
        ScreenPoint p1 = sc.r2s(s.getList().get(s.getList().size() - 1));
        ScreenPoint p2 = sc.r2s(s.getList().get(0));
        ld.drawLine(p1, p2, Color.BLUE);
        cd.drawCircle(p1.getX() - 5, p1.getY() - 5, 5);
    }

    private static boolean isBelongs(Star s, RealPoint p) {//принадлежит ли точка треугольнику
        double x1 = s.getList().get(0).getX();
        double y1 = s.getList().get(0).getY();
        double x2 = s.getList().get(1).getX();
        double y2 = s.getList().get(1).getY();
        double x3 = s.getList().get(2).getX();
        double y3 = s.getList().get(2).getY();
        double x4 = s.getList().get(0).getX();
        double y4 = s.getList().get(0).getY();
        double x5 = s.getList().get(1).getX();
        double y5 = s.getList().get(1).getY();
        double x6 = s.getList().get(2).getX();
        double y6 = s.getList().get(2).getY();
        double x7 = s.getList().get(0).getX();
        double y7 = s.getList().get(0).getY();
        double x8 = s.getList().get(1).getX();
        double y8 = s.getList().get(1).getY();
        double x9 = s.getList().get(2).getX();
        double y9 = s.getList().get(2).getY();
        double x10 = s.getList().get(0).getX();
        double y10 = s.getList().get(0).getY();

        double x0 = p.getX();
        double y0 = p.getY();

        double a = (x1 - x0) * (y2 - y1) - (x2 - x1) * (y1 - y0);
        double b = (x2 - x0) * (y3 - y2) - (x3 - x2) * (y2 - y0);
        double c = (x3 - x0) * (y4 - y3) - (x4 - x3) * (y3 - y0);
        double d = (x4 - x0) * (y5 - y4) - (x5 - x4) * (y4 - y0);
        double e = (x5 - x0) * (y6 - y5) - (x6 - x5) * (y5 - y0);
        double f = (x6 - x0) * (y7 - y6) - (x7 - x6) * (y6 - y0);
        double g = (x7 - x0) * (y8 - y7) - (x8 - x7) * (y7 - y0);
        double m = (x8 - x0) * (y9 - y8) - (x9 - x8) * (y8 - y0);
        double l = (x9 - x0) * (y10 - y9) - (x10 - x9) * (y9 - y0);
        double n = (x10 - x0) * (y1 - y10) - (x1 - x10) * (y10 - y0);


        if ((a >= 0 && b >= 0 && c >= 0 && d >= 0 && e >= 0 && f >= 0 && g >= 0 && m >= 0 && n >= 0 && l >= 0) || (a <= 0 && b <= 0 && c <= 0 && d <= 0 && e <= 0 && f <= 0 && g <= 0 && m <= 0 && n <= 0 && l <= 0)) {//если одинакового знака лежит внутри, если 0 - лежит на стороне
            return true;
        } else {
            return false;
        }

    }
}