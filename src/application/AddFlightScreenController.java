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

public class AddFlightScreenController {
	@FXML
	private TextField AirlineInput;

	@FXML
	private TextField DepLocInput;

	@FXML
	private TextField DesLocInput;

	@FXML
	private TextField PriceInput;

	@FXML
	private Button confirmBtn;

	@FXML
	private Button cancelBtn;

	@FXML
	void cancelAddFlight(ActionEvent event) {
		VBox root;
		try {
			root = (VBox)FXMLLoader.load(getClass().getResource("ProductList.fxml"));
			Scene scene = cancelBtn.getScene();
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
	void confirmAddFlight(ActionEvent event) {


		if(AirlineInput.getText().isEmpty() || DepLocInput.getText().isEmpty() || DesLocInput.getText().isEmpty() || PriceInput.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING, "Please fill in all empty fields to add Flight", ButtonType.OK);
			alert.showAndWait();
		}else {
			VBox root;
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductList.fxml"));
				root = (VBox)loader.load();
				
				ProductScreenController pSController = loader.getController();
				
				Product p = new Flight(AirlineInput.getText(),DepLocInput.getText(),DesLocInput.getText(), Double.parseDouble(PriceInput.getText()));
				pSController.addProduct(p);
				
				Scene scene = confirmBtn.getScene();
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

}
