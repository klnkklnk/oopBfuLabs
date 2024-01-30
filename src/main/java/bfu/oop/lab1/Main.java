package bfu.oop.lab1;

import java.util.function.Function;

public class Main
{
	public static void main(String[] args)
	{
		TrapzCalc trapzCalc = new TrapzCalc(1000, 0.0001);
		SimpsonCalc simpsonCalc = new SimpsonCalc(1000, 0.0001);
		Function<Double, Double> function = Math::cos;
		double lowerBound = 0;
		double upperBound = Math.PI/3;
		System.out.printf("TrapzCalc result: %f\nSimpsonCalc result: %f",
				trapzCalc.calc(function, lowerBound, upperBound),
				simpsonCalc.calc(function, lowerBound, upperBound)
		);
	}
}
