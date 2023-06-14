package com.h33kz.APIConnectionDemo;

import java.util.ArrayList;
import java.util.Comparator;

public class University {
    private String country;
    private String alpha_two_code;
    private String name;
    private String state_province;
    private ArrayList<String> domains;
    private ArrayList<String> web_pages;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAlpha_two_code() {
        return alpha_two_code;
    }

    public void setAlpha_two_code(String alpha_two_code) {
        this.alpha_two_code = alpha_two_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState_province() {
        return state_province;
    }

    public void setState_province(String state_province) {
        this.state_province = state_province;
    }

    public ArrayList<String> getDomains() {
        return domains;
    }

    public void setDomains(ArrayList<String> domains) {
        this.domains = domains;
    }

    public ArrayList<String> getWeb_pages() {
        return web_pages;
    }

    public void setWeb_pages(ArrayList<String> web_pages) {
        this.web_pages = web_pages;
    }

    @Override
    public String toString() {
        return "[" + country + "," + alpha_two_code + "," + name + "," + state_province + "," + domains + ","
                + web_pages + "]";
    }

    public static Comparator<University> sortByName = new Comparator<University>() {
        public int compare(University u1, University u2) {
            return u1.getName().compareTo(u2.getName());
        }
    };
    public static Comparator<University> sortByDomain = new Comparator<University>() {
        public int compare(University u1, University u2) {
            return u1.getDomains().get(0).compareTo(u2.getDomains().get(0));
        }
    };
}
