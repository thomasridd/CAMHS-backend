package com.github.thomasridd.datalino.api;

import com.github.davidcarboni.restolino.framework.Api;
import com.github.thomasridd.datalino.model.Root;
import com.github.thomasridd.datalino.model.Trust;
import com.github.thomasridd.datalino.model.TrustList;

import java.io.IOException;
import java.util.ArrayList;
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
public class Search {
  @GET
  public List<Trust> get(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.addHeader("Access-Control-Allow-Origin", "*");
    TrustList trustList = Root.getTrustList();
    List<Trust> trusts = new ArrayList<>();

    String[] split = request.getPathInfo().split("/");
    if (split.length == 4) {
      String trustId = split[2]; // originating trust
      Trust origin = trustList.getTrust(trustId);

      String bedType = split[3];
      if (bedType.equalsIgnoreCase("1")) {
        trusts = trustList.stream().filter(trust -> trust.beds_available_type1 > 0).collect(Collectors.toList());
      } else if (bedType.equalsIgnoreCase("2")) {
        trusts = trustList.stream().filter(trust -> trust.beds_available_type2 > 0).collect(Collectors.toList());
      } else if (bedType.equalsIgnoreCase("3")) {
        trusts = trustList.stream().filter(trust -> trust.beds_available_type3 > 0).collect(Collectors.toList());
      }

      trusts.stream().forEach(trust -> trust.setDistanceTo(origin));

      return trusts;
    }

    return new ArrayList<>();
  }
}