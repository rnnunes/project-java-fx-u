package main.projectjfxjdbcv1.model.services;

import main.projectjfxjdbcv1.dao.DaoFactory;
import main.projectjfxjdbcv1.dao.DepartmentDao;
import main.projectjfxjdbcv1.DepartmentModel;

import java.util.List;

public class DepartmentService {

    private DepartmentDao dao = DaoFactory.createDepartmentDao();

    public List<DepartmentModel> findAll() {
        return dao.findAll();
    }

    public void saveOrUpdate(DepartmentModel obj) {
        if (obj.getId() == null) {
            dao.insert(obj);
        } else {
            dao.update(obj);
        }
    }
}

