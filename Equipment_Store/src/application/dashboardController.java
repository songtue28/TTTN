package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class dashboardController implements Initializable {

	@FXML
    private Button themsp_clearbtn;

    @FXML
    private TableColumn<?, ?> themsp_cot_donvi;

    @FXML
    private TableColumn<?, ?> themsp_cot_gia;

    @FXML
    private TableColumn<?, ?> themsp_cot_loaisp;

    @FXML
    private TableColumn<?, ?> themsp_cot_masp;

    @FXML
    private TableColumn<?, ?> themsp_cot_ncc;

    @FXML
    private TableColumn<?, ?> themsp_cot_ngay;

    @FXML
    private TableColumn<?, ?> themsp_cot_soluong;

    @FXML
    private TableColumn<?, ?> themsp_cot_tensp;

    @FXML
    private TextField themsp_donvi;

    @FXML
    private TextField themsp_gia;

    @FXML
    private ImageView themsp_imageView;

    @FXML
    private ComboBox<?> themsp_loaisp;

    @FXML
    private TextField themsp_masp;

    @FXML
    private ComboBox<?> themsp_ncc;

    @FXML
    private TextField themsp_soluong;

    @FXML
    private Button themsp_suabtn;

    @FXML
    private TableView<?> themsp_tableView;

    @FXML
    private Button themsp_tailenbtn;

    @FXML
    private TextField themsp_tensp;

    @FXML
    private Button themsp_thembtn;

    @FXML
    private Button themsp_xoabtn;

	@FXML
	private Button trangchu_btn;

	@FXML
	private Button sanpham_btn;

	@FXML
	private Button banhang_btn;

	@FXML
	private Button ncc_btn;

	@FXML
	private Button lichsuban_btn;

	@FXML
	private AnchorPane trangchu_form;

	@FXML
	private AnchorPane sanpham_form;

	@FXML
	private AnchorPane banhang_form;

	@FXML
	private AnchorPane ncc_form;

	@FXML
	private AnchorPane lichsuban_form;

	@FXML
	private Button logout;

	@FXML
	private AnchorPane main_form;

	@FXML
	private Button minimize;

	@FXML
	private Button close;

	@FXML
	private Label username;

	public void switchForm(ActionEvent event) {
		if (event.getSource() == trangchu_btn) {
			trangchu_form.setVisible(true);
			sanpham_form.setVisible(false);
			banhang_form.setVisible(false);
			ncc_form.setVisible(false);
			lichsuban_form.setVisible(false);
		}
		else if (event.getSource() == sanpham_btn) {
			sanpham_form.setVisible(true);
			trangchu_form.setVisible(false);
			banhang_form.setVisible(false);
			ncc_form.setVisible(false);
			lichsuban_form.setVisible(false);
		}
		else if (event.getSource() == banhang_btn) {
			banhang_form.setVisible(true);
			trangchu_form.setVisible(false);
			sanpham_form.setVisible(false);
			ncc_form.setVisible(false);
			lichsuban_form.setVisible(false);
		}
		else if (event.getSource() == ncc_btn) {
			ncc_form.setVisible(true);
			trangchu_form.setVisible(false);
			sanpham_form.setVisible(false);
			banhang_form.setVisible(false);
			lichsuban_form.setVisible(false);
		}
		else if (event.getSource() == lichsuban_btn) {
			lichsuban_form.setVisible(true);
			trangchu_form.setVisible(false);
			sanpham_form.setVisible(false);
			banhang_form.setVisible(false);
			ncc_form.setVisible(false);
		}
	}

	private double x = 0;
	private double y = 0;

	public void logout() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("comfirmation message");
		alert.setHeaderText(null);
		alert.setContentText("bạn có chắc chắn muốn đăng xuất không");
		Optional<ButtonType> optional = alert.showAndWait();
		try {
			if (optional.get().equals(ButtonType.OK)) {

				logout.getScene().getWindow().hide();

				Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
				Stage stage = new Stage();
				Scene scene = new Scene(root);

				root.setOnMousePressed((MouseEvent event) -> {
					x = event.getSceneX();
					y = event.getSceneY();
				});

				root.setOnMouseDragged((MouseEvent event) -> {
					stage.setX(event.getSceneX() - x);
					stage.setY(event.getSceneY() - y);

					stage.setOpacity(0.8);
				});

				root.setOnMouseReleased((MouseEvent event) -> {
					stage.setOpacity(1);
				});

				stage.initStyle(StageStyle.TRANSPARENT);///

				stage.setScene(scene);
				stage.show();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void minimize() {
		Stage stage = (Stage) main_form.getScene().getWindow();
		stage.setIconified(true);

	}

	public void close() {
		System.exit(0);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
