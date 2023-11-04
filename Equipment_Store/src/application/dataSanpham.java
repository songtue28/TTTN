package application;

import java.sql.Date;

public class dataSanpham {

	private Integer id;
	private String maSanPham;
	private String tenSanPham;
	private String loaiSanPham;
	private String nhaCungCap;
	private Integer soLuong;
	private Double gia;
	private String donViTinh;
	private Date ngayNhap;
	private String image;

	public dataSanpham(Integer id,String maSanPham,String tenSanPham, String loaiSanPham, String nhaCungCap, Integer soLuong, Double gia,String donViTinh,Date ngayNhap,String image ) {
		this.id = id;
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.loaiSanPham = loaiSanPham;
		this.nhaCungCap = nhaCungCap;
		this.soLuong = soLuong;
		this.gia = gia;
		this.donViTinh = donViTinh;
		this.ngayNhap = ngayNhap;
		this.image = image;
	}
	
	public dataSanpham(Integer id,String maSanPham,String tenSanPham, Integer soLuong, Double gia, String image, Date ngay) {
		this.id = id;
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.soLuong = soLuong;
		this.gia = gia;
		this.image = image;
		this.ngayNhap = ngay;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(String loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Double getGia() {
		return gia;
	}

	public void setGia(Double gia) {
		this.gia = gia;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
