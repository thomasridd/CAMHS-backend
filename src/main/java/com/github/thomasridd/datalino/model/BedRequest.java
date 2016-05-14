package com.github.thomasridd.datalino.model;

import java.util.Date;

/**
 * Created by Tom.Ridd on 14/05/2016.
 */
public class BedRequest {
  public String id;

  public String originId;
  public String destinationId;

  public String patient;

  int beds_type1;
  int beds_type2;
  int beds_type3;

  public int accepted = 0;
  public int rejected = 0;
  public int cancelled = 0;

  public Date created;
  public Date completed;

  public String referredBy;
  public String nhsNumber;
  public String age;
  public String gender;
}
