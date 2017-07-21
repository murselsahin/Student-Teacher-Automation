package com.db;

public class Ogretmenler {
	int ogretmen_id;
	String adi_soyadi;
	public int getOgretmen_id() {
		return ogretmen_id;
	}
	public void setOgretmen_id(int ogretmen_id) {
		this.ogretmen_id = ogretmen_id;
	}
	public String getAdi_soyadi() {
		return adi_soyadi;
	}
	public void setAdi_soyadi(String adi,String soyadi) {
		this.adi_soyadi = adi+" "+soyadi;
	}
	

}
