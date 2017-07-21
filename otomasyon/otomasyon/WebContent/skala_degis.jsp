<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Skala_degis.java" --%><%-- /jsf:pagecode --%>
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
			<table border="1" align="center">
				<tbody>
					<tr>
						<td>Ders Adi :</td>
						<td><h:selectOneMenu id="menu1" styleClass="selectOneMenu" value="#{pc_Skala_degis.ogretmen_ders_id }">
						<f:selectItems value="#{pc_Skala_degis.list_ogretmen_ders }" var="abc"
						itemValue="#{abc.ogretmen_ders_id }" itemLabel="#{abc.ders_adi }"/>
						</h:selectOneMenu></td>
						<td><hx:commandExButton type="submit" value="Getir" id="bgetir"
								styleClass="commandExButton" action="#{pc_Skala_degis.doBgetirAction}"></hx:commandExButton></td>
					</tr>
				</tbody>
			</table>
			<table border="1" align=center>
				<tbody>
					<tr>
						<td>AA : </td>
						<td><h:inputText id="text2" styleClass="inputText" size="3" value="#{pc_Skala_degis.saa }"></h:inputText></td>
					</tr>
					<tr>
						<td>BA : </td>
						<td><h:inputText id="text3" styleClass="inputText" size="3" value="#{pc_Skala_degis.sba }"></h:inputText></td>
					</tr>
					<tr>
						<td>BB : </td>
						<td><h:inputText id="text4" styleClass="inputText" size="3" value="#{pc_Skala_degis.sbb }"></h:inputText></td>
					</tr>
					<tr>
						<td>CB : </td>
						<td><h:inputText id="text5" styleClass="inputText" size="3" value="#{pc_Skala_degis.scb }"></h:inputText></td>
					</tr>
					<tr>
						<td>CC : </td>
						<td><h:inputText id="text6" styleClass="inputText" size="3" value="#{pc_Skala_degis.scc }"></h:inputText></td>
					</tr>
					<tr>
						<td>DC : </td>
						<td><h:inputText id="text7" styleClass="inputText" size="3" value="#{pc_Skala_degis.sdc }"></h:inputText></td>
					</tr>
					<tr>
						<td>DD : </td>
						<td><h:inputText id="text8" styleClass="inputText" size="3" value="#{pc_Skala_degis.sdd }"></h:inputText></td>
					</tr>
					<tr>
						<td>FD : </td>
						<td><h:inputText id="text9" styleClass="inputText" size="3" value="#{pc_Skala_degis.sfd }"></h:inputText></td>
					</tr>
					
				</tbody>
			</table>
			<table align=center>
			<tr>
			<td><hx:commandExButton type="submit" value="Degis" id="bskaladegis"
							styleClass="commandExButton" action="#{pc_Skala_degis.doBskaladegisAction}"></hx:commandExButton></td>
			<td><hx:commandExButton type="submit" value="Geri Don" id="bgeridon"
							styleClass="commandExButton" action="#{pc_Skala_degis.doBgeridonAction}"></hx:commandExButton></td>
			</tr>
			<tr>
			<td colspan=2><h:outputText id="text1" styleClass="outputText" value="#{pc_Skala_degis.degis_sonuc }"></h:outputText></td>
			</tr>
			</table>
		</h:form>

	</body>
</f:view>
</html>