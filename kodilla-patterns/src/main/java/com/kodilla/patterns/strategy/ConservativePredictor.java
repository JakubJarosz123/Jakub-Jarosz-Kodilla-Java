package com.kodilla.patterns.strategy;

public non-sealed class ConservativePredictor implements BuyPredictor{

    @Override
    public String predictWhatToBuy() {
        return "[Conservative predictor] Buy debentures of XYZ";
    }
}
