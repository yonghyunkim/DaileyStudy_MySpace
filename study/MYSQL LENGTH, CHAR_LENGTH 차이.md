# MYSQL LENGTH, CHAR_LENGTH 차이

**LENGTH와 CHAR_LENGTH 비교**


```
LENGTH는 문자열의 길이를 BYTE단위로 가져오기때문에 한글이 정확할 수 없다.    
하지만 영문(영어)는 BYTE단위로 길이를 가져와도 값이같다.    
```
   
   
<pre>
<code>

SELECT LENGTH('안녕하세요')    -   15  

SELECT CHAR_LENGTH('안녕하세요')    -   5


SELECT LENGTH('HELLO')    -   15  

SELECT CHAR_LENGTH('HELLO')    -   5



</code>
</pre>




