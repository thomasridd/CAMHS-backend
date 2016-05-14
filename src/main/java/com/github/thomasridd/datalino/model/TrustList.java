package com.github.thomasridd.datalino.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Tom.Ridd on 14/05/2016.
 */
public class TrustList extends ArrayList<Trust> {
  Trust getTrust(String id) {
    List<Trust> collect = this.stream().filter(trust -> trust.id.equalsIgnoreCase(id)).collect(Collectors.toList());
    return collect.size() > 0 ? collect.get(0) : null;
  }
}
