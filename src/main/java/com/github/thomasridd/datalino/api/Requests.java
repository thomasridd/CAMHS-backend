package com.github.thomasridd.datalino.api;

import com.github.davidcarboni.restolino.framework.Api;
import com.github.thomasridd.datalino.model.BedRequestList;
import com.github.thomasridd.datalino.model.Root;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;

/**
 * Created by Tom.Ridd on 14/05/2016.
 */
@Api
public class Requests {

  @GET
  public BedRequestList get(HttpServletRequest request, HttpServletResponse response) throws IOException {

    BedRequestList list = Root.getBedRequestList();
    return list;
  }



}
