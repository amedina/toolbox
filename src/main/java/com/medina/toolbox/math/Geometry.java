package com.medina.toolbox.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Geometry {

	private static Logger log = LoggerFactory.getLogger(Geometry.class);
	
	private static boolean isPointInsideRectangle(Point p, Rectangle r) {
		
		if ((p.x >= r.x) && (p.y <= r.y + r.h)) {
			return true;
		}
		
		return false;
	}
	
	private static boolean doRectanglesIntersect(Rectangle r1, Rectangle r2) {
		
		Point p_r1_1 = new Point(r1.x, r1.y); 
		Point p_r1_2 = new Point(r1.x + r1.w, r1.y);
		Point p_r1_3 = new Point(r1.x, r1.y + r1.h);
		Point p_r1_4 = new Point(r1.x + r1.w, r1.y + r1.h);
		
		if (isPointInsideRectangle(p_r1_1, r2) || isPointInsideRectangle(p_r1_2, r2) || isPointInsideRectangle(p_r1_3, r2) || isPointInsideRectangle(p_r1_4, r2)) {
			return true;
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {

		Rectangle r = new Rectangle(4, 3, 5, 3);
		Point p = new Point(4,7);		
		boolean intersect = isPointInsideRectangle(p, r);		
		log.info("{}", r);
		log.info("{}", p);
		log.info("Intersection?: {}", intersect);
		
		p.x = 7;
		p.y = 4;
		intersect = isPointInsideRectangle(p, r);
		log.info("{}", p);
		log.info("Intersection?: {}", intersect);
		
		p.x = 4.5f;
		p.y = 9.5f;
		intersect = isPointInsideRectangle(p, r);
		log.info("{}", p);
		log.info("Intersection?: {}", intersect);
		
		Rectangle r1 = new Rectangle(4, 3, 5, 3);
		Rectangle r2 = new Rectangle(4, 3, 3, 5);
		log.info("Rectangle Intersection?: {}", doRectanglesIntersect(r1, r2));
		
		Rectangle r3 = new Rectangle(10, 3, 3, 5);
		log.info("Rectangle Intersection?: {}", doRectanglesIntersect(r1, r3));
	}

	private static class Point {
		
		public float x; 
		public float y;

		public Point(float x, float y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Point [x=");
			builder.append(x);
			builder.append(", y=");
			builder.append(y);
			builder.append("]");
			return builder.toString();
		}
		
	}
	
	private static class Rectangle {
		
		public float x;
		public float y;
		public float h;
		public float w;
		
		public Rectangle(float rx, float ry, float rh, float rw) {
			super();
			this.x = rx;
			this.y = ry;
			this.h = rh;
			this.w = rw;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Rectangle [rx=");
			builder.append(x);
			builder.append(", ry=");
			builder.append(y);
			builder.append(", rh=");
			builder.append(h);
			builder.append(", rw=");
			builder.append(w);
			builder.append("]");
			return builder.toString();
		}
	}
}
