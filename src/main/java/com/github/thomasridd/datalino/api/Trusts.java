package com.github.thomasridd.datalino.api;

import com.github.davidcarboni.restolino.framework.Api;
import com.github.thomasridd.datalino.model.BedRequestList;
import com.github.thomasridd.datalino.model.Root;
import com.github.thomasridd.datalino.model.TrustList;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;

/**
 * Created by Tom.Ridd on 14/05/2016.
 */
@Api
public class Trusts {
  @GET
  public TrustList get(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.addHeader("Access-Control-Allow-Origin", "*");

    return Root.getTrustList();
  }
}
