package main.projectjfxjdbcv1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import main.projectjfxjdbcv1.model.services.DepartmentService;
import main.projectjfxjdbcv1.util.Alerts;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemCadastro;

    @FXML
    private MenuItem menuItemDepartamentos;

    @FXML
    private MenuItem menuItemAbout;

    @FXML
    public void onMenuItemCadastroAction() {
        System.out.println("Testando Cadastro");
    }
    @FXML
    public void onMenuItemDepartamentosAction() {
        loadView("DepartamentList.fxml", (DepartamentListController controller) -> {
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();
        });
    }
    @FXML
    public void onMenuItemAboutAction() {
        loadView("AboutView.fxml", x -> {});
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private synchronized <T> void loadView(String absolutename, Consumer<T> inicializingAction) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutename));
            VBox newVBox = loader.load();

            Scene mainScene = Main.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());

            T controller = loader.getController();
            inicializingAction.accept(controller);

        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Erro no carregamento da View", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
