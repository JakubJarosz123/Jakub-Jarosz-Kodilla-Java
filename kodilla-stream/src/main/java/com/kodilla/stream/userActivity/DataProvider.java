package com.kodilla.stream.userActivity;

import java.util.*;

public class DataProvider {

    List<User> getUsers() {
        User john = new User("1", "John Smith", false);
        User kate = new User("2", "Kate Blanchett", true);
        User dean = new User("3", "Dean Winchester", true);
        User joe = new User("4", "Joe Hughes", false);
        User rebecca = new User("5", "Rebecca Johnson", true);
        List<User> users = new ArrayList<User>();
        users.add(john);
        users.add(kate);
        users.add(dean);
        users.add(joe);
        users.add(rebecca);
        return users;
    }

    Set<Activity> getActivities() {
       Activity johnLogin = new Activity("1", "login", 10);
       Activity johnPurchase = new Activity("1", "purchase", 30);
       Activity johnComment = new Activity("1", "comment", 600);

       Activity kateLogin = new Activity("2", "login", 1500);
       Activity katePurchase = new Activity("2", "purchase", 100);
       Activity kateComment = new Activity("2", "comment", 450);

       Activity deanLogin = new Activity("3", "login", 1000);
       Activity deanPurchase = new Activity("3", "purchase", 1050);
       Activity deanComment = new Activity("3", "comment", 1500);

       Activity joeLogin = new Activity("4", "login", 60);
       Activity joePurchase = new Activity("4", "purchase", 0);
       Activity joeComment = new Activity("4", "comment", 1550);

       Activity rebeccaLogin = new Activity("5", "login", 750);
       Activity rebeccaPurchase = new Activity("5", "purchase", 3000);
       Activity rebeccaComment = new Activity("5", "comment", 250);

       Set<Activity> activities = new HashSet<>();
       activities.add(johnLogin);
       activities.add(johnPurchase);
       activities.add(johnComment);
       activities.add(kateLogin);
       activities.add(katePurchase);
       activities.add(kateComment);
       activities.add(deanLogin);
       activities.add(deanPurchase);
       activities.add(deanComment);
       activities.add(joeLogin);
       activities.add(joePurchase);
       activities.add(joeComment);
       activities.add(rebeccaLogin);
       activities.add(rebeccaPurchase);
       activities.add(rebeccaComment);

       return activities;
    }

    Map<String, Integer> getBonuses() {
        Map<String, Integer> bonuses = new HashMap<>();
        bonuses.put("login", 10);
        bonuses.put("purchase", 30);
        bonuses.put("comment", 600);
        return bonuses;
    }
}
