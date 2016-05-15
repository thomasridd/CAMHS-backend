package com.github.thomasridd.datalino.api;

import com.github.davidcarboni.restolino.framework.Api;
import com.github.thomasridd.datalino.model.Root;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;

/**
 * Created by Tom.Ridd on 15/05/2016.
 */
@Api
public class Trust {

  @GET
  public com.github.thomasridd.datalino.model.Trust get(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String[] split = request.getPathInfo().split("/");
    if (split.length < 2) {
      return null;
    } else if (split.length == 3){
      return Root.getTrustList().getTrust(split[2]);
    }
    return null;
  }
}
