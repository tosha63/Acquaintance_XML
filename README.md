# Acquaintance_XML
## TaskOne
Based on request
SELECT ID_ART,NAME,CODE,USERNAME,GUID FROM WHS.ARTICLE where rownum < 10000
Generate view XML:
<pre>
&lt;articles>
&lt;articles id_art="104880" name="Rolled long loaf 0.4kg" code="1010050114" username="WHS" guid="6992B998083711DC87F900093D12899D">
...
&lt;/articles>
</pre>

## TaskTwo

Write an XSLT transformation that will bring the xml obtained in the previous task to the form:
<pre>
&lt;articles>
&lt;article>
&lt;id_art>104880&lt;/id_art>
&lt;name>Sliced long loaf 0.4kg&lt;/name>
&lt;code>1010050114&lt;/code>
&lt;username>WHS&lt;username>
&lt;guid>6992B998083711DC87F900093D12899D&lt;guid>
&lt;article>
...
&lt;articles>
</pre>

## TaskThree
Write a program that from the xml received from the previous task after conversion will form a CSV file of the form
ID_ART,NAME,CODE,USERNAME,GUID
104880,Батон нарезной в/с 0.4кг,1010050114,WHS,6992B998083711DC87F900093D12899D