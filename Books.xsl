<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
>
    <xsl:param name="mapper"/>
    <xsl:template match="/">
        <html>
            <body>
                <h2>Books</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>Id</th>
                        <th>Title</th>
                        <th>Artist</th>
                        <th>Genre</th>
                        <th>Price</th>
                        <th>Publish Date</th>
                        <th>Description</th>
                    </tr>
                    <xsl:for-each select="catalog/book">
                        <xsl:sort select="title"/>
                        <xsl:choose>
                            <xsl:when test="price &lt; 10">
                                <tr bgcolor="blue">
                                    <td>
                                        <xsl:value-of select="@id"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="title"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="author"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="genre"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="price"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="publish_date"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="description"/>
                                    </td>

                                </tr>
                            </xsl:when>
                            <xsl:otherwise>
                                <xsl:if test="not (price &gt; 40)">
                                    <tr bgcolor="yellow">
                                        <td>
                                            <xsl:value-of select="@id"/>
                                        </td>
                                        <td>
                                            <xsl:value-of select="title"/>
                                        </td>
                                        <td>
                                            <xsl:value-of select="author"/>
                                        </td>
                                        <td>
                                            <xsl:value-of select="genre"/>
                                        </td>
                                        <td>
                                            <xsl:value-of select="price"/>
                                        </td>
                                        <td>
                                            <xsl:value-of select="publish_date"/>
                                        </td>
                                        <td>
                                            <xsl:value-of select="description"/>
                                        </td>

                                    </tr>
                                </xsl:if>
                            </xsl:otherwise>
                        </xsl:choose>

                    </xsl:for-each>
                </table>

            </body>
        </html>
    </xsl:template>


</xsl:stylesheet>