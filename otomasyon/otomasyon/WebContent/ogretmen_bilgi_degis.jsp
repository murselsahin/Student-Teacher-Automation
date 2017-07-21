<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Ogretmen_bilgi_degis.java" --%><%-- /jsf:pagecode --%>
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
						<td>Yeni Kullanici Adin :</td>
						<td><h:inputText id="text1" styleClass="inputText" value="#{pc_Ogretmen_bilgi_degis.kullanici_adi }"></h:inputText></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>Yeni Sifren :</td>
						<td><h:inputSecret id="secret1" styleClass="inputSecret" value="#{pc_Ogretmen_bilgi_degis.sifre }"></h:inputSecret></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td><hx:commandExButton type="submit" value="Bilgierini Degis" id="bdegis"
								styleClass="commandExButton" action="#{pc_Ogretmen_bilgi_degis.doBdegisAction}"></hx:commandExButton></td>
						<td><hx:commandExButton type="submit" value="Geri Don" id="bgeridon"
								styleClass="commandExButton" action="#{pc_Ogretmen_bilgi_degis.doBgeridonAction}"></hx:commandExButton></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td><h:outputText id="text2" styleClass="outputText" value="#{pc_Ogretmen_bilgi_degis.degis_sonuc }"></h:outputText></td>
					</tr>
				</tbody>
			</table>
		</h:form>
	</body>
</f:view>
</html>