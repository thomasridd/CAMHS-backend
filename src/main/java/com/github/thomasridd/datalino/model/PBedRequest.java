package com.github.thomasridd.datalino.model;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Tom.Ridd on 14/05/2016.
 */
public class PBedRequest {
  public String id;

  public String originId;
  public Trust originTrust;

  public String destinationId;
  public Trust destinationTrust;

  public String patient;

  int beds_type1;
  int beds_type2;
  int beds_type3;

  public int accepted = 0;
  public int rejected = 0;
  public int cancelled = 0;

  public String status;

  public Date created;
  public Date completed;


  public String referredBy;
  public String nhsNumber;
  public String age;
  public String gender;

  public PBedRequest(BedRequest bedRequest) throws IOException {
    id = bedRequest.id;
    originId = bedRequest.originId;
    originTrust = Root.getTrustList().getTrust(originId);

    patient = bedRequest.patient;

    destinationId = bedRequest.destinationId;
    destinationTrust = Root.getTrustList().getTrust(destinationId);

    beds_type1 = bedRequest.beds_type1;
    beds_type2 = bedRequest.beds_type2;
    beds_type3 = bedRequest.beds_type3;

    accepted = bedRequest.accepted;
    rejected = bedRequest.rejected;
    cancelled = bedRequest.cancelled;

    if (accepted == 1) { status = "Accepted"; }
    else if (rejected == 1) { status = "Rejected"; }
    else if (cancelled == 1) { status = "Cancelled"; }
    else { status = "Active"; }

    created = bedRequest.created;
    completed = bedRequest.completed;

    referredBy = bedRequest.referredBy;
    nhsNumber = bedRequest.nhsNumber;
    age = bedRequest.age;
    gender = bedRequest.gender;
  }
}
