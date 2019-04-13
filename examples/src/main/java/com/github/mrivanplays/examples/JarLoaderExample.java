package com.github.mrivanplays.examples;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import com.github.mrivanplays.jarloader.api.JarLoader;

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