/**
 * 
 */
package pagecode;

import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;

import com.db.Bolumler;
import com.db.Db;
import com.ibm.faces.component.html.HtmlCommandExButton;
/**
 * @author sahin
 *
 */
public class Dersekle extends PageCodeBase {

	int bolum_id;
	String ders_adi;
	List<Bolumler> list_bolum;
	String skredi;
	String ekle_sonuc;
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
	protected HtmlInputText text1;
	protected HtmlCommandExButton bekle;
	protected HtmlCommandExButton bgeridon;
	protected HtmlInputText text2;
	protected HtmlOutputText text3;
	protected HtmlOutputText text4;
	protected HtmlOutputText text5;
	protected HtmlOutputText text6;
	protected HtmlOutputText text7;
	protected HtmlOutputText text8;
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

	protected HtmlInputText getText1() {
		if (text1 == null) {
			text1 = (HtmlInputText) findComponentInRoot("text1");
		}
		return text1;
	}

	protected HtmlCommandExButton getBekle() {
		if (bekle == null) {
			bekle = (HtmlCommandExButton) findComponentInRoot("bekle");
		}
		return bekle;
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

	public String getDers_adi() {
		
		return ders_adi;
	}

	public void setDers_adi(String ders_adi) {
		this.ders_adi = ders_adi;
	}

	public String doBekleAction() {
		try
		{
			
			int kredi=Integer.parseInt(skredi);
			if(kredi>0 && ders_adi.length()>0 && bolum_id>0)
				if(new Db().ders_ekle(kredi,bolum_id,ders_adi))
				{
					ekle_sonuc=ders_adi+" Basariyla Eklendi";
					ders_adi="";
					skredi="";
				}
				else
				{
					ekle_sonuc="Sorun var";
					
				}
				
		}catch(Exception ex)
		{
			ekle_sonuc="Sorun var";
			System.out.println(ex+"");
		}
		return "";
	}

	public String doBgeridonAction() {
		bolum_id=0;
		ders_adi="";
		list_bolum=null;
		skredi="";
		ekle_sonuc="";
		return "yonetici_giris?faces-redirect=true";
	}

	public List<Bolumler> getList_bolum() {
		list_bolum=new Db().list_bolum_gonder();
		return list_bolum;
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

	public String getEkle_sonuc() {
		return ekle_sonuc;
	}

	protected HtmlOutputText getText3() {
		if (text3 == null) {
			text3 = (HtmlOutputText) findComponentInRoot("text3");
		}
		return text3;
	}

	public void onPageLoadBegin(FacesContext facescontext) {
		String[] eklenen=new Db().son_5_ders_eklenen_gonder();
		son_1=eklenen[0];
		son_2=eklenen[1];
		son_3=eklenen[2];
		son_4=eklenen[3];
		son_5=eklenen[4];
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

	

}