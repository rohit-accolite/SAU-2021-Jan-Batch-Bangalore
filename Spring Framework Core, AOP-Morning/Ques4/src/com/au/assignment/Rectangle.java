package com.au.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Rectangle {

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Autowired
    @Qualifier("pointA")
    private Point pointA;

    @Autowired
    @Qualifier("pointB")
    private Point pointB;

    @Autowired
    @Qualifier("pointC")
    private Point pointC;

    @Autowired
    @Qualifier("pointD")
    private Point pointD;

    private int height;
    private int width;

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public Point getPointD() {
        return pointD;
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void draw() {
        System.out.println("Rectangle drawn with height: "+getHeight()+" and width: "+getWidth());
        System.out.println("having points:");
        System.out.println("Point A: "+pointA.getX()+" "+pointA.getY());
        System.out.println("Point B: "+pointB.getX()+" "+pointB.getY());
        System.out.println("Point C: "+pointC.getX()+" "+pointC.getY());
        System.out.println("Point D: "+pointD.getX()+" "+pointD.getY());
    }
}
