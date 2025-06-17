package br.unesp.feg.esw.db.dao;

import java.util.List;
import java.util.Optional;

import br.unesp.feg.esw.model.User;

/**
 * Este exemplo usa um design pattern conhecido como "DAO (Data Access Object) pattern".
 * Uma explicação breve sobre esta técnica está disponível em
 * https://www.digitalocean.com/community/tutorials/dao-design-pattern
 */
public interface UserDAO {
	List<User> getAllUsers() throws Exception;
	Optional<User> getUserByID(int id) throws Exception;
	void save(User user) throws Exception;
	void delete(User user) throws Exception;
	void update(User user) throws Exception;
}
