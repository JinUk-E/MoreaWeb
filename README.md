# AdminWeb
모래게임즈 관리용 웹페이지
이미지가 포함된 Docu : https://jjw6822.notion.site/AWS-11f93cba1563808cac8feb494bcf9ba0?pvs=4

## 📚 Kotlin + Spring Boot + Tomcat 프로젝트 구성 Wiki

### 목차

1. 프로젝트 개요
2. 환경 설정
   1) 개발 도구
   2) JDK 설치
   3) Kotlin 설정
   4) Gradle 설정
3. 프로젝트 생성
   1) 스프링 부트 초기 설정
   2) 톰캣 서버 설정
4. 애플리케이션 구조
5. 빌드 및 실행
6. FAQ

---

## 1. 프로젝트 개요

Kotlin을 기반으로 한 스프링부트 프로젝트로, Tomcat 서버를 사용하여 애플리케이션을 배포하는 것이 목표입니다. <br>
이 문서에서는 해당 프로젝트를 구성하고 실행하는 방법을 설명합니다.


## 2. 환경설정

1. 개발도구
    - IntelliJ IDEA
    - **JDK 17** (또는 그 이상)
    - Gradle (빌드 도구)

1. JDK 설치
    - IntelliJ 에서 제공하는 JDK 버전 사용

2. Kotlin 설정
    - 코틀린으로 기본 언어 설정

3. Gradle 설정
    - 코틀린과 연결된 Gradle 설정

    - 초기 Gradle 설정값
        ```kotlin
        plugins {
        	kotlin("jvm") version "1.9.25"
        	kotlin("plugin.spring") version "1.9.25"
        	id("org.springframework.boot") version "3.3.4"
        	id("io.spring.dependency-management") version "1.1.6"
        }
        
        group = "com.example"
        version = "0.0.1-SNAPSHOT"
        
        java {
        	toolchain {
        		languageVersion = JavaLanguageVersion.of(17)
        	}
        }
        
        repositories {
        	mavenCentral()
        }
        
        dependencies {
        	implementation("org.springframework.boot:spring-boot-starter-web")
        	implementation("org.springframework.boot:spring-boot-starter-web-services")
        	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        	implementation("org.jetbrains.kotlin:kotlin-reflect")
        	developmentOnly("org.springframework.boot:spring-boot-devtools")
        	runtimeOnly("org.postgresql:postgresql")
        	testImplementation("org.springframework.boot:spring-boot-starter-test")
        	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
        	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
        }
        
        kotlin {
        	compilerOptions {
        		freeCompilerArgs.addAll("-Xjsr305=strict")
        	}
        }
        
        tasks.withType<Test> {
        	useJUnitPlatform()
        }
        ```


1. IntelliJ프로젝트 세팅


## 3. 프로젝트 생성

1. 스프링부트 초기 설정
    - intelliJ의 프로젝트 생성을 통해 스프링부트 프로젝트를 생성합니다.
        - 스프링 부트 버전 3.3.4
        - 의존성 추가 :
          `Spring Web`,  `Spring Web Services`, `Spring Boot DevTools`, `PostgreSQL Driver`,
          `Mustache`


2. 톰캣 서버 설정
    - 기본적으로 스프링부트는 내장 톰캣 서버를 사용합니다. 별도의 설정 없이 내장 톰캣이 기본적으로 실행됩니다.
    - **Tomcat 포트 변경 (Optional)**
      `src/main/resources/application.properties` 파일에서 포트를 변경할 수 있습니다.

## 4. 애플리케이션 구조

1. 폴더 구조
    - 스프링부트의 기본 구조를 따르며, Kotlin으로 작성됩니다. 기본 구조는 아래와 같습니다.

    ```json
    src/
      └─ main/
          ├─ kotlin/  # Kotlin 소스 파일
          │   └─ com.example.demo/
          │       └─ DemoApplication.kt
          ├─ resources/
          │   └─ application.properties  # 설정 파일
          └─ test/
              └─ kotlin/
                  └─ com.example.demo/
    ```

2. 컨트롤러 작성 예시
    - 컨트롤러 어노테이션 사용
    - URL과 매핑 후 ResponseBody 를 통해 반환
   
   ```kotlin
   package com.moraegames.adminweb
   
   import org.springframework.stereotype.Controller
   import org.springframework.ui.Model
   import org.springframework.web.bind.annotation.GetMapping
   
   @Controller
   class MainController {
       @GetMapping("/")
       fun main(model: Model): String {
           model.addAttribute("title", "Main Page")
           model.addAttribute("name", "Morae")
           return "main"
       }
   }
   ```


## 5. 빌드 및 실행

1. build
    - Gradle을 사용해 프로젝트를 build

    ```bash
    ./gradlew build
    ```

    - build에 성공하면  `ProjectFolder>build>libs` 에 다음과 같은 jar 파일이 생성된다.
    `admin-web-0.0.1-SNAPSHOT.jar`

2. 실행
    - 내장된 Tomcat 서버로 애플리케이션을 실행

    ```bash
    ./gradlew bootRun
    ```

    - local에서 실행하면 http://localhost:{port} 에서 실행.
    - port 는 `ProjectFolder > src > main > resources > application.properties` 에서 수정 가능

    ```bash
    spring.application.name=TestSpringKo
    server.port=202 // 포트설정
    ```
