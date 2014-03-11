package client.webapp

class WebApp {

	def cssContent() '''
		body {
			background: white !important;
			font-family: 'Helvetica Neue', Helvetica, Arial Geneva, sans-serif;
			font-weight: 400;
			font-size: 12px;
			text-rendering: optimizeLegibility;
			-webkit-font-smoothing: antialiased;
		}
		
		body {
			margin: 0px;
		}
		
		* {
			box-sizing: border-box;
			-moz-box-sizing: border-box;
		}
	'''

	def htmlContent(String moduleName) '''
		<!doctype html>
		<html>
		  <head>
		    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
		    <link type="text/css" rel="stylesheet" href="app.css">
		    <title>«moduleName»</title>
		    <script type="text/javascript" language="javascript" src="«moduleName»/«moduleName».nocache.js"></script>
		  </head>
		  <body>
		    <!-- OPTIONAL: include this if you want history support -->
		    <iframe src="javascript:''" id="__gwt_historyFrame" tabIndex='-1' style="position:absolute;width:0;height:0;border:0"></iframe>
		    <!-- RECOMMENDED if your web app will not function without JavaScript enabled -->
		    <noscript>
		      <div style="width: 22em; position: absolute; left: 50%; margin-left: -11em; color: red; background-color: white; border: 1px solid red; padding: 4px; font-family: sans-serif">
		        Your web browser must have JavaScript enabled
		        in order for this application to display correctly.
		      </div>
		    </noscript>
		  </body>
		</html>
	'''
	
	def webContent(String moduleName) '''
		<?xml version="1.0" encoding="UTF-8"?>
		<!DOCTYPE web-app
		    PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
		    "http://java.sun.com/dtd/web-app_2_3.dtd">
		
		<web-app>
			<welcome-file-list>
				<welcome-file>index.html</welcome-file>
			</welcome-file-list>
		</web-app>
	'''

}