# Apache Virtual Host란

Web Server에는 기본적으로 존재하는 Host가 있다. 이를 Main Host라고 한다.  
하나의 Web Server에는 Main Host 외에 별도의 디렉토리를 가진 여러개의 Host를 설정하여 사용할수있다.    

이중에서 Main Host 외에 나머지 Host를 Virtual Host라고 부르며,     
이를 하나의 컴퓨터에서 여러개의 Web Site를 서비스 할 수 있다.  

Apache에서는 Name-based Virtual Host 와 IP-based Virtual Host 두 가지 방식을 제공한다.  

1. Name-based Virtual Host (이름 기반의 가상호스트)  
하나의 IP Address당 여러 이름을 가지는 방식이며, 보편적이다.  

2. IP-based Virtual Host (IP Address 기반의 가상호스트)  
각 웹 사이트마다 다른 IP Address 또는 Port를 가지는방식이다.  
IP Address를 다르게 하거나 Port번호를 다르게 하므로써 사이트를 구분 할 수 있다.  

```
설정한 Virtual Host를 적용한다.  
적용하기 위해서는 먼저 앞서 만든 '/etc/apache2/sites-available'    
디렉토리에 있는 'example.conf '파일을 '/etc/apache2/sites-enabled'에 등록 시킨 후,  
Apache Service를 Reload 해주어야 한다.  

(1) 'sites-enabled'에 등록 : a2ensite example.conf

(*참고 : 'a2ensite'은 해당 파일을 'sites-available'에서  'sites-enabled'으로 등록시켜주는 명령어이다.)

(2) Apache Reload : service apache2 reload

```
