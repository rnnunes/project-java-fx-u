package main.projectjfxjdbcv1.model.services;

import main.projectjfxjdbcv1.DepartmentModel;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    public List<DepartmentModel> findAll() {
        List<DepartmentModel> list = new ArrayList<>();
        list.add(new DepartmentModel(1,"Books"));
        list.add(new DepartmentModel(2, "Computers"));
        list.add(new DepartmentModel(3,"Eletronics"));
        return list;
        }
    }

