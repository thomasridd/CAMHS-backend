package com.github.thomasridd.datalino.api;

import com.github.davidcarboni.restolino.framework.Api;
import com.github.thomasridd.datalino.model.BedRequest;
import com.github.thomasridd.datalino.model.BedRequestList;
import com.github.thomasridd.datalino.model.PBedRequest;
import com.github.thomasridd.datalino.model.Root;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;

/**
 * Created by Tom.Ridd on 14/05/2016.
 */
@Api
public class Requests {

  @GET
  public List<PBedRequest> get(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.addHeader("Access-Control-Allow-Origin", "*");

    List<BedRequest> bedRequestList = new ArrayList<>();

    String[] split = request.getPathInfo().split("/");
    if (split.length < 3) {
      bedRequestList = Root.getBedRequestList();
    } else if (split[2].equalsIgnoreCase("sent")) {
      String id = split[3];
      bedRequestList = Root.getBedRequestList().stream()
              .filter(bedRequest -> bedRequest.originId.equalsIgnoreCase(id))
              .collect(Collectors.toList());
    } else if (split[2].equalsIgnoreCase("received")) {
      String id = split[3];
      bedRequestList = Root.getBedRequestList().stream()
              .filter(bedRequest -> bedRequest.destinationId.equalsIgnoreCase(id))
              .collect(Collectors.toList());
    }

    String status = request.getParameter("status");

    if (status == null) {
      System.out.println("No status");
    } else if (status.equalsIgnoreCase("active")) {
      bedRequestList = bedRequestList.stream()
              .filter(bedRequest -> (bedRequest.accepted + bedRequest.cancelled + bedRequest.rejected == 0))
              .collect(Collectors.toList());
    } else if (status.equalsIgnoreCase("rejected")) {
      bedRequestList = bedRequestList.stream()
              .filter(bedRequest -> (bedRequest.rejected == 1))
              .collect(Collectors.toList());
    } else if (status.equalsIgnoreCase("cancelled")) {
      bedRequestList = bedRequestList.stream()
              .filter(bedRequest -> (bedRequest.cancelled == 1))
              .collect(Collectors.toList());
    } else if (status.equalsIgnoreCase("accepted")) {
      bedRequestList = bedRequestList.stream()
              .filter(bedRequest -> (bedRequest.accepted == 1))
              .collect(Collectors.toList());
    }

     List<PBedRequest> pBedRequests = new ArrayList<>();
    for (BedRequest bedRequest: bedRequestList) {
      pBedRequests.add(new PBedRequest(bedRequest));
    }

    return pBedRequests;
  }



}
