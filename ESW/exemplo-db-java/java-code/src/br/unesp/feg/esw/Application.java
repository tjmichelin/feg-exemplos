package br.unesp.feg.esw;

import java.util.List;
import java.util.Optional;

import br.unesp.feg.esw.db.dao.UserDAO;
import br.unesp.feg.esw.db.dao.UserDBDAO;
import br.unesp.feg.esw.model.User;

public class Application {

	public static void main(String[] args) {
		UserDAO dao = null;
		
		try {
			dao = new UserDBDAO();
			
			// Salva os dados de um novo usuário no banco de dados
			User user = new User("user12345", "Ciclano de Tal", "ciclano@example.com", "senha12345");
			dao.save(user);
			
			// Procura pelo usuário com ID = 1
			Optional<User> op = dao.getUserByID(1);
			if (op.isPresent()) {
				System.out.println(op.get().toString());
			} else {
				System.out.println("Couldn't find any user with this ID");
			}
			
			// Cria uma lista com todos os usuários cadastrados no banco de dados
			List<User> list = dao.getAllUsers();
			
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
		} catch (ClassNotFoundException enf) {
			System.out.println(enf.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
