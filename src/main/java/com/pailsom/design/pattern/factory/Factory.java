package com.pailsom.design.pattern.factory;

public class Factory {
    /**
     * Wholesale object creation.
     * What is factory?
     * Ans - A component responsible solely for the wholesale (not piecewise)
     * creation of objects.
     */
    public static void main(String[] args) {
        Point.PointFactory.newCartesianPoint(2d,3d);

    }
    static class Point{
        private Double x,y;

        public Point(Double x, Double y) {
            this.x = x;
            this.y = y;
        }

        public static class PointFactory {
            public static Point newCartesianPoint(Double a, Double b){
                return new Point(a,b);
            }
            public static Point newPolarPoint(Double a, Double b){
                return new Point(a*Math.sin(b),a*Math.cos(b));
            }
        }
    }

}
