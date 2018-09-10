package ai;

import java.util.ArrayList;
import java.util.List;

public class Perceptron {

    private static final String TABS = "\t\t";
    static int[] weights = {0,0,0};
    static int[] labels = {1,1,-1,-1};
    public static void printIterations(List<List<Integer>> featureVector) {
        int count = featureVector.size();
        int it = 1;
        while(true) {
          //  System.out.print("\t" + it + TABS);

            int j = 0;

            for(List<Integer> feature: featureVector) {
                System.out.print("\t" + it + TABS);
                int i =0;
                int sum = 0;
                int label = -1;
                for(Integer val: feature) {
                    System.out.print(val + "  ");
                    sum += weights[i++] * val;
                }
                System.out.print(TABS + sum + TABS );
                if(sum > 0) {
                    label = 1;
                }
                if(label != labels[j]) {
                    System.out.print("Yes" + TABS );
                    for(int k=0; k < 3; k++) {
                        weights[k] = weights[k] + labels[j] * feature.get(k);
                    }
                } else {
                    System.out.print("No" + TABS );
                    count--;
                }
                j++;
                for(int k=0; k < 3; k++) {
                    System.out.print(weights[k] + "  ");
                }
                System.out.println();
                //System.out.print(TABS+TABS);
            }
            if(count == 0) {
                break;
            } else {
                count = featureVector.size();
            }
            it++;

        }
    }

    public static List<Integer> createFeatureVector(int[] features) {
        List<Integer> l1 = new ArrayList<>();
        for (int i=0; i< features.length; i++) {
            l1.add(features[i]);
        }
        return l1;
    }
    public static void main(String[] args) {
        List<List<Integer>> featureVector = new ArrayList<List<Integer>>();
        featureVector.add(createFeatureVector(new int[]{1,1,4}));
        featureVector.add(createFeatureVector(new int[]{1,3,2}));
        featureVector.add(createFeatureVector(new int[]{1,1,2}));
        featureVector.add(createFeatureVector(new int[]{1,2,1}));
//        System.out.print("Iteration" + "\t\t");
//        System.out.print("Feature Vector" + "\t\t");
//        System.out.print("Sum" + TABS);
//        System.out.print("Weights Updated?" + "\t\t");
//        System.out.println("Weight Vector");
        printIterations(featureVector);
    }
}
