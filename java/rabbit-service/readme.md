
此脚手架集成了测试,打包

## 文件夹结构
```
- rabbit-shared
  - pom.xml (shared config)
- rabbit-app
  - pom.xml
- rabbit-lib
  - pom.xml
- pom.xml  (only for module)
```

## coge 快速开始
创建 member_service 多模块项目
``` bash
# 根据 coge  创建工程
coge java rabbit-service  rabbit:member  @:member-service
# 确定工程 OK
cd member-service  && mvn install &&  mvn test
```

## 从命令启动 sprign-boot:run
从目标目录
``` bash
# 必须安装到 .m2, mvn spring-boot:run 才找的到
mvn clean install && cd rabbit-app && mvn spring-boot:run
```

从根目录,指定模块
``` bash
mvn clean install && mvn -pl rabbit-app spring-boot:run
```

## package for fat jar
``` sh
cd rabbit_service
mvn clean package
```


## 统一版本
parent/pom.xml
下面代码管理了统一版本, 放在 parent 里是个合适的选择.
```
  <dependencyManagement>
    <dependencies>
      <!-- SpringBoot 依赖配置 -->
      <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-dependencies</artifactId>
        <version>${spring-boot.version}</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
    </dependencies>
  </dependencyManagement>
```


## fat jar 配置

rabbit-app/pom.xml
``` xml
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
```


## 包上与下载配置

配置在 parent 里, 请联系运维, 将 url 配置正确.

``` xml
    <!--包下载配置-->
    <repositories>
        <repository>
            <id>x-center-public</id>
            <name>Public Repositories</name>
            <url>https://nexus.x.cn/repository/center-public/</url>
            <snapshots>
                <updatePolicy>always</updatePolicy>
                <enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>

    <!--插件服务器配置-->
    <pluginRepositories>
        <pluginRepository>
            <id>x-center-public</id>
            <name>Public Repositories</name>
            <url>https://nexus.x.cn/repository/center-public/</url>
        </pluginRepository>
    </pluginRepositories>

    <!--上传服务器配置-->
    <distributionManagement>
        <repository>
            <id>x-center-releases</id>
            <name>x Center Releases</name>
            <url>https://nexus.x.cn/repository/center-release/</url>
        </repository>
        <snapshotRepository>
            <id>x-center-snapshots</id>
            <name>x Center Snapshots</name>
            <url>https://nexus.x.cn/repository/center-snapshot/</url>
        </snapshotRepository>
    </distributionManagement>

```

## 打包上传
``` bash
cd rabbit-app
mvn clean source:jar  deploy
```

