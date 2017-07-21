/**
 * 
 */
package pagecode;

import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;

import com.db.Bolumler;
import com.db.Db;
import com.db.Dersler;
import com.ibm.faces.component.html.HtmlCommandExButton;
/**
 * @author sahin
 *
 */
public class Dersduzenle extends PageCodeBase {
	int bolum_id;
	int ders_id;
	int yeni_bolum_id;
	String yeni_ders_adi;
	List<Bolumler> list_bolumler;
	List<Dersler> list_dersler;
	String skredi;
	String duzenle_sonuc;
	protected HtmlSelectOneMenu menu1;
	protected HtmlForm form1;
	protected HtmlCommandExButton bdersgetir;
	protected HtmlSelectOneMenu menu2;
	protected HtmlSelectOneMenu menu3;
	protected HtmlInputText text1;
	protected HtmlCommandExButton bduzenle;
	protected HtmlCommandExButton bgeridon;
	protected HtmlInputText text2;
	protected HtmlOutputText text3;
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

	protected HtmlCommandExButton getBdersgetir() {
		if (bdersgetir == null) {
			bdersgetir = (HtmlCommandExButton) findComponentInRoot("bdersgetir");
		}
		return bdersgetir;
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

	protected HtmlInputText getText1() {
		if (text1 == null) {
			text1 = (HtmlInputText) findComponentInRoot("text1");
		}
		return text1;
	}

	protected HtmlCommandExButton getBduzenle() {
		if (bduzenle == null) {
			bduzenle = (HtmlCommandExButton) findComponentInRoot("bduzenle");
		}
		return bduzenle;
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

	public int getDers_id() {
		return ders_id;
	}

	public void setDers_id(int ders_id) {
		this.ders_id = ders_id;
	}

	public int getYeni_bolum_id() {
		return yeni_bolum_id;
	}

	public void setYeni_bolum_id(int yeni_bolum_id) {
		this.yeni_bolum_id = yeni_bolum_id;
	}

	public String getYeni_ders_adi() {
		return yeni_ders_adi;
	}

	public void setYeni_ders_adi(String yeni_ders_adi) {
		this.yeni_ders_adi = yeni_ders_adi;
	}

	public String doBdersgetirAction() {
		list_dersler=new Db().ders_gonder(bolum_id);
		return "";
	}

	public String doBduzenleAction() {
		try
		{
			int kredi=Integer.parseInt(skredi);
			if(kredi>0 && yeni_bolum_id>0 && yeni_ders_adi.length()>0 && ders_id>0)
				if(new Db().ders_update(yeni_bolum_id, kredi, yeni_ders_adi, ders_id))
				{
					duzenle_sonuc=yeni_ders_adi+" Basariyla Guncellendi";
					yeni_ders_adi="";
					skredi="";
				}
				else
				{
					duzenle_sonuc="Sorun Olustu";
				}
		}catch(Exception ex)
		{
			System.out.println(ex+"");
			duzenle_sonuc="Sorun Olustu";
		}
		return "";
	}

	public String doBgeridonAction() {
		list_bolumler=null;
		list_dersler=null;
		bolum_id=0;
		ders_id=0;
		yeni_bolum_id=0;
		yeni_ders_adi="";
		skredi="";
		duzenle_sonuc="";
		return "yonetici_giris?faces-redirect=true";
		
	}

	public List<Bolumler> getList_bolumler() {
		list_bolumler=new Db().list_bolum_gonder();
		return list_bolumler;
	}

	public List<Dersler> getList_dersler() {
		return list_dersler;
	}

	protected HtmlInputText getText2() {
		if (text2 == null) {
			text2 = (HtmlInputText) findComponentInRoot("text2");
		}
		return text2;
	}

	public String getSkredi() {
		return skredi;
	}

	public void setSkredi(String skredi) {
		this.skredi = skredi;
	}

	protected HtmlOutputText getText3() {
		if (text3 == null) {
			text3 = (HtmlOutputText) findComponentInRoot("text3");
		}
		return text3;
	}

	public String getDuzenle_sonuc() {
		return duzenle_sonuc;
	}

}