# wineme-java :wine:

When working with the Hibernate backend please use these commands.

## Set-up
Downgrade to java 8 (do this once before working on project)
First check that you are using Java 8
`java -version`

If not type this into command line to downgrade to Java 8
`export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)`

If you don't have Java8 download it from `oracle.com`

## When ever you wanat to start server again after changes are made
First clean install the maven project
`mvn clean install`

Then compress to jar which starts a server at `localhost:8000`
`java -jar target/java-server-0.0.1-SNAPSHOT.jar`
