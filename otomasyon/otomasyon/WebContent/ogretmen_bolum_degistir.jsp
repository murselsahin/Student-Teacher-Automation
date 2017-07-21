<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Ogretmen_bolum_degistir.java" --%><%-- /jsf:pagecode --%>
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
			<table align="center">
				<tbody>
					<tr>
						<td>Ogretmen Adi :</td>
						<td><h:selectOneMenu onchange="submit()" id="menu1" styleClass="selectOneMenu" value="#{pc_Ogretmen_bolum_degistir.ogretmen_id }">
						<f:selectItems value="#{pc_Ogretmen_bolum_degistir.list_ogretmenler }" var="ogretmenler"
						itemValue="#{ogretmenler.ogretmen_id }" itemLabel="#{ogretmenler.adi_soyadi }"/>
						</h:selectOneMenu></td>
					</tr>
					<tr>
						<td colspan=2 align=center><h:outputText id="text1"
								styleClass="outputText" value="#{pc_Ogretmen_bolum_degistir.simdiki_bolum }"></h:outputText></td>
						
					</tr>
					<tr>
						<td>Yeni Bolumu :</td>
						<td><h:selectOneMenu id="menu2" styleClass="selectOneMenu" value="#{pc_Ogretmen_bolum_degistir.bolum_id }">
						<f:selectItems value="#{pc_Ogretmen_bolum_degistir.list_bolum }" var="bolumler"
						itemValue="#{bolumler.bolum_id }" itemLabel="#{bolumler.bolum_adi }"/>
						</h:selectOneMenu></td>
					</tr>
					<tr>
						<td><hx:commandExButton type="submit" value="Bolumu Degistir" id="bbolumdegis"
								styleClass="commandExButton" action="#{pc_Ogretmen_bolum_degistir.doBbolumdegisAction}"></hx:commandExButton></td>
						<td><hx:commandExButton type="submit" value="Geri Don" id="bgeridon"
								styleClass="commandExButton" action="#{pc_Ogretmen_bolum_degistir.doBgeridonAction}"></hx:commandExButton></td>
					</tr>
					<tr>
					<td colspan=2 align=center><h:outputText id="text2"
								styleClass="outputText" value="#{pc_Ogretmen_bolum_degistir.bolum_degistir_sonuc }"></h:outputText></td>
					</tr>
				</tbody>
			</table>
		</h:form>
	</body>
</f:view>
</html>