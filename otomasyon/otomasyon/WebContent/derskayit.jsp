<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Derskayit.java" --%><%-- /jsf:pagecode --%>
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
	<hx:scriptCollector preRender="#{pc_Derskayit.onPageLoadBegin}">
		<h:form id="form1" styleClass="form">
		<table align=center>
			<tr>
			<td>
		
			<table align="center">
				<tbody>
					<tr>
						<td colspan="2" align="center">Hosgeldiniz <h:outputText
								id="text1" styleClass="outputText" value="#{pc_Ogrenci_giris.ogrenci_adi_soyadi }"></h:outputText></td>
					</tr>
					<tr>
						<td colspan="2" align="center">Kalan Kredi Hakkiniz :<h:outputText
								id="text2" styleClass="outputText" value="#{pc_Derskayit.kalan_kredi }"></h:outputText></td>

					</tr>
					<tr>
						<td>Almadigin Dersler :</td>
						<td><h:selectOneMenu id="menu1" styleClass="selectOneMenu" value="#{pc_Derskayit.ders_id }">
						<f:selectItems value="#{pc_Derskayit.list_dersler }" var="dersler"
						itemValue="#{dersler.ders_id }" itemLabel="#{dersler.ders_adi }"/>
						</h:selectOneMenu></td>
						<td>
						<h:commandButton type="submit" value="Dersin Kredisi" id="bkredigetir"
								styleClass="commandButton" action="#{pc_Derskayit.doBkredigetirAction}"></h:commandButton>
						</td>
					</tr>
					<tr>
						<td colspan=2>Dersin Kredisi : <h:outputText id="text3"
								styleClass="outputText" value="#{pc_Derskayit.dersin_kredisi }"></h:outputText></td>
						
					</tr>
					<tr>
						<td><hx:commandExButton type="submit" value="Kayit Yap" id="bkayit"
								styleClass="commandExButton" action="#{pc_Derskayit.doBkayitAction}"></hx:commandExButton></td>
						<td><hx:commandExButton type="submit" value="Geri Don" id="bgeridon"
								styleClass="commandExButton" action="#{pc_Derskayit.doBgeridonAction}"></hx:commandExButton></td>
					</tr>
					<tr>
					<td colspan=2 align=center><h:outputText id="text4"
								styleClass="outputText" value="#{pc_Derskayit.kayit_sonuc }"></h:outputText></td>
					</tr>
					
					
				</tbody>
			</table>
			<td>
			<table>
			<tr>
					<td colspan=2 align=center><h4>Son 5 Ders Kaydi</h4></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text6" styleClass="outputText" value="#{pc_Derskayit.sonuc_1 }"></h:outputText></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text7" styleClass="outputText" value="#{pc_Derskayit.sonuc_2 }"></h:outputText></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text8" styleClass="outputText" value="#{pc_Derskayit.sonuc_3 }"></h:outputText></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text9" styleClass="outputText" value="#{pc_Derskayit.sonuc_4 }"></h:outputText></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text10" styleClass="outputText" value="#{pc_Derskayit.sonuc_5 }"></h:outputText></td>
					</tr>
			</table>
			</td>
			</td>
			</tr>
			</table>
		</h:form>
</hx:scriptCollector>
	</body>
</f:view>
</html>