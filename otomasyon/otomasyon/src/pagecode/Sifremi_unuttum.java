/**
 * 
 */
package pagecode;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;

import com.db.Db;
import com.ibm.faces.component.html.HtmlCommandExButton;

/**
 * @author Emre
 *
 */
public class Sifremi_unuttum extends PageCodeBase {

	String tcno;
	String mail;
	String kullanici_adi;
	String sifre;
	String guncelle_sonuc;
	protected HtmlCommandExButton bguncelle;
	protected HtmlForm form1;
	protected HtmlCommandExButton bgeridon;
	protected HtmlInputText text1;
	protected HtmlInputText text2;
	protected HtmlOutputText text4;
	protected HtmlInputText text3;
	protected HtmlInputSecret secret1;
	protected HtmlCommandExButton getBguncelle() {
		if (bguncelle == null) {
			bguncelle = (HtmlCommandExButton) findComponentInRoot("bguncelle");
		}
		return bguncelle;
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

	protected HtmlOutputText getText4() {
		if (text4 == null) {
			text4 = (HtmlOutputText) findComponentInRoot("text4");
		}
		return text4;
	}

	protected HtmlInputText getText3() {
		if (text3 == null) {
			text3 = (HtmlInputText) findComponentInRoot("text3");
		}
		return text3;
	}

	protected HtmlInputSecret getSecret1() {
		if (secret1 == null) {
			secret1 = (HtmlInputSecret) findComponentInRoot("secret1");
		}
		return secret1;
	}

	public String getTcno() {
		return tcno;
	}

	public void setTcno(String tcno) {
		this.tcno = tcno;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getKullanici_adi() {
		return kullanici_adi;
	}

	public void setKullanici_adi(String kullanici_adi) {
		this.kullanici_adi = kullanici_adi;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String doBguncelleAction() {
		if(kullanici_adi.length()<5 || sifre.length()<6)
		{
			guncelle_sonuc="Kullanici adi veya sifre yeterli uzunlukta degil";
			return "";
		}
		int kullanici_id = new Db().mail_tcno_kontrol_varmi(tcno, mail);
		if(kullanici_id==-1)
		{
			guncelle_sonuc="Tc No ve mail eslesmedi";
			return "";
		}
		if(new Db().kullanici_bilgi_degis(kullanici_adi, sifre, kullanici_id))
		{
			tcno="";
			mail="";
			kullanici_adi="";
			guncelle_sonuc="Basarili İslem";
		}else
		{
			guncelle_sonuc="Hata Olustu";
		}
		return "";
	}

	public String getGuncelle_sonuc() {
		return guncelle_sonuc;
	}

	public String doBgeridonAction() {
		tcno="";
		mail="";
		kullanici_adi="";
		sifre="";
		guncelle_sonuc="";
		return "anasayfa?faces-redirect=true";

}
}