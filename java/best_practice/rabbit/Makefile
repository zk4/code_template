# run:
# 	javac src/main/java/com/zk/App.java
# 	java -cp ./src/main/java com.zk.App


package:
	mvn package

test:
	mvn test

run:
	mvn clean package
	java -jar target/Crunchify/App.jar

run_one_jar:
	mvn clean assembly:assembly -DdescriptorId=jar-with-dependencies
	java -jar target/*.jar

run_jar_with_lib:
	mvn clean package
	java -jar target/Crunchify/*.jar