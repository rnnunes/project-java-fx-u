module main.projectjfxjdbcv1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens main.projectjfxjdbcv1 to javafx.fxml;
    exports main.projectjfxjdbcv1;
}