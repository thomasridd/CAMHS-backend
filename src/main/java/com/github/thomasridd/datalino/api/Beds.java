package com.github.thomasridd.datalino.api;

import com.github.davidcarboni.restolino.framework.Api;
import com.github.thomasridd.datalino.model.Root;
import com.github.thomasridd.datalino.model.Trust;
import com.github.thomasridd.datalino.model.TrustList;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

/**
 * Created by Tom.Ridd on 14/05/2016.
 */
@Api
public class Beds {
  @GET
  public int get(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.addHeader("Access-Control-Allow-Origin", "*");

    String[] split = request.getPathInfo().split("/");
    if (split.length == 5) {
      String trustId = split[2];
      String bedType = split[3];
      String action = split[4];
      Trust trust = Root.getTrustList().getTrust(trustId);
      if (bedType.equalsIgnoreCase("1")) {
        if (action.equalsIgnoreCase("plus")) {
          trust.beds_available_type1++;
        } else if (action.equalsIgnoreCase("minus")) {
          trust.beds_available_type1--;
        }
      } else if (bedType.equalsIgnoreCase("2")) {
        if (action.equalsIgnoreCase("plus")) {
          trust.beds_available_type2++;
        } else if (action.equalsIgnoreCase("minus")) {
          trust.beds_available_type2--;
        }
      } else if (bedType.equalsIgnoreCase("3")) {
        if (action.equalsIgnoreCase("plus")) {
          trust.beds_available_type3++;
        } else if (action.equalsIgnoreCase("minus")) {
          trust.beds_available_type3--;
        }
      }
    }

    if (split.length >= 4) {
      String trustId = split[2];
      String bedType = split[3];
      Trust trust = Root.getTrustList().getTrust(trustId);
      if (bedType.equalsIgnoreCase("1")) {
        return trust.beds_available_type1;
      } else if (bedType.equalsIgnoreCase("2")) {
        return trust.beds_available_type2;
      } else if (bedType.equalsIgnoreCase("3")) {
        return trust.beds_available_type3;
      }
    }
    return -1;
  }

  @POST
  public int post(HttpServletRequest request, HttpServletResponse response) throws IOException {
    return get(request, response);
  }
}