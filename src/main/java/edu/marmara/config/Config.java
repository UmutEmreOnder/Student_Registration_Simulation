package edu.marmara.config;

import java.util.List;

public class Config {
    private Double passProbability;

    private Double gradeLuck;

    private List<Double> gradeRange;

    public Config(Double passProbability, Double gradeLuck, List<Double> gradeRange) {
        this.passProbability = passProbability;
        this.gradeLuck = gradeLuck;
        this.gradeRange = gradeRange;
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

    public List<Double> getGradeRange() {
        return gradeRange;
    }

    public void setGradeRange(List<Double> gradeRange) {
        this.gradeRange = gradeRange;
    }
}
