<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Yonetici_giris.java" --%><%-- /jsf:pagecode --%>
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
		<table align=center>
		<tr>
		<td align=center><h3></h3></td>
		<td align=center><h3></h3></td>
		<td></td>
		
		</tr>
		<tr>
		<td>
				<h4><hx:outputLinkEx id="linkEx1" styleClass="outputLinkEx"
					value="dersekle.jsp">
					<h:outputText id="text1" styleClass="outputText"
						value="Ders Tanimla"></h:outputText>
				</hx:outputLinkEx></h4>
		
		</td>
		<td>
		<h4><hx:outputLinkEx id="linkEx3" styleClass="outputLinkEx" value="ogretmen_ders.jsp">
						<h:outputText id="text3" styleClass="outputText"
							value="Ogretmen-Ders Tanimla"></h:outputText>
					</hx:outputLinkEx></h4>
				</td>
		<td>
		<h4><hx:outputLinkEx id="linkEx7" styleClass="outputLinkEx"
						value="ogretmen_ogrenci_ekle.jsp">
						<h:outputText id="text7" styleClass="outputText"
							value="Kullanici Ekle"></h:outputText>
					</hx:outputLinkEx></h4>
				</td>
			</tr>
			<tr>
			<td>
			<h4><hx:outputLinkEx id="linkEx2" styleClass="outputLinkEx"
						value="dersduzenle.jsp">
						<h:outputText id="text2" styleClass="outputText"
							value="Ders Duzenle"></h:outputText>
					</hx:outputLinkEx></h4>
				</td>
			<td>
			<h4><hx:outputLinkEx id="linkEx4" styleClass="outputLinkEx"
						value="ogretmen_bolum_degistir.jsp">
						<h:outputText id="text4" styleClass="outputText"
							value="Ogretmen Bolum Degistir"></h:outputText>
					</hx:outputLinkEx></h4>
				</td>
			</tr>
			<tr>
			<td><h4><hx:outputLinkEx id="linkEx8" styleClass="outputLinkEx"
						value="ogrenci_ders_cikar.jsp">
						<h:outputText id="text8" styleClass="outputText"
							value="Ogrenci-Ders Cikar"></h:outputText>
					</hx:outputLinkEx></h4></td>
			<td><h4><hx:outputLinkEx id="linkEx5" styleClass="outputLinkEx"
						value="ogretmen_ders_cikar.jsp">
						<h:outputText id="text5" styleClass="outputText"
							value="Ogretmen-Ders Cikar"></h:outputText>
					</hx:outputLinkEx></h4></td>
				<td><h4><hx:outputLinkEx id="linkEx6" styleClass="outputLinkEx"
						value="anasayfa.jsp">
						<h:outputText id="text6" styleClass="outputText" value="Cikis"></h:outputText>
					</hx:outputLinkEx></h4></td>
			</tr>
			
		</table>
	</body>
</f:view>
</html>