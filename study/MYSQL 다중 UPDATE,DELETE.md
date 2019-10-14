# MYSQL 다중 UPDATE,DELETE

**다중 DELETE**
<pre>
<code>
```  
DELETE A, B  
  FROM ENC_CUSTOMER A  
 INNER JOIN ENC_EMP B  
    ON A.CUST_NAME = B.EMP_NAME;
```
</code>
</pre>


**다중 UPDATE**   
<pre>
<code>
```
UPDATE META A  
     , TRANS_DATA B  
   SET B.T_USE = 0  
 WHERE A.MD_SEQ = B.MD_SEQ  
   AND A.MD_DATE BETWEEN '2019-10-09 00:00:00' AND '2019-10-10 23:59:59'
```
</code>
</pre>
