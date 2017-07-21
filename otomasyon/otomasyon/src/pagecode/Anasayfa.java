/**
 * 
 */
package pagecode;

import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;

import com.db.Db;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.session.Session;
import javax.faces.component.html.HtmlForm;

/**
 * @author sahin
 *
 */
public class Anasayfa extends PageCodeBase {
	
	String kullanici_adi;
	String sifre;
	String giris_sonuc;
	public String getGiris_sonuc() {
		return giris_sonuc;
	}

	protected HtmlInputText text1;
	protected HtmlInputSecret secret1;
	protected HtmlCommandExButton bgiris;
	protected HtmlCommandExButton bunuttum;
	protected HtmlOutputText text2;
	protected HtmlForm form1;

	protected HtmlInputText getText1() {
		if (text1 == null) {
			text1 = (HtmlInputText) findComponentInRoot("text1");
		}
		
		return text1;
	}

	protected HtmlInputSecret getSecret1() {
		if (secret1 == null) {
			secret1 = (HtmlInputSecret) findComponentInRoot("secret1");
		}
		return secret1;
	}

	protected HtmlCommandExButton getBgiris() {
		if (bgiris == null) {
			bgiris = (HtmlCommandExButton) findComponentInRoot("bgiris");
		}
		return bgiris;
	}

	public String doBgirisAction() {
		String[] dizi=new Db().giris_kontrol(kullanici_adi, sifre);
		//dizi[0]=true or false , dizi[1]=kullanici_id , dizi[2]=tip
		
		
		if(dizi[0].equals("false"))
		{	
			//Sifre Yanlis , sessionları false yap
			Session.admin_giris=false;
			Session.ogrenci_giris=false;
			Session.ogretmen_giris=false;
			Session.kullanici_id=0;
			giris_sonuc="Kullanici Adi veya Sifre Yanlis";
			return "";
		}
		if(dizi[2].equals("2"))
		{
			
			//Yonetici ise sessionları belirle yonlendirme yap.
			Session.admin_giris=true;
			Session.ogrenci_giris=false;
			Session.ogretmen_giris=false;
			Session.kullanici_id=Integer.parseInt(dizi[1]);
			return "yonetici_giris?faces-redirect=true";
			
		}
		if(dizi[2].equals("1"))
		{
			//Ogretmen ise sessionları belirle yonlendirme yap.
			Session.admin_giris=false;
			Session.ogrenci_giris=false;
			Session.ogretmen_giris=true;
			Session.kullanici_id=Integer.parseInt(dizi[1]);
			return "ogretmen_giris?faces-redirect=true";
		}
		if(dizi[2].equals("0"))
		{
			//Ogrenci ise sessionları belirle yonlendirme yap.
			Session.admin_giris=false;
			Session.ogrenci_giris=true;
			Session.ogretmen_giris=false;
			Session.kullanici_id=Integer.parseInt(dizi[1]);
			return "ogrenci_giris?faces-redirect=true";
		}
		return "";
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

	public void onPageLoadBegin(FacesContext facescontext) {
		Session.admin_giris=false;
		Session.ogrenci_giris=false;
		Session.ogretmen_giris=false;
		Session.kullanici_id=0;
		
	}

	protected HtmlCommandExButton getBunuttum() {
		if (bunuttum == null) {
			bunuttum = (HtmlCommandExButton) findComponentInRoot("bunuttum");
		}
		return bunuttum;
	}

	public String doBunuttumAction() {

		return "sifremi_unuttum?faces-redirect=true";
		
	}

	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
	}

	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

}