<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Ogrenci_ders_cikar.java" --%><%-- /jsf:pagecode --%>
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
	<hx:scriptCollector preRender="#{pc_Ogrenci_ders_cikar.onPageLoadBegin}">
		<h:form id="form1" styleClass="form">
		<table align=center>
			<tr>
			<td>
			<table border="1" align="center">
				<tbody>
					<tr>
						<td>Ogrenci No :</td>
						<td><h:inputText id="text1" styleClass="inputText" value="#{pc_Ogrenci_ders_cikar.ogrenci_no }"></h:inputText></td>
						<td><hx:commandExButton type="submit" value="Ara" id="bara"
								styleClass="commandExButton" action="#{pc_Ogrenci_ders_cikar.doBaraAction}"></hx:commandExButton></td>
					</tr>
					<tr>
						<td>Ogrenci Adi :</td>
						<td><h:selectOneMenu id="menu1" styleClass="selectOneMenu" value="#{pc_Ogrenci_ders_cikar.ogrenci_id }">
						<f:selectItems value="#{pc_Ogrenci_ders_cikar.list_ogrenciler }" var="abc"
						itemValue="#{abc.ogrenci_id }" itemLabel="#{abc.adi_soyadi }"/>
						</h:selectOneMenu></td>
						<td><hx:commandExButton type="submit" value="Dersleri Getir" id="bgetir"
								styleClass="commandExButton" action="#{pc_Ogrenci_ders_cikar.doBgetirAction}"></hx:commandExButton></td>
					</tr>
					<tr>
						<td>Dersler</td>
						<td><h:selectOneMenu id="menu2" styleClass="selectOneMenu" value="#{pc_Ogrenci_ders_cikar.ogrenci_ders_id }">
						<f:selectItems value="#{pc_Ogrenci_ders_cikar.list_ogrenci_ders }" var="abc"
						itemValue="#{abc.ogrenci_ders_id }" itemLabel="#{abc.ders_adi }"/>
						</h:selectOneMenu></td>
						<td></td>
					</tr>
					<tr>
						<td><hx:commandExButton type="submit" value="Dersi Cikar" id="bcikar"
								styleClass="commandExButton" action="#{pc_Ogrenci_ders_cikar.doBcikarAction}"></hx:commandExButton></td>
						<td><hx:commandExButton type="submit" value="Geri Don" id="bgeridon"
								styleClass="commandExButton" action="#{pc_Ogrenci_ders_cikar.doBgeridonAction}"></hx:commandExButton></td>
						<td></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text2" styleClass="outputText" value="#{pc_Ogrenci_ders_cikar.cikar_sonuc }"></h:outputText></td>
					</tr>
					
				</tbody>
			</table>
			<td>
			<table>
			<tr>
					<td colspan=2 align=center><h4>Son 5 Islem</h4></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text3" styleClass="outputText" value="#{pc_Ogrenci_ders_cikar.son_1 }"></h:outputText></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text4" styleClass="outputText" value="#{pc_Ogrenci_ders_cikar.son_2 }"></h:outputText></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text5" styleClass="outputText" value="#{pc_Ogrenci_ders_cikar.son_3 }"></h:outputText></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text6" styleClass="outputText" value="#{pc_Ogrenci_ders_cikar.son_4 }"></h:outputText></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text7" styleClass="outputText" value="#{pc_Ogrenci_ders_cikar.son_5 }"></h:outputText></td>
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