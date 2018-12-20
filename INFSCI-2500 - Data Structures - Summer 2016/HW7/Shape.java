abstract class Shape
{
	//abstract methods
	public abstract double area();
	public abstract double perimeter();

	public double semiperimeter()
	{ return perimeter()/2;}
}//end Shape

class Circle extends Shape
{
	private double radius;

	public double getRadius()
	{ return radius;}

	//constructor
	public Circle(double rad)
	{ radius = rad;}
	
	//implement abstruct methods
	public double area()
	{ return Math.PI * radius * radius;}

	public double perimeter()
	{ return 2 * Math.PI * radius;}

	//reload method toString
	public String toString()
	{ return "Circle: " + radius + " (radius)";}
}//end Circle

class Rectangle extends Shape
{
	private double length;
	private double width;

	public double getLength()
	{ return length;}

	public double getWidth()
	{ return width;}

	//construtor
	public Rectangle(double len, double wid)
	{ length = len; width = wid;}

	//implement abstruct methods
	public double area()
	{ return length * width;}

	public double perimeter()
	{ return 2 * (length + width);}

	//reload method toString
	public String toString()
	{ return "Rectangle: " + length + "*" + width + " (length * width)";}
}//end Rectangle

class Square extends Rectangle
{
	//constructor
	public Square(double side)
	{ super(side, side);}//call the constructor of Rectangle

	//reload method toString
	public String toString()
	{ return "Square: " + getLength() + "*" + getWidth()  + " (side * side)";}
}//end Square

class ShapeDemo
{
	public static double totalArea(Shape[] arr)
	{
		double ta=0;

		for (Shape s : arr)
		{
			if (s!=null)
				ta += s.area();
		}//end foreach loop

		return ta;
	}//end totalArea

	public static double totalPerimeter(Shape[] arr)
	{
		double tp=0;

		for (Shape s : arr)
		{
			if (s!=null)
				tp += s.perimeter();
		}//end foreach loop

		return tp;
	}//end totalPerimeter

	//printing method
	public static void printAll(Shape[] arr)
	{
		for (Shape s : arr)
			System.out.println(s);//automatically call method toString
			//end foreach loop
	}//end printAll

	public static void main(String[] args) 
	{
		//create Shape objects
		Shape[] a = {new Circle(2.3), new Rectangle(1.5, 2.8), new Square(2.5), null};
		
		printAll(a);
		System.out.println("Total Area = " + totalArea(a));
		System.out.println("Total Perimeter = " + totalPerimeter(a));
	}//end main
}//end ShapeDemo