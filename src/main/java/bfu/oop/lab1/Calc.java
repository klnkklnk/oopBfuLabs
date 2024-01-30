package bfu.oop.lab1;

import java.util.function.Function;

abstract class Calc {
	protected int amountOfPoints;
	protected double precision;
	public Calc(int amountOfPoints, double precision)
	{
		this.amountOfPoints = amountOfPoints;
		this.precision = precision;
	}
	public abstract double calc(Function<Double, Double> function, double lowerBound, double upperBound);
}