package bfu.oop.lab1;

import java.util.function.Function;

public class SimpsonCalc extends Calc
{
	
	public SimpsonCalc(int amountOfPoints, double precision)
	{
		super(amountOfPoints, precision);
	}
	
	@Override
	public double calc(Function<Double, Double> function, double lowerBound, double upperBound)
	{
		double result = 0;
		double x = lowerBound;
		double dx = (upperBound - lowerBound) / amountOfPoints;
		for (int i = 0; i < amountOfPoints; i++)
		{
			double y1 = function.apply(x);
			double y2 = function.apply(x + dx / 2);
			double y3 = function.apply(x + dx);
			result += (dx / 6) * (y1 + 4 * y2 + y3);
			x += dx;
		}
		return Math.round(result / precision) * precision;
	}
}
