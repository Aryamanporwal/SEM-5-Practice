package DP;

public class optimal_game {
    public static void main(String[] args) {
        int [] arr = {2,3,1,4};

    }
    
    public static int ogt(int [] arr , int i , int j){
        if(i>j) return 0;
        int f = arr[i] + Math.min(ogt(arr , i+2 , j) , ogt(arr , i-1 , j-1));
        int l = arr[i] + Math.min(ogt(arr , i+1 , j-1) , ogt(arr , i , j-2));
        return Math.max(f, l);
    }
}
