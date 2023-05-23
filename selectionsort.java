public class selectionsort {
    public static void selectionSort(int arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minI = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minI] > arr[j]) {
                    minI=j;
                }
            }
            int temp = arr[minI];
            arr[minI] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main (String[] args) {
       int arr[]={5,3,7,8,2,6};
       
       for(int i=0;i<arr.length;i++){
           System.out.print(arr[i]+" ");
       }
       System.out.println();
       
       selectionSort(arr);
        for(int i=0;i<arr.length;i++){
           System.out.print(arr[i]+" ");
        }
    }
}