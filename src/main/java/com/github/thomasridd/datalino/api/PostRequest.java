package com.github.thomasridd.datalino.api;

import com.github.davidcarboni.restolino.framework.Api;
import com.github.thomasridd.datalino.model.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;

/**
 * Created by Tom.Ridd on 15/05/2016.
 */
@Api
public class PostRequest {
  @GET
  public PBedRequest get(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.addHeader("Access-Control-Allow-Origin", "*");

    String originId = request.getParameter("originId");
    String patient = request.getParameter("patient");
    String beds_type = request.getParameter("beds_type");
    String referredBy = request.getParameter("referredBy");
    String nhsNumber = request.getParameter("nhsNumber");
    String age = request.getParameter("age");
    String gender = request.getParameter("gender");

    Search search = new Search();
    List<com.github.thomasridd.datalino.model.Trust> trusts = search.get(originId, beds_type);

    BedRequest bedRequest = null;
    for (int i = 0; (i < 5 && i < trusts.size()); i ++) {
      bedRequest = new BedRequest();
      bedRequest.originId = originId;
      bedRequest.destinationId = trusts.get(i).id;
      bedRequest.patient = patient;
      bedRequest.gender = gender;
      bedRequest.age = age;
      bedRequest.nhsNumber = nhsNumber;
      bedRequest.referredBy = referredBy;
      if (beds_type.equalsIgnoreCase("1")) {
        bedRequest.beds_type = 1;
        bedRequest.beds_type1 = 1;
      } else if (beds_type.equalsIgnoreCase("2")) {
        bedRequest.beds_type = 2;
        bedRequest.beds_type2 = 1;
      } else {
        bedRequest.beds_type = 3;
        bedRequest.beds_type3 = 1;
      }
      Root.addBedRequest(bedRequest);
    }
    return new PBedRequest(bedRequest);
  }

}
