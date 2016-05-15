package com.github.thomasridd.datalino.api;

import com.github.davidcarboni.restolino.framework.Startup;
import com.github.thomasridd.datalino.model.BedRequestGenerator;
import com.github.thomasridd.datalino.model.Root;

import java.io.IOException;

/**
 * Created by Tom.Ridd on 14/05/2016.
 */
public class Init implements Startup {
  @Override
  public void init() {
    Root.init();

    try {
      BedRequestGenerator.generate();
      BedRequestGenerator.generate();
      for (int i = 1; i <= 5; i++) {
        BedRequestGenerator.generateAndComplete(i);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
