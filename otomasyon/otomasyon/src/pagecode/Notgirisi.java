/**
 * 
 */
package pagecode;

import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneListbox;
import javax.faces.component.html.HtmlSelectOneMenu;

import com.db.Db;
import com.db.Dersler;
import com.db.Ogrenci_ders;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.session.Session;
/**
 * @author sahin
 *
 */
public class Notgirisi extends PageCodeBase {

	List<Dersler> list_dersler;
	int ders_id;
	int[] idler;
	List<Ogrenci_ders> list_ogrenci_ders;
	int ogrenci_ders_id;
	String vize;
	String finnal;
	String notu_gir_sonuc;
	String aranacak;
	public String getNotu_gir_sonuc() {
		return notu_gir_sonuc;
	}

	public void setNotu_gir_sonuc(String notu_gir_sonuc) {
		this.notu_gir_sonuc = notu_gir_sonuc;
	}

	public String getVize() {
		return vize;
	}

	public void setVize(String vize) {
		this.vize = vize;
	}

	public String getFinnal() {
		return finnal;
	}

	public void setFinnal(String finnal) {
		this.finnal = finnal;
	}

	protected HtmlSelectOneListbox listbox1;
	protected HtmlForm form1;
	protected HtmlSelectOneListbox listbox2;
	protected HtmlSelectOneListbox listbox3;
	protected HtmlSelectOneListbox listbox4;
	protected HtmlSelectOneListbox listbox5;
	protected HtmlCommandExButton bnotugir;
	protected HtmlCommandExButton bgeridon;
	protected HtmlSelectOneMenu menu1;
	protected HtmlCommandExButton bgetir;
	protected HtmlInputText text1;
	protected HtmlInputText text2;
	protected HtmlOutputText text3;
	protected HtmlSelectOneListbox listbox6;
	protected HtmlInputText text4;
	protected HtmlCommandExButton bara;
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

	protected HtmlSelectOneListbox getListbox5() {
		if (listbox5 == null) {
			listbox5 = (HtmlSelectOneListbox) findComponentInRoot("listbox5");
		}
		return listbox5;
	}

	protected HtmlCommandExButton getBnotugir() {
		if (bnotugir == null) {
			bnotugir = (HtmlCommandExButton) findComponentInRoot("bnotugir");
		}
		return bnotugir;
	}

	protected HtmlCommandExButton getBgeridon() {
		if (bgeridon == null) {
			bgeridon = (HtmlCommandExButton) findComponentInRoot("bgeridon");
		}
		return bgeridon;
	}

	public String doBgeridonAction() {
		list_dersler=null;
		ders_id=0;
		idler=null;
		list_ogrenci_ders=null;
		ogrenci_ders_id=0;
		vize="";
		finnal="";
		notu_gir_sonuc="";
		aranacak="";
		return "ogretmen_giris?faces-redirect=true";
	}

	protected HtmlSelectOneMenu getMenu1() {
		if (menu1 == null) {
			menu1 = (HtmlSelectOneMenu) findComponentInRoot("menu1");
		}
		return menu1;
	}

	protected HtmlCommandExButton getBgetir() {
		if (bgetir == null) {
			bgetir = (HtmlCommandExButton) findComponentInRoot("bgetir");
		}
		return bgetir;
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

	public List<Dersler> getList_dersler() {
		list_dersler=new Db().list_ogretmenin_tanimli_oldugu_dersleri_gonder(Session.kullanici_id);
		return list_dersler;
	}

	public int getDers_id() {
		return ders_id;
	}

	public void setDers_id(int ders_id) {
		this.ders_id = ders_id;
	}

	public int[] getIdler() {
		return idler;
	}

	public void setIdler(int[] idler) {
		this.idler = idler;
	}

	public List<Ogrenci_ders> getList_ogrenci_ders() {
		return list_ogrenci_ders;
	}

	public String doBgetirAction() {
		list_ogrenci_ders=new Db().list_dersin_aldigi_ogrencileri_getir(ders_id,Session.kullanici_id,"");
		return "";
	}

	public String doBnotugirAction() {
		try
		{
			int vize=Integer.parseInt(this.vize);
			int finnal=Integer.parseInt(this.finnal);
			if(vize<0 || vize>100 || finnal<0 || finnal>100)
			{
				notu_gir_sonuc="0-100 Arasinda Bir Sayi Giriniz";
				return "";
			}
			if(new Db().not_gir(vize, finnal, ogrenci_ders_id))
			{
				notu_gir_sonuc="Basarili";
				this.vize="";
				this.finnal="";
			}
			else
				notu_gir_sonuc="Hata Olustu";
			list_ogrenci_ders=new Db().list_dersin_aldigi_ogrencileri_getir(ders_id,Session.kullanici_id,"");
			
			
		}catch(Exception ex)
		{
			notu_gir_sonuc="0-100 Arasinda Bir Sayi Giriniz";
		}
		return "";
	}

	public int getOgrenci_ders_id() {
		return ogrenci_ders_id;
	}

	public void setOgrenci_ders_id(int ogrenci_ders_id) {
		this.ogrenci_ders_id = ogrenci_ders_id;
	}

	protected HtmlOutputText getText3() {
		if (text3 == null) {
			text3 = (HtmlOutputText) findComponentInRoot("text3");
		}
		return text3;
	}

	protected HtmlSelectOneListbox getListbox6() {
		if (listbox6 == null) {
			listbox6 = (HtmlSelectOneListbox) findComponentInRoot("listbox6");
		}
		return listbox6;
	}

	protected HtmlInputText getText4() {
		if (text4 == null) {
			text4 = (HtmlInputText) findComponentInRoot("text4");
		}
		return text4;
	}

	protected HtmlCommandExButton getBara() {
		if (bara == null) {
			bara = (HtmlCommandExButton) findComponentInRoot("bara");
		}
		return bara;
	}

	public String getAranacak() {
		return aranacak;
	}

	public void setAranacak(String aranacak) {
		this.aranacak = aranacak;
	}

	public String doBaraAction() {
		list_ogrenci_ders=new Db().list_dersin_aldigi_ogrencileri_getir(ders_id,Session.kullanici_id,aranacak);
		return "";
	}

	
	

	

}