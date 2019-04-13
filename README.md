[ ![Download](https://api.bintray.com/packages/mrivanplaysbg/com.github.mrivanplays/JarLoaderAPI/images/download.svg) ](https://bintray.com/mrivanplaysbg/com.github.mrivanplays/JarLoaderAPI/_latestVersion)

# JarLoader API
Load your jars easily!

# Usage

First, setup your gradle/maven. We will use maven in our example.
Here's our example pom:
```xml

  <groupId>GROUP</groupId>
  <artifactId>ARTIFACT</artifactId>
  <version>VERSION</version>

  <build>
    <defaultGoal>clean package</defaultGoal>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.7.0</version>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-shade-plugin</artifactId>
        <version>3.1.0</version>
        <executions>
          <execution>
            <phase>package</phase>
            <goals>
              <goal>shade</goal>
            </goals>
            <configuration>
              <createDependencyReducedPom>false</createDependencyReducedPom>
              <relocations>
                <relocation>
                  <pattern>com.github.mrivanplays.jarloader.api</pattern>
                  <shadedPattern>YOUR_PACKAGE.com.github.mrivanplays.jarloader</shadedPattern>
                </relocation>
              </relocations>
            </configuration>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>

  <repositories>
    <repository>
      <id>mrivanplays-repo</id>
      <url>https://dl.bintray.com/mrivanplaysbg/com.github.mrivanplays/</url>
    </repository>
  </repositories>

  <dependencies>
    <dependency>
      <groupId>com.github.mrivanplays</groupId>
      <artifactId>jarloader-api</artifactId>
      <version>CURRENT_VERSION</version>
      <scope>compile</scope>
    </dependency>
  </dependencies>
```

Then need a parent class of the loaded files
Thats our example:
```java
public abstract class ExampleLoadingClass {

  public abstract void foo(String s);
  public abstract void bar(String s);
  public abstract void baz(String s);
}
```

And thats how to use it (loading all jar files from a directory)
```java
public class JarLoaderExample {

  public static List<ExampleLoadingClass> loadAll(File dir) {
    if(!dir.isDirectory()) {
      return Collections.emptyList();
    }
    if(!dir.exists()) {
      return Collections.emptyList();
    }
    List<ExampleLoadingClass> loaded = new ArrayList<>();
    JarLoader loader = new JarLoader();
    for(File file : dir.listFiles((file, name) -> name.endsWith(".jar"))) {
      loaded.add(loader.load(file, ExampleLoadingClass.class));
    }
    return loaded;
  }
}
```