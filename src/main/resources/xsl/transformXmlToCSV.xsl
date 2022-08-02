<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="text"/>
    <xsl:template match="/articles">
        <xsl:text>ID_ART,NAME,CODE,USERNAME,GUID</xsl:text>
        <xsl:text>&#10;</xsl:text>
        <xsl:for-each select="article">
            <xsl:value-of select="id_art"/>
            <xsl:text>,</xsl:text>
            <xsl:value-of select="name"/>
            <xsl:text>,</xsl:text>
            <xsl:value-of select="code"/>
            <xsl:text>,</xsl:text>
            <xsl:value-of select="username"/>
            <xsl:text>,</xsl:text>
            <xsl:value-of select="guid"/>
            <xsl:text>&#10;</xsl:text>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>