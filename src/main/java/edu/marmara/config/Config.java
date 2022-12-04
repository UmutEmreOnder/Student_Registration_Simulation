package edu.marmara.config;

public class Config {
    Double passProbability;

    public Config(Double passProbability) {
        this.passProbability = passProbability;
    }

    public Config() {

    }
    public Double getPassProbability() {
        return passProbability;
    }

    public void setPassProbability(Double passProbability) {
        this.passProbability = passProbability;
    }
}
