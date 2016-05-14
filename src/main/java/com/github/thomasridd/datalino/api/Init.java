package com.github.thomasridd.datalino.api;

import com.github.davidcarboni.restolino.framework.Startup;
import com.github.thomasridd.datalino.model.Root;

/**
 * Created by Tom.Ridd on 14/05/2016.
 */
public class Init implements Startup {
  @Override
  public void init() {
    Root.init();
  }
}
