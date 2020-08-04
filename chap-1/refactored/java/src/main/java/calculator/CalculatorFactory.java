package calculator;

import data.invoice.Performance;

import static java.lang.String.format;

public class CalculatorFactory {

    public static PerformaceCalculator getCalculator(Performance performance){
        switch(performance.getPlay().getType()){
            case TRAGEDY: return new TragedyCalculator(performance);
            case COMEDY: return new ComedyCalculator(performance);
            default:
                throw new RuntimeException(format("Unknown type: %s", performance.getPlay().getType()));
        }

    }
}
