<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<html>
	<head>
		<title>Provider Login</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<link rel="stylesheet" media="screen" type="text/css" href="./css/reset.css" />
		<link rel="stylesheet" media="screen" type="text/css" href="./css/green.css" />	
	</head>
	
	<body>

		<div id="header">
			<h1>Admin Login</h1>
			<div id="language"></div>
			<div class="clear"></div>
		</div>
		<div class="errorMessages">		
   		        <html:errors/>
   		</div>
    	<div id="loginarea">
    	
    		<div id="login-welcome">
    			<h3>admin login:</h3>
    		</div>
    		<tiles:insert attribute="body" />
    		
    	
    	</div>
		
	</body>
	
</html>