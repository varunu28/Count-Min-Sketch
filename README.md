# Count Min Sketch
A Java implementation of the probabilistic data structure Count Min Sketch.

## How to use?
#### Build the project
```
mvn clean install
```

#### Add the dependency to your project
```xml
<dependency>
    <groupId>com.varun.smc</groupId>
    <artifactId>sketch-min-count</artifactId>
    <version>1.0.0</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/path/to/sketch-min-count-1.0.0.jar</systemPath>
</dependency>
```

#### Create a Count Min Sketch
```java
public class Main {
    public static void main(String[] args) {
        CountMinSketch<String> sketch = new CountMinSketchImpl<>(5, 100);
        sketch.increment("example");
        int count = sketch.getCount("example");
        System.out.println("Count: " + count);
    }
}
```