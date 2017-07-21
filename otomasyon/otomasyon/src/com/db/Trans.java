package com.db;

public class Trans {
	String ders_adi;
	int kredi;
	double puan;
	String harf;
	String spuan;
	public String getDers_adi() {
		return ders_adi;
	}
	public void setDers_adi(String ders_adi) {
		this.ders_adi = ders_adi;
	}
	public int getKredi() {
		return kredi;
	}
	public void setKredi(int kredi) {
		this.kredi = kredi;
	}
	public double getPuan() {
		return puan;
	}
	public void setPuan(double puan) {
		this.puan = puan;
	}
	public String getHarf() {
		return harf;
	}
	public void setHarf(String harf) {
		this.harf = harf;
	}
	public String getSpuan() {
		return spuan;
	}
	public void setSpuan(String spuan) {
		this.spuan = spuan;
	}
	public void setSpuan(double puan)
	{
		if(puan==-1)
			this.spuan="-";
		else
			this.spuan=puan+"";
	}
	

}
