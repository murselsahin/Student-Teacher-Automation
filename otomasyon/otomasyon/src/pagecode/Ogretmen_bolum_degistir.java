/**
 * 
 */
package pagecode;

import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;

import com.db.Bolumler;
import com.db.Db;
import com.db.Ogretmenler;
import com.ibm.faces.component.html.HtmlCommandExButton;
/**
 * @author sahin
 *
 */
public class Ogretmen_bolum_degistir extends PageCodeBase {

	int ogretmen_id;
	String simdiki_bolum;
	int bolum_id;
	List<Ogretmenler> list_ogretmenler;
	List<Bolumler> list_bolum;
	String bolum_degistir_sonuc;
	protected HtmlSelectOneMenu menu1;
	protected HtmlForm form1;
	protected HtmlOutputText text1;
	protected HtmlSelectOneMenu menu2;
	protected HtmlCommandExButton bbolumdegis;
	protected HtmlCommandExButton bgeridon;
	protected HtmlOutputText text2;

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

	protected HtmlOutputText getText1() {
		if (text1 == null) {
			text1 = (HtmlOutputText) findComponentInRoot("text1");
		}
		return text1;
	}

	protected HtmlSelectOneMenu getMenu2() {
		if (menu2 == null) {
			menu2 = (HtmlSelectOneMenu) findComponentInRoot("menu2");
		}
		return menu2;
	}

	protected HtmlCommandExButton getBbolumdegis() {
		if (bbolumdegis == null) {
			bbolumdegis = (HtmlCommandExButton) findComponentInRoot("bbolumdegis");
		}
		return bbolumdegis;
	}

	protected HtmlCommandExButton getBgeridon() {
		if (bgeridon == null) {
			bgeridon = (HtmlCommandExButton) findComponentInRoot("bgeridon");
		}
		return bgeridon;
	}

	public String doBbolumdegisAction() {
		if(new Db().ogretmen_bolum_degistir(ogretmen_id, bolum_id))
			bolum_degistir_sonuc="Basarili";
		else
			bolum_degistir_sonuc="Basarisiz";
		return "";
	}

	public String doBgeridonAction() {
		ogretmen_id=0;
		simdiki_bolum="";
		bolum_id=0;
		list_ogretmenler=null;
		list_bolum=null;
		bolum_degistir_sonuc="";

		return "yonetici_giris?faces-redirect=true";
	}

	public int getOgretmen_id() {
		return ogretmen_id;
	}

	public void setOgretmen_id(int ogretmen_id) {
		this.ogretmen_id = ogretmen_id;
	}

	public int getBolum_id() {
		return bolum_id;
	}

	public void setBolum_id(int bolum_id) {
		this.bolum_id = bolum_id;
	}

	public String getSimdiki_bolum() {
		simdiki_bolum="Simdiki Bolum : "+new Db().bolum_adi_gonder(ogretmen_id);
		return simdiki_bolum;
	}

	public List<Ogretmenler> getList_ogretmenler() {
		list_ogretmenler=new Db().list_tum_ogretmenleri_gonder();
		return list_ogretmenler;
	}

	public List<Bolumler> getList_bolum() {
		list_bolum=new Db().list_bolum_gonder();
		return list_bolum;
	}

	public String getBolum_degistir_sonuc() {
		return bolum_degistir_sonuc;
	}

	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
	}

}