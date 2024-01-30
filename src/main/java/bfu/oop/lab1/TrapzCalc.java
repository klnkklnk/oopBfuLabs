package bfu.oop.lab1;

import java.util.function.Function;

public class TrapzCalc extends Calc {
	
	public TrapzCalc(int amountOfPoints, double precision)
	{
		super(amountOfPoints, precision);
	}
	
	@Override
	public double calc(Function<Double, Double> function, double lowerBound, double upperBound)
	{
		double result = 0.0;
		double dx = (upperBound - lowerBound) / amountOfPoints;
		double x = lowerBound;
		for (int i = 0; i <= amountOfPoints; i++)
		{
			double y = function.apply(x);
			if (i == 0 || i == amountOfPoints)
			{
				result += 0.5 * y;
			}
			else
			{
				result += y;
			}
			x += dx;
		}
		return Math.round((result * dx) / precision) * precision;
	}
}
