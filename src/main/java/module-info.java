module main.projectjfxjdbcv1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens main.projectjfxjdbcv1 to javafx.fxml;
    exports main.projectjfxjdbcv1;
}