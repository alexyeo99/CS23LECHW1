/*
Sorting methods to implement:
1. Merge Sort
2. Insertion Sort
3. Bubble Sort
HW for CMSC 23
*/
import java.util.Arrays;

public class sorting{

    //Bubble Sort
    public static void bSort(Integer[] input){
        boolean swap = false;
        do{
            swap = false;
            for(int i=0;i<input.length;i++){
                if(i!=input.length-1){
                    if(input[i]>input[i+1]){
                        int temp = input[i];
                        input[i] = input[i+1];
                        input[i+1] = temp;
                        swap = true;
                    }
                }
            }
        }while(swap);
    }

    //Insertion Sort
    public static void iSort(Integer[] input){
        for(int i=0;i<input.length;i++){
            Integer key = input[i];
            Integer subbArr = i - 1;
            while(subbArr>=0 && (key<input[subbArr])){
                input[subbArr+1] = input[subbArr];
                subbArr--;
            }
            input[subbArr+1] = key;
        }
    }

    //Merge Sort
    public static void mSort(Integer[] input){
        if(input.length > 1){
            Integer midVal = (int)Math.floor((input.length-1)/2);
            Integer[] leftArr = Arrays.copyOfRange(input, 0, midVal+1); //use subarrays to save lines
            Integer[] rightArr = Arrays.copyOfRange(input, midVal+1, input.length);
            mSort(leftArr);
            mSort(rightArr);
            int i = 0;
            int j = 0;
            int k = 0;
            while(i<leftArr.length && (j<rightArr.length)){
                if(leftArr[i] < rightArr[j]){
                    input[k] = leftArr[i];
                    i++;
                }else{
                    input[k] = rightArr[j];
                    j++;
                }
                k++;
            }
            while(i < leftArr.length){
                input[k] = leftArr[i];
                i++;
                k++;
            }
            while(j < rightArr.length){
                input[k] = rightArr[j];
                j++;
                k++;
            }
        }
    }

    //Print Array
    public static void printArr(Integer[] input){
        for(int i=0;i<input.length;i++){
            System.out.print(input[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        System.out.println("Hello World!");
        Integer[] test1 = {10,9,8,7,6,5,4,3,2,1,0,100,4312,43,3,6,2};
        Integer[] test2 = {10,9,8,7,6,5,4,3,2,1,0,100,4312,43,3,6,2};
        Integer[] test3 = {10,9,8,7,6,5,4,3,2,1,0,100,4312,43,3,6,2};
        mSort(test1);
        System.out.println("Merge Sort Output: ");
        printArr(test1);
        iSort(test2);
        System.out.println("Insertion Sort Output: ");
        printArr(test2);
        bSort(test3);
        System.out.println("Bible Sort Output: ");
        printArr(test3);
    }
}