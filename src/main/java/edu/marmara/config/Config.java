package edu.marmara.config;

public class Config {
    private Double passProbability;

    private Double gradeLuck;

    private Double gradeVariance;

    private Integer minimumCreditReq;


    public Config(Double passProbability, Double gradeLuck, Double gradeVariance, Integer minimumCreditReq) {
        this.passProbability = passProbability;
        this.gradeLuck = gradeLuck;
        this.gradeVariance = gradeVariance;
        this.minimumCreditReq = minimumCreditReq;
    }

    public Config() {

    }

    public Double getPassProbability() {
        return passProbability;
    }

    public void setPassProbability(Double passProbability) {
        this.passProbability = passProbability;
    }

    public Double getGradeLuck() {
        return gradeLuck;
    }

    public void setGradeLuck(Double gradeLuck) {
        this.gradeLuck = gradeLuck;
    }

    public Double getGradeVariance() {
        return gradeVariance;
    }

    public void setGradeVariance(Double gradeVariance) {
        this.gradeVariance = gradeVariance;
    }

    public Integer getMinimumCreditReq() {return minimumCreditReq;}

    public void setMinimumCreditReq(Integer minimumCreditReq) {this.minimumCreditReq = minimumCreditReq;}
}
