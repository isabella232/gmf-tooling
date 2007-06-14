<?xml version='1.0'?>
<xsl:stylesheet version = '1.0' xmlns:xsl='http://www.w3.org/1999/XSL/Transform'>

<xsl:output method="text" indent="no"/>
<xsl:param name="build-type"/>
<xsl:param name="feature-id"/>
<xsl:param name="token"/>

<xsl:key name="f" match="feature" use="@id"/>

<xsl:template match="/">
	<xsl:apply-templates select="key('f',$feature-id)[contains(category/@name, $build-type)]">
		<xsl:sort select="substring-after(category/@name, $build-type)" order="descending"/>
	</xsl:apply-templates>
</xsl:template>

<xsl:template match="feature">
<xsl:if test="position() = 1">
<xsl:text>

####################################################
# </xsl:text><xsl:value-of select="$token"/> - <xsl:apply-templates select="@version" mode="full-version"/>
full<xsl:value-of select="concat(translate(substring($token,1,1),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),substring($token,2))"/>Version=<xsl:apply-templates select="@version" mode="full-version"/><xsl:text>
</xsl:text>
<xsl:value-of select="$token"/>FeatureId=<xsl:value-of select="@id"/><xsl:text>
</xsl:text>
<xsl:choose>
<xsl:when test="string-length(substring-after(@version, '-')) > 0">
<xsl:value-of select="$token"/>BuildDate=<xsl:call-template name="v-date"><xsl:with-param name="version" select="substring-before(@version, '-')"/></xsl:call-template><xsl:text>
</xsl:text>
<xsl:value-of select="$token"/>BuildTime=<xsl:call-template name="v-time"><xsl:with-param name="version" select="substring-before(@version, '-')"/></xsl:call-template><xsl:text>
</xsl:text>
<xsl:value-of select="$token"/>FeatureQualifier=<xsl:value-of select="substring-after(@version, '-')"/><xsl:text>
</xsl:text>
</xsl:when>
<xsl:otherwise>
<xsl:value-of select="$token"/>BuildDate=<xsl:call-template name="v-date"><xsl:with-param name="version" select="@version"/></xsl:call-template><xsl:text>
</xsl:text>
<xsl:value-of select="$token"/>BuildTime=<xsl:call-template name="v-time"><xsl:with-param name="version" select="@version"/></xsl:call-template><xsl:text>
</xsl:text>
</xsl:otherwise>
</xsl:choose>
<xsl:value-of select="$token"/>UpdateVersion=<xsl:value-of select="@version"/>
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
