package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class cardSanphamController implements Initializable {

	@FXML
    private AnchorPane card_form;

    @FXML
    private Label giasp;

    @FXML
    private ImageView imageView;

    @FXML
    private Spinner<Integer> spinner;

    @FXML
    private Label tensp;

    @FXML
    private Button thembtn;
    
    dataSanpham dataSp;

	private Image image;
	private SpinnerValueFactory<Integer> spin;

	private String masanpham;
	private String imagesp;
//    private java.sql.Date ngay;
	private String loaisp;
	private double gia;
	private double tongTien;

	private Connection connect;
	private Statement statement;
	private PreparedStatement prepared;
	private ResultSet result;

	Alert alert;

	public void setData(dataSanpham dataSp) {
		this.dataSp = dataSp;

		masanpham = dataSp.getMaSanPham();
		imagesp = dataSp.getImage();
//		ngay = dataSp.getNgayNhap();
		loaisp = dataSp.getLoaiSanPham();
		gia = dataSp.getGia();

		tensp.setText(dataSp.getTenSanPham());
		giasp.setText(String.valueOf(dataSp.getGia() + "VND"));

		String path = "File:" + dataSp.getImage();
		image = new Image(path, 210, 90, false, true);
		imageView.setImage(image);
	}

	private int soluong;

	public void setSoLuong() {
		spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
		spinner.setValueFactory(spin);
	}

	public void themBtn() {

		dashboardController dashboardController = new dashboardController();
		dashboardController.customerID();
		soluong = spinner.getValue();
		connect = database.connectDb();

		try {
			int checkStck = 0;
			String checkStock = "SELECT soLuong FROM sanpham WHERE maSanPham = '" + masanpham + "'";

			prepared = connect.prepareStatement(checkStock);
			result = prepared.executeQuery();

			if (result.next()) {
				checkStck = result.getInt("soLuong");
			}
			if (checkStck == 0) {

				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Thông Báo!");
				alert.setHeaderText(null);
				alert.setContentText("Hết hàng!");
				alert.showAndWait();

			} else {

				if (checkStck < soluong) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Thông Báo!");
					alert.setHeaderText(null);
					alert.setContentText("Số Lượng hàng không đủ");
					alert.showAndWait();
				} else {
				imagesp = imagesp.replace("\\", "\\\\");

					String insertData = "INSERT INTO chitietbanhang "
							+ "(maDon ,  tenSanPham, soLuong, gia, ngay, nguoiBan,masanpham,image) " + "VALUES(?,?,?,?,?,?,?,?)";
					prepared = connect.prepareStatement(insertData);
					prepared.setString(1, String.valueOf(getData.cID));
//                prepared.setString(2, masp);
					prepared.setString(2, tensp.getText());
//                prepared.setString(4, loaisp);
					prepared.setString(3, String.valueOf(soluong));

					tongTien = (soluong * gia);
					prepared.setString(4, String.valueOf(tongTien));

					Date date = new Date();
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					prepared.setString(5, String.valueOf(sqlDate));

                prepared.setString(8, imagesp);
					prepared.setString(6, getData.username);
					prepared.setString(7, masanpham);

					prepared.executeUpdate();

					int capnhatSoluong = checkStck - soluong;

					String updateStock = "UPDATE sanpham SET  soLuong = '" + capnhatSoluong + "' WHERE maSanPham = '"
							+ masanpham + "'";

					prepared = connect.prepareStatement(updateStock);
					prepared.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Thông báo");
					alert.setHeaderText(null);
					alert.setContentText("Thêm thành công");
					alert.showAndWait();
					dashboardController.displayThanhtien();
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		setSoLuong();

	}

}