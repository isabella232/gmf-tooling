
<?xml version='1.0'?>
<xsl:stylesheet version = '1.0' xmlns:xsl='http://www.w3.org/1999/XSL/Transform'>

<xsl:output method="xml" indent="yes"/>
		<xsl:template match="/">
<project name="gmf-build-cfg" basedir="." default="main">
	<target name="main">
		<echo file="install-dependencies.xml"><![CDATA[
<project name="install-dependencies" default="install.dependencies">
	<target name="install.dependencies">
		<delete file="${scripts}/dependencies.info"/>]]>
		</echo>		
			<xsl:apply-templates/>
		<echo file="install-dependencies.xml" append="true"><![CDATA[
	</target>
</project>]]>
		</echo>				
	</target>
</project>		
		</xsl:template>
		

		<xsl:template match="dependency">
			<xsl:element name="get">
				<xsl:attribute name="dest">site.xml</xsl:attribute>
				<xsl:attribute name="src"><xsl:value-of select="@update-site"/></xsl:attribute>
			</xsl:element>
			<xsl:apply-templates/>
			<xsl:element name="delete">
				<xsl:attribute name="file">site.xml</xsl:attribute>
				<xsl:attribute name="failonerror">false</xsl:attribute>
			</xsl:element>
		</xsl:template>

		<xsl:template match="dependency/feature">
			<xsl:element name="xslt">
				<xsl:attribute name="style">extract-config.xsl</xsl:attribute>
				<xsl:attribute name="in">site.xml</xsl:attribute>
				<xsl:attribute name="out">install-feature.xml</xsl:attribute> <!-- change and concat after -->
				<xsl:element name="param">
					<xsl:attribute name="name">feature-id</xsl:attribute>
					<xsl:attribute name="expression"><xsl:value-of select="@id"/></xsl:attribute>
				</xsl:element>
				<xsl:element name="param">
					<xsl:attribute name="name">build-type</xsl:attribute>
					<xsl:attribute name="expression"><xsl:value-of select="../@build-type"/></xsl:attribute>
				</xsl:element>
				<xsl:element name="param">
					<xsl:attribute name="name">update-site</xsl:attribute>
					<xsl:attribute name="expression"><xsl:value-of select="../@update-site"/></xsl:attribute>
				</xsl:element>
				<xsl:element name="param">
					<xsl:attribute name="name">token</xsl:attribute>
					<xsl:attribute name="expression"><xsl:value-of select="../@name"/></xsl:attribute>
				</xsl:element>
				<xsl:element name="param">
					<xsl:attribute name="name">download-url</xsl:attribute>
					<xsl:attribute name="expression"><xsl:value-of select="../@download-url"/></xsl:attribute>
				</xsl:element>
			</xsl:element>
			<xsl:element name="concat">
				<xsl:attribute name="destfile">install-dependencies.xml</xsl:attribute>
				<xsl:attribute name="append">true</xsl:attribute>
				<xsl:element name="fileset">
					<xsl:attribute name="dir">.</xsl:attribute>
					<xsl:attribute name="includes">install-feature.xml</xsl:attribute>
				</xsl:element>
			</xsl:element>
			<xsl:element name="delete">
				<xsl:attribute name="file">install-feature.xml</xsl:attribute>
				<xsl:attribute name="failonerror">false</xsl:attribute>
			</xsl:element>
		</xsl:template>	
</xsl:stylesheet>
