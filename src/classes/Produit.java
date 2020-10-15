package classes;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import dao.ProduitInterface;

public class Produit implements ProduitInterface {
private int id,quantite;
private String titre,description;
private double prix;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
public Produit(int id, int quantite, String titre, String description, double prix) {
	super();
	this.id = id;
	this.quantite = quantite;
	this.titre = titre;
	this.description = description;
	this.prix = prix;
}
public Produit(int quantite, String titre, String description, double prix) {
	super();
	this.quantite = quantite;
	this.titre = titre;
	this.description = description;
	this.prix = prix;
}
public Produit() {
	super();
}
@Override
public void create() {
	// TODO Auto-generated method stub
	try {
		// TODO add your handling code here:
		
		Connexion c= new Connexion(); //instanciation de connexion
		java.sql.PreparedStatement statement = c.conn.prepareStatement("INSERT INTO `produit`(`titre`, `description`, `quantite`, `prix`) VALUES   ('"+this.getTitre()+"','"+this.getDescription() +"','"+this.getQuantite()+"','"+this.getPrix()+"')");
		statement.executeUpdate();
		//JOptionPane.showMessageDialog(null,"Ajouté avec	succés","",JOptionPane.INFORMATION_MESSAGE);
		System.out.println("ajouté");
		}
	catch (SQLException ex) {
		System.out.println(ex);
		
	}
	
}


public Produit(int quantite, String titre, double prix) {
	super();
	this.quantite = quantite;
	this.titre = titre;
	this.prix = prix;
}
@Override
public void update() {
	// TODO Auto-generated method stub
	try {
		// TODO add your handling code here:
		Connexion c= new Connexion();
		String sql="UPDATE `produit` SET `description`='"+this.description+"' ,`quantite`='"+this.quantite+"',`prix`='"+this.prix+"' WHERE		`id`='"+this.id+"';";
		java.sql.PreparedStatement statement = c.conn.prepareStatement(sql);
		statement.executeUpdate();
		
		System.out.println("modifié");

		
		} catch (SQLException ex) {
			System.out.println(ex);
		
		}
}
@Override
public void delete() {
	// TODO Auto-generated method stub
	try {
		// TODO add your handling code here:
		Connexion c= new Connexion();
		String sql = "DELETE FROM `produit` WHERE `id`=?";
		java.sql.PreparedStatement statement = c.conn.prepareStatement(sql);
		statement.setInt(1, this.getId());
		statement.execute();
		System.out.println("supprimer");
		} catch (SQLException ex) {
			System.out.println(ex);
		
		}
	
}
@Override
public ResultSet affiche() throws SQLException {
	// TODO Auto-generated method stub
	Connexion c=new Connexion();
	PreparedStatement pst;
	pst = (PreparedStatement) c.conn.prepareStatement("SELECT * FROM	produit");
	pst.executeQuery();
	ResultSet rs = (ResultSet) pst.executeQuery();
	return rs;
}


}
