package application;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SalesScreenController {

    @FXML
    private Button HomeBtn;

    @FXML
    private Button addBtn;

    @FXML
    private Button deleteBtn;
    
    @FXML
    private ListView<Sale> listOfSales;
    
    
   private static ObservableList<Sale> items = FXCollections.observableArrayList (new Sale("Sale1", "Jamie", "Jackson", "12/2/2020"),
		   new Sale("Sale2", "Barbara", "Stacy", "8/5/2020"), new Sale("Sale3", "Jamie", "Hailey", "9/2/2020"));
    
    @FXML
	public void initialize() {	
    	listOfSales.setItems(SalesScreenController.items);
	}
    
    public void setSale(Sale sale) {
    	listOfSales.getItems().add(sale);
    }

    @FXML
    void addSalesScreen(ActionEvent event) {
    	VBox root;
		try {
			root = (VBox)FXMLLoader.load(getClass().getResource("AddSaleScreen.fxml"));
			Scene scene = addBtn.getScene();
			scene.setRoot(root);
			
			Window window = scene.getWindow();
			Stage stage = (Stage)window;
			stage.setHeight(450);
			stage.setWidth(400);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void deleteSalesBtn(ActionEvent event) {
    	Sale saleSelected = listOfSales.getSelectionModel().getSelectedItem();	
    	
    	if (saleSelected!=null) {
			Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to delete this sale?", ButtonType.YES, ButtonType.NO);
			alert.setTitle("Delete Sale");
			
            alert.showAndWait();
			if (alert.getResult()==ButtonType.YES) {
				items.remove(listOfSales.getSelectionModel().getSelectedItem());
			}
    	}else {
    		Alert alert = new Alert(AlertType.WARNING, "Please first select a sale", ButtonType.OK);
    		alert.showAndWait();
    	}
			
    }

    @FXML
    void returnHome(ActionEvent event) {
    	BorderPane root;
		try {
			root = (BorderPane)FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
			Scene scene = HomeBtn.getScene();
			scene.setRoot(root);
	    	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
