package com.arquitectura.circuitbreker.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Country {
    private Name name;
    private List<String> tld;
    private String cca2;
    private String ccn3;
    private String cca3;
    private String cioc;
    private boolean independent;
    private String status;
    private boolean unMember;
    private Currencies currencies;
    private Idd idd;
    private List<String> capital;
    private List<String> altSpellings;
    private String region;
    private String subregion;
    private Languages languages;
    private Translations translations;
    private List<Double> latlng;
    private boolean landlocked;
    private List<String> borders;
    private double area;
    private Demonyms demonyms;
    private String flag;
    private Maps maps;
    private int population;
    private Gini gini;
    private String fifa;
    private Car car;
    private List<String> timezones;
    private List<String> continents;
    private Flags flags;
    private CoatOfArms coatOfArms;
    private String startOfWeek;
    private CapitalInfo capitalInfo;

    @Data
    public static class Name {
        private String common;
        private String official;
        private NativeName nativeName;
    }

    @Data
    public static class NativeName {
        private Spa spa;
    }

    @Data
    public static class Spa {
        private String official;
        private String common;
    }

    @Data
    public static class Currencies {
        private Map<String, Currency> COP;
    }

    @Data
    public static class Currency {
        private String name;
        private String symbol;
    }

    @Data
    public static class Idd {
        private String root;
        private List<String> suffixes;
    }

    @Data
    public static class Languages {
        private String spa;
    }

    @Data
    public static class Translations {
        private Map<String, String> ara;
        private Map<String, String> bre;
        private Map<String, String> ces;
        private Map<String, String> cym;
        private Map<String, String> deu;
        private Map<String, String> est;
        private Map<String, String> fin;
        private Map<String, String> fra;
        private Map<String, String> hrw;
        private Map<String, String> hun;
        private Map<String, String> ita;
        private Map<String, String> jpn;
        private Map<String, String> kor;
        private Map<String, String> nld;
        private Map<String, String> per;
        private Map<String, String> pol;
        private Map<String, String> por;
        private Map<String, String> rus;
        private Map<String, String> slk;
        private Map<String, String> spa;
        private Map<String, String> srp;
        private Map<String, String> swe;
        private Map<String, String> tur;
        private Map<String, String> urd;
        private Map<String, String> zho;
    }

    @Data
    public static class Demonyms {
        private Map<String, String> eng;
        private Map<String, String> fra;
    }

    @Data
    public static class Maps {
        private String googleMaps;
        private String openStreetMaps;
    }

    @Data
    public static class Gini {
        private double value;
    }

    @Data
    public static class Car {
        private List<String> signs;
        private String side;
    }

    @Data
    public static class Flags {
        private String png;
        private String svg;
        private String alt;
    }

    @Data
    public static class CoatOfArms {
        private String png;
        private String svg;
    }

    @Data
    public static class CapitalInfo {
        private List<Double> latlng;
    }
}
