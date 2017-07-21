<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Notgirisi.java" --%><%-- /jsf:pagecode --%>
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
		<h:form id="form1" styleClass="form" >
			<table border="0" align=center>
				<tbody>
				<tr>
				<td>Ders Adi :</td>
				<td><h:selectOneMenu id="menu1" styleClass="selectOneMenu" value="#{pc_Notgirisi.ders_id }">
				<f:selectItems value="#{pc_Notgirisi.list_dersler }" var="dersler"
				itemValue="#{dersler.ders_id }" itemLabel="#{dersler.ders_adi }"/>
				</h:selectOneMenu></td>
				<td><hx:commandExButton type="submit" value="Getir" id="bgetir"
					
				styleClass="commandExButton" action="#{pc_Notgirisi.doBgetirAction}"></hx:commandExButton></td>
				<td><h:inputText id="text4" styleClass="inputText" size="12" value="#{pc_Notgirisi.aranacak }"></h:inputText></td>
				<td><hx:commandExButton type="submit" value="Ara" id="bara"
								styleClass="commandExButton" action="#{pc_Notgirisi.doBaraAction}"></hx:commandExButton></td>			
				</tr>
					<tr>
						<td>Ogrenci No</td>
						<td>Ogrenci Adi</td>
						<td>Vize</td>
						<td>Final</td>
						<td>Ortalama</td>
						<td>Harf</td>
					</tr>
					<tr>
					<td><h:selectOneListbox id="listbox6" styleClass="selectOneListbox" size="15" disabled="true">
					<f:selectItems value="#{pc_Notgirisi.list_ogrenci_ders }" var="abc"
					itemLabel="#{abc.ogrenci_no }" />
					</h:selectOneListbox></td>
						<td><h:selectOneListbox id="listbox1"
								styleClass="selectOneListbox" size="15" value="#{pc_Notgirisi.ogrenci_ders_id }">
						<f:selectItems value="#{pc_Notgirisi.list_ogrenci_ders }" var="ogrenci_ders"
						itemValue="#{ogrenci_ders.ogrenci_ders_id }" itemLabel="#{ogrenci_ders.adi_soyadi }"/>
								</h:selectOneListbox></td>
						<td><h:selectOneListbox id="listbox2"
								styleClass="selectOneListbox" size="15" readonly="false"
								disabled="true">
								<f:selectItems value="#{pc_Notgirisi.list_ogrenci_ders }"
									var="ogrenci_ders" itemLabel="#{ogrenci_ders.vize }" />
							</h:selectOneListbox></td>
						<td><h:selectOneListbox id="listbox3"
								styleClass="selectOneListbox" size="15" disabled="true">
						<f:selectItems value="#{pc_Notgirisi.list_ogrenci_ders }" var="ogrenci_ders"
						itemLabel="#{ogrenci_ders.finnal }"/>		
								</h:selectOneListbox></td>
						<td><h:selectOneListbox id="listbox4"
								styleClass="selectOneListbox" size="15" disabled="true">
						<f:selectItems value="#{pc_Notgirisi.list_ogrenci_ders }" var="abc"
						itemLabel="#{abc.ortalama }"/>
								</h:selectOneListbox></td>
						<td><h:selectOneListbox id="listbox5"
								styleClass="selectOneListbox" size="15" disabled="true">
						<f:selectItems value="#{pc_Notgirisi.list_ogrenci_ders }" var="abc"
						itemLabel="#{abc.harf }"/>		
								</h:selectOneListbox></td>
					</tr>
					<tr>
					<td></td>
					<td></td>
					<td><h:inputText id="text1" styleClass="inputText" size="5" value="#{pc_Notgirisi.vize }"></h:inputText></td>
					<td><h:inputText id="text2" styleClass="inputText" size="5" value="#{pc_Notgirisi.finnal }"></h:inputText></td>
					</tr>
					<tr>
						<td><hx:commandExButton type="submit" value="Notu Gir" id="bnotugir"
								styleClass="commandExButton" action="#{pc_Notgirisi.doBnotugirAction}"></hx:commandExButton></td>
						<td><hx:commandExButton type="submit" value="Geri Don" id="bgeridon"
								styleClass="commandExButton" action="#{pc_Notgirisi.doBgeridonAction}"></hx:commandExButton></td>
						<td><h:outputText id="text3" styleClass="outputText" value="#{pc_Notgirisi.notu_gir_sonuc }"></h:outputText></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</h:form>
	</body>
</f:view>
</html>