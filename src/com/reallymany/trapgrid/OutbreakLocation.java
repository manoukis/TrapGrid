package com.reallymany.trapgrid;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;
/**
 * Amazing OutbreakLocation class abstracts a release at a given location on the grid
 * of a given number of flies having a given diffusion coefficient 
 * @author bhall
 *
 */
public class OutbreakLocation {
	Point2D.Double location;
	int numberOfFlies;
	double diffusionCoefficient;
	Random rng;

	public OutbreakLocation(Point2D.Double rp, int numFlies, double dc, long seed) {
		this.location = rp;
		this.numberOfFlies = numFlies;
		this.diffusionCoefficient = dc;
		this.rng = new Random(seed);
	}
	
	public String toString() {
		String result = this.numberOfFlies + " flies released at (";
		result += this.location.getX() + ", " + this.location.getY() + ") ";
		result += "with Diffusion Coefficient " + this.diffusionCoefficient;
		return result;
	}

	/**
	 * Returns the location of the OutbreakLocation in "(x, y)" format
	 * @return
	 */
	public String shortString() {
		String result = "(" + this.location.getX() + ", " + this.location.getY() + ")";
		return result;
	}
		
	/**
	 * Randomly places flies using a Gaussian distribution according to their
	 * diffusion coefficient and the number of days elapsed since their release
	 * @param day
	 * @return	An ArrayList of points representing the locations of the flies
	 */
	public ArrayList<Point2D.Double> locateFlies(int day) {
			return EsotericMath.pickSomePoints(location, diffusionCoefficient, day, numberOfFlies, rng);
		}	
}
