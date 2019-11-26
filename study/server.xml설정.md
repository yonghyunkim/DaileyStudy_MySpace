# server.xml 설정


### Server (org.apache.catalina.Server)
최상위 element로써, shutdowon 요청 처리를 위한 address와 port속성을 가지고 있다.
IP address와 포트를 설정하며 기본 값은 localhost 8005이다.

```
<Server port="8005" shutdown="SHUTDOWN">
```

### Service(org.apache.catalina.Service)
Service 하위에 있으며 <Connector> 모음이다.
속성 : className, name

```
<Service name="Catalina">
```

### Engine(org.apache.catalina.Engine)
속성 : name, defaultHost, jvmRoute 

```
* name : <Engine>의 이름
* defaultHost : <Engine>하위에 속한 <Host>가운데 하나이며, 어떤 도 처리하지 않는 요청을 처리한다.
* jvmRoute : Apache HTTP Server 등 front-end에 위치한 Load Balancer가 여러 Tomcat 인스턴스를 구분하기 위해 사용한다. 특히 클러스터 그룹 내의 jvmRoute는 각 인스턴스마다 고유해야 한다.
```

```
<Engine name="Catalina" defaultHost="localhost">
```

### Host(org.apache.catalin.Hst)
속성 : name, appBase

```
* name : <Host>의 이름은 name 속성을 통해 설정한다. 상위 <Engine>내에 2개 이상의 <Host>가 구성되어 있다면 그 중 1개 <Host>가 <Engine>의 defaultHost값이 되어야 한다.
* appBase : <Host>의 애플리케이션 디렉터리 "/"를 포함한 절대 경로, 혹은 $CATALINA_BASE의 상대 경로로 설정하며 기본은 wbapps이다.
```

```
<Host name="localhost" appBase="webapps" unpackWARs="true" autoDeploy="true">
```

### Context

```
* docBase : 프로젝트의 경로를 설정해 줘야된다.
* path : docBase에서의 범위를 설정해야한다.
* reloadable : java, jsp 파일이 변경되면 자동 reload되야 하는지를 설정.
```

```
<Host name="localhost" appBase="webapps"
            unpackWARs="true" autoDeploy="true">
  <Context docBase="특정경로" path="/application1" reloadable="true"></Context>
  ...
```

속성 : 기본적으로 docBase, path, reloadable







