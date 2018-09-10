package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Vector2D implements Iterator<Integer> {
    int indexInList = 0;
    int index = 0;
    List<List<Integer>> vec2d;
    List<Integer> currList = null;
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        if(!(vec2d == null) && !(vec2d.size() == 0) ){
            currList = vec2d.get(0);
        }
    }

    @Override
    public Integer next() {
        int next = this.currList.get(indexInList++);
        if(indexInList == currList.size()) {
            this.index++;
            this.indexInList = 0;
            if(index != vec2d.size())
                this.currList = this.vec2d.get(index);
        }
        return next;
    }

    @Override
    public boolean hasNext() {
        return !(index > vec2d.size()-1 || (index == vec2d.size()-1 && indexInList > currList.size()-1));
    }
}
public class Flatten2DVector {


    public static void main(String[] args) {
        List<List<Integer>> vec2d = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        vec2d.add(list);
//        list = new ArrayList<>();
//        list.add(3);
//        vec2d.add(list);
//        list.add(4);
//        list.add(5);
//        list.add(6);
        //vec2d.add(list);

        Vector2D i = new Vector2D(vec2d);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
