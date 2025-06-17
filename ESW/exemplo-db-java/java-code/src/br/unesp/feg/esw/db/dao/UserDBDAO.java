package br.unesp.feg.esw.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.unesp.feg.esw.db.Database;
import br.unesp.feg.esw.db.PostgresqlDB;
import br.unesp.feg.esw.model.User;

public class UserDBDAO implements UserDAO {
	private Database db;
	
	public UserDBDAO() throws Exception {
		this.db = new PostgresqlDB("localhost", 5432, "exemplo_esw", "dbuser", "senha1234");
	}
	
	@Override
	public List<User> getAllUsers() throws Exception {
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM users";
		
		PreparedStatement stmt = this.db.getConnection().prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			
			users.add(user);
		}
		
		stmt.close();
		return users;
	}

	@Override
	public Optional<User> getUserByID(int id) throws Exception {
		String sql = "SELECT * FROM users WHERE id = ?";
		
		PreparedStatement stmt = this.db.getConnection().prepareStatement(sql);
		stmt.setInt(id, 1);
	
		ResultSet rs = stmt.executeQuery();
		User user = null;
		
		if (rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
		}
		
		Optional<User> op = Optional.ofNullable(user);
		return op;
	}

	@Override
	public void save(User user) throws Exception {
		String sql = "INSERT INTO users(username, name, email, password) VALUES(?, ?, ?, ?)";
		
		this.db.getConnection().setAutoCommit(false);
		
		PreparedStatement saveUser = this.db.getConnection().prepareStatement(sql);
		saveUser.setString(1, user.getUsername());
		saveUser.setString(2, user.getName());
		saveUser.setString(3, user.getEmail());
		saveUser.setString(4, user.getPassword());
		
		saveUser.execute();
		this.db.getConnection().commit();
		this.db.getConnection().setAutoCommit(true);
		saveUser.close();
	}

	@Override
	public void delete(User user) throws Exception {
		String sql = "DELETE FROM users WHERE id = ?";
		
		this.db.getConnection().setAutoCommit(false);
		PreparedStatement deleteUser = this.db.getConnection().prepareStatement(sql);
		deleteUser.setInt(1, user.getId());
		deleteUser.execute();
		this.db.getConnection().commit();
		this.db.getConnection().setAutoCommit(true);
		deleteUser.close();
	}

	@Override
	public void update(User user) throws Exception {
		String sql = "UPDATE users SET username = ?, name = ?, email = ?, password = ? WHERE id = ?";
		
		this.db.getConnection().setAutoCommit(false);
		PreparedStatement updateUser = this.db.getConnection().prepareStatement(sql);
		updateUser.setString(1, user.getUsername());
		updateUser.setString(2, user.getName());
		updateUser.setString(3, user.getEmail());
		updateUser.setString(4, user.getPassword());
		updateUser.setInt(5, user.getId());
		
		updateUser.execute();
		this.db.getConnection().commit();
		this.db.getConnection().setAutoCommit(true);
		updateUser.close();
	}

	@Override
	protected void finalize() {
		this.db.closeConnection();
	}
}
