package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ProductScreenController {

    @FXML
    private Button addFlightBtn;

    @FXML
    private Button addHDBtn;

    @FXML
    private Button homeBtn;
    
    @FXML
    private ListView<Product> listOfProducts;
    
    private static ObservableList<Product> items = FXCollections.observableArrayList ();
    
    @FXML
	public void initialize() {	
    	listOfProducts.setItems(ProductScreenController.items);
	}
    
    public void addProduct(Product p){
    	items.add(p);
    }

    @FXML
    void addFlightScreen(ActionEvent event) {
    	VBox root;
		try {
			root = (VBox)FXMLLoader.load(getClass().getResource("AddFlightScreen.fxml"));
			Scene scene = addFlightBtn.getScene();
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
    void addHotelDealScreen(ActionEvent event) {
    	VBox root;
		try {
			root = (VBox)FXMLLoader.load(getClass().getResource("AddHotelDeal.fxml"));
			Scene scene = addHDBtn.getScene();
			scene.setRoot(root);
			
			Window window = scene.getWindow();
			Stage stage = (Stage)window;
			stage.setHeight(350);
			stage.setWidth(400);
	    	
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void returnHome(ActionEvent event) {
    	BorderPane root;
		try {
			root = (BorderPane)FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
			Scene scene = homeBtn.getScene();
	    	scene.setRoot(root);
	    	
	    	Window window = scene.getWindow();
			Stage stage = (Stage)window;
			stage.setHeight(350);
			stage.setWidth(400);
				    	
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}


