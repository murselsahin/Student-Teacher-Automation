/**
 * 
 */
package pagecode;

import javax.faces.component.html.HtmlOutputText;

import com.db.Db;
import com.ibm.faces.component.html.HtmlOutputLinkEx;
import com.session.Session;
/**
 * @author sahin
 *
 */
public class Ogretmen_giris extends PageCodeBase {

	String ogretmen_adi_soyadi;
	protected HtmlOutputLinkEx linkEx1;
	protected HtmlOutputText text1;
	protected HtmlOutputText text2;
	protected HtmlOutputLinkEx linkEx2;
	protected HtmlOutputText text3;
	protected HtmlOutputLinkEx linkEx3;
	protected HtmlOutputText text4;
	protected HtmlOutputLinkEx linkEx4;
	protected HtmlOutputText text5;
	protected HtmlOutputLinkEx getLinkEx1() {
		if (linkEx1 == null) {
			linkEx1 = (HtmlOutputLinkEx) findComponentInRoot("linkEx1");
		}
		return linkEx1;
	}

	protected HtmlOutputText getText1() {
		if (text1 == null) {
			text1 = (HtmlOutputText) findComponentInRoot("text1");
		}
		return text1;
	}

	public String getOgretmen_adi_soyadi() {
		ogretmen_adi_soyadi=new Db().ogretmen_adi_soyadi_gonder(Session.kullanici_id);
		return ogretmen_adi_soyadi;
	}

	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
	}

	protected HtmlOutputLinkEx getLinkEx2() {
		if (linkEx2 == null) {
			linkEx2 = (HtmlOutputLinkEx) findComponentInRoot("linkEx2");
		}
		return linkEx2;
	}

	protected HtmlOutputText getText3() {
		if (text3 == null) {
			text3 = (HtmlOutputText) findComponentInRoot("text3");
		}
		return text3;
	}

	protected HtmlOutputLinkEx getLinkEx3() {
		if (linkEx3 == null) {
			linkEx3 = (HtmlOutputLinkEx) findComponentInRoot("linkEx3");
		}
		return linkEx3;
	}

	protected HtmlOutputText getText4() {
		if (text4 == null) {
			text4 = (HtmlOutputText) findComponentInRoot("text4");
		}
		return text4;
	}

	protected HtmlOutputLinkEx getLinkEx4() {
		if (linkEx4 == null) {
			linkEx4 = (HtmlOutputLinkEx) findComponentInRoot("linkEx4");
		}
		return linkEx4;
	}

	protected HtmlOutputText getText5() {
		if (text5 == null) {
			text5 = (HtmlOutputText) findComponentInRoot("text5");
		}
		return text5;
	}

}