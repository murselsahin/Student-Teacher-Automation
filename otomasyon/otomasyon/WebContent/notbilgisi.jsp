<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Notbilgisi.java" --%><%-- /jsf:pagecode --%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" title="Style"
	href="theme/stylesheet.css">
</head>
<f:view>
	<body background="arka3.jpg">
		<h:form id="form1" styleClass="form">
			<table border="0" align="center">
				<tbody>
					<tr>
						<td>Ders</td>
						<td>Vize</td>
						<td>Final</td>
						<td>Ortalama</td>
						<td>Harf</td>
					</tr>
					<tr>
						<td><h:selectOneListbox id="listbox1"
								styleClass="selectOneListbox" size="18" value="#{pc_Notbilgisi.ders_id }">
						<f:selectItems value="#{pc_Notbilgisi.list_ogrenci_ders }" var="abc"
						itemValue="#{abc.ders_id }" itemLabel="#{abc.ders_adi }"/>		
								</h:selectOneListbox></td>
						<td><h:selectOneListbox id="listbox2"
								styleClass="selectOneListbox" size="18">
						<f:selectItems value="#{pc_Notbilgisi.list_ogrenci_ders }" var="abc"
						 itemLabel="#{abc.vize }"/>		
								</h:selectOneListbox></td>
						<td><h:selectOneListbox id="listbox3"
								styleClass="selectOneListbox" size="18">
						<f:selectItems value="#{pc_Notbilgisi.list_ogrenci_ders }" var="abc"
						 itemLabel="#{abc.finnal }"/>			
								</h:selectOneListbox></td>
						<td><h:selectOneListbox id="listbox4"
								styleClass="selectOneListbox" size="18">
						<f:selectItems value="#{pc_Notbilgisi.list_ogrenci_ders }" var="abc"
						 itemLabel="#{abc.ortalama }"/>		
								</h:selectOneListbox></td>
								<td><h:selectOneListbox id="listbox5"
								styleClass="selectOneListbox" size="18">
						<f:selectItems value="#{pc_Notbilgisi.list_ogrenci_ders }" var="abc"
						 itemLabel="#{abc.harf }"/>		
								</h:selectOneListbox></td>
					</tr>
					<tr>
						<td><hx:commandExButton type="submit" value="Ayrinti" id="bayrinti"
								styleClass="commandExButton" action="#{pc_Notbilgisi.doBayrintiAction}"></hx:commandExButton></td>
						<td><hx:commandExButton type="submit" value="Geri Don" id="bgeridon"
								styleClass="commandExButton" action="#{pc_Notbilgisi.doBgeridonAction}"></hx:commandExButton></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
				<tr>
				<td colspan=5>Dersin Adi : <h:outputText id="text1"
							styleClass="outputText" value="#{pc_Notbilgisi.ders_adi }"></h:outputText></td>
				</tr>
				<tr>
				<td colspan=5>Dersin Hocasi : <h:outputText id="text7"
							styleClass="outputText" value="#{pc_Notbilgisi.dersin_hocasi }"></h:outputText></td>
				</tr>
				<tr>
				<td colspan=5>Alan Kisi Sayisi : <h:outputText id="text2"
							styleClass="outputText" value="#{pc_Notbilgisi.alan_kisi_sayisi }"></h:outputText></td>
				</tr>
				<tr>
				<td colspan=5>Sinava Giren Kisi Sayisi : <h:outputText id="text6"
							styleClass="outputText" value="#{pc_Notbilgisi.sinava_giren_kisi_sayisi }"></h:outputText></td>
				</tr>
				<tr>
				<td colspan=5>Sinifin Ortalamasi : <h:outputText id="text3"
							styleClass="outputText" value="#{pc_Notbilgisi.sinifin_ortalamasi }"></h:outputText></td>
				</tr>
				<tr>
				<td colspan=5>En Yuksek Not : <h:outputText id="text4"
							styleClass="outputText" value="#{pc_Notbilgisi.en_yuksek_not }"></h:outputText></td>
				</tr>
				<tr>
				<td colspan=5><h:outputText id="text5" styleClass="outputText" value="#{pc_Notbilgisi.harf_bilgi }"></h:outputText></td>
				</tr>
				
				
			</table>
		</h:form>

	</body>
</f:view>
</html>