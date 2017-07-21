<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Ogretmen_ogrenci_ekle.java" --%><%-- /jsf:pagecode --%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" title="Style"
	href="theme/stylesheet.css">
</head>
<f:view>
	<body background="arka3.jpg">
	<hx:scriptCollector preRender="#{pc_Ogretmen_ogrenci_ekle.onPageLoadBegin}">
		<h:form id="form1" styleClass="form">
		<table align=center>
			<tr>
			<td>
			<table border="1" align="center">
				<tbody>
					<tr>
						<td>Adi :</td>
						<td><h:inputText id="text1" styleClass="inputText" value="#{pc_Ogretmen_ogrenci_ekle.adi }"></h:inputText></td>
					</tr>
					<tr>
						<td>Soyadi :</td>
						<td><h:inputText id="text2" styleClass="inputText" value="#{pc_Ogretmen_ogrenci_ekle.soyadi }"></h:inputText></td>
					</tr>
					<tr>
						<td>Bolumu :</td>
						<td><h:selectOneMenu id="menu1" styleClass="selectOneMenu" value="#{pc_Ogretmen_ogrenci_ekle.bolum_id }">
						<f:selectItems value="#{pc_Ogretmen_ogrenci_ekle.list_bolum }" var="abc"
						itemValue="#{abc.bolum_id }" itemLabel="#{abc.bolum_adi }"/>
						</h:selectOneMenu></td>
					</tr>
					<tr>
						<td>E-mail :</td>
						<td><h:inputText id="text3" styleClass="inputText" value="#{pc_Ogretmen_ogrenci_ekle.mail }"></h:inputText></td>
					</tr>
					<tr>
						<td>Tc No :</td>
						<td><h:inputText id="text4" styleClass="inputText" value="#{pc_Ogretmen_ogrenci_ekle.tcno }"></h:inputText></td>
					</tr>
					<tr>
						<td>Tip :</td>
						<td><h:selectOneRadio disabledClass="selectOneRadio_Disabled"
								enabledClass="selectOneRadio_Enabled" id="radio1"
								styleClass="selectOneRadio" value="#{pc_Ogretmen_ogrenci_ekle.tip }">
						<f:selectItem itemValue="1" itemLabel="Ogretmen"/>		
						<f:selectItem itemValue="0" itemLabel="Ogrenci"/>	
								</h:selectOneRadio></td>
					</tr>
					<tr>
						<td><hx:commandExButton type="submit" value="Ekle" id="bekle"
								styleClass="commandExButton" action="#{pc_Ogretmen_ogrenci_ekle.doBekleAction}"></hx:commandExButton></td>
						<td><hx:commandExButton type="submit" value="Geri Don" id="bgeridon"
								styleClass="commandExButton" action="#{pc_Ogretmen_ogrenci_ekle.doBgeridonAction}"></hx:commandExButton></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text5" styleClass="outputText" value="#{pc_Ogretmen_ogrenci_ekle.ekle_sonuc }"></h:outputText></td>
					</tr>
					
				</tbody>
			</table>
			<td>
			<table>
			<tr>
					<td colspan=2 align=center><h4>Son Eklenen 5 Kullanici</h4></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text6" styleClass="outputText" value="#{pc_Ogretmen_ogrenci_ekle.son_1 }"></h:outputText></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text7" styleClass="outputText" value="#{pc_Ogretmen_ogrenci_ekle.son_2 }"></h:outputText></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text8" styleClass="outputText" value="#{pc_Ogretmen_ogrenci_ekle.son_3 }"></h:outputText></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text9" styleClass="outputText" value="#{pc_Ogretmen_ogrenci_ekle.son_4 }"></h:outputText></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text10" styleClass="outputText" value="#{pc_Ogretmen_ogrenci_ekle.son_5 }"></h:outputText></td>
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