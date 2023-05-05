package org.example;

import java.util.Arrays;
public class FactoryFilters {
    public int solution(int[] A) {

        //convert to double array
        double[] DA = new double[A.length];
        int index = 0;
        for (int value : A) {
            DA[index++] = value;
        }

        Arrays.sort(DA);

        double currentPollutionSum = Arrays.stream(DA).sum();
        double initial_pollution_half = currentPollutionSum / 2;
        int filters = 0;
        int actionIndex = A.length - 1;

        while (currentPollutionSum > initial_pollution_half) {
            currentPollutionSum -= DA[actionIndex] / 2;
            DA[actionIndex] = DA[actionIndex] / 2;

            filters++;
            if (actionIndex > 0) {
                if (DA[actionIndex - 1] > DA[actionIndex]) {
                    actionIndex--;
                }
            }
        }
        return filters;
    }
}
