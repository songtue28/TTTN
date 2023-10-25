package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class loginController implements Initializable {
	@FXML
	private Button close;

	@FXML
	private Hyperlink forgotPass;

	@FXML
	private Button loginBtn;

	@FXML
	private AnchorPane main_form;

	@FXML
	private TextField username;

	@FXML
	private PasswordField password;

	// database
	private Connection connect;
	private PreparedStatement prepare;
	private ResultSet result;

	private double x = 0;
	private double y = 0;

	public void loginAdmin() {

		String sql = "SELECT * FROM admin WHERE username = ? and password = ?";

		connect = database.connectDb();

		try {

			prepare = connect.prepareStatement(sql);
			prepare.setString(1, username.getText());
			prepare.setString(2, password.getText());

			result = prepare.executeQuery();
			Alert alert;

			if (username.getText().isEmpty() || password.getText().isEmpty()) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Thông báo lỗi");
				alert.setHeaderText(null);
				alert.setContentText("Vui lòng nhập đầy đủ thông tin");

				alert.showAndWait();

			} else {
				if (result.next()) {

					getData.username = username.getText();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("information message");
					alert.setHeaderText(null);
					alert.setContentText("Đăng nhập thành công");
					alert.showAndWait();

					loginBtn.getScene().getWindow().hide();
					Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

					Stage stage = new Stage();
					Scene scene = new Scene(root);

					root.setOnMousePressed((MouseEvent event) -> {
						x = event.getSceneX();
						y = event.getSceneY();
					});

					root.setOnMouseDragged((MouseEvent event) -> {
						stage.setX(event.getSceneX() - x);
						stage.setY(event.getSceneY() - y);

					});

					stage.initStyle(StageStyle.TRANSPARENT);
					stage.setScene(scene);
					stage.show();

				} else {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("error message");
					alert.setHeaderText(null);
					alert.setContentText("Thông tin đăng nhập không đúng");
					alert.showAndWait();

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void close() {
		System.exit(0);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
