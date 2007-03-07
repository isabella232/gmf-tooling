<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>GMF Project Downloads</title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<meta name="author" content="Eclipse Foundation, Inc." />
	<meta name="keywords" content="gmf,graphical modeling framework, eclipse, plug-ins,plugins,java,gef,emf,open source,modeling,uml" />
	<link rel="stylesheet" type="text/css" href="/eclipse/eclipse.org-common/stylesheets/visual.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="/eclipse/eclipse.org-common/stylesheets/layout.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="/eclipse/eclipse.org-common/stylesheets/print.css" media="print" />
	<script type="text/javascript">

sfHover = function() {
	var sfEls = document.getElementById("leftnav").getElementsByTagName("LI");
	for (var i=0; i<sfEls.length; i++) {
		sfEls[i].onmouseover=function() {
			this.className+=" sfhover";
		}
		sfEls[i].onmouseout=function() {
			this.className=this.className.replace(new RegExp(" sfhover\\b"), "");
		}
	}
}
if (window.attachEvent) window.attachEvent("onload", sfHover);
</script>
</head>

<body>

<?php
	
	$fileHandle = fopen("dlconfig.txt", "r");
	while (!feof($fileHandle)) {
		
		$aLine = fgets($fileHandle, 4096);
		parse_str($aLine);

		
	}
	fclose($fileHandle);
	
	for ($i = 0; $i < count($dropType); $i++) {
		$typeToPrefix[$dropType[$i]] = $dropPrefix[$i];
	}
	
	$aDirectory = dir("drops");
	while ($anEntry = $aDirectory->read()) {

		// Short cut because we know aDirectory only contains other directories.
		if ($anEntry != "." && $anEntry!="..") {
			$aDropDirectory = dir("drops/".$anEntry);
			$fileCount = 0;
			while ($aDropEntry = $aDropDirectory->read()) {
				if (stristr($aDropEntry, ".zip")) {
					// Count the files in the directory
					$fileCount = $fileCount + 1;
				}
			}
			$aDropDirectory.closedir();
			// Read the count file
			$countFile = "drops/".$anEntry."/files.count";
			$indexFile = "drops/".$anEntry."/index.php";
			if (file_exists($countFile) && file_exists($indexFile)) {
				$anArray = file($countFile);
	
				// If a match - process the directory
				if ($anArray[0] == $fileCount) {
					$parts = explode("-", $anEntry);
					if (count($parts) == 3) {
			
						$buckets[$parts[0]][] = $anEntry;
			
						$timePart = $parts[2];
						$year = substr($timePart, 0, 4);
						$month = substr($timePart, 4, 2);
						$day = substr($timePart, 6, 2);
						$hour = substr($timePart,8,2);
						$minute = substr($timePart,10,2);
						$timeStamp = mktime($hour, $minute, 0, $month, $day, $year);
					
						$timeStamps[$anEntry] = date("D, j M Y -- H:i (O)", $timeStamp);
			
						if ($timeStamp > $latestTimeStamp[$parts[0]]) {
							$latestTimeStamp[$parts[0]] = $timeStamp;
							$latestFile[$parts[0]] = $anEntry;
						}
					}
				}
			}
		}
	}
	// $aDirectory.closedir();
?>

<div id="header">
	<a href="http://www.eclipse.org/"><img src="/eclipse/eclipse.org-common/stylesheets/header_logo.gif" width="163" height="68" border="0" alt="Eclipse Logo" class="logo" /></a>
	<div id="searchbar">
		<img src="/eclipse/eclipse.org-common/stylesheets/searchbar_transition.gif" width="92" height="26" class="transition" alt="" />
		<img src="/eclipse/eclipse.org-common/stylesheets/searchbar_header.gif" width="64" height="17" class="header" alt="Search" />
		<form method="get" action="http://www.eclipse.org/search/search.cgi">
			<input type="hidden" name="t" value="All" />
			<input type="hidden" name="t" value="Doc" />
			<input type="hidden" name="t" value="Downloads" />
			<input type="hidden" name="t" value="Wiki" />
			<input type="hidden" name="wf" value="574a74" />
			<input type="text" name="q" value="" />
			<input type="image" class="button" src="/eclipse/eclipse.org-common/stylesheets/searchbar_submit.gif" alt="Submit" onclick="this.submit();" />
		</form>
	</div>
	<ul id="headernav">
		<li class="first"><a href="http://www.eclipse.org/org/foundation/contact.php">Contact</a></li>
		<li><a href="http://www.eclipse.org/legal/">Legal</a></li>
	</ul>
</div>
<div id="topnav">
	<ul>
		<li><a>GMF Downloads</a></li>
		<li class="tabstartselected">&#160;&#160;&#160;</li>
		<li><a class="tabselected" href="http://www.eclipse.org/gmf" target="_self">GMF Homepage</a></li>
<!--
		<li class="tabseparatorselected">&#160;&#160;&#160;</li>
		<li><a class="" href="winPlatform.php" target="_self">Windows</a></li>
		<li class="tabstart">&#160;&#160;&#160;</li>
		<li><a class="" href="linPlatform.php" target="_self">Linux</a></li>
		<li class="tabstart">&#160;&#160;&#160;</li>
		<li><a class="" href="solPlatform.php" target="_self">Solaris</a></li>
		<li class="tabstart">&#160;&#160;&#160;</li>
		<li><a class="" href="aixPlatform.php" target="_self">AIX</a></li>
		<li class="tabstart">&#160;&#160;&#160;</li>	
		<li><a class="" href="macPlatform.php" target="_self">Macintosh</a></li>
		<li class="tabseparator">&#160;&#160;&#160;</li>
-->					
	</ul>
</div>
<div id="topnavsep"></div>
<div id="leftcol">
<ul id="leftnav">
  <?php
	foreach($dropType as $value) {
		echo "<li><a href=\"#{$value}s\">{$value}s</a></li>";
	}
  ?>	 
  <li style="background-image: url(/eclipse/eclipse.org-common/stylesheets/leftnav_fade.jpg); background-repeat: repeat-x; border-style: none;">
			<br /><br /><br /><br /><br />
  </li>
</ul>

</div>

&nbsp;

<div id="midcolumn">
	<table BORDER=0 CELLSPACING=5 CELLPADDING=2 WIDTH="100%" > 
	<tr> 
		<td> 
				<p><b><font face="Verdana" size="+3">Graphical Modeling Framework Downloads</font></b><br> 
				These downloads are provided under the <a href="http://www.eclipse.org/legal/epl/notice.html">
				<b>Eclipse Foundation Software User Agreement</b></a>.</p>
		</td><tr><tr>
	<tr>
			<td width="75%">
				<p>On this page you can find the latest builds produced by the GMF project. 
				To get started run the program and go through the user and developer documentation 
				provided in the online help system. If you have problems downloading the drops, 
				contact the <font face="arial,helvetica,geneva" size="-1"><a href="mailto:webmaster@eclipse.org">webmaster</a></font>.</p>
				<p> For information
				about different kinds of builds read our build <a href="build_types.html">types</a> page.</p>
				<p>Builds can also be installed via Update Manager, from an existing installation of Eclipse, by following these  
				<a href="http://download.eclipse.org/modeling/gmf/update-site/releases/site.xml" target="_self">steps</a>.
				</p>
			</td>
		</tr>
	</table>

  <div class="homeitem3col">
	<h3>Latest Downloads</h3>


<table width="100%" cellspacing=0 cellpadding=3 align=center>


<TABLE  width="100%" CELLSPACING=0 CELLPADDING=3>
<tr>
	<td width=\"30%\"><b>Build Type</b></td>
	<td><b>Build Name</b></td>
	<td><b>Build Date</b></td>
</tr>

<?php
	foreach($dropType as $value) {
		$prefix=$typeToPrefix[$value];
		$fileName = $latestFile[$prefix];
		echo "<tr>
			<td width=\"30%\">$value</td>";
		
		$parts = explode("-", $fileName);
		
		// Uncomment the line below if we need click through licenses.
		// echo "<td><a href=license.php?license=drops/$fileName>$parts[1]</a></td>";
		
		// Comment the line below if we need click through licenses.
		echo "<td><a href=\"drops/$fileName/index.php\">$parts[1]</a></td>";
		
		echo "<td>$timeStamps[$fileName]</td>";
		echo "</tr>";
	}
?>
</table></table>
</div>
<hr class="clearer" />
</div>

<div id="rightcolumn">
		</br></br></br></br></br>
		<div class="sideitem">
			<h6>GMF Update Sites</h6>
			<ul>
				<li><a href="http://download.eclipse.org/modeling/gmf/update-site/releases/site.xml">
				Release builds</a></li>
				<li><a href="http://download.eclipse.org/modeling/gmf/update-site/milestone/site.xml">
				Milestone builds</a></li>
				<li><a href="http://download.eclipse.org/modeling/gmf/update-site/interim/site.xml">
				Integration builds</a></li>
				<li><a href="http://download.eclipse.org/modeling/gmf/update-site/europa/site.xml">
				Europa builds</a></li>
			</ul>
		</div>		
</div>		

<table align="left" cellspacing=0 cellpadding=3 WIDTH="100%">

<?php
	foreach($dropType as $value) {
		$prefix=$typeToPrefix[$value];
		echo "
		<tr><td><div class=\"homeitem3col\">
		<h3><a name=\"{$value}s\">{$value}s</a></h3>";
		echo "
		<table BORDER=0 CELLSPACING=0 CELLPADDING=3 WIDTH=\"100%\" bordercolor=\"#999999\" >
		<tr>
		<td width=\"30%\"><b>Build Name</b></td>
		<td><b>Build Date</b></td>
		</tr>";
		
		$aBucket = $buckets[$prefix];
		if (isset($aBucket)) {
			rsort($aBucket);
			foreach($aBucket as $innerValue) {
				$parts = explode("-", $innerValue);
				echo "<tr>";
				
					// Uncomment the line below if we need click through licenses.
					// echo "<td><a href=\"license.php?license=drops/$innerValue\">$parts[1]</a></td>";
					
					// Comment the line below if we need click through licenses.
					echo "<td><a href=\"drops/$innerValue/index.php\">$parts[1]</a></td>";

					echo "<td>$timeStamps[$innerValue]</td>
					</tr>";
			}
		}
		echo "</table></div></td></tr>";
	}
?>
</table>

</body></html>
