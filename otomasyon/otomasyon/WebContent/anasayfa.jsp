<!DOCTYPE HTML>
<%-- jsf:pagecode language="java" location="/src/pagecode/Anasayfa.java" --%><%-- /jsf:pagecode --%><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<html>
<head>
<title>Ana Sayfa</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" title="Style"
	href="theme/stylesheet.css">
</head>
<f:view>
	<body background="arka3.jpg">
	<hx:scriptCollector preRender="#{pc_Anasayfa.onPageLoadBegin}">
			<h:form id="form1" styleClass="form">
				<table align="center">
					<tbody>
						<tr>
							<td>Kullanici Adi :</td>
							<td><h:inputText id="text1" styleClass="inputText"
									value="#{pc_Anasayfa.kullanici_adi }"></h:inputText></td>
						</tr>
						<tr>
							<td>Sifre :</td>
							<td><h:inputSecret id="secret1" styleClass="inputSecret"
									value="#{pc_Anasayfa.sifre }"></h:inputSecret></td>
						</tr>
						<tr>
							<td align="center"><hx:commandExButton type="submit"
									value="Giris" id="bgiris" styleClass="commandExButton"
									action="#{pc_Anasayfa.doBgirisAction}"></hx:commandExButton></td>
							<td><hx:commandExButton type="submit"
									value="Sifremi Unuttum" id="bunuttum"
									styleClass="commandExButton"
									action="#{pc_Anasayfa.doBunuttumAction}"></hx:commandExButton></td>
						</tr>
						<tr>
							<td colspan=2><h:outputText id="text2"
									styleClass="outputText" value="#{pc_Anasayfa.giris_sonuc }"></h:outputText></td>
						</tr>
					</tbody>
				</table>
			</h:form>
		</hx:scriptCollector>
	</body>
</f:view>
</html>