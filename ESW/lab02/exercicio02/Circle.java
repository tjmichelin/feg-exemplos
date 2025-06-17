package exercicio02;

public class Circle extends Shape {
	private double r;

	/**
	 * Método construtor.
	 * O menor valor aceito para o raio do círculo é 0.5. Valores menores que este serão
	 * ignorados e o valor 0.5 será atribuído ao atributo r.
	 * @param raio - O valor do raio do círculo
	 */
	public Circle(double raio) {
		if (raio < 0.5) {
			this.r = 0.5;
		} else {
			this.r = raio;
		}
		
		/*
		 	O if-else pode ser substituído por
			this.r = (raio < 0.5) ? 0.5 : raio;
		*/
	}

	@Override
	public double calcularArea() {
		double area = Math.PI * Math.pow(this.r, 2);
		
		return area;
	}

	@Override
	public double calcularPerimetro() {
		double perimetro = 2 * Math.PI * this.r;

		return perimetro;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("Circulo de raio ");
		str.append(this.r);
		
		return str.toString();
	}
}
