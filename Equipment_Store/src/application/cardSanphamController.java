package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
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
    private Spinner<?> spinner;

    @FXML
    private Label tensp;

    @FXML
    private Button thembtn;
    
    dataSanpham dataSp;

	private Image image;
    
    public void setData(dataSanpham dataSp) {
    	
    
		this.dataSp = dataSp;
		
		tensp.setText(dataSp.getTenSanPham());
		giasp.setText(String.valueOf(dataSp.getGia()));
		
		String path = "File:" +dataSp.getImage();
		image = new Image(path, 210, 90, false, true);
		imageView.setImage(image);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
