package main.projectjfxjdbcv1.impl;

import main.projectjfxjdbcv1.DB.DB;
import main.projectjfxjdbcv1.DB.DbException;
import main.projectjfxjdbcv1.DB.DbIntegrityException;
import main.projectjfxjdbcv1.DepartmentModel;
import main.projectjfxjdbcv1.dao.DepartmentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public DepartmentModel findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM departamentos WHERE id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				DepartmentModel obj = new DepartmentModel();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				obj.setGerente(rs.getString("gerente"));
				obj.setCoordenador(rs.getString("coordenador"));

				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<DepartmentModel> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM departamentos ORDER BY Name");
			rs = st.executeQuery();

			List<DepartmentModel> list = new ArrayList<>();

			while (rs.next()) {
				DepartmentModel obj = new DepartmentModel();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				obj.setGerente(rs.getString("gerente"));
				obj.setCoordenador(rs.getString("coordenador"));
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void insert(DepartmentModel obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"INSERT INTO departamentos " +
				"(name, gerente, coordenador) " +
				"VALUES " +
				"(?, ?, ?)",
				Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getName());

			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(DepartmentModel obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"UPDATE departamentos " +
				"SET name = ?, gerente = ?, coordenador = ?" +
				"WHERE id = ?");

			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"DELETE FROM departamentos WHERE id = ?");

			st.setInt(1, id);

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}
}
