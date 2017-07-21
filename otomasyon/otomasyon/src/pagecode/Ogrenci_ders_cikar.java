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

import com.db.Db;
import com.db.Ogrenci_ders;
import com.db.Ogrenciler;
import com.ibm.faces.component.html.HtmlCommandExButton;
/**
 * @author Emre
 *
 */
public class Ogrenci_ders_cikar extends PageCodeBase {
	String ogrenci_no;
	int ogrenci_id=0;
	int ogrenci_ders_id;
	List<Ogrenciler> list_ogrenciler;
	List<Ogrenci_ders> list_ogrenci_ders;
	String cikar_sonuc;
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

	public String getCikar_sonuc() {
		return cikar_sonuc;
	}

	public String getOgrenci_no() {
		return ogrenci_no;
	}

	public void setOgrenci_no(String ogrenci_no) {
		this.ogrenci_no = ogrenci_no;
	}

	public int getOgrenci_id() {
		return ogrenci_id;
	}

	public void setOgrenci_id(int ogrenci_id) {
		this.ogrenci_id = ogrenci_id;
	}

	public int getOgrenci_ders_id() {
		return ogrenci_ders_id;
	}

	public void setOgrenci_ders_id(int ogrenci_ders_id) {
		this.ogrenci_ders_id = ogrenci_ders_id;
	}

	public List<Ogrenciler> getList_ogrenciler() {
		return list_ogrenciler;
	}

	public List<Ogrenci_ders> getList_ogrenci_ders() {
		return list_ogrenci_ders;
	}

	protected HtmlInputText text1;
	protected HtmlForm form1;
	protected HtmlCommandExButton bara;
	protected HtmlSelectOneMenu menu1;
	protected HtmlCommandExButton bgetir;
	protected HtmlSelectOneMenu menu2;
	protected HtmlCommandExButton bcikar;
	protected HtmlCommandExButton bgeridon;
	protected HtmlOutputText text2;
	protected HtmlOutputText text3;
	protected HtmlOutputText text4;
	protected HtmlOutputText text5;
	protected HtmlOutputText text6;
	protected HtmlOutputText text7;

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

	protected HtmlCommandExButton getBara() {
		if (bara == null) {
			bara = (HtmlCommandExButton) findComponentInRoot("bara");
		}
		return bara;
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

	protected HtmlSelectOneMenu getMenu2() {
		if (menu2 == null) {
			menu2 = (HtmlSelectOneMenu) findComponentInRoot("menu2");
		}
		return menu2;
	}

	protected HtmlCommandExButton getBcikar() {
		if (bcikar == null) {
			bcikar = (HtmlCommandExButton) findComponentInRoot("bcikar");
		}
		return bcikar;
	}

	protected HtmlCommandExButton getBgeridon() {
		if (bgeridon == null) {
			bgeridon = (HtmlCommandExButton) findComponentInRoot("bgeridon");
		}
		return bgeridon;
	}

	public String doBgeridonAction() {
		ogrenci_no="";
		ogrenci_id=0;
		ogrenci_ders_id=0;
		list_ogrenciler=null;
		list_ogrenci_ders=null;
		cikar_sonuc="";
		return "yonetici_giris?faces-redirect=true";
	}

	public String doBaraAction() {
		list_ogrenciler = new Db().list_ogrenci_no_ara(ogrenci_no);
		return "";
	}

	public String doBgetirAction() {
		if(ogrenci_id==0) return "";
		list_ogrenci_ders=new Db().list_ogrencinin_aldigi_dersleri_gonder(ogrenci_id);
		return "";
	}

	public String doBcikarAction() {
		if(new Db().ogrenci_ders_cikar(ogrenci_ders_id))
		{
			cikar_sonuc="Basariyla Cikarildi";
			list_ogrenci_ders=null;
			doBgetirAction();
		}
		else
		{
			cikar_sonuc="Hata Olustu";
			
		}
		return "";
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

	protected HtmlOutputText getText7() {
		if (text7 == null) {
			text7 = (HtmlOutputText) findComponentInRoot("text7");
		}
		return text7;
	}

	public void onPageLoadBegin(FacesContext facescontext) {
		String[] eklenen=new Db().son_5_ders_cikar_gonder2();
		son_1=eklenen[0];
		son_2=eklenen[1];
		son_3=eklenen[2];
		son_4=eklenen[3];
		son_5=eklenen[4];
	}

}