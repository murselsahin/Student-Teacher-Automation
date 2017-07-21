package com.db;

public class Ogrenciler {
	int ogrenci_id;
	String adi_soyadi;
	public int getOgrenci_id() {
		return ogrenci_id;
	}
	public void setOgrenci_id(int ogrenci_id) {
		this.ogrenci_id = ogrenci_id;
	}
	public String getAdi_soyadi() {
		return adi_soyadi;
	}
	public void setAdi_soyadi(String adi_soyadi) {
		this.adi_soyadi = adi_soyadi;
	}
	public void setAdi_soyadi(String adi,String soyadi)
	{
		this.adi_soyadi=adi+" "+soyadi;
	}

}
