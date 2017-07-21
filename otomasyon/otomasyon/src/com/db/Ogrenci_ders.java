package com.db;

public class Ogrenci_ders {
	
	String adi_soyadi;
	String vize;
	String finnal;
	int ogrenci_ders_id;
	String ortalama="-";
	String harf="-";
	int ders_id;
	String ders_adi;
	String ogrenci_no;
	
	
	
	public String getDers_adi() {
		return ders_adi;
	}


	public void setDers_adi(String ders_adi) {
		this.ders_adi = ders_adi;
	}


	public int getDers_id() {
		return ders_id;
	}


	public void setDers_id(int ders_id) {
		this.ders_id = ders_id;
	}


	public void setHarf(int vize,int finnal,int[] skala)
	{
		if(vize==-1 || finnal==-1)
			return;
		
		if(skala[0]==0)
		{
			skala = new int[8];
			skala[0]=90;
			skala[1]=80;
			skala[2]=70;
			skala[3]=65;
			skala[4]=60;
			skala[5]=55;
			skala[6]=50;
			skala[7]=40;
		}
			
		double dortalama=(vize*0.4+finnal*0.6)+0.5;
		int ortalama=(int)dortalama;
		String[] harfler={"AA","BA","BB","CB","CC","DC","DD","FD"};
		for(int i=0;i<8;i++)
			if(ortalama>=skala[i])
			{
				this.harf=harfler[i];
				return;
			}
		this.harf="FF";
		
	
		
		
	}
	
	
	public String getHarf() {
		return harf;
	}
	public void setHarf(String harf) {
		this.harf = harf;
	}
	public String getOrtalama() {
		return ortalama;
	}
	public void setOrtalama(String ortalama) {
		this.ortalama = ortalama;
	}
	public void setOrtalama(int vize,int finnal)
	{
		if(vize==-1 || finnal==-1)
			return;
		
		double dortalama=(vize*0.4+finnal*0.6)+0.5;
		int iortalama=(int)dortalama;
		this.ortalama=iortalama+"";
	}
	public String getAdi_soyadi() {
		return adi_soyadi;
	}
	public void setAdi_soyadi(String adi_soyadi) {
		this.adi_soyadi = adi_soyadi;
	}
	public String getVize() {
		return vize;
	}
	public void setVize(int vize) {
		if(vize==-1)
			this.vize="Not Girilmedi";
		else
			this.vize = vize+"";
	}
	public String getFinnal() {
		return finnal;
	}
	public void setFinnal(int finnal) {
		if(finnal==-1)
			this.finnal="Not Girilmedi";
		else
			this.finnal = finnal+"";
	}
	
	public int getOgrenci_ders_id() {
		return ogrenci_ders_id;
	}
	public void setOgrenci_ders_id(int ogrenci_ders_id) {
		this.ogrenci_ders_id = ogrenci_ders_id;
	}


	public String getOgrenci_no() {
		return ogrenci_no;
	}


	public void setOgrenci_no(String ogrenci_no) {
		this.ogrenci_no = ogrenci_no;
	}
	
	

}
