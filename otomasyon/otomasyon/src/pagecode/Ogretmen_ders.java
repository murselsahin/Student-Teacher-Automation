/**
 * 
 */
package pagecode;

import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;

import com.db.Bolumler;
import com.db.Db;
import com.db.Dersler;
import com.db.Ogretmenler;
import com.ibm.faces.component.html.HtmlCommandExButton;
/**
 
 * @author sahin
 *
 */
public class Ogretmen_ders extends PageCodeBase {

	int bolum_id;
	int ogretmen_id;
	int ders_id;
	List<Bolumler> list_bolumler;
	List<Ogretmenler> list_ogretmenler;
	List<Dersler> list_dersler;
	String tanimla_sonuc;
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

	protected HtmlSelectOneMenu menu1;
	protected HtmlForm form1;
	protected HtmlCommandExButton bogrgetir;
	protected HtmlSelectOneMenu menu2;
	protected HtmlSelectOneMenu menu3;
	protected HtmlCommandExButton btanimla;
	protected HtmlCommandExButton bgeridon;
	protected HtmlOutputText text1;
	protected HtmlOutputText text2;
	protected HtmlOutputText text3;
	protected HtmlOutputText text4;
	protected HtmlOutputText text5;
	protected HtmlOutputText text6;

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

	protected HtmlCommandExButton getBogrgetir() {
		if (bogrgetir == null) {
			bogrgetir = (HtmlCommandExButton) findComponentInRoot("bogrgetir");
		}
		return bogrgetir;
	}

	protected HtmlSelectOneMenu getMenu2() {
		if (menu2 == null) {
			menu2 = (HtmlSelectOneMenu) findComponentInRoot("menu2");
		}
		return menu2;
	}

	protected HtmlSelectOneMenu getMenu3() {
		if (menu3 == null) {
			menu3 = (HtmlSelectOneMenu) findComponentInRoot("menu3");
		}
		return menu3;
	}

	protected HtmlCommandExButton getBtanimla() {
		if (btanimla == null) {
			btanimla = (HtmlCommandExButton) findComponentInRoot("btanimla");
		}
		return btanimla;
	}

	protected HtmlCommandExButton getBgeridon() {
		if (bgeridon == null) {
			bgeridon = (HtmlCommandExButton) findComponentInRoot("bgeridon");
		}
		return bgeridon;
	}

	public int getBolum_id() {
		return bolum_id;
	}

	public void setBolum_id(int bolum_id) {
		this.bolum_id = bolum_id;
	}

	public int getOgretmen_id() {
		return ogretmen_id;
	}

	public void setOgretmen_id(int ogretmen_id) {
		this.ogretmen_id = ogretmen_id;
	}

	public int getDers_id() {
		return ders_id;
	}

	public void setDers_id(int ders_id) {
		this.ders_id = ders_id;
	}

	public String doBogrgetirAction() {
		
		list_ogretmenler = new Db().list_ogretmen_gonder(bolum_id);
		list_dersler = new Db().list_alinmamis_ders_gonder(bolum_id);
		return "";
	}

	public String doBtanimlaAction() {
		if(new Db().ogretmen_ders_tanimla(ogretmen_id, ders_id))
		{
			tanimla_sonuc="Ogretmen-Ders İliskisi Saglandi";
			list_dersler = new Db().list_alinmamis_ders_gonder(bolum_id);
		}
		else
			tanimla_sonuc="İslem Basarisiz";
		return "";
	}

	public String doBgeridonAction() {
		bolum_id=0;
		ogretmen_id=0;
		ders_id=0;
		list_bolumler=null;
		list_ogretmenler=null;
		list_dersler=null;
		tanimla_sonuc="";
		return "yonetici_giris?faces-redirect=true";
	}

	public List<Bolumler> getList_bolumler() {
		list_bolumler=new Db().list_bolum_gonder();
		
		return list_bolumler;
	}

	public List<Ogretmenler> getList_ogretmenler() {
		return list_ogretmenler;
	}

	public List<Dersler> getList_dersler() {
		return list_dersler;
	}

	public String getTanimla_sonuc() {
		return tanimla_sonuc;
	}

	protected HtmlOutputText getText1() {
		if (text1 == null) {
			text1 = (HtmlOutputText) findComponentInRoot("text1");
		}
		return text1;
	}

	public void onPageLoadBegin(FacesContext facescontext) {
		
		String[] eklenen=new Db().son_5_ogretmen_ders_ekle_gonder();
		son_1=eklenen[0];
		son_2=eklenen[1];
		son_3=eklenen[2];
		son_4=eklenen[3];
		son_5=eklenen[4];
		
		
	}

	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
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

}