package main.projectjfxjdbcv1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.projectjfxjdbcv1.model.services.DepartmentService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DepartamentListController implements Initializable {

    private DepartmentService service;

    @FXML
    private TableView<DepartmentModel> tableViewDepartment;

    @FXML
    private TableColumn<DepartmentModel, Integer> tableColumnId;

    @FXML
    private TableColumn<DepartmentModel, String> tableColumnName;

    @FXML
    private TableColumn<DepartmentModel, String> tableColumnGerente;

    @FXML
    private TableColumn<DepartmentModel, String> tableColumnCoordenador;

    @FXML
    private Button btNew;

    private ObservableList<DepartmentModel> observableList;

    @FXML
    public void onBtNewAction() {
        System.out.println("Teste bot~ao");
    }

    public void setDepartmentService(DepartmentService service) {
        this.service = service;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeNodes();
    }

    private void initializeNodes() {
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnGerente.setCellValueFactory(new PropertyValueFactory<>("gerente"));
        tableColumnCoordenador.setCellValueFactory(new PropertyValueFactory<>("coordenador"));

        Stage stage = (Stage) Main.getMainScene().getWindow();
        tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
    }

    public void updateTableView () {
        if (service == null) {
            throw new IllegalStateException("Serviço esta Nulo!");
        }
        List<DepartmentModel> list = service.findAll();
        observableList = FXCollections.observableArrayList(list);
        tableViewDepartment.setItems(observableList);
    }
}
