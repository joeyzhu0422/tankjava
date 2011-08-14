<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="/WEB-INF/tlds/tiles-jsp.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="de" lang="de">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="Generator" content="iWeb 3.0.3" />
    <meta name="iWeb-Build" content="local-build-20110512" />
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <meta name="viewport" content="width=700" />
    <title><tiles:getAsString name="title"/></title>
	<link href="css/common.css" type="text/css" rel="stylesheet" />  	
</head>
  <body onload="onPageLoad();">
    <div style="text-align: center; ">
      <div style="margin-bottom: 0px; margin-left: auto; margin-right: auto; margin-top: 0px; overflow: hidden; position: relative; word-wrap: break-word;  background: rgb(0, 0, 0); text-align: left; width: 700px; " id="body_content">
        
        <!-- header -->
        <tiles:insertAttribute name="header"></tiles:insertAttribute>
        <!-- header -->
        
        <tiles:insertAttribute name="main"></tiles:insertAttribute>

		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
      </div>
        
       
        
   </div>

	<div style="position: absolute; display: none; z-index: 9999;" id="livemargins_control">
		<img src="image/Home/monitor-background-horizontal.png" style="position: absolute; left: -77px; top: -5px;" width="77" height="5" />
		<img src="image/Home/monitor-background-vertical.png" style="position: absolute; left: 0pt; top: -5px;" />
		<img id="monitor-play-button" src="image/Home/monitor-play-button.png" onmouseover="this.style.opacity=1" onmouseout="this.style.opacity=0.5" style="position: absolute; left: 1px; top: 0pt; opacity: 0.5; cursor: pointer;" />
	</div>

  </body>
</html>