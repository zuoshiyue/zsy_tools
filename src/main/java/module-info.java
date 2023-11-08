module com.zsy.tool.zsy_tools {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zsy.tool.zsy_tools to javafx.fxml;
    exports com.zsy.tool.zsy_tools;
}