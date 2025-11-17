package com.kodilla.stream.userActivity;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ActivityService {

    public int calculateTotalPoints(Set<Activity> activities) {
        activities.stream()
                .map(Activity::getPoints)
                .reduce(0, (x, y) -> x + y);
        return activities.size();
    }

    public int calculateTotalPointWithBonuses(Set<Activity> activities, Map<String, Integer> bonuses) {
        return activities.stream()
                .map(activity -> {
                    int basePoints = activity.getPoints();
                    int bonues = bonuses.getOrDefault(activity.getType(), 0);
                    return basePoints + bonues;
                })
                .reduce(0, Integer::sum);
    }

    public int countActiveUsers(List<User> users) {
        return users.stream()
                .reduce(0, (sum, user) -> sum + (user.isActive() ? 1 : 0), Integer::sum);
    }


}
