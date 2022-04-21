<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:map="xalan://java.util.Map"
                extension-element-prefixes="map">
    <xsl:param name="mapData"/>

    <xsl:template match="/class">

        <html>
            <body>
                <h3>Student Details</h3>
                <table border="1">
                    <tr bgcolor="#E6E6FA">
                        <th>Roll Number</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Nick Name</th>
                        <th>Marks</th>
                        <th>Address</th>
                    </tr>
                    <xsl:for-each select="student">
                        <tr>
                            <xsl:variable name="rollNumber" select="./@rollno"/>
                            <xsl:variable name="addressData" select="map:get($mapData,string($rollNumber))"/>
                            <td>
                                <xsl:value-of select="./@rollno" />
                            </td>
                            <td>
                                <xsl:value-of select="firstname" />
                            </td>
                            <td>
                                <xsl:value-of select="lastname" />
                            </td>
                            <td>
                                <xsl:value-of select="nickname" />
                            </td>
                            <td>
                                <xsl:value-of select="marks" />
                            </td>
                            <td>
                                <xsl:value-of select="$addressData" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
