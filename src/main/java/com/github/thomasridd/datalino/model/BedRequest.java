package com.github.thomasridd.datalino.model;

import fabricator.Contact;
import fabricator.Fabricator;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Tom.Ridd on 14/05/2016.
 */
public class BedRequest {
  public String id;

  public String originId;
  public String destinationId;

  public String patient;

  public int beds_type1 = 0;
  public int beds_type2 = 0;
  public int beds_type3 = 0;

  public int accepted = 0;
  public int rejected = 0;
  public int cancelled = 0;

  public Date created;
  public Date completed;

  public String referredBy;
  public String nhsNumber;
  public String age;
  public String gender;

  public int beds_type = 0;
}
