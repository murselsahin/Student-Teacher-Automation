<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Ogretmen_ders.java" --%><%-- /jsf:pagecode --%>
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
	
<hx:scriptCollector preRender="#{pc_Ogretmen_ders.onPageLoadBegin}">
		<h:form id="form1" styleClass="form">
		<table align=center>
			<tr>
			<td>
			<table border="0" align="center">
				<tbody>
					<tr>
						<td>Bolum Adi :</td>
						<td><h:selectOneMenu id="menu1" styleClass="selectOneMenu" value="#{pc_Ogretmen_ders.bolum_id }">
						<f:selectItems value="#{pc_Ogretmen_ders.list_bolumler }" var="bolumler"
						itemValue="#{bolumler.bolum_id }" itemLabel="#{bolumler.bolum_adi }"/>
						</h:selectOneMenu> </td>
						<td><hx:commandExButton type="submit" value="Ogretmenleri Getir" id="bogrgetir"
								styleClass="commandExButton" action="#{pc_Ogretmen_ders.doBogrgetirAction}"></hx:commandExButton></td>
					</tr>
					<tr>
						<td>Ogretmen Adi :</td>
						<td><h:selectOneMenu id="menu2" styleClass="selectOneMenu" value="#{pc_Ogretmen_ders.ogretmen_id }">
						<f:selectItems value="#{pc_Ogretmen_ders.list_ogretmenler }" var="ogretmenler"
						itemValue="#{ogretmenler.ogretmen_id }" itemLabel="#{ogretmenler.adi_soyadi }"/>
						</h:selectOneMenu></td>
						<td></td>
					</tr>
					<tr>
						<td>Alinmamis Dersler :</td>
						<td><h:selectOneMenu id="menu3" styleClass="selectOneMenu" value="#{pc_Ogretmen_ders.ders_id }">
						<f:selectItems value="#{pc_Ogretmen_ders.list_dersler }" var="dersler"
						itemValue="#{dersler.ders_id }" itemLabel="#{dersler.ders_adi }"/>
						</h:selectOneMenu></td>
						<td></td>
					</tr>
					<tr>
						<td><hx:commandExButton type="submit" value="Ogretmeni Tanimla" id="btanimla"
								styleClass="commandExButton" action="#{pc_Ogretmen_ders.doBtanimlaAction}"></hx:commandExButton></td>
						<td><hx:commandExButton type="submit" value="Geri Don" id="bgeridon"
								styleClass="commandExButton" action="#{pc_Ogretmen_ders.doBgeridonAction}"></hx:commandExButton></td>
						<td></td>
					</tr>
					<tr>
					<td colspan=2 align=center><h:outputText id="text1"
								styleClass="outputText" value="#{pc_Ogretmen_ders.tanimla_sonuc }"></h:outputText></td>
					</tr>
					
				</tbody>
			</table>
			<td>
			<table>
			<tr>
					<td colspan=2 align=center><h4>Son 5 Islem</h4></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text2" styleClass="outputText" value="#{pc_Ogretmen_ders.son_1 }"></h:outputText></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text3" styleClass="outputText" value="#{pc_Ogretmen_ders.son_2 }"></h:outputText></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text4" styleClass="outputText" value="#{pc_Ogretmen_ders.son_3 }"></h:outputText></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text5" styleClass="outputText" value="#{pc_Ogretmen_ders.son_4 }"></h:outputText></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text6" styleClass="outputText" value="#{pc_Ogretmen_ders.son_5 }"></h:outputText></td>
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