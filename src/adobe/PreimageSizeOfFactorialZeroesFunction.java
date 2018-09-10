package adobe;

/*
Kaisa question hai o_0
 */
public class PreimageSizeOfFactorialZeroesFunction {
    public int preimageSizeFZF(int K) {
       /*
        findRange(K)- All elements factorial <= K zeroes
        findRange(K-1) -All elements factorial <= K-1 zeroes
        */
        return findRange(K)-findRange(K-1);
    }

    // Using Binary Search
    int findRange(int k){
        long low = 0, high = Long.MAX_VALUE;

        while(low<=high){
            long mid = low + (high-low)/2;
            if(getZeroes(mid)>k) {
                high = mid-1;
            }
            else {
                low = mid + 1;
            }
        }

        return (int)low-1;
    }

    // get zeroes in N!
    long getZeroes(long N){
        long count = 0;
        for(long i = 5; N/i >= 1; i = i*5) {
            count += N/i;
        }

        return count;
    }
}