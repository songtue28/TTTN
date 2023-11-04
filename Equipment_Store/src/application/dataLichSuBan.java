package application;

import java.util.Date;

public class dataLichSuBan {

	private Integer id;
	private Integer maDon;
	private Double tongTien;
	private Date ngay;
	private String nguoiBan;

	public dataLichSuBan(Integer id, Integer maDon, Double tongTien, Date ngay, String nguoiBan) {
		this.id = id;
		this.maDon = maDon;
		this.tongTien = tongTien;
		this.ngay = ngay;
		this.nguoiBan = nguoiBan;
	}

	public Integer getId() {
		return id;
	}

	public Integer getMaDon() {
		return maDon;
	}

	public Double getTongTien() {
		return tongTien;
	}

	public Date getNgay() {
		return ngay;
	}

	public String getNguoiBan() {
		return nguoiBan;
	}

}
