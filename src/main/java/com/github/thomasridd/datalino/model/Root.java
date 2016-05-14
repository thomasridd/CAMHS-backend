package com.github.thomasridd.datalino.model;

import com.github.davidcarboni.ResourceUtils;
import com.github.davidcarboni.restolino.json.Serialiser;
import com.github.thomasridd.datalino.api.UrlHandler;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * Created by Tom.Ridd on 14/05/2016.
 */
public class Root {
  private static TrustList trustList = null;
  private static BedRequestList bedRequestList = null;

  public static TrustList getTrustList() throws IOException {
    URL resource = UrlHandler.class.getResource("/trusts2.json");
    if (trustList == null) {
      trustList = Serialiser.deserialise(Paths.get(resource.getPath()),TrustList.class);
    }
    return trustList;
  }

  public static BedRequestList getBedRequestList() throws IOException {
    URL resource = UrlHandler.class.getResource("/bedrequests.json");
    if (bedRequestList == null) {
      bedRequestList = Serialiser.deserialise(Paths.get(resource.getPath()),BedRequestList.class);
    }
    return bedRequestList;
  }
}
