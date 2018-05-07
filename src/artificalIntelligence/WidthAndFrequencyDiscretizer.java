package artificalIntelligence;

import java.util.Arrays;

/**
 *
 * @author mattoop
 */
public class WidthAndFrequencyDiscretizer {

    // Cut-points
    private double[][] dataPoints = null;

    private void obtainCutPointsForEachAttribute(double[] input, String type) {
        if (type.equalsIgnoreCase("width")) {   // Can use Polymorphism in the form of Strategy Pattern
            calculateCutPointsByEqualWidthBinning(input);
            System.out.println("Equal Width discretization: " + Arrays.deepToString(dataPoints));
        } else if (type.equalsIgnoreCase("frequency")) {
            calculateCutPointsByEqualFrequencyBinning(input, 3); // specific case of 3 bins
            System.out.println("Equal Frequency discretization: " + Arrays.deepToString(dataPoints));
        }

    }

    /*
     Equal width binning would divide the scope of possible values into N bins of the same width
     width would be (max value - min value) / N
     */
    private void calculateCutPointsByEqualWidthBinning(double[] input) {
        double binWidth = (getMaxValue(input) - getMinValue(input)) / input.length; //Perhaps can compute max, min in a single loop
        double[] inputDataCutPointsByWidth = new double[input.length - 1];
        double[] equalWidthDiscreteArrayOne = new double[input.length];
        double[] equalWidthDiscreteArraySeven = new double[input.length];
        double[] equalWidthDiscreteArrayTwo = new double[input.length];
        double[] equalWidthDiscreteArrayEight = new double[input.length];
        double[] equalWidthDiscreteArrayThree = new double[input.length];
        double[] equalWidthDiscreteArrayNine = new double[input.length];
        double[] equalWidthDiscreteArrayFour = new double[input.length];
        double[] equalWidthDiscreteArrayTen = new double[input.length];
        double[] equalWidthDiscreteArrayFive = new double[input.length];
        double[] equalWidthDiscreteArrayEleven = new double[input.length];
        double[] equalWidthDiscreteArraySix = new double[input.length];
        double[] equalWidthDiscreteArrayTwelve = new double[input.length];

        int cpIndexOne = 0;
        int cpIndexTwo = 0;
        int cpIndexThree = 0;
        int cpIndexFour = 0;
        int cpIndexFive = 0;
        int cpIndexSix = 0;
        int cpIndexSeven = 0;
        int cpIndexEight = 0;
        int cpIndexNine = 0;
        int cpIndexTen = 0;
        int cpIndexEleven = 0;
        int cpIndexTwelve = 0;
        for (int widthSubScope = 1; widthSubScope < input.length; widthSubScope++) {
            inputDataCutPointsByWidth[widthSubScope - 1] = getMinValue(input) + binWidth * widthSubScope;
        }
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < inputDataCutPointsByWidth.length; j++) {
                if (input[i] <= inputDataCutPointsByWidth[j]) {
                    if (j == 0) {
                        equalWidthDiscreteArrayOne[cpIndexOne] = input[i];
                        cpIndexOne++;
                    } else if (j == 1) {
                        equalWidthDiscreteArrayTwo[cpIndexTwo] = input[i];
                        cpIndexTwo++;
                    } else if (j == 2) {
                        equalWidthDiscreteArrayThree[cpIndexThree] = input[i];
                        cpIndexThree++;
                    } else if (j == 3) {
                        equalWidthDiscreteArrayFour[cpIndexFour] = input[i];
                        cpIndexFour++;
                    } else if (j == 4) {
                        equalWidthDiscreteArrayFive[cpIndexFive] = input[i];
                        cpIndexFive++;
                    } else if (j == 5) {
                        equalWidthDiscreteArraySix[cpIndexSix] = input[i];
                        cpIndexSix++;
                    } else if (j == 6) {
                        equalWidthDiscreteArraySeven[cpIndexSeven] = input[i];
                        cpIndexSeven++;
                    } else if (j == 7) {
                        equalWidthDiscreteArrayEight[cpIndexEight] = input[i];
                        cpIndexEight++;
                    } else if (j == 8) {
                        equalWidthDiscreteArrayNine[cpIndexNine] = input[i];
                        cpIndexNine++;
                    } else if (j == 9) {
                        equalWidthDiscreteArrayTen[cpIndexTen] = input[i];
                        cpIndexTen++;
                    } else if (j == 10) {
                        equalWidthDiscreteArrayEleven[cpIndexEleven] = input[i];
                        cpIndexEleven++;
                    } else if (j == 11) {
                        equalWidthDiscreteArrayTwelve[cpIndexTwelve] = input[i];
                        cpIndexTwelve++;
                    }
                }
            }
        }
        dataPoints = new double[][]{equalWidthDiscreteArrayOne, equalWidthDiscreteArrayTwo, equalWidthDiscreteArrayThree, equalWidthDiscreteArrayFour, equalWidthDiscreteArrayFive,
            equalWidthDiscreteArraySix, equalWidthDiscreteArraySeven, equalWidthDiscreteArrayEight, equalWidthDiscreteArrayNine, equalWidthDiscreteArrayTen, equalWidthDiscreteArrayEleven,
            equalWidthDiscreteArrayTwelve};
    }

    ;

    private void calculateCutPointsByEqualFrequencyBinning(double[] inputDataPoints, int numBins) {
        double frequency = inputDataPoints.length / numBins;
        double frequencyOne = -1;
        double frequencyTwo = -1;
        double[] inputDataCutPointsByFreqOne = null;
        double[] inputDataCutPointsByFreqTwo = null;
        double[] inputDataCutPointsByFreqThree = null;
        int cpIndexOne = 0;
        int cpIndexTwo = 0;
        int cpIndexThree = 0;

        if (inputDataPoints.length % numBins == 0) {
            inputDataCutPointsByFreqOne = new double[(int) frequency];
            inputDataCutPointsByFreqTwo = new double[(int) frequency];
            inputDataCutPointsByFreqThree = new double[(int) frequency];
        }

        // Filter frequency rule engine
        if (frequency * numBins < inputDataPoints.length) {
            if ((frequency * numBins) + 2 <= inputDataPoints.length) {
                frequencyTwo = frequency + 1;
                inputDataCutPointsByFreqTwo = new double[(int) frequencyTwo];
            } else {
                inputDataCutPointsByFreqTwo = new double[(int) frequency];
            }
            if ((frequency * numBins) + 1 <= inputDataPoints.length) {
                frequencyOne = frequency + 1;
                inputDataCutPointsByFreqOne = new double[(int) frequencyOne];
            }
            inputDataCutPointsByFreqThree = new double[(int) frequency];
        }
        for (int i = 0; i < inputDataPoints.length; i++) {
            if (frequencyOne != -1 ? i < frequencyOne : i < frequency) {
                inputDataCutPointsByFreqOne[cpIndexOne] = inputDataPoints[i];
                cpIndexOne++;
            } else if (frequencyTwo != -1) {
                if (i >= frequency && i < frequencyTwo * 2) {
                    inputDataCutPointsByFreqTwo[cpIndexTwo] = inputDataPoints[i];
                    cpIndexTwo++;
                }
                if (i >= frequencyTwo * 2 && i < frequencyTwo * 3) {
                    inputDataCutPointsByFreqThree[cpIndexThree] = inputDataPoints[i];
                    cpIndexThree++;
                }
            } else if (frequencyTwo == -1) {
                if (frequencyOne != -1) {
                    if (i >= frequencyOne && i <= frequency * 2) {
                        inputDataCutPointsByFreqTwo[cpIndexTwo] = inputDataPoints[i];
                        cpIndexTwo++;
                    }
                    if (i > frequency * 2 && i <= frequency * 3) {
                        inputDataCutPointsByFreqThree[cpIndexThree] = inputDataPoints[i];
                        cpIndexThree++;
                    }
                } else {
                    if (i >= frequencyOne && i < frequency * 2) {
                        inputDataCutPointsByFreqTwo[cpIndexTwo] = inputDataPoints[i];
                        cpIndexTwo++;
                    }
                    if (i >= frequency * 2 && i < frequency * 3) {
                        inputDataCutPointsByFreqThree[cpIndexThree] = inputDataPoints[i];
                        cpIndexThree++;
                    }
                }
            }
        }
        dataPoints = new double[][]{inputDataCutPointsByFreqOne, inputDataCutPointsByFreqTwo, inputDataCutPointsByFreqThree};
    }

    private double getMaxValue(double[] inputDataPoints) {
        double maxValue = inputDataPoints[0];
        for (int i = 1; i < inputDataPoints.length; i++) {
            if (inputDataPoints[i] > maxValue) {
                maxValue = inputDataPoints[i];
            }
        }
        return maxValue;
    }

    private double getMinValue(double[] inputDataPoints) {
        double minValue = inputDataPoints[0];
        for (int j = 1; j < inputDataPoints.length; j++) {
            for (int i = 0; i < inputDataPoints.length; i++) {
                if (inputDataPoints[j] < minValue) {
                    minValue = inputDataPoints[j];
                }
            }
        }
        return minValue;
    }

    public static void main(String[] str) {
        WidthAndFrequencyDiscretizer widthAndFrequencyDiscretizer = new WidthAndFrequencyDiscretizer();
        double[] input = new double[]{0.1, 3.4, 3.5, 3.6, 7.0, 9.0, 6.0, 4.4, 2.5, 3.9, 4.5, 2.8};
        widthAndFrequencyDiscretizer.obtainCutPointsForEachAttribute(input, "width");
        widthAndFrequencyDiscretizer.obtainCutPointsForEachAttribute(input, "frequency");
    }

}
