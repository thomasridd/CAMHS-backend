package com.github.thomasridd.datalino.api;

import com.github.davidcarboni.restolino.framework.Api;
import com.github.thomasridd.datalino.model.BedRequest;
import com.github.thomasridd.datalino.model.PBedRequest;
import com.github.thomasridd.datalino.model.Root;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

/**
 * Created by Tom.Ridd on 14/05/2016.
 */
@Api
public class Request {

  @GET
  public PBedRequest get(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.addHeader("Access-Control-Allow-Origin", "*");

    String[] split = request.getPathInfo().split("/");
    if (split.length < 2) {
      return null;
    } else if (split.length == 3){
      BedRequest bedRequest = Root.getBedRequestList().getRequest(split[2]);
      return new PBedRequest(bedRequest);

    } else {
        String action = split[3];
        String id = split[2];

      PBedRequest bedRequest = actionBedRequest(action, id);

      if (bedRequest != null) return bedRequest;
    }
    return null;
  }

  public PBedRequest actionBedRequest(String action, String id) throws IOException {
    if (action.equalsIgnoreCase("reject")) {
      BedRequest bedRequest = Root.getBedRequestList().getRequest(id);
      if (bedRequest != null) {
        bedRequest.completed = new Date();
        bedRequest.rejected = 1;
      }
      return new PBedRequest(bedRequest);

    } else if (action.equalsIgnoreCase("accept")) {
      BedRequest bedRequest = Root.getBedRequestList().getRequest(id);
      if (bedRequest != null) {
        bedRequest.completed = new Date();
        bedRequest.accepted = 1;

        Root.getBedRequestList().stream()
                .filter(altRequest -> altRequest.nhsNumber.equalsIgnoreCase(bedRequest.nhsNumber))
                .filter(altRequest2 -> ((altRequest2.rejected + altRequest2.accepted) == 0))
                .forEach(altRequest3 -> {
                  altRequest3.cancelled = 1;
                });
      }

      return new PBedRequest(bedRequest);

    } else if (action.equalsIgnoreCase("cancel")) {
      BedRequest bedRequest = Root.getBedRequestList().getRequest(id);
      if (bedRequest != null) {
        bedRequest.completed = new Date();
        bedRequest.cancelled = 1;
      }
      return new PBedRequest(bedRequest);

    }
    return null;
  }

}
