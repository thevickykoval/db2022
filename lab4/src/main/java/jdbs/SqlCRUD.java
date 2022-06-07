package jdbs;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import servlets.LabCRUDInterface;
import valuta.Valuta;

public class SqlCRUD implements LabCRUDInterface<Valuta> {

Connection connection;
	
	
	public SqlCRUD() {
		
		this.connection = new Connect().getCon();
		
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(Valuta t) {
		// TODO Auto-generated method stub
		try (PreparedStatement st = connection.prepareStatement("INSERT INTO valuta (\"valuta\", count,\"country\") " + "VALUES (?,?,?)")) {
			st.setString(1, t.getValuta());
			st.setDouble(2, t.getCount());
			st.setString(3, t.getCountry());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Valuta> read() {
		List<Valuta> list = new ArrayList<>();

		try (Statement st = connection.createStatement(); 
				ResultSet rs = st.executeQuery("SELECT * FROM valuta;");) {
			while (rs.next()) {
				list.add(new Valuta(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void update(int id, Valuta t) {
		try (PreparedStatement st = connection
				.prepareStatement("UPDATE valuta " + "SET \"valuta\"=?, \"count\"=?, \"country\"=? WHERE id=?;")) {
			st.setString(1, t.getValuta());
			st.setDouble(2, t.getCount());
			st.setString(3, t.getCountry());
			st.setInt(4, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try (PreparedStatement st = connection
				.prepareStatement("DELETE FROM valuta WHERE id=?;")) {
			st.setInt(1, id);			
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
