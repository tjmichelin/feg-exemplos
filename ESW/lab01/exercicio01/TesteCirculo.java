package exercicio01;

public class TesteCirculo {

	public static void main(String[] args) {
		double r = 5;
		
		Circulo circ1 = new Circulo(r);
		Circulo circ2 = new Circulo(20);
		
		System.out.print("Area do circulo de raio 5: ");
		System.out.printf("%.2f\n", circ1.calcularArea());
		System.out.print("Comprimento da circunferencia do circulo de raio 5: ");
		System.out.printf("%.2f\n", circ1.calcularCircunferencia());
		
		System.out.print("Area do circulo de raio 20: ");
		System.out.printf("%.2f\n", circ2.calcularArea());
		System.out.print("Comprimento da circunferencia do circulo de raio 20: ");
		System.out.printf("%.2f\n", circ2.calcularCircunferencia());
		
		double diferencaAreas = circ2.calcularArea() - circ1.calcularArea();
		System.out.print("Diferenca entre as areas dos circulos 2 e 1: ");
		System.out.printf("%.2f\n", diferencaAreas);
	}
}
