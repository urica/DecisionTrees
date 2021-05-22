//package com.candor.sp.server.model;
//
//import com.opencsv.bean.CsvBindByName;
//import lombok.Data;
//
//@Data
//public class DataFraud {
//    @CsvBindByName(column = "months_as_customer", required = true)
//    private String months_as_customer;
//
//    @CsvBindByName(column = "age", required = true)
//    private String age;
//
//    @CsvBindByName(column = "policy_state", required = true)
//    private String policy_state;
//
//    @CsvBindByName(column = "policy_deductable", required = true)
//    private String policy_deductable;
//
//    @CsvBindByName(column = "policy_annual_premium")
//    private String policy_annual_premium;
//
//    @CsvBindByName(column = "umbrella_limit", required = true)
//    private String umbrella_limit;
//
//    @CsvBindByName(column = "insured_sex", required = true)
//    private String insured_sex;
//
//    @CsvBindByName(column = "insured_education_level", required = true)
//    private String insured_education_level;
//
//    @CsvBindByName(column = "insured_occupation")
//    private String insured_occupation;
//
//    @CsvBindByName(column = "insured_hobbies")
//    private String insured_hobbies;
//
//    @CsvBindByName(column = "insured_relationship", required = true)
//    private String insured_relationship;
//
//    @CsvBindByName(column = "capital_gains")
//    private String capital_gains;
//
//    @CsvBindByName(column = "capital_loss")
//    private String capital_loss;
//
//    @CsvBindByName(column = "incident_type", required = true)
//    private String incident_type;
//
//    @CsvBindByName(column = "collision_type", required = true)
//    private String collision_type;
//
//    @CsvBindByName(column = "incident_severity", required = true)
//    private String incident_severity;
//
//    @CsvBindByName(column = "authorities_contacted", required = true)
//    private String authorities_contacted;
//
//    @CsvBindByName(column = "number_of_vehicles_involved", required = true)
//    private String number_of_vehicles_involved;
//
//    @CsvBindByName(column = "property_damage", required = true)
//    private String property_damage;
//
//    @CsvBindByName(column = "bodily_injuries", required = true)
//    private String bodily_injuries;
//
//    @CsvBindByName(column = "witnesses", required = true)
//    private String witnesses;
//
//    @CsvBindByName(column = "police_report_available")
//    private String police_report_available;
//
//    @CsvBindByName(column = "total_claim_amount")
//    private String total_claim_amount;
//
//    @CsvBindByName(column = "injury_claim")
//    private String injury_claim;
//
//    @CsvBindByName(column = "property_claim")
//    private String property_claim;
//
//    @CsvBindByName(column = "vehicle_claim")
//    private String vehicle_claim;
//
//    @CsvBindByName(column = "auto_make", required = true)
//    private String auto_make;
//
//    @CsvBindByName(column = "auto_year", required = true)
//    private String auto_year;
//
//    @CsvBindByName(column = "fraud_reported", required = true)
//    private String fraud_reported;
//
//    public String getFraud_reported() {
//        return fraud_reported;
//    }
//
//    public void setFraud_reported(String fraud_reported) {
//        this.fraud_reported = fraud_reported;
//    }
//
//    public String getValueByColName(String colName) {
//        switch (colName) {
//            case "Months_as_customer":
//                return getMonths_as_customer();
//            case "Age":
//                return getAge();
//            case "Policy_state":
//                return getPolicy_state();
//            case "Policy_deductable":
//                return getPolicy_deductable();
//            case "Policy_annual_premium":
//                return getPolicy_annual_premium();
//            case "Umbrella_limit":
//                return getUmbrella_limit();
//            case "Insured_sex":
//                return getInsured_sex();
//            case "Insured_education_level":
//                return getInsured_education_level();
//            case "Insured_occupation":
//                return getInsured_occupation();
//            case "Insured_hobbies":
//                return getInsured_hobbies();
//            case "Insured_relationship":
//                return getInsured_relationship();
//            case "Capital_gains":
//                return getCapital_gains();
//            case "Capital_loss":
//                return getCapital_loss();
//            case "Incident_type":
//                return getIncident_type();
//            case "Incident_severity":
//                return getIncident_severity();
//            case "Authorities_contacted":
//                return getAuthorities_contacted();
//            case "Number_of_vehicles_involved":
//                return getNumber_of_vehicles_involved();
//            case "Property_damage":
//                return getProperty_damage();
//            case "Bodily_injuries":
//                return getBodily_injuries();
//            case "Witnesses":
//                return getWitnesses();
//            case "Police_report_available":
//                return getPolice_report_available();
//            case "Total_claim_amount":
//                return getTotal_claim_amount();
//            case "Injury_claim":
//                return getInjury_claim();
//            case "Property_claim":
//                return getProperty_claim();
//            case "Vehicle_claim":
//                return getVehicle_claim();
//            case "Auto_make":
//                return getAuto_make();
//            case "Auto_year":
//                return getAuto_year();
//            case "Fraud_reported":
//                return getFraud_reported();
//            case "Collision_type":
//                return getCollision_type();
//            default:
//                break;
//        }
//        return "";
//    }
//}
