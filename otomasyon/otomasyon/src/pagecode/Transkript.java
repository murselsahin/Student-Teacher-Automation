/**
 * 
 */
package pagecode;

import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneListbox;

import com.db.Db;
import com.db.Trans;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.session.Session;
/**
 * @author Emre
 *
 */
public class Transkript extends PageCodeBase {
	
	String adi_soyadi;
	String bolumu;
	String toplam_puan;
	String toplam_kredi;
	String ortalama;
	List<Trans> list_trans;

	protected HtmlOutputText text1;
	protected HtmlOutputText text2;
	protected HtmlForm form1;
	protected HtmlSelectOneListbox listbox2;
	protected HtmlSelectOneListbox listbox3;
	protected HtmlSelectOneListbox listbox4;
	protected HtmlOutputText text3;
	protected HtmlOutputText text4;
	protected HtmlOutputText text5;
	protected HtmlCommandExButton bgeridon;
	protected HtmlSelectOneListbox listbox1;

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

	public String getAdi_soyadi() {
		adi_soyadi=new Db().ogrenci_adi_soyadi_gonder(Session.kullanici_id);
		return adi_soyadi;
	}

	public String getBolumu() {
		bolumu=new Db().ogrencinin_bolumunu_gonder(Session.kullanici_id);
		return bolumu;
	}

	public String getToplam_puan() {
		return toplam_puan;
	}

	public String getOrtalama() {
		return ortalama;
	}

	public String getToplam_kredi() {
		
		toplam_kredi=new Db().notu_girilen_toplam_kredi_gonder(Session.kullanici_id)+"";
		return toplam_kredi;
	}

	protected HtmlCommandExButton getBgeridon() {
		if (bgeridon == null) {
			bgeridon = (HtmlCommandExButton) findComponentInRoot("bgeridon");
		}
		return bgeridon;
	}

	@SuppressWarnings("unchecked")
	public List<Trans> getList_trans() {
		Object[] object=new Db().transkript_bilgileri(Session.kullanici_id);
		list_trans=(List<Trans>)object[0];
		toplam_puan=(String)object[1];
		
		int itoplam_kredi=new Db().notu_girilen_toplam_kredi_gonder(Session.kullanici_id);
		double dtoplam_puan=Double.parseDouble(toplam_puan);
		double dortalama=dtoplam_puan/itoplam_kredi*1.0;
		ortalama=dortalama+"";
		if(ortalama.length()>4)
			ortalama=ortalama.substring(0,4);
		
		return list_trans;
	}

	protected HtmlSelectOneListbox getListbox1() {
		if (listbox1 == null) {
			listbox1 = (HtmlSelectOneListbox) findComponentInRoot("listbox1");
		}
		return listbox1;
	}

	public String doBgeridonAction() {
		adi_soyadi="";
		bolumu="";
		toplam_puan="";
		toplam_kredi="";
		ortalama="";
		list_trans=null;
		return "ogrenci_giris?faces-redirect=true";
	}

}