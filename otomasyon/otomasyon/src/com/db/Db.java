package com.db;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Db {
	Connection conn;
	public Db()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:mursel2","MURSEL","123456");
			 
		}catch(Exception ex)
		{
			System.out.println(ex+"");
		}
		
	}
	
	public String[] giris_kontrol(String kullanici_adi,String sifre)
	{
		String[] parameters = new String[3];
		String parola=sifre_algoritmasi(sifre);
		try
		{
			parameters[0]="false";
			String sql="select kullanici_id,tip from kullanicilar where kullanici_adi=? AND sifre=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, kullanici_adi);
			ps.setString(2, parola);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				parameters[0]="true";
				parameters[1]=rs.getString("kullanici_id");
				parameters[2]=rs.getString("tip");
			}
			
			
			
			return parameters;
		}catch(Exception ex)
		{
			return parameters;
		}
	}
	
	public String sifre_algoritmasi(String sifre)
	{
		
		try
		{
			MessageDigest messageDigestNesnesi = MessageDigest.getInstance("MD5");
			messageDigestNesnesi.update(sifre.getBytes());
			byte messageDigestDizisi[] = messageDigestNesnesi.digest();
			StringBuffer sb32 = new StringBuffer();
			for(int i=0;i<messageDigestDizisi.length;i++)
				sb32.append(Integer.toString((messageDigestDizisi[i]& 0xff)+0x100,32));
			
			
			return sb32.toString();
			
		}catch(Exception ex)
		{
			return "";
		}
	}
	
	public List<Bolumler> list_bolum_gonder()
	{
		try
		{
			List<Bolumler> list = new ArrayList<Bolumler>();
			String sql="select bolum_id,bolum_adi from bolumler order by bolum_adi";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			;
			while(rs.next())
			{
				Bolumler b = new Bolumler();
				b.setBolum_id(rs.getInt("bolum_id"));
				b.setBolum_adi(rs.getString("bolum_adi"));
				
				list.add(b);
			}
			return list;
			
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	public boolean ders_ekle(int kredi,int bolum_id,String ders_adi)
	{
		try
		{
			String sql="insert into dersler(ders_adi,bolum_id,kredi) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ders_adi);
			ps.setInt(2, bolum_id);
			ps.setInt(3,kredi);
			int result=ps.executeUpdate();
			if(result>0)
				return true;
			else
				return false;
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return false;
		}
	}
	public List<Dersler> ders_gonder(int bolum_id)
	{
		try
		{
			List<Dersler> list=new ArrayList<Dersler>();
			String sql="select ders_id,ders_adi from dersler where bolum_id=? order by ders_adi";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,bolum_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Dersler d = new Dersler();
				d.setDers_id(rs.getInt("ders_id"));
				d.setDers_adi(rs.getString("ders_adi"));
				list.add(d);
			}
			return list;
		}catch(Exception ex)
		{
			return null;
		}
	}
	public boolean ders_update(int bolum_id,int kredi,String ders_adi,int ders_id)
	{
		try
		{
			String sql="update dersler set bolum_id=?,kredi=?,ders_adi=? where ders_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bolum_id);
			ps.setInt(2, kredi);
			ps.setString(3, ders_adi);
			ps.setInt(4, ders_id);
			int result = ps.executeUpdate();
			if(result>0)
				return true;
			else
				return false;
			
			
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return false;
		}
	}
	
	public List<Ogretmenler> list_ogretmen_gonder(int bolum_id)
	{
		try
		{
			List<Ogretmenler> list = new ArrayList<Ogretmenler>();
			String sql="select ogretmen_id,adi,soyadi from ogretmenler where bolum_id=? order by adi";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bolum_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Ogretmenler o = new Ogretmenler();
				o.setOgretmen_id(rs.getInt("ogretmen_id"));
				o.setAdi_soyadi(rs.getString("adi"), rs.getString("soyadi"));
				
				list.add(o);
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	
	public List<Dersler> list_alinmamis_ders_gonder(int bolum_id)
	{
		try
		{
			List<Dersler> list = new ArrayList<Dersler>();
			String sql="select ders_id,ders_adi from dersler d where bolum_id=? and not exists (select * from ogretmen_ders o where o.ders_id=d.ders_id)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bolum_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Dersler d = new Dersler();
				d.setDers_id(rs.getInt("ders_id"));
				d.setDers_adi(rs.getString("ders_adi"));
				list.add(d);
				
			}
			return list;
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	public boolean ogretmen_ders_tanimla(int ogretmen_id,int ders_id)
	{
		try
		{
			
			String sql="insert into ogretmen_ders(ogretmen_id,ders_id) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ogretmen_id);
			ps.setInt(2, ders_id);
			int result = ps.executeUpdate();
			if(result>0)
				return true;
			else
				return false;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return false;
		}
	}
	public List<Ogretmenler> list_tum_ogretmenleri_gonder()
	{
		try
		{
			List<Ogretmenler> list = new ArrayList<Ogretmenler>();
			String sql="select ogretmen_id,adi,soyadi from ogretmenler order by adi";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Ogretmenler o = new Ogretmenler();
				o.setOgretmen_id(rs.getInt("ogretmen_id"));
				o.setAdi_soyadi(rs.getString("adi"), rs.getString("soyadi"));
				
				list.add(o);
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	public String bolum_adi_gonder(int ogretmen_id)
	{
		try
		{
			String sql="select bolum_adi from ogretmenler o,bolumler b where o.ogretmen_id=? and o.bolum_id=b.bolum_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ogretmen_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getString("bolum_adi");
			}
			return "";
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return "";
		}
	}
	public boolean ogretmen_bolum_degistir(int ogretmen_id,int bolum_id)
	{
		try
		{
			String sql="update ogretmenler set bolum_id=? where ogretmen_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bolum_id);
			ps.setInt(2,ogretmen_id);
			int result = ps.executeUpdate();
			if(result>0)
				return  true;
			else
				return false;
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return false;
		}
	}
	
	public List<Dersler> list_aldigi_dersleri_gonder(int ogretmen_id)
	{
		try
		{
			List<Dersler> list = new ArrayList<Dersler>();
			String sql="select ders_id,ders_adi from dersler d where  EXISTS (select * from ogretmen_ders o where o.ogretmen_id=? and o.ders_id=d.ders_id)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,ogretmen_id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Dersler d = new Dersler();
				d.setDers_adi(rs.getString("ders_adi"));
				d.setDers_id(rs.getInt("ders_id"));
				list.add(d);
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	
	public boolean ders_cikar(int ogretmen_id,int ders_id)
	{
		try
		{
			String sql = "delete from ogretmen_ders where ogretmen_id=? AND ders_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ogretmen_id);
			ps.setInt(2, ders_id);
			int result = ps.executeUpdate();
			if(result>0)
				return  true;
			else
				return false;
				
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return false;
		}
		
	}
	
	public String ogrenci_adi_soyadi_gonder(int kullanici_id)
	{
		try
		{
			String sql="select adi,soyadi from ogrenciler where kullanici_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,kullanici_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getString("adi")+" "+rs.getString("soyadi");
			}
			return "";
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return "";
		}
	}
	private int ogrenci_id_gonder(int kullanici_id)
	{
		try
		{
			String sql="select ogrenci_id from ogrenciler where kullanici_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,kullanici_id);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt("ogrenci_id");
			}
			return -1;
		}catch(Exception ex)
		{
			return -1;
		}
	}
	
	public int aldigi_kredi_gonder(int kullanici_id)
	{
		try
		{
			int ogrenci_id = ogrenci_id_gonder(kullanici_id);
			String sql="select SUM(kredi) as kredi from dersler d where exists (select * from ogrenci_ders o where o.ogrenci_id=? and d.ders_id=o.ders_id)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ogrenci_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt("kredi");
					
			}
			return -1;
			
		}catch(Exception ex)
		{
			return -1;
		}
	}
	private int bolum_id_gonder(int kullanici_id)
	{
		try
		{
			String sql="select bolum_id from ogrenciler where kullanici_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,kullanici_id);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt("bolum_id");
			}
			return -1;
		}catch(Exception ex)
		{
			return -1;
		}
	}
	
	public List<Dersler> list_kayit_olmadigi_dersleri_gonder(int kullanici_id)
	{
		try
		{
			List<Dersler> list = new ArrayList<Dersler>();
			int ogrenci_id=ogrenci_id_gonder(kullanici_id);
			int bolum_id = bolum_id_gonder(kullanici_id);
			String sql="select ders_id,ders_adi from dersler where not exists(select * from ogrenci_ders where ogrenci_ders.ogrenci_id=? and dersler.ders_id=ogrenci_ders.ders_id)";
			sql=sql+" and bolum_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ogrenci_id);
			ps.setInt(2, bolum_id);
			ResultSet rs  = ps.executeQuery();
			while(rs.next())
			{
				Dersler d = new Dersler();
				d.setDers_id(rs.getInt("ders_id"));
				d.setDers_adi(rs.getString("ders_adi"));
				list.add(d);
				
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	
	public int dersin_kredisini_gonder(int ders_id)
	{
		try
		{
			String sql="select kredi from dersler where ders_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ders_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt("kredi");
			}
			return -1;
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return -1;
		}
	}
	
	public boolean ogrenci_ders_kayit_yap(int kullanici_id,int ders_id)
	{
		try
		{
			int ogrenci_id=ogrenci_id_gonder(kullanici_id);
			String sql="insert into ogrenci_ders(ogrenci_id,ders_id) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ogrenci_id);
			ps.setInt(2,ders_id);
			int result=ps.executeUpdate();
			if(result>0)
				return true;
			else
				return false;
		}catch(Exception ex)
		{
			return false;
		}
	}
	
	private int ogretmen_id_gonder(int kullanici_id)
	{
		try
		{
			String sql="select ogretmen_id from ogretmenler where kullanici_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,kullanici_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt("ogretmen_id");
			}
			return -1;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return -1;
		}
	}
	
	public String ogretmen_adi_soyadi_gonder(int kullanici_id)
	{
		try
		{
			int ogretmen_id=ogretmen_id_gonder(kullanici_id);
			String sql="select adi,soyadi from ogretmenler where ogretmen_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,ogretmen_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getString("adi")+" "+rs.getString("soyadi");
			}
			return "";
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return "";
		}
	}
	
	public List<Dersler> list_ogretmenin_tanimli_oldugu_dersleri_gonder(int kullanici_id)
	{
		try
		{
			List<Dersler> list = new ArrayList<Dersler>();
			int ogretmen_id=ogretmen_id_gonder(kullanici_id);
			String sql="select ders_id,ders_adi from dersler where exists (select * from ogretmen_ders where ogretmen_id=? and dersler.ders_id=ogretmen_ders.ders_id)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,ogretmen_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Dersler d = new Dersler();
				d.setDers_adi(rs.getString("ders_adi"));
				d.setDers_id(rs.getInt("ders_id"));
				list.add(d);
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	
	public List<Ogrenci_ders> list_dersin_aldigi_ogrencileri_getir(int ders_id,int kullanici_id,String aranacak)
	{
		try
		{	
			List<Ogrenci_ders> list = new ArrayList<Ogrenci_ders>();
			String ara="%"+aranacak+"%";
			/*
			 * 
			String sql="select ogrenci_ders.ogrenci_ders_id,ogrenci_ders.ogrenci_id,ogrenci_ders.ders_id,ogrenci_ders.vize,ogrenci_ders.final from ogrenci_ders";
			sql=sql+" where ogrenci_ders.ders_id=? AND exists(select * from dersler where dersler.ders_id=ogrenci_ders.ders_id) ";*/
			String sql="select ogrenci_no,ogrenci_ders.ogrenci_ders_id,ogrenci_ders.ogrenci_id,ogrenci_ders.ders_id,ogrenci_ders.vize,ogrenci_ders.final,ogrenciler.adi,ogrenciler.soyadi";
			sql+=" from ogrenci_ders,ogrenciler";
			sql+=" where ogrenci_ders.ders_id=? AND exists(select * from dersler where dersler.ders_id=ogrenci_ders.ders_id) and ogrenciler.ogrenci_id=ogrenci_ders.ogrenci_id";
			sql+="  AND ogrenci_no like ? order by ogrenciler.adi";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ders_id);
			ps.setString(2,ara);
			ResultSet rs = ps.executeQuery();
			int[] skala=skala_dondur(ders_id);
			while(rs.next())
			{
				
				Ogrenci_ders o=new Ogrenci_ders();
				
				o.setAdi_soyadi(rs.getString("adi")+" "+rs.getString("soyadi"));
				o.setFinnal(rs.getInt("final"));
				o.setVize(rs.getInt("vize"));
				o.setOrtalama(rs.getInt("vize"), rs.getInt("final"));
				o.setHarf(rs.getInt("vize"), rs.getInt("final"), skala);
				o.setOgrenci_ders_id(rs.getInt("ogrenci_ders_id"));
				o.setOgrenci_no(rs.getString("ogrenci_no"));
				list.add(o);
			}
			return list;
			
			
		}catch(Exception ex)
		{
			System.out.println(""+ex);
			return null;
			
		}
	}
	
	public int[] skala_dondur(int ders_id)
	{
		int[] skala=new int[8];
		
		try
		{
			String sql="select AA,BA,BB,CB,CC,DC,DD,FD from ogretmen_ders where ders_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ders_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				for(int i=0;i<8;i++)
					skala[i]=rs.getInt(i+1);
				
			}
		return skala;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
		
	}
	
	public String oogrenci_adi_soyadi_gonder(int ogrenci_id)
	{
		try
		{
			
			String sql="select adi,soyadi from ogrenciler where ogrenci_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,ogrenci_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getString("adi")+" "+rs.getString("soyadi");
			}
			return "";
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return "";
		}
	}
	
	public boolean not_gir(int vize,int finnal,int ogrenci_ders_id)
	{
		try
		{
			String sql="update ogrenci_ders set vize=?,final=? where ogrenci_ders_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,vize);
			ps.setInt(2,finnal);
			ps.setInt(3,ogrenci_ders_id);
			int result=ps.executeUpdate();
			if(result>0)
				return true;
			else
				return false;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return false;
		}
	}
	
	public boolean kullanici_bilgi_degis(String kullanici_adi,String e_sifre,int kullanici_id)
	{
		try
		{
			String sifre=sifre_algoritmasi(e_sifre);
			String sql="update kullanicilar set kullanici_adi=?,sifre=? where kullanici_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, kullanici_adi);
			ps.setString(2, sifre);
			ps.setInt(3, kullanici_id);
			int result=ps.executeUpdate();
			if(result>0)
				return true;
			else
				return false;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return false;
		}
	}
	
	public List<Ogrenci_ders> list_ogrencinin_aldigi_vize_final_gonder(int kullanici_id)
	{
		try
		{
			List<Ogrenci_ders> list = new ArrayList<Ogrenci_ders>();
			int ogrenci_id=ogrenci_id_gonder(kullanici_id);
			String sql="select dersler.ders_id,ders_adi,vize,final from dersler,ogrenci_ders where dersler.ders_id=ogrenci_ders.ders_id";
			sql+=" AND ogrenci_ders.ogrenci_id=? order by dersler.ders_adi";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ogrenci_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Ogrenci_ders o = new Ogrenci_ders();
				o.setDers_id(rs.getInt("ders_id"));
				int ogretmen_id = ders_idden_ogretmen_id_dondur(rs.getInt("ders_id"));
				int o_kullanici_id = ogretmen_idden_kullanici_id_dondur(ogretmen_id);
				int[] skala=skala_dondur(o_kullanici_id);
				
				o.setHarf(rs.getInt("vize"), rs.getInt("final"), skala);
				o.setDers_adi(rs.getString("ders_adi"));
				o.setVize(rs.getInt("vize"));
				o.setFinnal(rs.getInt("final"));
				o.setOrtalama(rs.getInt("vize"), rs.getInt("final"));
				list.add(o);
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	private int ogretmen_idden_kullanici_id_dondur(int ogretmen_id)
	{
		try
		{
			String sql="select kullanici_id from ogretmenler where ogretmen_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ogretmen_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt("kullanici_id");
			}
			return -1;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return -1;
		}
	}
	
	private int ders_idden_ogretmen_id_dondur(int ders_id)
	{
		try
		{
			String sql="select ogretmen_id from ogretmen_ders where ders_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ders_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt("ogretmen_id");
			}
			return -1;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return -1;
		}
		
	}
	
	public String ders_adi_gonder(int ders_id)
	{
		try
		{
			String sql="select ders_adi from dersler where ders_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ders_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getString("ders_adi");
			}
			return "";
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return "";
		}
	}
	
	public int dersi_alan_kisi_sayisi(int ders_id)
	{
		try
		{
			String sql="select count(*) as kisi_sayisi from ogrenci_ders where ders_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ders_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt("kisi_sayisi");
			}
			return -1;
			
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return -1;
		}
	}
	
	public int sinava_giren_kisi_sayisi(int ders_id)
	{
		try
		{
			String sql="select count(*) as kisi_sayisi from ogrenci_ders where ders_id=? AND vize>0 AND final>0";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ders_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt("kisi_sayisi");
			}
			return -1;
			
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return -1;
		}
	}
	
	
	public int dersin_ortalamasi(int ders_id)
	{
		try
		{
			String sql="select sum(vize) as vize,sum(final) as final from ogrenci_ders where ders_id=? AND vize>0 AND final>0";
			int sinava_giren_kisi=sinava_giren_kisi_sayisi(ders_id);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ders_id);
			ResultSet rs = ps.executeQuery();
			int vize=0;
			int finnal=0;
			while(rs.next())
			{
				vize=rs.getInt("vize");
				finnal=rs.getInt("final");
			}
			if(sinava_giren_kisi==0)
				return 0;
			double ortalama = ((vize*0.4+finnal*0.6)/sinava_giren_kisi)+0.5;
			return ((int)ortalama);
			
			
			
		}catch(Exception ex)
		{
			
			System.out.println(ex+"");
			return -1;
		}
	}
	
	public int en_yuksek_not(int ders_id)
	{
		try
		{
			String sql="select ((vize*0.4+final*0.6)+0.5) as enyuksek from ogrenci_ders where ders_id=? AND vize>0 AND final>0 order by enyuksek DESC ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ders_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return  rs.getInt("enyuksek");
			}
			return 0;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return -1;
		}
	}
	
	public String ders_idden_ogretmen_adi_gonder(int ders_id)
	{
		try
		{
			String sql="select adi,soyadi from ogretmenler,ogretmen_ders where ogretmenler.ogretmen_id=ogretmen_ders.ogretmen_id AND ders_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,ders_id);
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
				return rs.getString("adi")+" "+rs.getString("soyadi");
			}
			return "Yok";
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return "Hata Olustu";
		}
	}
	public String harf_bilgi(int ders_id)
	{
		try
		{
			String harfler="";
			int aa=0;int ba=0;int bb=0;int cb=0;int cc=0;int dc=0;int dd=0;
			int fd=0;int ff=0;
			int[] skala=skala_dondur(ders_id);
			String sql="select vize,final from ogrenci_ders where ders_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ders_id);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				Ogrenci_ders o = new Ogrenci_ders();
				o.setHarf(rs.getInt("vize"), rs.getInt("final"), skala);
				String harf=o.getHarf();
				if(harf.equals("AA"))
					aa++;
				if(harf.equals("BA"))
					ba++;
				if(harf.equals("BB"))
					bb++;
				if(harf.equals("CB"))
					cb++;
				if(harf.equals("CC"))
					cc++;
				if(harf.equals("DC"))
					dc++;
				if(harf.equals("DD"))
					dd++;
				if(harf.equals("FD"))
					fd++;
				if(harf.equals("FF"))
					ff++;
			}
			harfler+="AA : "+aa+ " ";
			harfler+="BA : "+ba+ " ";
			harfler+="BB : "+bb+ " ";
			harfler+="CB : "+cb+ " ";
			harfler+="CC : "+cc+ " ";
			harfler+="DC : "+dc+ " ";
			harfler+="DD : "+dd+ " ";
			harfler+="FD : "+fd+ " ";
			harfler+="FF : "+ff+ " ";
			
			
			
			
			return harfler;
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return "Hata Olustu";
		}
		
	}
	
	public Object[] transkript_bilgileri(int kullanici_id)
	{
		try
		{
			Object[] object = new Object[2];
			List<Trans> list=new ArrayList<Trans>();
			
			double toplam_puan=0;
			int ogrenci_id=ogrenci_id_gonder(kullanici_id);
			String sql="select d.ders_id,ders_adi,kredi,vize,final from dersler d,ogrenci_ders od where ";
			sql+="d.ders_id=od.ders_id AND od.ogrenci_id=? order by ders_adi";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,ogrenci_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Trans t = new Trans();
				t.setDers_adi(rs.getString("ders_adi"));
				int kredi=rs.getInt("kredi");
				t.setKredi(rs.getInt("kredi"));
				
				int[] skala=skala_dondur(rs.getInt("ders_id"));
				Ogrenci_ders o = new Ogrenci_ders();
				o.setHarf(rs.getInt("vize"), rs.getInt("final"), skala);
				String harf=o.getHarf();
				t.setHarf(harf);
				double puan=0;
				if(harf.equals("AA"))
					puan=4*kredi;
				else if(harf.equals("BA"))
					puan=3.5*kredi;
				else if(harf.equals("BB"))
					puan=3*kredi;
				else if(harf.equals("CB"))
					puan=2.5*kredi;
				else if(harf.equals("CC"))
					puan=2.25*kredi;
				else if(harf.equals("DC"))
					puan=1.75*kredi;
				else if(harf.equals("DD"))
					puan=1.25*kredi;
				else if(harf.equals("FD"))
					puan=0.75*kredi;
				else if(harf.equals("FF"))
					puan=0*kredi;
				else
					puan=-1;
				
				t.setPuan(puan);
				t.setSpuan(puan);
				if(puan>-1)
				toplam_puan+=puan;
				
				
				
				
				
				
				list.add(t);
			}
			object[0]=list;
			object[1]=toplam_puan+"";
			
			
			return object;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	
	public String ogrencinin_bolumunu_gonder(int kullanici_id)
	{
		try
		{
			String sql="select bolum_adi from bolumler,ogrenciler where bolumler.bolum_id=ogrenciler.bolum_id AND kullanici_id=?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,kullanici_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getString("bolum_adi");
			}
			return "";
			
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	
	public int notu_girilen_toplam_kredi_gonder(int kullanici_id)
	{
		try
		{
			int ogrenci_id=ogrenci_id_gonder(kullanici_id);
			String sql="select sum(kredi) as toplam_kredi from dersler d,ogrenci_ders o where d.ders_id=o.ders_id AND ogrenci_id=?";
			sql+=" AND vize>-1 AND final>-1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ogrenci_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt("toplam_kredi");
			}
			return -1;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return -1;
		}
	}
	
	public List<Ogretmen_ders> list_ogretmen_ders(int kullanici_id)
	{
		try
		{
			int ogretmen_id=ogretmen_id_gonder(kullanici_id);
			List<Ogretmen_ders> list=new ArrayList<Ogretmen_ders>();
			String sql="select ogretmen_ders_id,ders_adi from dersler d,ogretmen_ders o";
			sql+=" where d.ders_id=o.ders_id AND ogretmen_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ogretmen_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Ogretmen_ders o = new Ogretmen_ders();
				o.setOgretmen_ders_id(rs.getInt("ogretmen_ders_id"));
				o.setDers_adi(rs.getString("ders_adi"));
				
				list.add(o);
			}
			return list;
			
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	public String[] ogretmen_ders_idden_skala_dondur(int ogretmen_ders_id)
	{
		try
		{
			String[] skala=new String[8];
			String sql="select aa,ba,bb,cb,cc,dc,dd,fd from ogretmen_ders where ogretmen_ders_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ogretmen_ders_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				for(int i=0;i<8;i++)
					skala[i]=rs.getString(i+1);
			}
			return skala;
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	public boolean skala_guncelle(int ogretmen_ders_id,int[] skala)
	{
		try
		{
			String sql="update ogretmen_ders set aa=?,ba=?,bb=?,cb=?,cc=?,dc=?,dd=?,fd=? where ogretmen_ders_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int i=0;i<8;i++)
				ps.setInt(i+1, skala[i]);
			ps.setInt(9,ogretmen_ders_id);
			
			int result=ps.executeUpdate();
			if(result>0)
				return true;
			else
				return false;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return false;
		}
	}
	public boolean kullanici_ekle(String adi,String soyadi,int bolum_id,String mail,String tcno,int  tip)
	{
		try
		{
			String kullanici_adi = mail;
			String sifre = sifre_algoritmasi(tcno);
			String sql="insert into kullanicilar(kullanici_adi,sifre,tip) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, kullanici_adi);
			ps.setString(2,sifre);
			ps.setInt(3, tip);
			int result = ps.executeUpdate();
			if(result>0)
			{
				ps=null;
				int kullanici_id=kullanici_adindan_kullanici_id_getir(kullanici_adi);
				if(tip==0)
					sql="insert into ogrenciler(kullanici_id,adi,soyadi,bolum_id,mail,tcno) values(?,?,?,?,?,?)";
				else if(tip==1)
					sql="insert into ogretmenler(kullanici_id,adi,soyadi,bolum_id,mail,tcno) values(?,?,?,?,?,?)";
				
				ps=conn.prepareStatement(sql);
				ps.setInt(1, kullanici_id);
				ps.setString(2,adi);
				ps.setString(3,soyadi);
				ps.setInt(4, bolum_id);
				ps.setString(5, mail);
				ps.setString(6,tcno);
				int result2=ps.executeUpdate();
					if(result2>0)
						return true;
					else
						return false;
				
				
			}else
			{
				return false;
			}
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return false;
		}
	}
	

	private int kullanici_adindan_kullanici_id_getir(String kullanici_adi)
	{
		try
		{
			String sql="select kullanici_id from kullanicilar where kullanici_adi=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,kullanici_adi);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt("kullanici_id");
			}
			return -1;
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return -1;
		}
	}
	public int mail_tcno_kontrol_varmi(String tcno,String mail)
	{
		try
		{
			String sql="select kullanici_id from ogretmenler where tcno=? AND mail=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tcno);
			ps.setString(2, mail);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt("kullanici_id");
			}
			ps=null;
			sql="select kullanici_id from ogrenciler where tcno=? AND mail=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, tcno);
			ps.setString(2, mail);
			rs=null;
			rs=ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt("kullanici_id");
			}
			return -1;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return -1;
		}
	}
	
	public boolean mail_tcno_varmi_kayit_ederken(String mail,String tcno) //var ise false
	{
		try
		{
			
			String sql="select * from ogretmenler where mail=? OR tcno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,mail);
			ps.setString(2, tcno);
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
				
				return false;
			}
			ps=null;
			rs=null;
			sql="select * from ogrenciler where mail=? OR tcno=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,mail);
			ps.setString(2, tcno);
			rs =ps.executeQuery();
			while(rs.next())
			{
				
				return false;
			}
			
			return true;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return false;
		}
	}
	
	public String[] son_5_kullanici_eklenen_gonder()
	{
		try
		{
			String[] eklenen=new String[5];
			String sql="select kullanici_id,tip from   ( select * from KULLANICILAR order by KULLANICI_ID DESC) where ROWNUM <= 5";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int i=0;
			while(rs.next())
			{
				if(rs.getInt("tip")==0)
				{
					eklenen[i]=ogrenci_adi_soyadi_gonder(rs.getInt("kullanici_id"))+ " - Ogrenci";
					i++;
				}
				
				if(rs.getInt("tip")==1)
				{
					eklenen[i]=ogretmen_adi_soyadi_gonder(rs.getInt("kullanici_id"))+" - Ogretmen";
					i++;
				}
				
					
			}
				return eklenen;
			}
			
		catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	
	public String bolum_idden_bolum_adi_gonder(int bolum_id)
	{
		try
		{
			String sql="select bolum_adi from bolumler where bolum_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,bolum_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getString("bolum_adi");
			}
			return "";
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return "";
		}
		
	}
	
	
	public String[] son_5_ders_eklenen_gonder()
	{
		try
		{
			String[] eklenen=new String[5];
			String sql="select ders_adi,bolum_id from   ( select * from DERSLER order by DERS_ID DESC) where ROWNUM <= 5";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			int i=0;
			while(rs.next())
			{
				String bolum_adi=bolum_idden_bolum_adi_gonder(rs.getInt("bolum_id"));
				eklenen[i]=rs.getString("ders_adi")+" - "+bolum_adi;
				i++;
				
			}
			return eklenen;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	public String[] son_5_ders_cikar_gonder()
	{
		try
		{
			String[] eklenen=new String[5];
			
			String sql="select ogretmen_id,ders_id from   ( select * from OGRETMEN_DERS_CIKAR WHERE ISLEM=0 order by ogretmen_ders_cikar_id DESC) where ROWNUM <= 5";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			int i=0;
			while(rs.next())
			{
				String adi=ogretmen_idden_adi_soyadi_gonder(rs.getInt("ogretmen_id"));
				String ders_adi=ders_adi_gonder(rs.getInt("ders_id"));
				eklenen[i]=adi+" - "+ders_adi+" cikarildi";
				i++;
				
			}
			return eklenen;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	
	public String ogretmen_idden_adi_soyadi_gonder(int ogretmen_id)
	{
		try
		{
			String sql="select adi,soyadi from ogretmenler where ogretmen_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ogretmen_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getString("adi")+" "+rs.getString("soyadi");
			}
			return "";
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return "";
		}
	}
	
	public String[] son_5_ogretmen_ders_ekle_gonder()
	{
		try
		{
			String[] eklenen=new String[5];
			
			String sql="select ogretmen_id,ders_id,ISLEM from   ( select * from OGRETMEN_DERS_CIKAR order by ogretmen_ders_cikar_id DESC) where ROWNUM <= 5";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			int i=0;
			while(rs.next())
			{
				
				String adi=ogretmen_idden_adi_soyadi_gonder(rs.getInt("ogretmen_id"));
				String ders_adi=ders_adi_gonder(rs.getInt("ders_id"));
				if(rs.getInt("ISLEM")==0)
				eklenen[i]=adi+" - "+ders_adi+" cikarildi";
				if(rs.getInt("ISLEM")==1)
					eklenen[i]=adi+" - "+ders_adi+" eklendi";
				i++;
				
			}
			return eklenen;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	
	public String[] son_5_ogrenci_ders_kayit_gonder(int kullanici_id)
	{
		try {
			String[] sonuc=new String[5];
			int ogrenci_id=ogrenci_id_gonder(kullanici_id);
			String sql="select * from   ( select * from OGRENCI_DERS_KAYIT WHERE OGRENCI_ID=? order by OGRENCI_DERS_KAYIT_ID DESC) where ROWNUM <= 5";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ogrenci_id);
			ResultSet rs = ps.executeQuery();
			int i=0;
			while(rs.next())
			{
				String ders_adi=ders_adi_gonder(rs.getInt("ders_id"));
				if(rs.getInt("islem")==1)
					sonuc[i]=ders_adi+" eklendi.";
				if(rs.getInt("islem")==0)
					sonuc[i]=ders_adi+" cikarildi.";
				
				i++;
			}
			return sonuc;
			
		} catch (Exception ex) {
			System.out.println(ex+"");
			return null;
		}
	}
	
	public List<Ogrenciler> list_ogrenci_no_ara(String ogrenci_no)
	{
		try
		{
			List<Ogrenciler> list=new ArrayList<Ogrenciler>();
			String s = "%"+ogrenci_no+"%";
			
			String sql="select ogrenci_id,adi,soyadi from ogrenciler where ogrenci_no like ? order by adi";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Ogrenciler o = new Ogrenciler();
				
				o.setOgrenci_id(rs.getInt("ogrenci_id"));
				o.setAdi_soyadi(rs.getString("adi"), rs.getString("soyadi"));
				list.add(o);
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	
	public List<Ogrenci_ders> list_ogrencinin_aldigi_dersleri_gonder(int ogrenci_id)
	{
		try
		{
			List<Ogrenci_ders> list=new ArrayList<Ogrenci_ders>();
			String sql="select o.ogrenci_ders_id,d.ders_adi from dersler d,ogrenci_ders o where d.ders_id=o.ders_id and ogrenci_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ogrenci_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Ogrenci_ders o = new Ogrenci_ders();
				o.setOgrenci_ders_id(rs.getInt("ogrenci_ders_id"));
				o.setDers_adi(rs.getString("ders_adi"));
				list.add(o);
				
				
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}
	
	public boolean ogrenci_ders_cikar(int ogrenci_ders_id)
	{
		try
		{
			String sql="delete from ogrenci_ders where ogrenci_ders_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,ogrenci_ders_id);
			int result=ps.executeUpdate();
			if(result>0)
				return true;
			else
				return false;
			
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return false;
		}
	}
	
	public String[] son_5_ders_cikar_gonder2()
	{
		try
		{
			String[] sonuc=new String[5];
			String sql="select OGRENCI_ID,DERS_ID from   ( select * from OGRENCI_DERS_KAYIT WHERE ISLEM=0 order by OGRENCI_DERS_KAYIT_ID DESC) where ROWNUM <= 5";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int i=0;
			while(rs.next())
			{
				String adi = oogrenci_adi_soyadi_gonder(rs.getInt("ogrenci_id"));
				String ders_ad = ders_adi_gonder(rs.getInt("ders_id"));
				sonuc[i]=adi+"  -  "+ders_ad+"  Kaldirilmis";
				i++;
			}
			return sonuc;
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			return null;
		}
	}

}
