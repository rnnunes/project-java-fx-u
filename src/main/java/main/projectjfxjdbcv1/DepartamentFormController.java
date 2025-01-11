package main.projectjfxjdbcv1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.projectjfxjdbcv1.model.services.DepartmentService;
import main.projectjfxjdbcv1.util.Constraints;
import main.projectjfxjdbcv1.util.Utils;

import java.net.URL;
import java.util.ResourceBundle;

public class DepartamentFormController implements Initializable {

    private DepartmentModel entity;

    private DepartmentService service;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtGerente;

    @FXML
    private TextField txtCoordenadora;

    @FXML
    private Label labelErrorName;

    @FXML
    private Label labelErrorGerente;

    @FXML
    private Label labelErrorCoordenadora;

    @FXML
    private Button btSave;

    @FXML
    private Button btCancel;

    public void setDepartamentModel(DepartmentModel entity) {
        this.entity = entity;
    }

    public void setDepartmentService(DepartmentService service) {
        this.service = service;
    }

    @FXML
    public void onBtSaveAction() {
        entity = getFormData();
        service.saveOrUpdate(entity);
    }

    private DepartmentModel getFormData() {
        DepartmentModel obj = new DepartmentModel();
        obj.setId(Utils.tryParseToInt(txtId.getText()));
        obj.setName(txtName.getText());
        obj.setGerente(txtGerente.getText());
        obj.setCoordenador(txtCoordenadora.getText());

        return obj;
    }

    @FXML
    public void onBtCancelAction() {
        System.out.println("onBtCancelAction");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeNodes();
    }

    private void initializeNodes() {
        Constraints.setTextFieldInterger(txtId);
        Constraints.setTextFildMaxLength(txtName, 110);
        Constraints.setTextFildMaxLength(txtGerente, 110);
        Constraints.setTextFildMaxLength(txtCoordenadora, 110);
    }

    public void updateFormData() {
        if (entity == null) {
            throw new IllegalStateException("Entidade esta Nula");
        }
        txtId.setText(String.valueOf(entity.getId()));
        txtName.setText(entity.getName());
        txtGerente.setText(entity.getGerente());
        txtCoordenadora.setText(entity.getCoordenador());
    }

}
