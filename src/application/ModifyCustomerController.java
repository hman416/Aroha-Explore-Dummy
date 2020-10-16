package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ModifyCustomerController {

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
	
	private Customer customer; 

	public void setCustomer(Customer c) {
		nameInput.setText(c.getName());
		emailInput.setText(c.getEmail());
		contactNumInput.setText(c.getContact());
		cCNumInput.setText(c.getCCNum());
		addressInput.setText(c.getAddress());
		customer = c;
	}

	@FXML
	void cancelModifyCustomer(ActionEvent event) {
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
	void confirmModifyCustomer(ActionEvent event) {

		if(nameInput.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING, "Customer name cannot be blank. \nPlease fill in  customer name", ButtonType.OK);
			alert.showAndWait();
		}else {
			//customer.modifyCustomer(nameInput.getText(), emailInput.getText(), contactNumInput.getText(), cCNumInput.getText(), addressInput.getText());
			customer.modifyCustomer(nameInput.getText(), emailInput.getText(), contactNumInput.getText(), cCNumInput.getText(),addressInput.getText());			
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
	}

}
