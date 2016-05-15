package com.github.thomasridd.datalino.model;

import fabricator.Fabricator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Tom.Ridd on 15/05/2016.
 */
public class BedRequestGenerator {
  public static List<String> names;
  public static List<String> genders;
  public static List<Integer> nhsNumbers;
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
      nhsNumbers.add(random.nextInt(100000000));
      doctors.add("Dr " + fabricator.contact().lastName());

      hospitals = Arrays.asList("R1H12,R1H13,RK973,RQX43,R1HM0,RAX57,R1K02,RAL79,RAL16,RQ8MY".split(","));
    }
  }
  public static BedRequest generate() {
    if (names == null) { init(); }
    Random random = new Random();

    BedRequest bedRequest = new BedRequest();
    int rand = random.nextInt(200);
    bedRequest.patient = names.get(rand);


    return null;
  }

  public static BedRequest generate(int daysAgo) {
    return null;
  }

  public static BedRequest generate(int daysAgo, int accepted, int rejected, int cancelled) {
    return null;
  }

  public static void main(String[] args) {
    BedRequest bedRequest = BedRequestGenerator.generate();
  }
}
