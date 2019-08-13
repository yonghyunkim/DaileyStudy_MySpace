# Mutable & Immutable

## Immutable 이란

**Immutable이란 생성후 변경 불가한 객체. (Immutable에는 set메서드가 없다.)**
Immutable을 쓰면 멀티 쓰레드 환경에서 좀 더 신뢰할 수 있는 코드를 만들어 내기 쉽다.

대표적인 Immutable 클래스 : String, Boolean, Integer, Float, Long 등등..
주의할 점은 변경불가라는 것은 heap영역에서의 변경불가라는 뜻이다.


```
String a = "a" -> a = "b"; 로 재할당은 가능하다.
```
이는 a가 reference하고 있는 heap 영역의 객체가 바뀌는 것이지 heap영역에 있는 값이 바뀌는것이 아니다.
즉, a가 바라보고 있는 객체가 바뀌는 것이지 heap 영역에 바라보고 있는값이 바뀌는것이 아니다. (객체가 바뀌는것)


String : Immutable, StringBuffer : Mutable

만일 객체를 둘다 새로 만든다면 별차이는 없다. 

```
StringBuffer b = new StringBuffer();
StringBuffer a = b.append("test");
System.out.println(a == b);
```

안좋은예)

```
String a  = "";
while(어떤 조건문){
    a += "머시기";
    if(딴 조건문){
        break;
    }
}
```

문제는 *a += "머시기";* 이 부분이다.
while문이 계속 돌면서 a에 객체를 계속 변경될수 있는 곳에 쓰면 메모리를 왕창 잡아먹는다. 그러므로 값이 정리가 된 이후에 
한큐에 Immutable로 만들어야 한다. 

###Immutable은 보통 final 클래스로 정의합니다.




```
package immutable;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class WrongImmutable {
    private final Date date;
    private final SimpleDateFormat dateFormat;
    public WrongImmutable(Date date){
        this.date = date;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    public String getMessage(){
        return dateFormat.format(date);
    }
}

---------------------------------------------------------------------------

package immutable;

import java.util.Date;

public class WrongImmutableTest {
    public static void main(String[] args) {
        Date testDate = new Date();
        WrongImmutable wrongImmutable = new WrongImmutable(testDate);
        testDate.setTime(testDate.getTime() + 10000000);
        System.out.println(wrongImmutable.getMessage());
    }
}
```


final로 사용하는것은 Immutable로 사용하겠다는 의미이다. 
하지만 testDate를 생성자로 넣게된다면 지역변수의 date가 변경된다. Immutable에서는 멤버 변수가 외부로 공개되어 변경이 가능하면 안 됩니다.


###자바에 진짜 Immutable이란 건 없다!
java의 reflection을 이용하면 변경 가능합니다. 다음 코드를 실행시켜 보세요.










