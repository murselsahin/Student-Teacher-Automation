<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Sifremi_unuttum.java" --%><%-- /jsf:pagecode --%>
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
		<h:form id="form1" styleClass="form">
			<table border="1" align="center">
				<tbody>
					<tr>
						<td>TC No :</td>
						<td><h:inputText id="text1" styleClass="inputText" value="#{pc_Sifremi_unuttum.tcno }"></h:inputText></td>
					</tr>
					<tr>
						<td>E-mail :</td>
						<td><h:inputText id="text3" styleClass="inputText" value="#{pc_Sifremi_unuttum.mail }"></h:inputText></td>
					</tr>
					<tr>
						<td>Yeni Kullanici Adi :</td>
						<td><h:inputText id="text2" styleClass="inputText" value="#{pc_Sifremi_unuttum.kullanici_adi }"></h:inputText></td>
					</tr>
					<tr>
						<td>Yeni Sifre :</td>
						<td><h:inputSecret id="secret1" styleClass="inputSecret" value="#{pc_Sifremi_unuttum.sifre }"></h:inputSecret></td>
					</tr>
					<tr>
						<td><hx:commandExButton type="submit" value="Guncelle" id="bguncelle"
								styleClass="commandExButton" action="#{pc_Sifremi_unuttum.doBguncelleAction}"></hx:commandExButton></td>
						<td><hx:commandExButton type="submit" value="Geri Don" id="bgeridon"
								styleClass="commandExButton" action="#{pc_Sifremi_unuttum.doBgeridonAction}"></hx:commandExButton></td>
					</tr>
					<tr>
						<td colspan=2><h:outputText id="text4" styleClass="outputText" value="#{pc_Sifremi_unuttum.guncelle_sonuc }"></h:outputText></td>
						
					</tr>
				</tbody>
			</table>
		</h:form>
	</body>
</f:view>
</html>