/**
 * 
 */
package pagecode;

import java.util.List;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;

import com.db.Db;
import com.db.Dersler;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.session.Session;
/**
 * @author sahin
 *
 */
public class Derskayit extends PageCodeBase {

	int kalan_kredi;
	List<Dersler> list_dersler;
	int dersin_kredisi;
	int ders_id;
	String kayit_sonuc;
	String sonuc_1,sonuc_2,sonuc_3,sonuc_4,sonuc_5;
	public String getSonuc_1() {
		return sonuc_1;
	}

	public String getSonuc_2() {
		return sonuc_2;
	}

	public String getSonuc_3() {
		return sonuc_3;
	}

	public String getSonuc_4() {
		return sonuc_4;
	}

	public String getSonuc_5() {
		return sonuc_5;
	}

	protected HtmlOutputText text1;
	protected HtmlOutputText text2;
	protected HtmlSelectOneMenu menu1;
	protected HtmlForm form1;
	protected HtmlOutputText text3;
	protected HtmlCommandExButton bkayit;
	protected HtmlCommandExButton bgeridon;
	protected HtmlCommandButton bkredigetir;
	protected HtmlOutputText text4;
	protected HtmlOutputText text6;
	protected HtmlOutputText text7;
	protected HtmlOutputText text8;
	protected HtmlOutputText text9;
	protected HtmlOutputText text10;

	protected HtmlOutputText getText1() {
		if (text1 == null) {
			text1 = (HtmlOutputText) findComponentInRoot("text1");
		}
		
		return text1;
	}

	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
	}

	protected HtmlSelectOneMenu getMenu1() {
		if (menu1 == null) {
			menu1 = (HtmlSelectOneMenu) findComponentInRoot("menu1");
		}
		return menu1;
	}

	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	protected HtmlOutputText getText3() {
		if (text3 == null) {
			text3 = (HtmlOutputText) findComponentInRoot("text3");
		}
		return text3;
	}

	protected HtmlCommandExButton getBkayit() {
		if (bkayit == null) {
			bkayit = (HtmlCommandExButton) findComponentInRoot("bkayit");
		}
		return bkayit;
	}

	protected HtmlCommandExButton getBgeridon() {
		if (bgeridon == null) {
			bgeridon = (HtmlCommandExButton) findComponentInRoot("bgeridon");
		}
		return bgeridon;
	}

	public String doBgeridonAction() {
		kalan_kredi=0;
		list_dersler=null;
		dersin_kredisi=0;
		ders_id=0;
		kayit_sonuc="";
		return "ogrenci_giris?faces-redirect=true";
	}

	public int getKalan_kredi() {
		int aldigi_kredi = new Db().aldigi_kredi_gonder(Session.kullanici_id);
		kalan_kredi=21-aldigi_kredi;
		return kalan_kredi;
	}

	public List<Dersler> getList_dersler() {
		list_dersler = new Db().list_kayit_olmadigi_dersleri_gonder(Session.kullanici_id);
		return list_dersler;
	}

	public int getDersin_kredisi() {
		
		return dersin_kredisi;
	}

	protected HtmlCommandButton getBkredigetir() {
		if (bkredigetir == null) {
			bkredigetir = (HtmlCommandButton) findComponentInRoot("bkredigetir");
		}
		return bkredigetir;
	}

	public String doBkredigetirAction() {
		dersin_kredisi=new Db().dersin_kredisini_gonder(ders_id);
		return "";
	}

	public int getDers_id() {
		return ders_id;
	}

	public void setDers_id(int ders_id) {
		this.ders_id = ders_id;
	}

	public String doBkayitAction() {
		int kalan_kredi = 21-new Db().aldigi_kredi_gonder(Session.kullanici_id);
		int dersin_kredisi = new Db().dersin_kredisini_gonder(ders_id);
		if(dersin_kredisi>kalan_kredi)
		{
			//Dersin kredisi fazla
			kayit_sonuc="Daha fazla kredi alamazsiniz";
			return "";
		}
		if(new Db().ogrenci_ders_kayit_yap(Session.kullanici_id, ders_id))
			kayit_sonuc="Derse Basariyla Kaydoldun";
		else
			kayit_sonuc="Hata Olustu";
		
		return "";
	}

	protected HtmlOutputText getText4() {
		if (text4 == null) {
			text4 = (HtmlOutputText) findComponentInRoot("text4");
		}
		return text4;
	}

	public String getKayit_sonuc() {
		return kayit_sonuc;
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

	public void onPageLoadBegin(FacesContext facescontext) {
		String[] eklenen=new Db().son_5_ogrenci_ders_kayit_gonder(Session.kullanici_id);
		sonuc_1=eklenen[0];
		sonuc_2=eklenen[1];
		sonuc_3=eklenen[2];
		sonuc_4=eklenen[3];
		sonuc_5=eklenen[4];
	}

}