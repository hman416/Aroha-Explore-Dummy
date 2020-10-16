package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainScreenController {

    @FXML
    private Button ManageSales;

    @FXML
    private Button ManageCustomers;

    @FXML
    private Button ManageEmployees;

    @FXML
    private Button ManageProducts;

    @FXML
    void goToCustomerScreen(ActionEvent event) {
		try {
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("CustomerScreen.fxml"));
			
			Scene scene = ManageSales.getScene();
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
    void goToEmployeesScreen(ActionEvent event) {

    }

    @FXML
    void goToProductsScreen(ActionEvent event) {
    	try {
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("ProductList.fxml"));
			
			Scene scene = ManageProducts.getScene();
			scene.setRoot(root);
			
			Window window = scene.getWindow();
			Stage stage = (Stage)window;
			stage.setHeight(350);
			stage.setWidth(400);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void goToSalesScreen(ActionEvent event) {
		try {
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("SalesScreen.fxml"));
			
			Scene scene = ManageSales.getScene();
			scene.setRoot(root);
			
			Window window = scene.getWindow();
			Stage stage = (Stage)window;
			stage.setHeight(350);
			stage.setWidth(400);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

}
