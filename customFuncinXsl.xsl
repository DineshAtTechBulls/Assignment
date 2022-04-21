<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:foo="http://www.w3.org">

    <xsl:function name="foo:compareCI">
        <xsl:param name="string1"/>
        <xsl:param name="string2"/>
        <xsl:value-of select="compare(upper-case($string1),upper-case($string2))"/>
    </xsl:function>

    <xsl:template match="/">
        <html>
            <body>
        <table border="1">
            <tr bgcolor="yellow">
                <th>compareCI red,blue</th>
                <th>compareCI red,red</th>
                <th>compareCI red,Red</th>
                <th>compareCI red,Yellow</th>
            </tr>
            <tr>
                <td><xsl:value-of select="foo:compareCI('red','blue')"/></td>
                <td><xsl:value-of select="foo:compareCI('red','red')"/></td>
                <td><xsl:value-of select="foo:compareCI('red','Red')"/></td>
                <td><xsl:value-of select="foo:compareCI('red','Yellow')"/></td>
            </tr>
        </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>