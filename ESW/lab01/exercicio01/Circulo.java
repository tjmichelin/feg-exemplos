package exercicio01;

/**
 * Classe para a modelagem de um círculo
 */
public class Circulo {
	private double raio;
	
	/**
	 * Método construtor
	 * @param r
	 */
	public Circulo(double r) {
		this.raio = r;
	}

	/**
	 * Calcula o comprimento da circunferência do círculo
	 * @return O valor do comprimento da circunferência
	 */
	public double calcularCircunferencia() {
		double c = 2 * Math.PI * raio;
		
		return c;
	}
	
	/**
	 * Calcula o valor da área do círculo
	 * @return O valor da área do círculo
	 */
	public double calcularArea() {
		double a = Math.PI * raio * raio;
		
		return a;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("Circulo de raio ");
		str.append(this.raio);
		
		return str.toString();
	}
}
