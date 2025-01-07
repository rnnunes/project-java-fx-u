package main.projectjfxjdbcv1;

import java.util.List;

public interface DepartmentDao {

	void insert(DepartmentModel obj);
	void update(DepartmentModel obj);
	void deleteById(Integer id);
	DepartmentModel findById(Integer id);
	List<DepartmentModel> findAll();
}
