<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- jsf:pagecode language="java" location="/src/pagecode/Dersekle.java" --%><%-- /jsf:pagecode --%>
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
	<hx:scriptCollector preRender="#{pc_Dersekle.onPageLoadBegin}">
		<h:form id="form1" styleClass="form">
		<table align=center>
		<tr>
		<td>
			<table align=center>
				<tbody>
					<tr>
						<td>Bolum Adi :</td>
						<td><h:selectOneMenu id="menu1" styleClass="selectOneMenu" value="#{pc_Dersekle.bolum_id }">
						<f:selectItems value="#{pc_Dersekle.list_bolum }" var="abc"
						itemValue="#{abc.bolum_id }" itemLabel="#{abc.bolum_adi }"/>
						</h:selectOneMenu></td>
					</tr>
					
					<tr>
						<td>Ders Adi :</td>
						<td><h:inputText id="text1" styleClass="inputText" value="#{pc_Dersekle.ders_adi }"></h:inputText></td>
					</tr>
					<tr>
						<td>Kredi : </td>
						<td><h:inputText id="text2" styleClass="inputText" value="#{pc_Dersekle.skredi }"></h:inputText></td>
					</tr>
					<tr>
						<td align=center><hx:commandExButton type="submit" value="Ekle" id="bekle"
								styleClass="commandExButton" action="#{pc_Dersekle.doBekleAction}"></hx:commandExButton></td>
						<td align=center><hx:commandExButton type="submit" value="Geri Don" id="bgeridon"
								styleClass="commandExButton" action="#{pc_Dersekle.doBgeridonAction}"></hx:commandExButton></td>
					</tr>
					<tr>
					<td colspan=2><h:outputText id="text3" styleClass="outputText" value="#{pc_Dersekle.ekle_sonuc }"></h:outputText></td>
					</tr>
					
				</tbody>
			</table>
			</td>
			<td>
			<table>
			<tr>
					<td colspan=2 align=center ><h4>Son Eklenen 5 Ders</h3></td>
					</tr>
					<tr>
					<td colspan=2>
					<h:outputText id="text4" styleClass="outputText" value="#{pc_Dersekle.son_1 }"></h:outputText>
							</td>
					</tr>
					<tr>
					<td colspan=2>
					<h:outputText id="text5" styleClass="outputText" value="#{pc_Dersekle.son_2 }"></h:outputText>
							</td>
					</tr>
					<tr>
					<td colspan=2>
					<h:outputText id="text6" styleClass="outputText" value="#{pc_Dersekle.son_3 }"></h:outputText>
							</td>
					</tr>
					<tr>
					<td colspan=2>
					<h:outputText id="text7" styleClass="outputText" value="#{pc_Dersekle.son_4 }"></h:outputText>
							</td>
					</tr>
					<tr>
					<td colspan=2>
					<h:outputText id="text8" styleClass="outputText" value="#{pc_Dersekle.son_5 }"></h:outputText>
							</td>
							
					</tr>
					
			</table>
			</td>
			</tr>
			</table>
				
			</h:form>
		</hx:scriptCollector>
	</body>
</f:view>
</html>