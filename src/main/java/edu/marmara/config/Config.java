package edu.marmara.config;

import java.util.List;

public class Config {
    private Double passProbability;

    private Double gradeLuck;

    private Double gradeVariance;


    public Config(Double passProbability, Double gradeLuck, Double gradeVariance) {
        this.passProbability = passProbability;
        this.gradeLuck = gradeLuck;
        this.gradeVariance = gradeVariance;
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

    public Double getGradeVariance() {return gradeVariance;}

    public void setGradeVariance(Double gradeVariance) {this.gradeVariance = gradeVariance;}
}
