/**
 * 
 */
package pagecode;

import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.context.FacesContext;

import com.db.Bolumler;
import com.db.Db;
import com.ibm.faces.component.html.HtmlCommandExButton;
/**
 * @author Emre
 *
 */
public class Ogretmen_ogrenci_ekle extends PageCodeBase {
	String adi;
	String soyadi;
	int bolum_id;
	String mail;
	List<Bolumler> list_bolum;
	String tcno;
	String tip;
	String ekle_sonuc;
	String son_1,son_2,son_3,son_4,son_5;
	
	public String getSon_1() {
		return son_1;
	}

	public String getSon_2() {
		return son_2;
	}

	public String getSon_3() {
		return son_3;
	}

	public String getSon_4() {
		return son_4;
	}

	public String getSon_5() {
		return son_5;
	}

	protected HtmlCommandExButton bekle;
	protected HtmlForm form1;
	protected HtmlCommandExButton bgeridon;
	protected HtmlInputText text1;
	protected HtmlInputText text2;
	protected HtmlSelectOneMenu menu1;
	protected HtmlInputText text3;
	protected HtmlInputText text4;
	protected HtmlSelectOneRadio radio1;
	protected HtmlOutputText text5;
	protected HtmlOutputText text6;
	protected HtmlOutputText text7;
	protected HtmlOutputText text8;
	protected HtmlOutputText text9;
	protected HtmlOutputText text10;

	protected HtmlCommandExButton getBekle() {
		if (bekle == null) {
			bekle = (HtmlCommandExButton) findComponentInRoot("bekle");
		}
		return bekle;
	}

	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	protected HtmlCommandExButton getBgeridon() {
		if (bgeridon == null) {
			bgeridon = (HtmlCommandExButton) findComponentInRoot("bgeridon");
		}
		return bgeridon;
	}

	protected HtmlInputText getText1() {
		if (text1 == null) {
			text1 = (HtmlInputText) findComponentInRoot("text1");
		}
		return text1;
	}

	protected HtmlInputText getText2() {
		if (text2 == null) {
			text2 = (HtmlInputText) findComponentInRoot("text2");
		}
		return text2;
	}

	protected HtmlSelectOneMenu getMenu1() {
		if (menu1 == null) {
			menu1 = (HtmlSelectOneMenu) findComponentInRoot("menu1");
		}
		return menu1;
	}

	protected HtmlInputText getText3() {
		if (text3 == null) {
			text3 = (HtmlInputText) findComponentInRoot("text3");
		}
		return text3;
	}

	protected HtmlInputText getText4() {
		if (text4 == null) {
			text4 = (HtmlInputText) findComponentInRoot("text4");
		}
		return text4;
	}

	protected HtmlSelectOneRadio getRadio1() {
		if (radio1 == null) {
			radio1 = (HtmlSelectOneRadio) findComponentInRoot("radio1");
		}
		return radio1;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getSoyadi() {
		return soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

	public int getBolum_id() {
		return bolum_id;
	}

	public void setBolum_id(int bolum_id) {
		this.bolum_id = bolum_id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTcno() {
		return tcno;
	}

	public void setTcno(String tcno) {
		this.tcno = tcno;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public List<Bolumler> getList_bolum() {
		list_bolum=new Db().list_bolum_gonder();
		return list_bolum;
	}

	public String doBekleAction() {
		try
		{
			Double.parseDouble(tcno);
			int tip=Integer.parseInt(this.tip);
			if(!(new Db().mail_tcno_varmi_kayit_ederken(mail, tcno)))
			{
				ekle_sonuc="Mail Yada Tc No Cakismasi";
				return "";
			}
			
			if(adi.length()>0 && soyadi.length()>0 && mail.length()>0 && tcno.length()==11)
				if(new Db().kullanici_ekle(adi, soyadi, bolum_id, mail, tcno, tip))
				{
					ekle_sonuc="Basariyla Kaydedildi";
					adi="";
					soyadi="";
					mail="";
					tcno="";
				}
				else
				{
					ekle_sonuc="Hata Olustu";
				}
			else
			{
				ekle_sonuc="Hatali Girisler";
			}
			
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			ekle_sonuc="Hatali Girisler";
		}
		return "";
	}

	public String doBgeridonAction() {
		adi="";
		soyadi="";
		bolum_id=0;
		mail="";
		list_bolum=null;
		tcno="";
		tip="";
		return "yonetici_giris?faces-redirect=true";
	}

	public String getEkle_sonuc() {
		return ekle_sonuc;
	}

	protected HtmlOutputText getText5() {
		if (text5 == null) {
			text5 = (HtmlOutputText) findComponentInRoot("text5");
		}
		return text5;
	}

	public void onPageLoadBegin(FacesContext facescontext) {
		String[] eklenen=new Db().son_5_kullanici_eklenen_gonder();
		son_1=eklenen[0];
		son_2=eklenen[1];
		son_3=eklenen[2];
		son_4=eklenen[3];
		son_5=eklenen[4];
	}

	protected HtmlOutputText getText6() {
		if (text6 == null) {
			text6 = (HtmlOutputText) findComponentInRoot("text6");
		}
		return text6;
	}

	protected HtmlOutputText getText7() {
		if (text7 == null) {
			text7 = (HtmlOutputText) findComponentInRoot("text7");
		}
		return text7;
	}

	protected HtmlOutputText getText8() {
		if (text8 == null) {
			text8 = (HtmlOutputText) findComponentInRoot("text8");
		}
		return text8;
	}

	protected HtmlOutputText getText9() {
		if (text9 == null) {
			text9 = (HtmlOutputText) findComponentInRoot("text9");
		}
		return text9;
	}

	protected HtmlOutputText getText10() {
		if (text10 == null) {
			text10 = (HtmlOutputText) findComponentInRoot("text10");
		}
		return text10;
	}

}