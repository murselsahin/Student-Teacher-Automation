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
import com.session.Session;

/**
 * @author Emre
 *
 */
public class Ogretmen_bilgi_degis extends PageCodeBase {

	protected HtmlInputText text1;
	protected HtmlForm form1;
	protected HtmlInputSecret secret1;
	protected HtmlCommandExButton bdegis;
	protected HtmlCommandExButton bgeridon;
	protected HtmlOutputText text2;
	String kullanici_adi;
	String sifre;
	String degis_sonuc;

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

	public String getDegis_sonuc() {
		return degis_sonuc;
	}

	public void setDegis_sonuc(String degis_sonuc) {
		this.degis_sonuc = degis_sonuc;
	}

	protected HtmlInputText getText1() {
		if (text1 == null) {
			text1 = (HtmlInputText) findComponentInRoot("text1");
		}
		return text1;
	}

	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	protected HtmlInputSecret getSecret1() {
		if (secret1 == null) {
			secret1 = (HtmlInputSecret) findComponentInRoot("secret1");
		}
		return secret1;
	}

	protected HtmlCommandExButton getBdegis() {
		if (bdegis == null) {
			bdegis = (HtmlCommandExButton) findComponentInRoot("bdegis");
		}
		return bdegis;
	}

	protected HtmlCommandExButton getBgeridon() {
		if (bgeridon == null) {
			bgeridon = (HtmlCommandExButton) findComponentInRoot("bgeridon");
		}
		return bgeridon;
	}

	public String doBgeridonAction() {
		kullanici_adi="";
		sifre="";
		degis_sonuc="";
		return "ogretmen_giris?faces-redirect=true";
	}

	public String doBdegisAction() {
		if(kullanici_adi.length()<5 || sifre.length()<6)
		{
			degis_sonuc="Kullanici Adi En Az 5,Sifre En Az 6 Karakter olmali";
			return "";
		}
		if(new Db().kullanici_bilgi_degis(kullanici_adi, sifre, Session.kullanici_id))
		{
			kullanici_adi="";
			degis_sonuc="Bilgileriniz Guncellendi";
		}
		else
			degis_sonuc="Hata Olustu";
		
		
		return "";
	}

	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
	}

}