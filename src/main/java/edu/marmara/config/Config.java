package edu.marmara.config;

import java.util.List;

public class Config {
    private Double passProbability;

    private Double gradeLuck;

    private List<Integer> gradeRange;

    public Config(Double passProbability, Double gradeLuck, List<Integer> gradeRange) {
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

    public List<Integer> getGradeRange() {
        return gradeRange;
    }

    public void setGradeRange(List<Integer> gradeRange) {
        this.gradeRange = gradeRange;
    }
}
