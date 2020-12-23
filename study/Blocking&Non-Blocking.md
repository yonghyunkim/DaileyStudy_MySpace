# Blocking&Non-Blocking

Blocking이란.2

I/O 작업은 User Level에서 할 수 없다.  
유저 프로세스는 커널(OS)에게 I/O 작업에 대한 요청을 해야 한다.  
I/O 작업을 처리하기 위해 User Level에 있던 Application이 시스템 함수를 호출한다. (system call).  
이때 context-switching이 발생한다.  
그리고 Kernel Level에서 해당 I/O 작업이 끝나고 데이터를 반환하게 되면 그 때 되서야 Application단의 스레드에 걸렸던 Block이 풀린다.

Blocking (=syschronous 동일의미)  
I/O가 끝날 때까지 대기해야 한다.  
끝나기 전에는 함수가 반환되지 않기 때문이다.  
커널이 작업을 완료되기전까지 유저 프로세스는 작업을 중단한 채 대기해야 한다.   
IO작업이 CPU자원을 거의 쓰지 않기 때문에 blocking방법은 cpu 자원 낭비가 심하다.  


Non - Blocking (=asynchronous)  
non-blocking 방식은 I/O작업을 진행하는 동안 유저 프로세스의 작업을 중단시키지 않는다.  

Blocking vs Non-Blocking  
Application 실행 시 운영체제 대기 큐에 들어가면서 요청에 대한 system call이 완료된 후에 응답을 보낼 경우 **blocking**    
Application 실행 시 운영체제 대기 큐에 들어가지 않고 실행 여부와 관계없이 바로 응답을 보낼 경우 **non-blocking**