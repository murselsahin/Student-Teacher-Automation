/**
 * 
 */
package pagecode;

import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;

import com.db.Db;
import com.db.Ogretmen_ders;
import com.ibm.faces.component.html.HtmlCommandExButton;
import com.session.Session;

/**
 * @author Emre
 *
 */
public class Skala_degis extends PageCodeBase {
	String saa,sba,sbb,scb,scc,sdc,sdd,sfd;
	int ogretmen_ders_id;
	List<Ogretmen_ders> list_ogretmen_ders;
	String degis_sonuc;

	protected HtmlSelectOneMenu menu1;
	protected HtmlForm form1;
	protected HtmlCommandExButton bgetir;
	protected HtmlCommandExButton bskaladegis;
	protected HtmlCommandExButton bgeridon;
	protected HtmlOutputText text1;
	protected HtmlInputText text2;
	protected HtmlInputText text3;
	protected HtmlInputText text4;
	protected HtmlInputText text5;
	protected HtmlInputText text6;
	protected HtmlInputText text7;
	protected HtmlInputText text8;
	protected HtmlInputText text9;
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

	protected HtmlCommandExButton getBgetir() {
		if (bgetir == null) {
			bgetir = (HtmlCommandExButton) findComponentInRoot("bgetir");
		}
		return bgetir;
	}

	protected HtmlCommandExButton getBskaladegis() {
		if (bskaladegis == null) {
			bskaladegis = (HtmlCommandExButton) findComponentInRoot("bskaladegis");
		}
		return bskaladegis;
	}

	protected HtmlCommandExButton getBgeridon() {
		if (bgeridon == null) {
			bgeridon = (HtmlCommandExButton) findComponentInRoot("bgeridon");
		}
		return bgeridon;
	}

	protected HtmlOutputText getText1() {
		if (text1 == null) {
			text1 = (HtmlOutputText) findComponentInRoot("text1");
		}
		return text1;
	}

	protected HtmlInputText getText2() {
		if (text2 == null) {
			text2 = (HtmlInputText) findComponentInRoot("text2");
		}
		return text2;
	}

	protected HtmlInputText getText3() {
		if (text3 == null) {
			text3 = (HtmlInputText) findComponentInRoot("text3");
		}
		return text3;
	}

	protected HtmlInputText getText4() {
		if (text4 == null) {
			text4 = (HtmlInputText) findComponentInRoot("text4");
		}
		return text4;
	}

	protected HtmlInputText getText5() {
		if (text5 == null) {
			text5 = (HtmlInputText) findComponentInRoot("text5");
		}
		return text5;
	}

	protected HtmlInputText getText6() {
		if (text6 == null) {
			text6 = (HtmlInputText) findComponentInRoot("text6");
		}
		return text6;
	}

	protected HtmlInputText getText7() {
		if (text7 == null) {
			text7 = (HtmlInputText) findComponentInRoot("text7");
		}
		return text7;
	}

	protected HtmlInputText getText8() {
		if (text8 == null) {
			text8 = (HtmlInputText) findComponentInRoot("text8");
		}
		return text8;
	}

	protected HtmlInputText getText9() {
		if (text9 == null) {
			text9 = (HtmlInputText) findComponentInRoot("text9");
		}
		return text9;
	}

	public String getSaa() {
		return saa;
	}

	public void setSaa(String saa) {
		this.saa = saa;
	}

	public String getSba() {
		return sba;
	}

	public void setSba(String sba) {
		this.sba = sba;
	}

	public String getSbb() {
		return sbb;
	}

	public void setSbb(String sbb) {
		this.sbb = sbb;
	}

	public String getScb() {
		return scb;
	}

	public void setScb(String scb) {
		this.scb = scb;
	}

	public String getScc() {
		return scc;
	}

	public void setScc(String scc) {
		this.scc = scc;
	}

	public String getSdc() {
		return sdc;
	}

	public void setSdc(String sdc) {
		this.sdc = sdc;
	}

	public String getSdd() {
		return sdd;
	}

	public void setSdd(String sdd) {
		this.sdd = sdd;
	}

	public String getSfd() {
		return sfd;
	}

	public void setSfd(String sfd) {
		this.sfd = sfd;
	}

	public int getOgretmen_ders_id() {
		return ogretmen_ders_id;
	}

	public void setOgretmen_ders_id(int ogretmen_ders_id) {
		
		this.ogretmen_ders_id = ogretmen_ders_id;
		
	
	}

	public List<Ogretmen_ders> getList_ogretmen_ders() {
		list_ogretmen_ders = new Db().list_ogretmen_ders(Session.kullanici_id);
		return list_ogretmen_ders;
	}

	public String doBgetirAction() {
		String[] skala=new Db().ogretmen_ders_idden_skala_dondur(ogretmen_ders_id);
		saa=skala[0];
		sba=skala[1];
		sbb=skala[2];
		scb=skala[3];
		scc=skala[4];
		sdc=skala[5];
		sdd=skala[6];
		sfd=skala[7];
		return "";
	}

	public String getDegis_sonuc() {
		return degis_sonuc;
	}

	public String doBskaladegisAction() {
		try
		{
			
			int aa=Integer.parseInt(saa);
			int ba=Integer.parseInt(sba);
			int bb=Integer.parseInt(sbb);
			int cb=Integer.parseInt(scb);
			int cc=Integer.parseInt(scc);
			int dc=Integer.parseInt(sdc);
			int dd=Integer.parseInt(sdd);
			int fd=Integer.parseInt(sfd);
			
			if(aa>ba && ba>bb && bb>cb && cb>cc && cc>dc && dc>dd && dd>fd
					&& aa<=100 && fd>=5)
			{
				int skala[] = new int[8];
				skala[0]=aa;
				skala[1]=ba;
				skala[2]=bb;
				skala[3]=cb;
				skala[4]=cc;
				skala[5]=dc;
				skala[6]=dd;
				skala[7]=fd;
				if(new Db().skala_guncelle(ogretmen_ders_id,skala))
					degis_sonuc="Basariyla Guncellendi";
				else
					degis_sonuc="Hata Olustu";
				
			}else
			{
				degis_sonuc="Sayilarda Yanlislik Var";
			}
				
			
		}catch(Exception ex)
		{
			degis_sonuc="Lutfen Sayi Giriniz";
		}
		return "";
	}

	public String doBgeridonAction() {
		saa="";sba="";sbb="";scb="";scc="";sdc="";sdd="";sfd="";
		ogretmen_ders_id=0;
		list_ogretmen_ders=null;
		degis_sonuc="";
		return "ogretmen_giris?faces-redirect=true";
	}

}