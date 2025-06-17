package exercicio02;
 
public class Rectangle extends Shape {
	private double l1;
	private double l2;
	
	/**
	 * Método construtor. Recebe como argumentos os valores dos
	 * lados do retângulo. O menor valor permitido para cada um dos lados
	 * é 0.0001. Valores menores que este serão ignorados e o valor
	 * 0.0001 será atribuído aos atributos l1 e l2.
	 * @param lado1
	 * @param lado2
	 */
	public Rectangle(double lado1, double lado2) {
		if (lado1 < 0.0001) {
			this.l1 = 0.001;
		} else {
			this.l1 = lado1;
		}
		
		if (lado2 < 0.0001) {
			this.l2 = 0.001;
		} else {
			this.l2 = lado1;
		}
	}
	
	@Override
	public double calcularArea() {
		return this.l1 * this.l2;
	}

	@Override
	public double calcularPerimetro() {
		return 2 * this.l1 + 2 * this.l2;
	}

	@Override
	public String toString() {
		String frase = "Retângulo com L1 = " + this.l1 + " e L2 = " + this.l2;
		
		return frase;
	}
}
