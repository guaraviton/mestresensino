<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		
		<tiles:importAttribute name="jsFiles"/>
		<c:forEach var="jsFile" items="${jsFiles}">
		  <script src="<c:url value='${jsFile}'/>" type="text/javascript" charset="utf-8"></script>
		</c:forEach>
		
		<tiles:importAttribute name="cssFiles"/>
		<c:forEach var="cssFile" items="${cssFiles}">
		  <link rel="stylesheet" href="<c:url value='${cssFile}'/>"/>
		</c:forEach>
		
	</head>
	<body>
		<table border="1" cellspacing="2" align="center">
			<tr>
				<td height="30">
					<tiles:insertAttribute name="header" />        
				</td>
			</tr>
			<tr>
				<td width="1024">
					<tiles:insertAttribute name="body" />        
				</td>
			</tr>
			<tr>
				<td height="30">
					<tiles:insertAttribute name="footer" />        
				</td>
			</tr>
		</table>
	</body>
</html>