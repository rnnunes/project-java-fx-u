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

//    public List<DepartmentModel> findAll() {
//        List<DepartmentModel> list = new ArrayList<>();
//        list.add(new DepartmentModel(1,"TECNOLOGIA DA INFORMACAO", "FREDSON PALMA LOPES", "JOSE PEREIRA DA SILVA (Juca)"));
//        list.add(new DepartmentModel(2, "CONTAS MEDICAS","RICARDO ALVES TAVARES", "WESLEY DA SILVA DIAS"));
//        list.add(new DepartmentModel(3,"DESENVOLVIMENTO DE MERCADO","JEFFERSON CLAUDIO DIAS PAIAO", "FERNANDA NAYARA PEREIRA SANTOS DINIZ"));
//        return list;
//        }
    }

