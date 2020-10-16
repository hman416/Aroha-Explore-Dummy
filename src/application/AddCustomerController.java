package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AddCustomerController {

	@FXML
	private TextField nameInput;

	@FXML
	private TextField emailInput;

	@FXML
	private TextField contactNumInput;

	@FXML
	private TextField cCNumInput;

	@FXML
	private TextField addressInput;

	@FXML
	private Button confirmBtn;

	@FXML
	private Button cancelBtn;

	@FXML
	void cancelAddCustomer(ActionEvent event) {
		VBox root;
		try {
			root = (VBox)FXMLLoader.load(getClass().getResource("CustomerScreen.fxml"));

			Scene scene = confirmBtn.getScene();
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
	void confirmAddCustomer(ActionEvent event) {
		VBox root;
		try {

			if (nameInput.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING, "Customer name cannot be blank. \nPlease fill in  customer name", ButtonType.OK);
				alert.showAndWait();
				
			}else {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerScreen.fxml"));
				root = (VBox)loader.load();
				CustomerScreenController cSController = loader.getController();
				
				Customer c = new Customer(nameInput.getText(), emailInput.getText(), contactNumInput.getText(), cCNumInput.getText(),addressInput.getText());
				cSController.addCustomer(c);

				Scene scene = confirmBtn.getScene();
				scene.setRoot(root);

				Window window = scene.getWindow();
				Stage stage = (Stage)window;
				stage.setHeight(350);
				stage.setWidth(400);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
