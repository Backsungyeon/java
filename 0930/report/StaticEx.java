package java2024;

class ArrayUtil {
    public static int[] concat(int[] a, int[] b) {
        int [] arr = new int[a.length+b.length];
 
        for(int i=0; i<a.length; i++){
            arr[i] = a[i];
        }
        for(int i=a.length; i<a.length+b.length; i++){
            arr[i] = b[i-a.length];
        }
 
        return arr;
    }
    public static void print(int[] a) {
        System.out.print("[ ");
        for(int i=0; i<a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.print("]");
    }
}
 
public class StaticEx {
    public static void main(String[] args) {
        int[] array1 = {1, 5, 7, 9};
        int[] array2 = {3, 6, -1, 100, 77};
        int[] array3 = ArrayUtil.concat(array1, array2);
        ArrayUtil.print(array3);
    }
}
