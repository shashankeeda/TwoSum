//Shashank Eeda
import java.util.*;
public class TwoSum {
    int first;//The two data members first and second are meant to be the indices of the values that add up to the sum
              //and they will never be given a value if there is not a solution
    int second;
    public int firstNum(){
        return first;
    }
    public int secondNum(){
        return second;
    }
    //These are getter methods that are just meant to return the first and second index
    public void selectionsort(int[] arr){

        for (int i = 0; i < arr.length-1; i++)
        {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    /*
    This is the selection sort method which is meant to take an array as a parameter and then sort the array
    through selection sort
     */
    boolean binarySearch(int arr[], int start, int end, int value)
    {
        if (end >= start) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == value)
                return true;

            if (arr[mid] > value)
                return binarySearch(arr, start, mid - 1, value);

            return binarySearch(arr, mid + 1, end, value);
        }
        return false;
    }
    /*
    This is the binary search method which will take in the value of sum-num[i] to find the value that will fit this
    solution, it will take the array, a start value of of zero and the arrays length subtracted by one, by using recursion
    it will see if that value is there and will return true if it is and false otherwise.
     */
    public int twoSum(int[] num, int sum){
        selectionsort(num);
        int temp1,temp2;

        for(int i=0;i<num.length;i++){
            temp1=num[i];
            if(binarySearch(num,i,num.length-1,sum-temp1)){
                first=i;
                temp2=sum-temp1;
                for(int w=0;w<num.length;w++){
                    if(num[w]==temp2)
                        second=w;
                }
                return 1;
                }
        }
        return -1;
    }
    /*
    The twoSum method will take an array as a parameter and the sum value which we want to find, it first calls the
    selectionsort method which will sort the values, then in a forloop we will keep callling the binary search method
    trying each index of the sorted array and trying to find the next value, once two values are found, first and second
    will be replaced to those indexes and 1 will be returned to indicate true, otherwise -1 will be returned;
     */
    public static void main(String[] args){
        int n, sum;
        int[] arr;
        TwoSum tester=new TwoSum();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the sum value that you are looking for: ");
        sum=input.nextInt();
        //This is where the user the sum value they want to look for
        System.out.println("Enter the number of items you will input in the array");
        n=input.nextInt();
        //This is where the user will input the number of items they will input in the array
        arr=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter item: ");
            arr[i]=input.nextInt();
        }
        //This is where the user will input all the items in the array
        if(tester.twoSum(arr,sum)==1) {
            System.out.print("Sorted Array: ");
            for(int i=0;i<arr.length;i++)
                System.out.print(arr[i]+" ");
            System.out.println();
            System.out.println("Indices are located in index " + tester.firstNum() + " and index " + tester.secondNum());
        }
        //If the values are found in the sorted array that adds up to the sum, the indices will be printed
        else
            System.out.println("No Solution");
        //Otherwise it will print no solution
        /*
        Sample input and output
        Enter the sum value that you are looking for:
        19
        Enter the number of items you will input in the array
        10
        Enter item:
        10
        Enter item:
        4
        Enter item:
        2
        Enter item:
        7
        Enter item:
        8
        Enter item:
        9
        Enter item:
        4
        Enter item:
        2
        Enter item:
        1
        Enter item:
        4
        Sorted Array: 1 2 2 4 4 4 7 8 9 10
        Indices are located in index 8 and index 9
         */
    }
}
