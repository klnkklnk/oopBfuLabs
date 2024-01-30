package bfu.oop.lab2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInterface
{
	private Scanner scanner;
	
	public ConsoleInterface()
	{
		this.scanner = new Scanner(System.in);
	}
	
	public void startProgram()
	{
		boolean isRunning = true;
		while (isRunning)
		{
			displayMenu();
			int choiceMenuItem = scanner.nextInt();
			switch (choiceMenuItem)
			{
				case 1 ->
				{
					addVectors();
				}
				case 2 ->
				{
					subtractVectors();
				}
				case 3 ->
				{
					reverseVector();
				}
				case 4 -> normalizeVector();
				case 5 ->
				{
					calculateScalarProduct();
				}
				case 6 ->
				{
					calculateVectorProduct();
				}
				case 7 ->
				{
					calculateMixedProduct();
				}
				case 8 ->
				{
					calculateVectorLength();
				}
				case 9 ->
				{
					checkCollinearity();
				}
				case 10 ->
				{
					checkComplementarity();
				}
				case 11 ->
				{
					calculateDistanceBetweenVectors();
				}
				case 12 ->
				{
					calculateAngleBetweenVectors();
				}
				case 13 ->
				{
					isRunning = false;
				}
				default ->
				{
					System.out.println("Такого варианта меню нет, попробуйте ещё раз");
				}
			}
		}
	}
	
	private void displayMenu()
	{
		System.out.println("\nВыберите необходимую операцию:");
		System.out.println("1. Сложение векторов");
		System.out.println("2. Вычитание векторов");
		System.out.println("3. Получение обратного вектора");
		System.out.println("4. Построение единичного вектора");
		System.out.println("5. Нахождение скалярного произведения двух векторов");
		System.out.println("6. Нахождение векторного произведения двух векторов");
		System.out.println("7. Нахождение смешанного произведения трёх векторов");
		System.out.println("8. Нахождение длины вектора");
		System.out.println("9. Определение коллинеарности двух векторов");
		System.out.println("10. Определение компланарности трёх векторов");
		System.out.println("11. Нахождение расстояния между двумя векторами");
		System.out.println("12. Нахождение угла между двумя векторами");
		System.out.println("13. --Завершить работу--\n");
	}
	
	private String vectorToString(Vector vector)
	{
		return "(" + vector.getX() +
				", " + vector.getY() + ", " +
				vector.getZ() + ")";
	}

	private Vector createVector()
	{
		while (true)
		{
			try
			{
				System.out.println("1. Создать вектор по одной точке\n2. Создать вектор по двум точкам");
				int choice = scanner.nextInt();
				switch (choice)
				{
					case 1 ->
					{
						System.out.println("Введите координаты x, y, z (формат: x y z):");
						double x = scanner.nextDouble();
						double y = scanner.nextDouble();
						double z = scanner.nextDouble();
						return new Vector(x, y, z);
					}
					case 2 ->
					{
						System.out.println("Введите координаты x1, y1, z1 и x2, y2, z2 (формат: x1 y1 z1 x2 y2 z2):");
						double x1 = scanner.nextDouble();
						double y1 = scanner.nextDouble();
						double z1 = scanner.nextDouble();
						double x2 = scanner.nextDouble();
						double y2 = scanner.nextDouble();
						double z2 = scanner.nextDouble();
						return new Vector(new Point(x1, y1, z1), new Point(x2, y2, z2));
					}
					default ->
					{
						System.out.println("Такого пункта нет!");
					}
				}
			}
			catch (Exception Exception)
			{
				this.scanner = new Scanner(System.in);
				System.out.println("Неправильно введенные данные.");
			}
		}
	}
	
	private void addVectors()
	{
		System.out.println("\nВведите первый вектор:");
		Vector vector1 = createVector();
		System.out.println("Введите второй вектор:");
		Vector vector2 = createVector();
		System.out.println("Результат: " + vectorToString(vector1.add(vector2)) + "\n");
	}
	
	private void subtractVectors()
	{
		System.out.println("\nВведите первый вектор:");
		Vector vector1 = createVector();
		System.out.println("Введите второй вектор:");
		Vector vector2 = createVector();
		System.out.println("Результат: " + vectorToString(vector1.subtract(vector2)) + "\n");
	}
	
	private void reverseVector()
	{
		System.out.println("\nВведите вектор:");
		System.out.println("Результат: " + vectorToString(createVector().getInverse()) + "\n");
	}
	
	private void normalizeVector()
	{
		System.out.println("\nВведите вектор:");
		System.out.println("Результат: " + vectorToString(createVector().getUnitVector()) + "\n");
	}
	
	private void calculateScalarProduct()
	{
		System.out.println("\nВведите первый вектор:");
		Vector vector1 = createVector();
		System.out.println("Введите второй вектор:");
		Vector vector2 = createVector();
		System.out.println("Результат: " + vector1.getScalarProduct(vector2) + "\n");
	}
	
	private void calculateVectorProduct()
	{
		System.out.println("\nВведите первый вектор:");
		Vector vector1 = createVector();
		System.out.println("Введите второй вектор:");
		Vector vector2 = createVector();
		System.out.println("Результат: " + vector1.getVectorProduct(vector2) + "\n");
	}
	
	private void calculateMixedProduct()
	{
		System.out.println("\nВведите первый вектор:");
		Vector vector1 = createVector();
		System.out.println("Введите второй вектор:");
		Vector vector2 = createVector();
		System.out.println("Введите третий вектор:");
		Vector vector3 = createVector();
		System.out.println("Результат: " + vector1.getMixedProduct(vector2, vector3) + "\n");
	}
	
	private void calculateVectorLength()
	{
		System.out.println("\nВведите вектор:");
		System.out.println("Результат: " + createVector().getLength() + "\n");
	}
	
	private void checkCollinearity()
	{
		System.out.println("\nВведите первый вектор:");
		Vector vector1 = createVector();
		System.out.println("Введите второй вектор:");
		Vector vector2 = createVector();
		if (vector1.isCollinear(vector2))
		{
			System.out.println("Результат: векторы коллинеарны\n");
		}
		else
		{
			System.out.println("Результат: векторы неколлинеарны\n");
		}
	}
	private void checkComplementarity()
	{
		System.out.println("\nВведите первый вектор:");
		Vector vector1 = createVector();
		System.out.println("Введите второй вектор:");
		Vector vector2 = createVector();
		System.out.println("Введите третий вектор:");
		Vector vector3 = createVector();
		if (vector1.isCoplanar(vector2, vector3))
		{
			System.out.println("Результат: векторы компланарны\n");
		}
		else
		{
			System.out.println("Результат: векторы некомпланарны\n");
		}
	}
	
	private void calculateDistanceBetweenVectors()
	{
		System.out.println("\nВведите первый вектор:");
		Vector vector1 = createVector();
		System.out.println("Введите второй вектор:");
		Vector vector2 = createVector();
		System.out.println("Результат: " + vector1.getDistance(vector2) + "\n");
	}
	
	private void calculateAngleBetweenVectors()
	{
		System.out.println("\nВведите первый вектор:");
		Vector vector1 = createVector();
		System.out.println("Введите второй вектор:");
		Vector vector2 = createVector();
		System.out.println("Результат: " + vector1.getAngle(vector2) + "\n");
	}
}
