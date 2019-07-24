### Maven: create a Java project

http://sparkjava.com/documentation#getting-started
https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
https://www.mkyong.com/maven/how-to-create-a-java-project-with-maven/

```
mvn archetype:generate -DgroupId={project-packaging} -DartifactId={project-name} -DarchetypeArtifactId={maven-template} -DinteractiveMode=false
eg
mvn archetype:generate -DgroupId=com.vince.proalpha -DartifactId=alpha-project -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

To run the all-in jar file:

```
java -cp target/alpha-project-1.0-SNAPSHOT.jar com.vince.proalpha.App
```


Try java bindings:

```
mvn compile
mvn exec:java@run-app -Drestport=8081 -Dparty=Bob
```

