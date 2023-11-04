package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class changpassController implements Initializable {

	@FXML
	private Button close;

	@FXML
	private Button luuBtn;

	@FXML
	private PasswordField newpass;

	@FXML
	private PasswordField password;

	@FXML
	private PasswordField renewpass;

	@FXML
	private TextField username;

	Alert alert;

	private Connection connect;
	private Statement statement;
	private PreparedStatement prepared;
	private ResultSet result;
	
	public void close() {
		close.getScene().getWindow().hide();
	}

	public void displayuser() {
		String user = getData.username;
		username.setText(user);
		username.setEditable(false);
	}

	public void luubtn() {
		if (password.getText().isEmpty() || newpass.getText().isEmpty() || renewpass.getText().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Thông báo");
			alert.setHeaderText(null);
			alert.setContentText("Vui lòng điền đủ thông tin");
			alert.showAndWait();
		} else {

			String getpass = "SELECT password FROM admin WHERE username = '" + username.getText() + "'";
			connect = database.connectDb();

			try {
				prepared = connect.prepareStatement(getpass);

				result = prepared.executeQuery();

				String pass = "";
				if (result.next()) {
					pass = result.getString("password");
				}
				if (pass.equals(password.getText())) {
					if (newpass.getText().equals(renewpass.getText())) {

						String updatePass = "UPDATE admin SET password = '" + newpass.getText() + "' WHERE username = '"
								+ username.getText() + "'";

						try {
							prepared = connect.prepareStatement(updatePass);
							prepared.executeUpdate();

							alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Thông báo");
							alert.setHeaderText(null);
							alert.setContentText("Đổi mật khẩu thành công!");
							alert.showAndWait();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else {
						alert = new Alert(AlertType.ERROR);
						alert.setTitle("Thông báo");
						alert.setHeaderText(null);
						alert.setContentText("Mật khẩu mới không trùng nhau!!!");
						alert.showAndWait();
					}
				}else {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Thông báo");
					alert.setHeaderText(null);
					alert.setContentText("Mật khẩu cũ của bạn không đúng!!!!");
					alert.showAndWait();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		displayuser();
	}

}
