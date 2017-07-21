<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Transkript.java" --%><%-- /jsf:pagecode --%>
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
			
				
				<table align=center>
					<tr>
						<td>Adi Soyadi :</td>
						<td><h:outputText id="text1" styleClass="outputText" value="#{pc_Transkript.adi_soyadi }"></h:outputText></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>Bolumu :</td>
						<td><h:outputText id="text2" styleClass="outputText" value="#{pc_Transkript.bolumu }"></h:outputText></td>
						<td></td>
						<td></td>
					</tr>
					</table>
					<table align=center>
					<tr>
						<td>Ders Adi</td>
						<td>Kredi</td>
						<td>Puan</td>
						<td>Harf Notu</td>
					</tr>
					<tr>
						<td><h:selectOneListbox id="listbox1"
								styleClass="selectOneListbox" size="18">
								<f:selectItems value="#{pc_Transkript.list_trans }" var="abc"
									itemLabel="#{abc.ders_adi }" />
							</h:selectOneListbox></td>
						<td><h:selectOneListbox id="listbox2"
								styleClass="selectOneListbox" size="18" disabled="true">
								<f:selectItems value="#{pc_Transkript.list_trans }" var="abc"
									itemLabel="#{abc.kredi }" />
							</h:selectOneListbox></td>
						<td><h:selectOneListbox id="listbox3"
								styleClass="selectOneListbox" size="18" disabled="true">
						<f:selectItems value="#{pc_Transkript.list_trans }" var="abc"
									itemLabel="#{abc.spuan }" />		
								</h:selectOneListbox></td>
						<td><h:selectOneListbox id="listbox4"
								styleClass="selectOneListbox" size="18" disabled="true">
								<f:selectItems value="#{pc_Transkript.list_trans }" var="abc"
									itemLabel="#{abc.harf }" />
							</h:selectOneListbox></td>
					</tr>
					</table>
					<table align=center>
					<tr>
						<td>Toplam Puan : </td>
						<td><h:outputText id="text3" styleClass="outputText" value="#{pc_Transkript.toplam_puan }"></h:outputText></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>Toplam Kredi : </td>
						<td><h:outputText id="text4" styleClass="outputText" value="#{pc_Transkript.toplam_kredi }"></h:outputText>(Notu Girilen Krediler)</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>Ortalama : </td>
						<td><h:outputText id="text5" styleClass="outputText" value="#{pc_Transkript.ortalama }"></h:outputText></td>
						<td></td>
						<td><hx:commandExButton type="submit" value="Geri Don" id="bgeridon"
								styleClass="commandExButton" action="#{pc_Transkript.doBgeridonAction}"></hx:commandExButton></td>
					</tr>
					</table>
				
		</h:form>
	</body>
</f:view>
</html>