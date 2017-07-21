/**
 * 
 */
package pagecode;

import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneListbox;

import com.db.Db;
import com.db.Ogrenci_ders;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.session.Session;
/**
 * @author sahin
 *
 */
public class Notbilgisi extends PageCodeBase {

	List<Ogrenci_ders> list_ogrenci_ders;
	

	protected HtmlSelectOneListbox listbox1;
	protected HtmlForm form1;
	protected HtmlSelectOneListbox listbox2;
	protected HtmlSelectOneListbox listbox3;
	protected HtmlSelectOneListbox listbox4;
	protected HtmlCommandExButton bayrinti;
	protected HtmlCommandExButton bgeridon;
	protected HtmlSelectOneListbox listbox5;
	int ders_id;
	String ders_adi;
	String alan_kisi_sayisi;
	String sinifin_ortalamasi;
	String harf_bilgi;
	String en_yuksek_not;
	String sinava_giren_kisi_sayisi;
	String dersin_hocasi;

	protected HtmlOutputText text1;


	protected HtmlOutputText text2;


	protected HtmlOutputText text3;


	protected HtmlOutputText text4;


	protected HtmlOutputText text5;


	protected HtmlOutputText text6;


	protected HtmlOutputText text7;


	public int getDers_id() {
		return ders_id;
	}


	public void setDers_id(int ders_id) {
		this.ders_id = ders_id;
	}


	public List<Ogrenci_ders> getList_ogrenci_ders() {
		list_ogrenci_ders=new Db().list_ogrencinin_aldigi_vize_final_gonder(Session.kullanici_id);
		return list_ogrenci_ders;
	}
	
	
	protected HtmlSelectOneListbox getListbox1() {
		if (listbox1 == null) {
			listbox1 = (HtmlSelectOneListbox) findComponentInRoot("listbox1");
		}
		return listbox1;
	}

	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	protected HtmlSelectOneListbox getListbox2() {
		if (listbox2 == null) {
			listbox2 = (HtmlSelectOneListbox) findComponentInRoot("listbox2");
		}
		return listbox2;
	}

	protected HtmlSelectOneListbox getListbox3() {
		if (listbox3 == null) {
			listbox3 = (HtmlSelectOneListbox) findComponentInRoot("listbox3");
		}
		return listbox3;
	}

	protected HtmlSelectOneListbox getListbox4() {
		if (listbox4 == null) {
			listbox4 = (HtmlSelectOneListbox) findComponentInRoot("listbox4");
		}
		return listbox4;
	}

	protected HtmlCommandExButton getBayrinti() {
		if (bayrinti == null) {
			bayrinti = (HtmlCommandExButton) findComponentInRoot("bayrinti");
		}
		return bayrinti;
	}

	protected HtmlCommandExButton getBgeridon() {
		if (bgeridon == null) {
			bgeridon = (HtmlCommandExButton) findComponentInRoot("bgeridon");
		}
		return bgeridon;
	}

	public String doBgeridonAction() {
		list_ogrenci_ders=null;
		ders_id=0;
		ders_adi="";
		alan_kisi_sayisi="";
		sinifin_ortalamasi="";
		harf_bilgi="";
		en_yuksek_not="";
		sinava_giren_kisi_sayisi="";
		dersin_hocasi="";
		return "ogrenci_giris?faces-redirect=true";
	}

	protected HtmlSelectOneListbox getListbox5() {
		if (listbox5 == null) {
			listbox5 = (HtmlSelectOneListbox) findComponentInRoot("listbox5");
		}
		return listbox5;
	}


	public String doBayrintiAction() {
		ders_adi=new Db().ders_adi_gonder(ders_id);
		alan_kisi_sayisi=new Db().dersi_alan_kisi_sayisi(ders_id)+"";
		sinava_giren_kisi_sayisi=new Db().sinava_giren_kisi_sayisi(ders_id)+"";
		sinifin_ortalamasi=new Db().dersin_ortalamasi(ders_id)+"";
		en_yuksek_not=new Db().en_yuksek_not(ders_id)+"";
		dersin_hocasi=new Db().ders_idden_ogretmen_adi_gonder(ders_id);
		harf_bilgi=new Db().harf_bilgi(ders_id);
		return "";
	}


	public String getDers_adi() {
		return ders_adi;
	}


	public String getAlan_kisi_sayisi() {
		return alan_kisi_sayisi;
	}


	public String getSinifin_ortalamasi() {
		return sinifin_ortalamasi;
	}


	public String getHarf_bilgi() {
		return harf_bilgi;
	}


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


	public String getEn_yuksek_not() {
		return en_yuksek_not;
	}


	protected HtmlOutputText getText3() {
		if (text3 == null) {
			text3 = (HtmlOutputText) findComponentInRoot("text3");
		}
		return text3;
	}


	protected HtmlOutputText getText4() {
		if (text4 == null) {
			text4 = (HtmlOutputText) findComponentInRoot("text4");
		}
		return text4;
	}


	protected HtmlOutputText getText5() {
		if (text5 == null) {
			text5 = (HtmlOutputText) findComponentInRoot("text5");
		}
		return text5;
	}


	protected HtmlOutputText getText6() {
		if (text6 == null) {
			text6 = (HtmlOutputText) findComponentInRoot("text6");
		}
		return text6;
	}


	public String getSinava_giren_kisi_sayisi() {
		return sinava_giren_kisi_sayisi;
	}


	public String getDersin_hocasi() {
		return dersin_hocasi;
	}


	protected HtmlOutputText getText7() {
		if (text7 == null) {
			text7 = (HtmlOutputText) findComponentInRoot("text7");
		}
		return text7;
	}

}