# spring-boot-cloud-eureka-path-variable-issue

https://github.com/spring-cloud/spring-cloud-netflix/issues/1252  
https://github.com/spring-projects/spring-boot/issues/6629  
https://gitter.im/spring-projects/spring-boot?at=57acee60ae838f6f56988f67  

Relvant class: `my.test.TestRESTController`

To produce this issue:
```
./gradlew bootRun
curl http://localhost:8080/my/custom/path/test@sample.com
```

UNEXPECTED: **You get a 406 back**

------------

Workaround (well not really for me, I need to use spring cloud eureka)!

* Comment out in build.gradle
```
//compile 'org.springframework.cloud:spring-cloud-starter-eureka'
```

Run again: 
```
./gradlew clean
./gradlew bootRun
curl http://localhost:8080/my/custom/path/test@sample.com
```

EXPECTED: **i got here test@sample.com**


 
