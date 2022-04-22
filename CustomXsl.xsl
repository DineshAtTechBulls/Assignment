<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="3.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:Date="java:java.util.Date"
                xmlns:saxon="http://icl.com/saxon"
                xmlns:Math="java:java.lang.Math"
                xmlns:map="java:java.util.Map"
                xmlns:fib="java:com.demo.xslt.FibonacciNumber"
                xmlns:cal="java:java.util.GregorianCalendar"
                extension-element-prefixes="map fib">
    <xsl:param name="mapData"/>
    <xsl:template match="/">
        <html>
            <body>
                <!--calling static method-->
                <h3>Fib:</h3>
                <xsl:value-of select="fib:calculate(number(10))"/>
                <!--calling java in-built method-->
                <h3>min Number:</h3>
                <b>
                    <xsl:value-of select="Math:min( number(2), number(3))"/>
                </b>
                <!--calling non-static method-->
                <h3>sum:</h3>
                <xsl:variable name="sumOne" select="fib:new()"/>
                <xsl:value-of select="fib:sum($sumOne, number(1),number(2))"/>
                <!--calling java in-built date method-->
                <h3>Date:</h3>
                <b>
                    <xsl:value-of select="Date:new()"/>
                </b>
                <xsl:variable name="now" select="cal:getInstance()"/>

                <xsl:variable name="month" select="cal:get($now, 2) + 1"/>
                <xsl:variable name="day" select="cal:get($now, 5) "/>
                <xsl:variable name="year" select="cal:get($now, 1)"/>
                <h3>Day:</h3>
                <xsl:value-of select="$year"/>-<xsl:value-of select="$month"/>-<xsl:value-of select="$day"/>
                <table>
                    <tr>
                        <th>users</th>
                    </tr>
                    <tr>
                        <td>
                            <xsl:value-of select="map:get($mapData, string(1))"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <xsl:value-of select="map:get($mapData, string(2))"/>
                        </td>
                    </tr>
                </table>
                <!--formatting input date value-->
                <h3>Date format:</h3>
                Date Edited:
                <xsl:value-of select="fib:dateFormat()"/>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>