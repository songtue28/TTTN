package application;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class dashboardController implements Initializable {
	@FXML
	private Button banhang_bienlaibtn;

	@FXML
	private Button banhang_btn;

	@FXML
	private TableColumn<?, ?> banhang_cot_gia;

	@FXML
	private TableColumn<?, ?> banhang_cot_soluong;

	@FXML
	private TableColumn<?, ?> banhang_cot_tensp;

	@FXML
	private AnchorPane banhang_form;

	@FXML
	private GridPane banhang_girdPane;

	@FXML
	private ScrollPane banhang_scrolPane;

	@FXML
	private TextField banhang_sotien;

	@FXML
	private TableView<?> banhang_tableView;

	@FXML
	private Button banhang_thanhtoanbtn;

	@FXML
	private Label banhang_tienthoi;

	@FXML
	private Label banhang_tongtien;

	@FXML
	private Button banhang_xoabtn;

	@FXML
	private Button themncc_clearbtn;

	@FXML
	private TableColumn<dataNCC, String> themncc_cot_diachi;

	@FXML
	private TableColumn<dataNCC, String> themncc_cot_mancc;

	@FXML
	private TableColumn<dataNCC, String> themncc_cot_sdt;

	@FXML
	private TableColumn<dataNCC, String> themncc_cot_tenncc;

	@FXML
	private TextField themncc_diachi;

	@FXML
	private TextField themncc_mancc;

	@FXML
	private TextField themncc_sdt;

	@FXML
	private Button themncc_suabtn;

	@FXML
	private TableView<dataNCC> themncc_tableView;

	@FXML
	private TextField themncc_tenncc;

	@FXML
	private Button themncc_thembtn;

	@FXML
	private Button themncc_xoabtn;

	@FXML
	private Button themsp_clearbtn;

	@FXML
	private TableColumn<dataSanpham, String> themsp_cot_donvi;

	@FXML
	private TableColumn<dataSanpham, String> themsp_cot_gia;

	@FXML
	private TableColumn<dataSanpham, String> themsp_cot_loaisp;

	@FXML
	private TableColumn<dataSanpham, String> themsp_cot_masp;

	@FXML
	private TableColumn<dataSanpham, String> themsp_cot_ncc;

	@FXML
	private TableColumn<dataSanpham, String> themsp_cot_ngay;

	@FXML
	private TableColumn<dataSanpham, String> themsp_cot_soluong;

	@FXML
	private TableColumn<dataSanpham, String> themsp_cot_tensp;

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
	private TableView<dataSanpham> themsp_tableView;

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
	private Button ncc_btn;

	@FXML
	private Button lichsuban_btn;

	@FXML
	private AnchorPane trangchu_form;

	@FXML
	private AnchorPane sanpham_form;

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

	private Alert alert;

	private Image image;

	private Connection connect;
	private Statement statement;
	private PreparedStatement prepared;
	private ResultSet result;

	private ObservableList<dataSanpham> cardList = FXCollections.observableArrayList();

	public ObservableList<dataSanpham> menuGetData() {
		String sql = "SELECT * FROM sanpham";

		ObservableList<dataSanpham> listData = FXCollections.observableArrayList();
		connect = database.connectDb();

		try {
			prepared = connect.prepareStatement(sql);
			result = prepared.executeQuery();

			dataSanpham dataSp;

			while (result.next()) {
//	            	dataSanpham = new dataSanpham(result.getInt("id")
//	            			,result.getString("maSanPham")
//	            			,result.getString("tenSanPham")
//	            			,result.getString("loaiSanPham")
//	            			,result.getString("nhaCungCap")
//	            			,result.getInt("soLuong")
//	            			, result.getDouble("gia")
//	            			,result.getString("donViTinh")
//	            			, result.getDate("ngayNhap")
//	            			, result.getString("image"));
				dataSp = new dataSanpham(result.getInt("id"), result.getString("maSanPham"),
						result.getString("tenSanpham"), result.getDouble("gia"), result.getString("image"));
				listData.add(dataSp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return cardList;
	}

	public void menuDisplayCard() {

		cardList.clear();
		cardList.addAll(menuGetData());

		int row = 0;
		int column = 0;

		banhang_girdPane.getChildren().clear();
		banhang_girdPane.getRowConstraints().clear();
		banhang_girdPane.getColumnConstraints().clear();

		for (int q = 0; q < cardList.size(); q++) {

			try {
				FXMLLoader load = new FXMLLoader();
				load.setLocation(getClass().getResource("cardSanpham.fxml"));

				AnchorPane pane = load.load();
				cardSanphamController cardC = load.getController();
				cardC.setData(cardList.get(q));

				if (column == 3) {
					column = 0;
					row += 1;
				}

				banhang_girdPane.add(pane, column++, row);

				GridPane.setMargin(pane, new Insets(10));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void sp_ClearSPbtn() {
		themsp_masp.setText(null);
		themsp_tensp.setText(null);
		themsp_loaisp.getSelectionModel().clearSelection();
		themsp_ncc.getSelectionModel().clearSelection();
		themsp_soluong.setText(null);
		themsp_gia.setText(null);
		themsp_donvi.setText(null);
		themsp_imageView.setImage(null);

	}

	public void sp_SuaSPbtn() {
		if (themsp_masp.getText().isEmpty() || themsp_tensp.getText().isEmpty()
				|| themsp_loaisp.getSelectionModel().getSelectedItem() == null
				|| themsp_ncc.getSelectionModel().getSelectedItem() == null || themsp_soluong.getText().isEmpty()
				|| themsp_gia.getText().isEmpty() || themsp_donvi.getText().isEmpty() || getData.path == null) {

			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Thông báo");
			alert.setHeaderText(null);
			alert.setContentText("Vui lòng nhập đầy đủ thông tin");
			alert.showAndWait();
		} else {
			String path = getData.path;
			path = path.replace("\\", "\\\\");
			// ngay hien tai// Lấy ngày tháng hiện tại
			Calendar calendar = Calendar.getInstance();
			java.util.Date utilDate = calendar.getTime();

			// Chuyển đổi thành java.sql.Date
			Date sqlDate = new Date(utilDate.getTime());

			String sql = "UPDATE sanpham SET tenSanPham = '" + themsp_tensp.getText() + "'," + " loaiSanPham = '"
					+ themsp_loaisp.getSelectionModel().getSelectedItem() + "'," + " nhaCungCap = '"
					+ themsp_ncc.getSelectionModel().getSelectedItem() + "', soLuong = '" + themsp_soluong.getText()
					+ "', gia = '" + themsp_gia.getText() + "', donViTinh = '" + themsp_donvi.getText()
					+ "', ngayNhap = ' " + sqlDate + "', image = '" + path + "'" + " WHERE maSanPham = '"
					+ themsp_masp.getText() + "'";
			connect = database.connectDb();
			try {
				alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Thông báo");
				alert.setHeaderText(null);
				alert.setContentText("Bạn có chắc cập nhật thông tin của mã sản phẩm: " + themsp_masp.getText() + " ?");

				Optional<ButtonType> option = alert.showAndWait();

				if (option.get().equals(ButtonType.OK)) {
					statement = connect.createStatement();
					statement.executeUpdate(sql);

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Thông báo");
					alert.setHeaderText(null);
					alert.setContentText("Cập nhật thành công!");
					alert.showAndWait();

					dataSPShow();
					sp_ClearSPbtn();
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}

	public void sp_XoaSPbtn() {
		if (getData.id == null) {

			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Thông báo");
			alert.setHeaderText(null);
			alert.setContentText("Vui lòng nhập đầy đủ thông tin");
			alert.showAndWait();

		} else {
			alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Thông Báo");
			alert.setHeaderText(null);
			alert.setContentText("Bạn chắc chắn xóa sản phẩm có mã là: " + themsp_masp.getText() + "?");
			Optional<ButtonType> option = alert.showAndWait();

			if (option.get().equals(ButtonType.OK)) {
				String deleteData = "DELETE FROM sanpham WHERE id = " + getData.id;
				try {
					prepared = connect.prepareStatement(deleteData);
					prepared.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Thông báo");
					alert.setHeaderText(null);
					alert.setContentText("Xóa thành công!");
					alert.showAndWait();

					dataSPShow();
					sp_ClearSPbtn();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void sp_ThemSPbtn() {
		if (themsp_masp.getText().isEmpty() || themsp_tensp.getText().isEmpty()
				|| themsp_loaisp.getSelectionModel().getSelectedItem() == null
				|| themsp_ncc.getSelectionModel().getSelectedItem() == null || themsp_soluong.getText().isEmpty()
				|| themsp_gia.getText().isEmpty() || themsp_donvi.getText().isEmpty() || getData.path == null) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Thông báo lỗi");
			alert.setHeaderText(null);
			alert.setContentText("Vui lòng nhập đầy đủ thông tin");
			alert.showAndWait();
		} else {
			String kiemtra = "SELECT maSanPham FROM sanpham WHERE maSanPham = '" + themsp_masp.getText() + "'";

			connect = database.connectDb();
			try {

				statement = connect.createStatement();
				result = statement.executeQuery(kiemtra);

				if (result.next()) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Thông báo lỗi");
					alert.setHeaderText(null);
					alert.setContentText("Mã sản phẩm: " + themsp_masp.getText() + " đã tồn tại!");
					alert.showAndWait();
				} else {
					String sql = " INSERT  INTO sanpham "
							+ "(maSanPham, tenSanPham, loaiSanPham, nhaCungCap, soLuong, gia, donViTinh, ngayNhap, image)"
							+ "VALUES(?,?,?,?,?,?,?,?,?)";

					prepared = connect.prepareStatement(sql);
					prepared.setString(1, themsp_masp.getText());
					prepared.setString(2, themsp_tensp.getText());
					prepared.setString(3, (String) themsp_loaisp.getSelectionModel().getSelectedItem());
					prepared.setString(4, (String) themsp_ncc.getSelectionModel().getSelectedItem());
					prepared.setString(5, themsp_soluong.getText());
					prepared.setString(6, themsp_gia.getText());
					prepared.setString(7, themsp_donvi.getText());

					// ngay hien tai// Lấy ngày tháng hiện tại
					Calendar calendar = Calendar.getInstance();
					java.util.Date utilDate = calendar.getTime();

					// Chuyển đổi thành java.sql.Date
					Date sqlDate = new Date(utilDate.getTime());

					// Gán cho tham số của câu lệnh SQL
					prepared.setDate(8, sqlDate);

					String path = getData.path;
					path = path.replace("\\", "\\\\");
					prepared.setString(9, path);

					prepared.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Thông báo");
					alert.setHeaderText(null);
					alert.setContentText("Thêm sản phẩm thành công!");
					alert.showAndWait();

					dataSPShow();
					sp_ClearSPbtn();
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}

	public ObservableList<dataSanpham> dataListSP() {
		// hợp nhất dữ liệu
		ObservableList<dataSanpham> listData = FXCollections.observableArrayList();
		String sql = "SELECT * FROM sanpham";

		connect = database.connectDb();
		try {
			prepared = connect.prepareStatement(sql);
			result = prepared.executeQuery();

			dataSanpham dataSanpham;
			while (result.next()) {
				dataSanpham = new dataSanpham(result.getInt("id"), result.getString("maSanPham"),
						result.getString("tenSanPham"), result.getString("loaiSanPham"), result.getString("nhaCungCap"),
						result.getInt("soLuong"), result.getDouble("gia"), result.getString("donViTinh"),
						result.getDate("ngayNhap"), result.getString("image"));

				listData.add(dataSanpham);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listData;
	}

	//
	private ObservableList<dataSanpham> listSP;

	public void dataSPShow() {
		listSP = dataListSP();

		themsp_cot_masp.setCellValueFactory(new PropertyValueFactory<>("maSanPham"));
		themsp_cot_tensp.setCellValueFactory(new PropertyValueFactory<>("tenSanPham"));
		themsp_cot_loaisp.setCellValueFactory(new PropertyValueFactory<>("loaiSanPham"));
		themsp_cot_ncc.setCellValueFactory(new PropertyValueFactory<>("nhaCungCap"));
		themsp_cot_soluong.setCellValueFactory(new PropertyValueFactory<>("soLuong"));
		themsp_cot_gia.setCellValueFactory(new PropertyValueFactory<>("gia"));
		themsp_cot_donvi.setCellValueFactory(new PropertyValueFactory<>("donViTinh"));
		themsp_cot_ngay.setCellValueFactory(new PropertyValueFactory<>("ngayNhap"));
		themsp_tableView.setItems(listSP);

	}

	public void spSelectData() {
		dataSanpham dataSanpham = themsp_tableView.getSelectionModel().getSelectedItem();
		int num = themsp_tableView.getSelectionModel().getSelectedIndex();

		if (num - 1 < -1) {
			return;
		}
		themsp_masp.setText(dataSanpham.getMaSanPham());
		themsp_tensp.setText(dataSanpham.getTenSanPham());
		themsp_loaisp.setPromptText(dataSanpham.getLoaiSanPham());
		themsp_ncc.setPromptText(dataSanpham.getNhaCungCap());
		themsp_soluong.setText(String.valueOf(dataSanpham.getSoLuong()));
		themsp_gia.setText(String.valueOf(dataSanpham.getSoLuong()));
		themsp_donvi.setText(dataSanpham.getDonViTinh());

		getData.path = dataSanpham.getImage();
		String path = "File:" + dataSanpham.getImage();
		image = new Image(path, 120, 127, false, true);
		themsp_imageView.setImage(image);
	}

	public void taiAnhLenBtn() {

		FileChooser openFile = new FileChooser();
		openFile.getExtensionFilters().add(new ExtensionFilter("Open Image File", "*png", "*jpg"));

		File file = openFile.showOpenDialog(main_form.getScene().getWindow());

		if (file != null) {

			getData.path = file.getAbsolutePath();
			image = new Image(file.toURI().toString(), 120, 127, false, true);

			themsp_imageView.setImage(image);
		}
	}

	public void themSPListLoaiSP() {
		String[] listLoaisp = { "Thiết bị vật tư nước", "Thiết bị vật tư điện", "Thiết bị vật tư xây dựng",
				" Dụng cụ cầm tay", " Thiết bị và vật dụng khác" };
		List<String> listLoai = new ArrayList<>();

		for (String data : listLoaisp) {
			listLoai.add(data);
		}

		ObservableList listData = FXCollections.observableArrayList(listLoai);
		themsp_loaisp.setItems(listData);
	}

	public void themSPListNCC() {

		String sql = "SELECT tenNCC FROM nhacungcap";
		connect = database.connectDb();
		try { // Thực hiện truy vấn SQL
			prepared = connect.prepareStatement(sql);
			result = prepared.executeQuery();

			ObservableList listdata = FXCollections.observableArrayList();

			while (result.next()) {
				String itemString = result.getString("tenNCC");
				listdata.add(itemString);
			}
			themsp_ncc.setItems(listdata);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void nccthemncc() {
		// thêm nhà cung cấp
		String sql = "INSERT INTO nhacungcap" + "(maNCC,tenNCC, sdt, diaChi) " + "VALUES(?,?,?,?)";
		connect = database.connectDb();
		try {
			if (themncc_mancc.getText().isEmpty() || themncc_tenncc.getText().isEmpty()
					|| themncc_sdt.getText().isEmpty() || themncc_diachi.getText().isEmpty()) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Thông báo lỗi");
				alert.setHeaderText(null);
				alert.setContentText("Vui lòng nhập đầy đủ thông tin");
				alert.showAndWait();
			} else {
				String kiemtra = "SELECT maNCC FROM nhacungcap WHERE maNCC = '" + themncc_mancc.getText() + "'";

				statement = connect.createStatement();
				result = statement.executeQuery(kiemtra);
				if (result.next()) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Thông báo lỗi");
					alert.setHeaderText(null);
					alert.setContentText("Mã Nhà Cung Cấp: " + themncc_mancc.getText() + " đã tồn tại!");
					alert.showAndWait();
				} else {
					prepared = connect.prepareStatement(sql);
					prepared.setString(1, themncc_mancc.getText());
					prepared.setString(2, themncc_tenncc.getText());
					prepared.setString(3, themncc_sdt.getText());
					prepared.setString(4, themncc_diachi.getText());
					prepared.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Thông báo");
					alert.setHeaderText(null);
					alert.setContentText("Thêm Nhà Cung Cấp thành công!");
					alert.showAndWait();

					dataNCCShowList();
//					nccCLEARncc();

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void nccCapNhatncc() {
		if (themncc_mancc.getText().isEmpty() || themncc_tenncc.getText().isEmpty() || themncc_sdt.getText().isEmpty()
				|| themncc_diachi.getText().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Thông báo lỗi");
			alert.setHeaderText(null);
			alert.setContentText("Vui lòng nhập đầy đủ thông tin");
			alert.showAndWait();
		} else {

			String sql = "UPDATE nhacungcap" + " SET " + " tenNCC = '" + themncc_tenncc.getText() + "'," + " sdt = '"
					+ themncc_sdt.getText() + "'," + " diaChi = '" + themncc_diachi.getText() + "'" + " WHERE maNCC = '"
					+ themncc_mancc.getText() + "'";
			connect = database.connectDb();
			try {

//				String kiemtra = "SELECT maNCC FROM nhacungcap WHERE maNCC = '" + themncc_mancc.getText() + "'";
//
//				statement = connect.createStatement();
//				result = statement.executeQuery(kiemtra);
//				if (!result.next()) {
//					alert = new Alert(AlertType.ERROR);
//					alert.setTitle("Thông báo lỗi");
//					alert.setHeaderText(null);
//					alert.setContentText("Mã Nhà Cung Cấp: " + themncc_mancc.getText() + " không tồn tại!");
//					alert.showAndWait();
//				} else 
				{

					alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Thông báo");
					alert.setHeaderText(null);
					alert.setContentText(
							"Bạn có chắc cập nhật thông tin của mã nhà cung cấp: " + themncc_mancc.getText() + " ?");

					Optional<ButtonType> option = alert.showAndWait();

					if (option.get().equals(ButtonType.OK)) {
						statement = connect.createStatement();
						statement.executeUpdate(sql);

						alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Thông báo");
						alert.setHeaderText(null);
						alert.setContentText("Cập nhật thành công!");
						alert.showAndWait();
					} else {

					}
				}

				dataNCCShowList();
//				nccCLEARncc();

			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}

	public void nccCLEARncc() {
		// xóa các trường thông tin
		themncc_mancc.setText("");
		themncc_tenncc.setText(null);
		themncc_sdt.setText(null);
		themncc_diachi.setText(null);

	}

	public void nccXoancc() {
		if (getData.id == null) {

			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Thông báo");
			alert.setHeaderText(null);
			alert.setContentText("Vui lòng nhập đầy đủ thông tin");
			alert.showAndWait();

		} else {
			alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Thông Báo");
			alert.setHeaderText(null);
			alert.setContentText("Bạn chắc chắn xóa nhà cung cấp có mã là: " + themncc_mancc.getText() + "?");
			Optional<ButtonType> option = alert.showAndWait();

			if (option.get().equals(ButtonType.OK)) {
				String deleteData = "DELETE FROM nhacungcap WHERE id = " + getData.id;
				try {
					prepared = connect.prepareStatement(deleteData);
					prepared.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Thông báo");
					alert.setHeaderText(null);
					alert.setContentText("Xóa thành công!");
					alert.showAndWait();

					dataNCCShowList();
					nccCLEARncc();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public ObservableList<dataNCC> dataListNCC() {
		// hợp nhất dữ liệu
		ObservableList<dataNCC> listData = FXCollections.observableArrayList();
		String sql = "SELECT * FROM nhacungcap";

		connect = database.connectDb();
		try {
			prepared = connect.prepareStatement(sql);
			result = prepared.executeQuery();

			dataNCC dataNCC;
			while (result.next()) {
				dataNCC = new dataNCC(result.getString("maNCC"), result.getString("tenNCC"), result.getString("sdt"),
						result.getString("diaChi"), result.getInt("id"));
				listData.add(dataNCC);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listData;
	}

	private ObservableList<dataNCC> listNCC;

	public void dataNCCShowList() {
		// show data từ sql lên bảng
		listNCC = dataListNCC();
		themncc_cot_sdt.setCellValueFactory(new PropertyValueFactory<>("sdt"));
		themncc_cot_diachi.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
		themncc_cot_mancc.setCellValueFactory(new PropertyValueFactory<>("maNCC"));
		themncc_cot_tenncc.setCellValueFactory(new PropertyValueFactory<>("tenNCC"));

		themncc_tableView.setItems(listNCC);

	}

	public void nccSelectData() {
		// chọn hàng trong bảng
		dataNCC dataNCC = themncc_tableView.getSelectionModel().getSelectedItem();
		int num = themncc_tableView.getSelectionModel().getSelectedIndex();

		if (num - 1 < -1) {
			return;
		}
		themncc_mancc.setText(dataNCC.getMaNCC());
		themncc_tenncc.setText(dataNCC.getTenNCC());
		themncc_sdt.setText(dataNCC.getSdt());
		themncc_diachi.setText(dataNCC.getDiaChi());

		getData.id = dataNCC.getId();

	}

	public void switchForm(ActionEvent event) {
		// chuyển đổi các giao diện
		if (event.getSource() == trangchu_btn) {
			trangchu_form.setVisible(true);
			sanpham_form.setVisible(false);
			banhang_form.setVisible(false);
			ncc_form.setVisible(false);
			lichsuban_form.setVisible(false);

			trangchu_btn.setStyle(" -fx-background-color:linear-gradient(to bottom right, #272b3f, #125e7c)");
			sanpham_btn.setStyle("-fx-brackground-color: transparent");
			banhang_btn.setStyle("-fx-brackground-color: transparent");
			ncc_btn.setStyle("-fx-brackground-color: transparent");
			lichsuban_btn.setStyle("-fx-brackground-color: transparent");
		} else if (event.getSource() == sanpham_btn) {
			sanpham_form.setVisible(true);
			trangchu_form.setVisible(false);
			banhang_form.setVisible(false);
			ncc_form.setVisible(false);
			lichsuban_form.setVisible(false);

			sanpham_btn.setStyle(" -fx-background-color:linear-gradient(to bottom right, #272b3f, #125e7c)");
			trangchu_btn.setStyle("-fx-brackground-color: transparent");
			banhang_btn.setStyle("-fx-brackground-color: transparent");
			lichsuban_btn.setStyle("-fx-brackground-color: transparent");
			ncc_btn.setStyle("-fx-brackground-color: transparent");

		} else if (event.getSource() == banhang_btn) {
			banhang_form.setVisible(true);
			trangchu_form.setVisible(false);
			sanpham_form.setVisible(false);
			ncc_form.setVisible(false);
			lichsuban_form.setVisible(false);

			banhang_btn.setStyle(" -fx-background-color:linear-gradient(to bottom right, #272b3f, #125e7c)");
			trangchu_btn.setStyle("-fx-brackground-color: transparent");
			sanpham_btn.setStyle("-fx-brackground-color: transparent");
			ncc_btn.setStyle("-fx-brackground-color: transparent");
			lichsuban_btn.setStyle("-fx-brackground-color: transparent");

			menuDisplayCard();

		} else if (event.getSource() == ncc_btn) {
			ncc_form.setVisible(true);
			trangchu_form.setVisible(false);
			sanpham_form.setVisible(false);
			banhang_form.setVisible(false);
			lichsuban_form.setVisible(false);

			ncc_btn.setStyle(" -fx-background-color:linear-gradient(to bottom right, #272b3f, #125e7c)");
			trangchu_btn.setStyle("-fx-brackground-color: transparent");
			sanpham_btn.setStyle("-fx-brackground-color: transparent");
			banhang_btn.setStyle("-fx-brackground-color: transparent");
			lichsuban_btn.setStyle("-fx-brackground-color: transparent");
		} else if (event.getSource() == lichsuban_btn) {
			lichsuban_form.setVisible(true);
			trangchu_form.setVisible(false);
			sanpham_form.setVisible(false);
			banhang_form.setVisible(false);
			ncc_form.setVisible(false);

			lichsuban_btn.setStyle(" -fx-background-color:linear-gradient(to bottom right, #272b3f, #125e7c)");
			trangchu_btn.setStyle("-fx-brackground-color: transparent");
			sanpham_btn.setStyle("-fx-brackground-color: transparent");
			banhang_btn.setStyle("-fx-brackground-color: transparent");
			ncc_btn.setStyle("-fx-brackground-color: transparent");

		}
	}

	public void displayusername() {

//		username.setText(getData.username);

		String user = getData.username;
		user = user.substring(0, 1).toUpperCase() + user.substring(1);
		username.setText(user);
	}

	public void defaultNav() {
		trangchu_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #272b3f, #125e7c)");
		trangchu_form.setVisible(true);
		sanpham_form.setVisible(false);
		banhang_form.setVisible(false);
		ncc_form.setVisible(false);
		lichsuban_form.setVisible(false);
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
		displayusername();
		defaultNav();

		dataNCCShowList();
		spSelectData();
		dataSPShow();
		themSPListNCC();
		themSPListLoaiSP();

		menuDisplayCard();
	}

}
