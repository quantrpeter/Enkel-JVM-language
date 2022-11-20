# Enkel

[![Build Status](https://travis-ci.org/JakubDziworski/Enkel-JVM-language.svg?branch=master)](https://travis-ci.org/JakubDziworski/Enkel-JVM-language)

Enkel is a simple programming language running on the  jvm

# [Blog - Creating JVM Language](http://jakubdziworski.github.io/categories.html#Enkel-ref)
 Since day one I've been describing whole project development process on my [blog post series - Creating JVM Language](http://jakubdziworski.github.io/categories.html#Enkel-ref). 
It consist of 20 posts covering all the issues.
When in doubt browsing the code, I encorouge you to take a look at the blog.

## Compiling and running Enkel scripts


1. Make sure `java` and `mvn` are using Java 8:
```bash
> export JAVA_HOME=/home/me/jdks/JDK8
> mvn --version
Apache Maven 3.8.6 (84538c9988a25aec085021c365c560670ad80f63)
Maven home: /usr/local/Cellar/maven/3.8.6/libexec
Java version: 1.8.0_352, vendor: Temurin, runtime: /Users/kuba/Library/Java/JavaVirtualMachines/temurin-1.8.0_352/Contents/Home/jre
Default locale: en_PL, platform encoding: UTF-8
OS name: "mac os x", version: "10.16", arch: "x86_64", family: "mac"
> java -version
openjdk version "1.8.0_352"
OpenJDK Runtime Environment (Temurin)(build 1.8.0_352-b08)
OpenJDK 64-Bit Server VM (Temurin)(build 25.352-b08, mixed mode)
```
2. Build compiler into executable jar

```bash
mvn clean package
```
3. Compile sample .enk file (You can find more examples in EnkelExamples directory)

```bash
java -classpath compiler/target/compiler-1.0-SNAPSHOT-jar-with-dependencies.jar:. com.kubadziworski.compiler.Compiler EnkelExamples/DefaultParamTest.enk
```

3. Run compiled .enk program

```bash
java DefaultParamTest
```
