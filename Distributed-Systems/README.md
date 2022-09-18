# Distributed-Systems

ForkExec

**Fork**: delicious menus for **Exec**utives

Distributed Systems 2018-2019, 2nd semester project

## Authors

Group A51

João Palet       86447   joaopalet

Francisco Sena   86420   innerpolymorph

André Rodrigues  70119   deankart

### Description

To configure and run tests on the project:

    - On the root directory,, run:
        > mvn install -Dskiptests

    - Then, in /hub-ws, /pts-ws and one /rst-ws server directories, run:
        > mvn compile exec:java

    - To run the second /rst-ws server, run on another terminal:
        > mvn compile exec:java -Dws.i=2

    - Finally, to test all hub-ws-cli IT tests, on /rst-ws-cli run:    
        > mvn verify



To run specific restaurant tests:

    - On /rst-ws directory, run:
        > mvn compile exec:java
    - To run the other server, on another terminal on the same directory, run:
        > mvn compile exec:java -Dws.i=2
    - Finally, to run tests open a terminal on /rst-ws-cli:
        > mvn verify



To run specific points tests:

    - On /pts-ws directory, run:
        > mvn compile exec:java
    - To run the other server, on another terminal on the same directory, run:
        > mvn compile exec:java -Dws.i=2
    - Finally, to run tests open a terminal on /pts-ws-cli:
        > mvn verify

### Prerequisites

Java Developer Kit 8 is required running on Linux, Windows or Mac.
Maven 3 is also required.

To confirm that you have them installed, open a terminal and type:

```
javac -version

mvn -version
```

### Installing

To compile and install all modules:

```
mvn clean install -DskipTests
```

The tests are skipped because they require each server to be running.


## Built With

* [Maven](https://maven.apache.org/) - Build Tool and Dependency Management
* [JAX-WS](https://javaee.github.io/metro-jax-ws/) - SOAP Web Services implementation for Java



## Versioning

We use [SemVer](http://semver.org/) for versioning. 