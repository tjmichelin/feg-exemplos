package exercicio02;

public class Square extends Shape {
	private double l;
	
	/**
	 * Método construtor. Recebe como argumento o valor do lado do quadrado.
	 * O menor valor permitido para o lado é 0.0001. Valores menores que este
	 * serão ignorados e o valor 0.0001 será atribuído ao atributo l.
	 * @param lado1
	 * @param lado2
	 */
	public Square(double lado) {
		if (lado < 0.0000001) {
			this.l = 0.0000001;
		} else {
			this.l = lado;
		}
	}
	
	@Override
	public double calcularArea() {
		return this.l * this.l;
	}

	@Override
	public double calcularPerimetro() {
		return 4 * this.l;
	}

	@Override
	public String toString() {
		return "Quadrado de lado " + this.l;
	}

}
