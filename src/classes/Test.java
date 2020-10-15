package classes;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
//Produit p=new Produit(20,"chemise","aucune",120);
//Produit p=new Produit();

//p.create();
//p.setId(2);
//p.delete();
//p.update();
		/*
ResultSet rs=p.affiche();
while(rs.next())
{
	System.out.println(rs.getString("titre"));
	

}
	}
*/
		User u=new User("admin","admin");
		User u2=new User("admins","xy");

		User resultat=u.authentifier();
		User resultat2=u2.authentifier();

		System.out.println(resultat.toString());
		if(resultat2!=null)
			System.out.println(resultat2.toString());
		else
			System.out.println("inexistant");

	}
}
