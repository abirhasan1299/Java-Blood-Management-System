module com.mycompany.blood_management_system {
    
    exports com.mycompany.blood_management_system;
    exports com.mycompany.blood_management_system.query;
    exports com.mycompany.blood_management_system.model;
    
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
 

    opens com.mycompany.blood_management_system to javafx.fxml;
    
    
}
