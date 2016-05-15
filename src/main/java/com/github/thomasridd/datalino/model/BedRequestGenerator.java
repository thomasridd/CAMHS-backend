package com.github.thomasridd.datalino.model;

import com.github.thomasridd.datalino.api.PostRequest;
import com.github.thomasridd.datalino.api.Request;
import fabricator.Fabricator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Tom.Ridd on 15/05/2016.
 */
public class BedRequestGenerator {
  public static List<String> names;
  public static List<String> genders;
  public static List<String> nhsNumbers;
  public static List<String> doctors;
  public static List<String> hospitals;

  private static void init() {
    Fabricator fabricator = new Fabricator();
    names = new ArrayList<>();
    genders = new ArrayList<>();
    nhsNumbers = new ArrayList<>();
    doctors = new ArrayList<>();
    hospitals = new ArrayList<>();

    Random random = new Random();

    for (int i = 0; i < 200; i++) {
      names.add(fabricator.contact().fullName(false));
      genders.add(i % 2 == 1 ? "Male" : "Female");
      nhsNumbers.add(random.nextInt(100000000) + "" + random.nextInt(100));
      doctors.add("Dr " + fabricator.contact().lastName());

      hospitals = Arrays.asList("R1H12,R1H13,RK973,RQX43,R1HM0,RAX57,R1K02,RAL79,RAL16,RQ8MY".split(","));
    }
  }

  public static List<PBedRequest> generate() throws IOException {
    return generate(new Date());
  }
  public static List<PBedRequest> generate(Date date) throws IOException {
    if (names == null) { init(); }
    Random random = new Random();

    int rand = random.nextInt(200);


    String patient = names.get(rand);
    String nhsNumber = nhsNumbers.get(rand);
    String gender = genders.get(rand);
    String referredBy = doctors.get(rand);
    String age = 10 + random.nextInt(6) + "";
    String originId = hospitals.get(random.nextInt(hospitals.size()));
    String bed_type = random.nextInt(2) + 1 + "";
    PostRequest postRequest = new PostRequest();
    List<PBedRequest> pBedRequests = postRequest.sendBedRequest(originId, patient, bed_type, referredBy,
            nhsNumber, age, gender, date);

    return pBedRequests;
  }
  public static List<PBedRequest> generateAndComplete(Date date) throws IOException {
    List<PBedRequest> bedRequests = generate(date);
    Random random = new Random();
    Request request = new Request();

    if (!bedRequests.isEmpty()) {
      request.actionBedRequest("accept", bedRequests.get(0).id);
    }

    for (int i = 1; i < bedRequests.size(); i++) {
      if (random.nextInt(5) % 2 == 0) {
        request.actionBedRequest("reject", bedRequests.get(i).id);
      } else {
        request.actionBedRequest("cancel", bedRequests.get(i).id);
      }
    }

    return bedRequests;
  }

  public static List<PBedRequest> generateAndComplete(int daysAgo) throws IOException {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -daysAgo);
    return generateAndComplete(cal.getTime());
  }

  public static List<PBedRequest> generate(int daysAgo) throws IOException {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -daysAgo);
    return generate(cal.getTime());
  }
}
