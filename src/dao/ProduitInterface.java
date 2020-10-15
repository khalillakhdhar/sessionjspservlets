package dao;

import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

public interface ProduitInterface {
void create();
void update();
void delete();
ResultSet affiche() throws SQLException;
}
