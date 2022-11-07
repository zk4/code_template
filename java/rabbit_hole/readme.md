
此脚手架集成了测试,打包

## coge 快速开始
创建 member_service 多模块项目,
``` bash
coge java rabbit_hole rabbit:web hole:api rabbit_hole:member_service  @:member_service

cd member_service  && mvn install
cd web && mvn spring-boot:run
```

## package for fat jar
``` sh
cd rabbit_hole
mvn clean package
```


## 统一版本
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

rabbit/pom.xml
``` xml
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>1.1.12.RELEASE</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

```


## 包上与下载配置

在 rabbit_hole/pom.xml 确定以下配置为自己私服的正确配置

``` xml
  <!--包下载配置-->
     <repositories>
         <repository>
             <id>zkty-center-public</id>
             <name>Public Repositories</name>
             <url>https://nexus.spacenx.cn/repository/center-public/</url>
             <snapshots>
                 <updatePolicy>always</updatePolicy>
                 <enabled>true</enabled>
             </snapshots>
         </repository>
     </repositories>

     <!--插件服务器配置-->
     <pluginRepositories>
         <pluginRepository>
             <id>zkty-center-public</id>
             <name>Public Repositories</name>
             <url>https://nexus.spacenx.cn/repository/center-public/</url>
         </pluginRepository>
     </pluginRepositories>

     <!--上传服务器配置-->
     <distributionManagement>
         <repository>
             <id>zkty-center-releases</id>
             <name>zkty Center Releases</name>
             <url>https://nexus.spacenx.cn/repository/center-release/</url>
         </repository>
         <snapshotRepository>
             <id>zkty-center-snapshots</id>
             <name>zkty Center Snapshots</name>
             <url>https://nexus.spacenx.cn/repository/center-snapshot/</url>
         </snapshotRepository>
     </distributionManagement>
```

## 打包上传
``` bash
mvn  clean source:jar  deploy
```

