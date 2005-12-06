<?php  																														require_once($_SERVER['DOCUMENT_ROOT'] . "/eclipse.org-common/system/app.class.php");	require_once($_SERVER['DOCUMENT_ROOT'] . "/eclipse.org-common/system/nav.class.php"); 	require_once($_SERVER['DOCUMENT_ROOT'] . "/eclipse.org-common/system/menu.class.php"); 	$App 	= new App();	$Nav	= new Nav();	$Menu 	= new Menu();		include($App->getProjectCommon());    # All on the same line to unclutter the user's desktop'


	#*****************************************************************************
	#
	# index.php
	#
	# Author: 		Richard C. Gronback
	# Date:			2005-12-01
	#
	# Description: 
	#
	#
	#****************************************************************************
	
	#
	# Begin: page-specific settings.  Change these. 
	$pageTitle 		= "Graphical Modeling Framework Downloads";
	$pageKeywords	= "eclipse,project,graphical,modeling,model-driven";
	$pageAuthor		= "Richard C. Gronback";
	
	# Add page-specific Nav bars here
	# Format is Link text, link URL (can be http://www.someothersite.com/), target (_self, _blank), level (1, 2 or 3)
	# $Nav->addNavSeparator("My Page Links", 	"downloads.php");
	# $Nav->addCustomNav("My Link", "mypage.php", "_self", 3);
	# $Nav->addCustomNav("Google", "http://www.google.com/", "_blank", 3);

	# End: page-specific settings
	#
	
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
	
	$latest = "";
	foreach($dropType as $value) {
		$prefix=$typeToPrefix[$value];
		$fileName = $latestFile[$prefix];
		$latest .= "<tr><td width=\"30%\">$value</td>";
		
		$parts = explode("-", $fileName);
		
		// Uncomment the line below if we need click through licenses.
		// echo "<td><a href=license.php?license=drops/$fileName>$parts[1]</a></td>";
		
		// Comment the line below if we need click through licenses.
		$latest .= "<td><a href=\"drops/$fileName/index.php\">$parts[1]</a></td>";
		
		$latest .= "<td>$timeStamps[$fileName]</td>";
		$latest .= "</tr>";
	}

	$list = "";
	foreach($dropType as $value) {
		$prefix=$typeToPrefix[$value];
		$list .="
		<table width=\"100%\" cellspacing=0 cellpadding=3 align=center>
		<tr bgcolor=\"#999999\">
		<td align=left width=\"30%\"><b><a name=\"$value\"><font color=\"#FFFFFF\" face=\"Arial,Helvetica\">$value";
		$list .= "s</font></b></a></td>
		</TR>
		<TR>
		<td align=left>
		<TABLE  width=\"100%\" CELLSPACING=0 CELLPADDING=3>
		<tr>
		<td width=\"30%\"><b>Build Name</b></td>
		<td><b>Build Date</b></td>
		</tr>";
		
		$aBucket = $buckets[$prefix];
		if (isset($aBucket)) {
			rsort($aBucket);
			foreach($aBucket as $innerValue) {
				$parts = explode("-", $innerValue);
				$list .="<tr>";
				
					// Uncomment the line below if we need click through licenses.
					// echo "<td><a href=\"license.php?license=drops/$innerValue\">$parts[1]</a></td>";
					
					// Comment the line below if we need click through licenses.
					$list .=+ "<td><a href=\"drops/$innerValue/index.php\">$parts[1]</a></td>";

					$list .="<td>$timeStamps[$innerValue]</td>
					</tr>";
			}
		}
		$list .="</table></table>&nbsp;";
	}
	
		
	# Paste your HTML content between the EOHTML markers!	
	$html = <<<EOHTML

<div id="maincontent">
	<div id="midcolumn"><br/>
		<table border="0" cellpadding="2" cellspacing="0" width="100%">
			<tbody>
				<tr>
					<td align="left"><h1>$pageTitle</h1></td>
					<td align="right"><img align="right" src="http://www.eclipse.org/gmf/images/logo_banner.png" /></td>
				</tr>
			</tbody>
		</table>

<div class="homeitem3col"><h3>Download Information</h3>
<table border=0 cellspacing=5 cellpadding=2 width="100%" >
  
	<tr> <td> <p>On this
page you can find the latest builds produced by
the GMF project. To get started run the program and go through the
user and developer documentation provided in the online help system. If you have
problems downloading the drops, contact the <a href="mailto:webmaster@eclipse.org">webmaster</a>.
All downloads are provided under the terms and conditions of the <a href="http://www.eclipse.org/legal/notice.html">Eclipse.org
Software User Agreement</a> unless otherwise specified. </p>
<p> For information
about different kinds of builds read our build <a href="build_types.html">types</a> page.</p>

<p>Builds can also be installed via Update Manager, from an existing installation of Eclipse, by following these  
<a href="http://download.eclipse.org/technology/gmf/update-site/index.html" target="_self">steps</a>.
</p></td></tr>
</table>
</div>

<div class="homeitem3col"><h3>Latest Downloads</h3>

<table width="100%" cellspacing=0 cellpadding=3 align=center>


<td align=left>
<TABLE  width="100%" CELLSPACING=0 CELLPADDING=3>
<tr>
	<td width=\"30%\"><b>Build Type</b></td>
	<td><b>Build Name</b></td>
	<td><b>Build Date</b></td>
</tr>

$latest
</table>
</table>
&nbsp;
$list
	</div>
			</div>
</div>


EOHTML;


	# Generate the web page
	$App->generatePage($theme, $Menu, $Nav, $pageAuthor, $pageKeywords, $pageTitle, $html);
?>

 



