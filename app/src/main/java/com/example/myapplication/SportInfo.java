package com.example.myapplication;

import androidx.annotation.NonNull;

public class SportInfo {

    String SportName;
    String CoachName;
    String CoachEmail;

    public SportInfo(String sportName, String coachName, String coachEmail) {
        SportName = sportName;
        CoachName = coachName;
        CoachEmail = coachEmail;
    }

    public String getSportName() {
        return SportName;
    }

    public void setSportName(String sportName) {
        SportName = sportName;
    }

    public String getCoachName() {
        return CoachName;
    }

    public void setCoachName(String coachName) {
        CoachName = coachName;
    }

    public String getCoachEmail() {
        return CoachEmail;
    }

    public void setCoachEmail(String coachEmail) {
        CoachEmail = coachEmail;
    }
}