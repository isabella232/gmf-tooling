<?xml version='1.0'?>
<xsl:stylesheet version = '1.0' xmlns:xsl='http://www.w3.org/1999/XSL/Transform'>

<xsl:output method="xml" indent="yes" omit-xml-declaration="yes"/>
<xsl:param name="build-type"/>
<xsl:param name="feature-id"/>
<xsl:param name="token"/>
<xsl:param name="update-site"/>
<xsl:param name="download-url"/>

<xsl:key name="f" match="feature" use="@id"/>

<xsl:template match="/">
	<xsl:apply-templates select="key('f',$feature-id)[contains(category/@name, $build-type)]">
		<xsl:sort select="substring-after(category/@name, $build-type)" order="descending"/>
	</xsl:apply-templates>
</xsl:template>

<xsl:template match="feature">
<xsl:if test="position() = 1">

<xsl:element name="ant">
	<xsl:attribute name="antfile"><![CDATA[${scripts}]]>/update.xml</xsl:attribute>
	<xsl:attribute name="target">install</xsl:attribute>
	<xsl:element name="property">
		<xsl:attribute name="name">featureId</xsl:attribute>
		<xsl:attribute name="value"><xsl:value-of select="@id"/></xsl:attribute>
	</xsl:element>	
	<xsl:element name="property">
		<xsl:attribute name="name">version</xsl:attribute>
		<xsl:attribute name="value"><xsl:value-of select="@version"/></xsl:attribute>
	</xsl:element>	
	<xsl:element name="property">
		<xsl:attribute name="name">from.updatesite</xsl:attribute>
		<xsl:attribute name="value"><xsl:value-of select="$update-site"/></xsl:attribute>
	</xsl:element>	
	<xsl:element name="property">
		<xsl:attribute name="name">updatesite.name</xsl:attribute>
		<xsl:attribute name="value">requirements</xsl:attribute>
	</xsl:element>	
</xsl:element>

<!-- exporting dependencies.info properties file containing versions and download locations for publishing -->
<xsl:element name="echo">
	<xsl:attribute name="file"><![CDATA[${scripts}]]>/dependencies.info</xsl:attribute>
	<xsl:attribute name="message"><xsl:value-of select="$token"/>Version=<xsl:value-of select="category/@name"/></xsl:attribute>
	<xsl:attribute name="append">true</xsl:attribute>
</xsl:element>
<xsl:element name="echo">
	<xsl:attribute name="file"><![CDATA[${scripts}]]>/dependencies.info</xsl:attribute>
	<xsl:attribute name="message"><xsl:value-of select="$token"/>URL=<xsl:value-of select="$download-url"/></xsl:attribute>
	<xsl:attribute name="append">true</xsl:attribute>
</xsl:element>

</xsl:if>
</xsl:template>

<xsl:template name="v-date">
<xsl:param name="version"/>
<xsl:variable name="tail" select="substring-after(substring-after(substring-after($version,'.'),'.'),'.')"/>
<xsl:value-of select="substring($tail, string-length($tail)-11,8)"/>
<xsl:variable name="v-time" select="substring($tail, string-length($tail)-3,4)"/>
</xsl:template>

<xsl:template name="v-time">
<xsl:param name="version"/>
<xsl:variable name="tail" select="substring-after(substring-after(substring-after($version,'.'),'.'),'.')"/>
<xsl:value-of select="substring($tail, string-length($tail)-3,4)"/>
</xsl:template>

<xsl:template match="@version" mode="full-version">
<xsl:variable name="tail" select="substring-after(substring-after(substring-after(.,'.'),'.'),'.')"/>
<xsl:value-of select="substring-before(., concat('.', $tail))"/>
</xsl:template>

</xsl:stylesheet>
