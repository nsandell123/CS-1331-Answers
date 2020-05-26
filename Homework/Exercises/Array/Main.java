package Exercises.Array;

public class Main {
    public static void main(String[] args)
    {
        int[][] StudentArray = { {12, 22, 33},{45, 65, 95},{442, 444, 446},{785, 786, 787}};
        int [] arr = {1,2,3,4,5,6};
        int [] arr2 = {69,240};
        //returns first three elements of arr
        System.out.println(ArrayUtil.toString(ArrayUtil.take(3,arr)));

        //returns last three elements of arr
        System.out.println(ArrayUtil.toString(ArrayUtil.drop(3,arr)));

        //should return false
        System.out.println(ArrayUtil.equals(arr,arr2));

        //should return an array containing arr + arr2 together
        System.out.println(ArrayUtil.toString(ArrayUtil.concat(arr,arr2)));

        //Let's print out the toString of a 1d array
        System.out.println(ArrayUtil.toString(arr));
        //Let's print out the toString of a 2d array
        System.out.println(ArrayUtil.toString(StudentArray));

        //Let's print out a 5x5 identity matrix
        System.out.println(ArrayUtil.toString(ArrayUtil.identity(5)));

    }
}
