module main.projectjfxjdbcv1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens main.projectjfxjdbcv1 to javafx.fxml;
    exports main.projectjfxjdbcv1;
    exports main.projectjfxjdbcv1.DB;
    opens main.projectjfxjdbcv1.DB to javafx.fxml;
    exports main.projectjfxjdbcv1.dao;
    opens main.projectjfxjdbcv1.dao to javafx.fxml;
    exports main.projectjfxjdbcv1.impl;
    opens main.projectjfxjdbcv1.impl to javafx.fxml;
    exports main.projectjfxjdbcv1.util;
    opens main.projectjfxjdbcv1.util to javafx.fxml;
}