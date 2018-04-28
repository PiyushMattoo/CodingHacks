package javafx;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import java.util.List;
import javafx.collections.ObservableList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import java.net.URL;
import javafx.fxml.Initializable;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.util.Arrays;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.DefaultStringConverter;

/**
 * Controls the main application screen
 */
public class MainController implements Initializable {

    @FXML
    TableView<BeanObject> tableView;
    @FXML 
    private TableColumn<BeanObject, Boolean> tableColumnOne;
    @FXML 
    private TableColumn<BeanObject, Boolean> tableColumnTwo;
    @FXML 
    private TableColumn<BeanObject, Boolean> tableColumnThree;
    @FXML 
    private TableColumn<BeanObject, String> tableColumnOutLocation;
    
    ObservableList<BeanObject> data;
    ObservableList<String> outLocationValues;
    
    List<BeanObject> beanObjectItem;
    
    public void populateTable() {
            BeanObject beanObject = new BeanObject(false, false, false);
            beanObjectItem.add(beanObject);
            List<String> outLocationList = Arrays.asList("sup1", "sup2", "sup3");
    }
    
    
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        outLocationValues = FXCollections.observableArrayList(); 
        
        tableColumnOne.setEditable(true);
        tableColumnTwo.setEditable(true);
        tableColumnOutLocation.setEditable(true);
        tableView.setEditable(true);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        
        Platform.runLater(new Runnable() {
             @Override
             public void run() {
                 tableColumnOne.setCellValueFactory(
                         new PropertyValueFactory<BeanObject, Boolean>("one")
                 );
                 
                 tableColumnTwo.setCellValueFactory(
                         new PropertyValueFactory<BeanObject, Boolean>("two")
                 );
                 
                 tableColumnTwo.setCellValueFactory(
                         new PropertyValueFactory<BeanObject, Boolean>("three")
                 );
                 
                 
                 tableColumnOutLocation.setCellValueFactory(new PropertyValueFactory<BeanObject, String>("name"));
                 tableColumnOutLocation.setCellFactory(ComboBoxTableCell.forTableColumn(outLocationValues)); 
                 
                 
                 tableView.setItems(data);
                 
             }
         });
        
    }
    
    
    }
