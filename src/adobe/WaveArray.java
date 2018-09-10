package adobe;

import java.util.ArrayList;

public class WaveArray {
    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        ArrayList<Integer> wave = new ArrayList<Integer> ();
        for(int i=0; i < a.size(); i++ ) {
            if(i-1 > 0 && a.get(i) < a.get(i-1)) {
                swap(i, i-1, a);
            }
            if(i+1 <= a.size() && a.get(i) < a.get(i+1)) {
                swap(i, i-1, a);
            }
        }
        return wave;
    }

    private void swap(int i, int i1, ArrayList<Integer> a) {
        Integer temp = a.get(i);
        a.set(i, a.get(i1));
        a.set(i1, temp);
    }
}
