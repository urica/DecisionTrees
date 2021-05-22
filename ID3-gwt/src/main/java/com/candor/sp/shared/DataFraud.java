package com.candor.sp.shared;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

public class DataFraud implements Serializable {

    @CsvBindByName(column = "months_as_customer", required = true)
    private String months_as_customer;
    @CsvBindByName(column = "age", required = true)
    private String age;
    @CsvBindByName(column = "policy_state", required = true)
    private String policy_state;
    @CsvBindByName(column = "policy_deductable", required = true)
    private String policy_deductable;
    @CsvBindByName(column = "policy_annual_premium")
    private String policy_annual_premium;
    @CsvBindByName(column = "umbrella_limit", required = true)
    private String umbrella_limit;
    @CsvBindByName(column = "insured_sex", required = true)
    private String insured_sex;
    @CsvBindByName(column = "insured_education_level", required = true)
    private String insured_education_level;
    @CsvBindByName(column = "insured_occupation")
    private String insured_occupation;
    @CsvBindByName(column = "insured_hobbies")
    private String insured_hobbies;
    @CsvBindByName(column = "insured_relationship", required = true)
    private String insured_relationship;
    @CsvBindByName(column = "capital_gains")
    private String capital_gains;
    @CsvBindByName(column = "capital_loss")
    private String capital_loss;
    @CsvBindByName(column = "incident_type", required = true)
    private String incident_type;
    @CsvBindByName(column = "collision_type", required = true)
    private String collision_type;
    @CsvBindByName(column = "incident_severity", required = true)
    private String incident_severity;
    @CsvBindByName(column = "authorities_contacted", required = true)
    private String authorities_contacted;
    @CsvBindByName(column = "number_of_vehicles_involved", required = true)
    private String number_of_vehicles_involved;
    @CsvBindByName(column = "property_damage", required = true)
    private String property_damage;
    @CsvBindByName(column = "bodily_injuries", required = true)
    private String bodily_injuries;
    @CsvBindByName(column = "witnesses", required = true)
    private String witnesses;
    @CsvBindByName(column = "police_report_available")
    private String police_report_available;
    @CsvBindByName(column = "total_claim_amount")
    private String total_claim_amount;
    @CsvBindByName(column = "injury_claim")
    private String injury_claim;
    @CsvBindByName(column = "property_claim")
    private String property_claim;
    @CsvBindByName(column = "vehicle_claim")
    private String vehicle_claim;
    @CsvBindByName(column = "auto_make", required = true)
    private String auto_make;
    @CsvBindByName(column = "auto_year", required = true)
    private String auto_year;
    @CsvBindByName(column = "fraud_reported", required = true)
    private String fraud_reported;

    public DataFraud() {
    }

    public String getMonths_as_customer() {
        return months_as_customer;
    }

    public void setMonths_as_customer(String months_as_customer) {
        this.months_as_customer = months_as_customer;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPolicy_state() {
        return policy_state;
    }

    public void setPolicy_state(String policy_state) {
        this.policy_state = policy_state;
    }

    public String getPolicy_deductable() {
        return policy_deductable;
    }

    public void setPolicy_deductable(String policy_deductable) {
        this.policy_deductable = policy_deductable;
    }

    public String getPolicy_annual_premium() {
        return policy_annual_premium;
    }

    public void setPolicy_annual_premium(String policy_annual_premium) {
        this.policy_annual_premium = policy_annual_premium;
    }

    public String getUmbrella_limit() {
        return umbrella_limit;
    }

    public void setUmbrella_limit(String umbrella_limit) {
        this.umbrella_limit = umbrella_limit;
    }

    public String getInsured_sex() {
        return insured_sex;
    }

    public void setInsured_sex(String insured_sex) {
        this.insured_sex = insured_sex;
    }

    public String getInsured_education_level() {
        return insured_education_level;
    }

    public void setInsured_education_level(String insured_education_level) {
        this.insured_education_level = insured_education_level;
    }

    public String getInsured_occupation() {
        return insured_occupation;
    }

    public void setInsured_occupation(String insured_occupation) {
        this.insured_occupation = insured_occupation;
    }

    public String getInsured_hobbies() {
        return insured_hobbies;
    }

    public void setInsured_hobbies(String insured_hobbies) {
        this.insured_hobbies = insured_hobbies;
    }

    public String getInsured_relationship() {
        return insured_relationship;
    }

    public void setInsured_relationship(String insured_relationship) {
        this.insured_relationship = insured_relationship;
    }

    public String getCapital_gains() {
        return capital_gains;
    }

    public void setCapital_gains(String capital_gains) {
        this.capital_gains = capital_gains;
    }

    public String getCapital_loss() {
        return capital_loss;
    }

    public void setCapital_loss(String capital_loss) {
        this.capital_loss = capital_loss;
    }

    public String getIncident_type() {
        return incident_type;
    }

    public void setIncident_type(String incident_type) {
        this.incident_type = incident_type;
    }

    public String getCollision_type() {
        return collision_type;
    }

    public void setCollision_type(String collision_type) {
        this.collision_type = collision_type;
    }

    public String getIncident_severity() {
        return incident_severity;
    }

    public void setIncident_severity(String incident_severity) {
        this.incident_severity = incident_severity;
    }

    public String getAuthorities_contacted() {
        return authorities_contacted;
    }

    public void setAuthorities_contacted(String authorities_contacted) {
        this.authorities_contacted = authorities_contacted;
    }

    public String getNumber_of_vehicles_involved() {
        return number_of_vehicles_involved;
    }

    public void setNumber_of_vehicles_involved(String number_of_vehicles_involved) {
        this.number_of_vehicles_involved = number_of_vehicles_involved;
    }

    public String getProperty_damage() {
        return property_damage;
    }

    public void setProperty_damage(String property_damage) {
        this.property_damage = property_damage;
    }

    public String getBodily_injuries() {
        return bodily_injuries;
    }

    public void setBodily_injuries(String bodily_injuries) {
        this.bodily_injuries = bodily_injuries;
    }

    public String getWitnesses() {
        return witnesses;
    }

    public void setWitnesses(String witnesses) {
        this.witnesses = witnesses;
    }

    public String getPolice_report_available() {
        return police_report_available;
    }

    public void setPolice_report_available(String police_report_available) {
        this.police_report_available = police_report_available;
    }

    public String getTotal_claim_amount() {
        return total_claim_amount;
    }

    public void setTotal_claim_amount(String total_claim_amount) {
        this.total_claim_amount = total_claim_amount;
    }

    public String getInjury_claim() {
        return injury_claim;
    }

    public void setInjury_claim(String injury_claim) {
        this.injury_claim = injury_claim;
    }

    public String getProperty_claim() {
        return property_claim;
    }

    public void setProperty_claim(String property_claim) {
        this.property_claim = property_claim;
    }

    public String getVehicle_claim() {
        return vehicle_claim;
    }

    public void setVehicle_claim(String vehicle_claim) {
        this.vehicle_claim = vehicle_claim;
    }

    public String getAuto_make() {
        return auto_make;
    }

    public void setAuto_make(String auto_make) {
        this.auto_make = auto_make;
    }

    public String getAuto_year() {
        return auto_year;
    }

    public void setAuto_year(String auto_year) {
        this.auto_year = auto_year;
    }

    public String getFraud_reported() {
        return fraud_reported;
    }

    public void setFraud_reported(String fraud_reported) {
        this.fraud_reported = fraud_reported;
    }

    public String getValueByColName(String colName) {
        switch (colName) {
            case "Months_as_customer":
                return getMonths_as_customer();
            case "Age":
                return getAge();
            case "Policy_state":
                return getPolicy_state();
            case "Policy_deductable":
                return getPolicy_deductable();
            case "Policy_annual_premium":
                return getPolicy_annual_premium();
            case "Umbrella_limit":
                return getUmbrella_limit();
            case "Insured_sex":
                return getInsured_sex();
            case "Insured_education_level":
                return getInsured_education_level();
            case "Insured_occupation":
                return getInsured_occupation();
            case "Insured_hobbies":
                return getInsured_hobbies();
            case "Insured_relationship":
                return getInsured_relationship();
            case "Capital_gains":
                return getCapital_gains();
            case "Capital_loss":
                return getCapital_loss();
            case "Incident_type":
                return getIncident_type();
            case "Incident_severity":
                return getIncident_severity();
            case "Authorities_contacted":
                return getAuthorities_contacted();
            case "Number_of_vehicles_involved":
                return getNumber_of_vehicles_involved();
            case "Property_damage":
                return getProperty_damage();
            case "Bodily_injuries":
                return getBodily_injuries();
            case "Witnesses":
                return getWitnesses();
            case "Police_report_available":
                return getPolice_report_available();
            case "Total_claim_amount":
                return getTotal_claim_amount();
            case "Injury_claim":
                return getInjury_claim();
            case "Property_claim":
                return getProperty_claim();
            case "Vehicle_claim":
                return getVehicle_claim();
            case "Auto_make":
                return getAuto_make();
            case "Auto_year":
                return getAuto_year();
            case "Fraud_reported":
                return getFraud_reported();
            case "Collision_type":
                return getCollision_type();
            default:
                break;
        }
        return "";
    }


    public void putValueByColName(String colName, String value) {
        switch (colName) {
            case "Months_as_customer":
                setMonths_as_customer(value);
            case "Age":
                setAge(value);
            case "Policy_state":
                setPolicy_state(value);
            case "Policy_deductable":
                setPolicy_deductable(value);
            case "Policy_annual_premium":
                setPolicy_annual_premium(value);
            case "Umbrella_limit":
                setUmbrella_limit(value);
            case "Insured_sex":
                setInsured_sex(value);
            case "Insured_education_level":
                setInsured_education_level(value);
            case "Insured_occupation":
                setInsured_occupation(value);
            case "Insured_hobbies":
                setInsured_hobbies(value);
            case "Insured_relationship":
                setInsured_relationship(value);
            case "Capital_gains":
                setCapital_gains(value);
            case "Capital_loss":
                setCapital_loss(value);
            case "Incident_type":
                setIncident_type(value);
            case "Incident_severity":
                setIncident_severity(value);
            case "Authorities_contacted":
                setAuthorities_contacted(value);
            case "Number_of_vehicles_involved":
                setNumber_of_vehicles_involved(value);
            case "Property_damage":
                setProperty_damage(value);
            case "Bodily_injuries":
                setBodily_injuries(value);
            case "Witnesses":
                setWitnesses(value);
            case "Police_report_available":
                setPolice_report_available(value);
            case "Total_claim_amount":
                setTotal_claim_amount(value);
            case "Injury_claim":
                setInjury_claim(value);
            case "Property_claim":
                setProperty_claim(value);
            case "Vehicle_claim":
                setVehicle_claim(value);
            case "Auto_make":
                setAuto_make(value);
            case "Auto_year":
                setAuto_year(value);
            case "Fraud_reported":
                setFraud_reported(value);
            case "Collision_type":
                setCollision_type(value);
            default:
                break;
        }
    }
}
