package classes;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import dao.UserInterface;

public class User implements UserInterface {
	private int id;
	private String nom,login,mdp;
	public User(int id, String nom, String login, String mdp) {
		super();
		this.id = id;
		this.nom = nom;
		this.login = login;
		this.mdp = mdp;
	}
	public User(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", login=" + login + ", mdp=" + mdp + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
	
	public User() {
		super();
	}
	@Override
	public User authentifier() 
		{
			// TODO Auto-generated method stub
			//SELECT * FROM `utilisateur` WHERE `login`='admin' AND `mdp`='admin'
		 try {
			 
			 
			 Connexion c=new Connexion();
			PreparedStatement pst;
			pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM `utilisateur` WHERE `login`='"+this.login+"' AND `mdp`='"+this.mdp+"'");
			pst.executeQuery();
			ResultSet rs = (ResultSet) pst.executeQuery();
		if(rs.next())
		{
			User u=new User(); 
			u.setId(rs.getInt("id"));
			u.setNom(rs.getString("nom"));
			u.setLogin(rs.getString("login"));
			u.setMdp(rs.getString("mdp"));
			return u;
		}
		else
			return null;
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	} 

	
	
	

}
