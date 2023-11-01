package edu.kit.kastel.sdq.scorestats.output.ratio;

import edu.kit.kastel.sdq.scorestats.output.Output;

public abstract class RatioOutput implements Output {

    protected final double numerator;
    protected final double denominator;

    protected int decimalPlaces;

    public RatioOutput(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.decimalPlaces = 0;
    }

    public RatioOutput(double numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.decimalPlaces = 1;
    }

    public RatioOutput(double numerator, int denominator, int decimalPlaces) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.decimalPlaces = decimalPlaces;
    }

    public void setDecimalPlaces(int decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public abstract String print();
}
