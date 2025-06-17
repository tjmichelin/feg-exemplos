package exercicio02;

public class Triangle extends Shape {
	private double b;
	private double h;
	private double l1;
	private double l2;
	private double l3;
	
	public Triangle(double base, double altura, double lado1, double lado2, double lado3) {
		final double valorMin = 0.01;
		
		this.b = (base < valorMin) ? valorMin : base;
		this.h = (altura < valorMin) ? valorMin : altura;
		this.l1 = (lado1 < valorMin) ? valorMin : lado1;
		this.l1 = (lado2 < valorMin) ? valorMin : lado2;
		this.l1 = (lado3 < valorMin) ? valorMin : lado3;
	}

	@Override
	public double calcularArea() {
		return (this.b * this.h) / 2;
	}

	@Override
	public double calcularPerimetro() {
		return this.l1 + this.l2 + this.l3;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("Triangulo com base ");
		str.append(this.b);
		str.append(" e altura ");
		str.append(this.h);
		
		return str.toString();
	}
}
