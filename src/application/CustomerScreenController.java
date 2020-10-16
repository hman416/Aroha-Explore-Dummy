package application;

import java.io.IOException;

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

public class CustomerScreenController {

	@FXML
	private Button HomeBtn;

	@FXML
	private Button addBtn;

	@FXML
	private Button modifyBtn;

	@FXML
	private ListView<Customer> listOfCustomers;

	private static ObservableList<Customer> items = FXCollections.observableArrayList (
			new Customer("Peter G","PG@amail.com","021 123 1234","12321313131",""));

	@FXML
	public void initialize() {	
		listOfCustomers.setItems(CustomerScreenController.items);
	}

	public void addCustomer(Customer c) {
		listOfCustomers.getItems().add(c);
	}

	@FXML
	void addCustomerScreen(ActionEvent event) {
		VBox root;
		try {
			root = (VBox)FXMLLoader.load(getClass().getResource("AddCustomer.fxml"));
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
	void modifyCustomerBtn(ActionEvent event) {
		Customer c = listOfCustomers.getSelectionModel().getSelectedItem();
		if(c == null) {
			Alert alert = new Alert(AlertType.WARNING, "Please select a customer to modify", ButtonType.OK);
			alert.showAndWait();
		}else {

			VBox root;
			try {
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyCustomer.fxml"));
				root = (VBox)loader.load();
				
				ModifyCustomerController mCController = loader.getController();
				mCController.setCustomer(c);
				
				Scene scene = modifyBtn.getScene();
				scene.setRoot(root);

				Window window = scene.getWindow();
				Stage stage = (Stage)window;
				stage.setHeight(450);
				stage.setWidth(400);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	void returnHome(ActionEvent event) {
		BorderPane root;
		try {
			root = (BorderPane)FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
			Scene scene = HomeBtn.getScene();
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
