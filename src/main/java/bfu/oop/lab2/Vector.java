package bfu.oop.lab2;

public class Vector
{
	private double x;
	private double y;
	private double z;
	public Vector(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector(Point point1, Point point2)
	{
		this.x = point2.getX() - point1.getX();
		this.y = point2.getY() - point1.getY();
		this.z = point2.getZ() - point1.getZ();
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public double getZ()
	{
		return z;
	}
	
	public void setX(double x)
	{
		this.x = x;
	}
	
	public void setY(double y)
	{
		this.y = y;
	}
	
	public void setZ(double z)
	{
		this.z = z;
	}
	
	public Vector add(Vector vector)
	{
		return new Vector(this.x + vector.getX(), this.y + vector.getY(), this.z + vector.getZ());
	}
	public Vector subtract(Vector vector)
	{
		return new Vector(this.x - vector.getX(), this.y - vector.getY(), this.z - vector.getZ());
	}
	
	public Vector getInverse()
	{
		return new Vector(-this.x, -this.y, -this.z);
	}
	
	public Vector getUnitVector()
	{
		double length = getLength();
		return new Vector(this.x / length, this.y / length, this.z / length);
	}
	
	public double getScalarProduct(Vector vector)
	{
		return this.x * vector.getX() + this.y * vector.getY() + this.z * vector.getZ();
	}
	
	public Vector getVectorProduct(Vector vector)
	{
		double resultX = this.y * vector.getZ() - this.z * vector.getY();
		double resultY = this.z * vector.getX() - this.x * vector.getZ();
		double resultZ = this.x * vector.getY() - this.y * vector.getX();
		return new Vector(resultX, resultY, resultZ);
	}
	
	public double getMixedProduct(Vector vector1, Vector vector2)
	{
		return this.getScalarProduct(vector1.getVectorProduct(vector2));
	}
	
	public double getLength()
	{
		return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
	}
	
	public boolean isCollinear(Vector vector)
	{
		return this.getScalarProduct(vector) == 0;
	}
	
	public boolean isCoplanar(Vector vector1, Vector vector2)
	{
		return this.getMixedProduct(vector1, vector2) == 0;
	}
	
	public double getDistance(Vector vector)
	{
		return this.subtract(vector).getLength();
	}
	
	public double getAngle(Vector vector)
	{
		return Math.acos(this.getScalarProduct(vector) / (this.getLength() * vector.getLength()));
	}
}
