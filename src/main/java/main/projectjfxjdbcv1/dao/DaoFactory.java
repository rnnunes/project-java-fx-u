package main.projectjfxjdbcv1.dao;

import main.projectjfxjdbcv1.DB.DB;
import main.projectjfxjdbcv1.impl.DepartmentDaoJDBC;
import main.projectjfxjdbcv1.impl.SellerDaoJDBC;

public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
}
