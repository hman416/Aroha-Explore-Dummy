package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AddSaleScreenController {

	 @FXML
	    private TextField productInput;

	    @FXML
	    private TextField customerInput;

	    @FXML
	    private TextField employeeInput;

	    @FXML
	    private TextField dateInput;

	    @FXML
	    private Button ConfirmBtn;

	    @FXML
	    private Button CancelBtn;

    @FXML
    void cancelAddSale(ActionEvent event) {
    	VBox root;
		try {
			root = (VBox)FXMLLoader.load(getClass().getResource("SalesScreen.fxml"));
			Scene scene = CancelBtn.getScene();
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
    void confirmAddSale(ActionEvent event) {
    	VBox root;
		try {
			
			Sale sale = new Sale(productInput.getText(), customerInput.getText(), employeeInput.getText(), dateInput.getText());		
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SalesScreen.fxml"));
			root = (VBox)loader.load();
			
			//get SalesScreenController object
			SalesScreenController sSController  = loader.getController();
			sSController.setSale(sale);
			
			
			Scene scene = ConfirmBtn.getScene();
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
