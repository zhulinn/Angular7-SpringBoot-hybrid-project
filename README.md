
# Angular7-SpringBoot-hybrid-project
This a hybrid Angular 7 & Spring Boot Maven project. It combines Angular 7 and Spring Boot codes into one single Maven project. 
It can be used to demo a RESTful web application with a single project.

#### Live Demo:  [https://springboot-angular-shop.herokuapp.com/](https://springboot-angular-shop.herokuapp.com/)

> The codes is modified from my another full stack web application. Check here: [SpringBoot-Angular7-ShoppingCart](https://github.com/zhulinn/SpringBoot-Angular7-ShoppingCart)

# How to Run

Start the Spring Boot Application.
```bash
mvn spring-boot:run
```
Angular CLI re-builds static files automatically each time the Spring Boot application starts.

# Approach
There are several modifications needed to combine Angular 7 and Spring Boot codes into one Maven project.

1. pom.xml
Insert executions to build Angular project automatically.
```xml
  <build>
    <plugins>
      
      <!--Build Angular project start-->
      <plugin>
        <groupId>com.github.eirslett</groupId>
        <artifactId>frontend-maven-plugin</artifactId>
        <version>1.6</version>
        <configuration>
          <nodeVersion>v8.12.0</nodeVersion>
          <npmVersion>6.4.1</npmVersion>
          <workingDirectory>src/main/web/</workingDirectory>
        </configuration>
        <executions>
          <execution>
            <id>install node and npm</id>
            <goals>
              <goal>install-node-and-npm</goal>
            </goals>
          </execution>
          <execution>
            <id>npm install</id>
            <goals>
              <goal>npm</goal>
            </goals>
          </execution>
          <execution>
            <id>prod</id>
            <goals>
              <goal>npm</goal>
            </goals>
            <configuration>
              <arguments>run-script build</arguments>
            </configuration>
            <phase>generate-resources</phase>
          </execution>
        </executions>
      </plugin>
      <!--Build Angular project end-->
      
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </build>
```

2. angular.json

Modify `outpath` of `ng build`, so the static files will be recognized by Spring Boot.
```json
            "outputPath": "src/main/resources/public",
```

3. .gitignore

Here is my example.
```
# See http://help.github.com/ignore-files/ for more about ignoring files.

# compiled output
/src/main/resources/public
/dist
/tmp
/out-tsc

# dependencies
/src/main/web
/node*
/node_modules

# IDEs and editors
/web.iml
/node_modules

# profiling files
chrome-profiler-events.json
speed-measure-plugin.json

# IDEs and editors
/.idea
.project
.classpath
.c9/
*.launch
.settings/
*.sublime-workspace

# IDE - VSCode
.vscode/*
!.vscode/settings.json
!.vscode/tasks.json
!.vscode/launch.json
!.vscode/extensions.json

# misc
/.sass-cache
/connect.lock
/coverage
/libpeerconnection.log
npm-debug.log
yarn-error.log
testem.log
/typings

# System Files
.DS_Store
Thumbs.db

/target/
!.mvn/wrapper/maven-wrapper.jar

### STS ###
.apt_generated
.classpath
.factorypath
.project
.settings
.springBeans
.sts4-cache

### IntelliJ IDEA ###
.idea
*.iws
*.iml
*.ipr

### NetBeans ###
/nbproject/private/
/build/
/nbbuild/
/dist/
/nbdist/
/.nb-gradle/
```

