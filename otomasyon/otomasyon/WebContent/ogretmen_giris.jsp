<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Ogretmen_giris.java" --%><%-- /jsf:pagecode --%>
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
		<table align="center" border=1>
			<tr>
				<td colspan=4><h4>Hos Geldiniz <h:outputText id="text2" styleClass="outputText" value="#{pc_Ogretmen_giris.ogretmen_adi_soyadi }"></h:outputText></h4></td>
			</tr>
			<tr>
				<td><h4><hx:outputLinkEx id="linkEx1" styleClass="outputLinkEx"
						value="notgirisi.jsp">
						<h:outputText id="text1" styleClass="outputText"
							value="Not Girisi"></h:outputText>
					</hx:outputLinkEx></h4></td>
					<td><h4><hx:outputLinkEx id="linkEx2" styleClass="outputLinkEx"
						value="ogretmen_bilgi_degis.jsp">
						<h:outputText id="text3" styleClass="outputText"
							value="Bilgilerini Duzenle"></h:outputText>
					</hx:outputLinkEx></h4></td>
					<td>
					<h4><hx:outputLinkEx id="linkEx3" styleClass="outputLinkEx"
						value="skala_degis.jsp">
						<h:outputText id="text4" styleClass="outputText"
							value="Skala Degis"></h:outputText>
					</hx:outputLinkEx></h4>
				</td>
				<td>
				<h4><hx:outputLinkEx id="linkEx4" styleClass="outputLinkEx"
						value="anasayfa.jsp">
						<h:outputText id="text5" styleClass="outputText" value="Cikis"></h:outputText>
					</hx:outputLinkEx></h4>
				</td>
			</tr>
			
		</table>

	</body>
</f:view>
</html>