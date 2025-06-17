package exemplo1;

import java.util.ArrayList;
import java.util.List;

public class TesteAnimal {

	public static void main(String[] args) {
		System.out.println("*********** Parte 1 ***********");
		Animal qualquerAnimal;
		
		qualquerAnimal = new Animal();
		
		Animal qualquerOutroAnimal = new Animal();
		
		System.out.println(qualquerAnimal.fazerBarulho());
		System.out.println(qualquerOutroAnimal.fazerBarulho());
		
		Frog sapo = new Frog();
		System.out.print("Barulho do sapo: ");
		System.out.println(sapo.fazerBarulho());
		
		Animal sapo2 = new Frog();
		System.out.print("Barulho do sapo 2: ");
		System.out.println(sapo2.fazerBarulho());
		
		Frog sapo3 = new Frog();
		System.out.print("Barulho do sapo 3: ");
		System.out.println(sapo3.fazerBarulho());
		
		Bird passaro1 = new Bird();
		System.out.print("Barulho do passaro 1: ");
		System.out.println(passaro1.fazerBarulho());
		
		Fish peixe1 = new Fish();
		System.out.print("Barulho do peixe 1: ");
		System.out.println(peixe1.fazerBarulho());
		
		System.out.println("*********** Parte 2 ***********");
		
		Animal passaro10 = new Bird();
		Animal sapo10 = new Frog();
		Animal peixe10 = new Fish();
		
		List<Animal> lista = new ArrayList<Animal>();
		lista.add(passaro10);
		lista.add(sapo10);
		lista.add(peixe10);
		
		for (Animal animal : lista) {
			String barulho = animal.fazerBarulho();
			System.out.println(barulho);
			
			/*
			 	As duas linhas acima são equivalentes à linha abaixo:
				System.out.println(animal.fazerBarulho());
			*/
		}
	}

}
