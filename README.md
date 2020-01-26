# Demo
The demo shows how to achieve SSL/TLS encrypted communication &amp; handle standard http-requests (interacting with H2-Database).</br>
>![picture](https://github.com/nicholas-dietz/spring-boot_angular_demo/blob/master/GitHub/img/demo-ui.png)

## Requires
- Spring-Boot
  - Jdk 8
  - Maven
- [Angular](https://codeburst.io/how-to-build-an-angular-app-with-angular-cli-in-a-couple-of-minutes-43089d3ab272)
  - NPM
  - Angular CLI

## Start

### Spring-Boot

> Navigate to ./Github/demo-service/


#### Generate keystore
```sh
keytool -genkeypair -alias <name> -keyalg RSA -keysize 2048 -storetype PKCS12 <name>.p12 -validity 3650
keytool -genkeypair -alias <name> -keyalg RSA -keysize 2048 -keystore <name>.jks -validity 3650
keytool -importkeystore -srckeystore <name>.jks -destkeystore <name>.p12 -deststoretype pkcs12
```
> Move <name>.p12 & <name>.jks to ../keystore/

##### Edit application.yml
server.ssl.* </br>
trust.*

#### Build jar
```sh
cd /Path/to/demo-service/ && ./mvnw clean package
``` 

**OR**

Run via IDE


### Angular

> Navigate to ./Github/demo-ui/

#### Edit ./src/environments/environment.ts

> serviceHost: 'https://[host-of-service]:8443/api/v1'

#### Run

``` sh
ng serve
```

### Finish

**Now Spring-Boot runs on port 8443 & Angular on port 4200.**
 
 > Also H2-Console is reachable at https://[host-of-service]:8443/h2-console
