package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AddHotelDealController {

	@FXML
	private TextField HotelNameInput;

	@FXML
	private TextField DurationInput;

	@FXML
	private TextField PriceInput;

	@FXML
	private Button ConfirmBtn;

	@FXML
	private Button CancelBtn;

	@FXML
	void cancelAdd(ActionEvent event) {
		VBox root;
		try {
			root = (VBox)FXMLLoader.load(getClass().getResource("ProductList.fxml"));
			Scene scene = ConfirmBtn.getScene();
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
	void confirmAddHD(ActionEvent event) {

		if(HotelNameInput.getText().isEmpty() || DurationInput.getText().isEmpty() || PriceInput.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING, "Please fill in all empty fields to add Hotel Deal", ButtonType.OK);
			alert.showAndWait();
		}else {

			VBox root;
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductList.fxml"));
				root = (VBox)loader.load();
				
				ProductScreenController pSController = loader.getController();
				
				Product p = new HotelDeal(HotelNameInput.getText(),DurationInput.getText(),Double.parseDouble(PriceInput.getText()));
				pSController.addProduct(p);
				
				Scene scene = CancelBtn.getScene();
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
