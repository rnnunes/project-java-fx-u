package main.projectjfxjdbcv1.dao;

import main.projectjfxjdbcv1.Department;
import main.projectjfxjdbcv1.Seller;

import java.util.List;

public interface SellerDao {

	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer id);
	Seller findById(Integer id);
	List<Seller> findAll();
	List<Seller> findByDepartment(Department department);
}
