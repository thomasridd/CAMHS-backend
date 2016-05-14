package com.github.thomasridd.datalino.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Tom.Ridd on 14/05/2016.
 */
public class BedRequestList extends ArrayList<BedRequest>{

  public BedRequest getRequest(String id) {
    List<BedRequest> collect = this.stream().filter(bedRequest -> bedRequest.id.equalsIgnoreCase(id)).collect(Collectors.toList());
    return collect.size() > 0 ? collect.get(0) : null;
  }
}
