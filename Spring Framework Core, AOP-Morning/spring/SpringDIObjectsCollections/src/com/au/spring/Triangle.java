package com.au.spring;

import java.util.HashMap;
import java.util.Map;

public class Triangle {

	private Point pointA;
	private Point pointB;
	private Point pointC;
	
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

	private HashMap<String, Point> map = new HashMap<>();

	public HashMap<String, Point> getMap() {
		return map;
	}
	public void setMap(HashMap<String, Point> map) {
		this.map = map;
	}

	public void draw() {
		for(Map.Entry<String, Point> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue().getX() +" "+ entry.getValue().getY());
		}
	}

}
