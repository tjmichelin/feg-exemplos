package exercicio02;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {

	public static void main(String[] args) {
		System.out.println("Instanciacao dos objetos:");
		Shape rect = new Rectangle(10, 15);
		Shape sq = new Square(32.5);
		Shape c = new Circle(4.5);
		Shape tr = new Triangle(4, 3, 3, 4, 5);
		
		System.out.println(rect.toString());
		System.out.println(sq);
		System.out.println(c);
		
		List<Shape> formasGeometricas = new ArrayList<Shape>();
		formasGeometricas.add(rect);
		formasGeometricas.add(sq);
		formasGeometricas.add(c);
		formasGeometricas.add(tr);
		
		for (int i = 0; i < formasGeometricas.size(); i++) {
			System.out.printf("Area do %s: %.2f\n", formasGeometricas.get(i), formasGeometricas.get(i).calcularArea());
		}
	}

}
