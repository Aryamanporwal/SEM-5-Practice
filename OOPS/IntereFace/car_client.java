package IntereFace;

public class car_client {
    public static void main(String[] args) {
        // int [] arr = new int[5];
        car[] arr = new car[5];
        arr[0] = new car(200, 10 , "white");
        arr[1] = new car(2000, 20 , "black");
        arr[2] = new car(345, 3 , "yellow");
        arr[3] = new car(34, 89  , "grey");
        arr[4] = new car(890, 6 , "pink");
        // Sort(arr);
        Arrays.sort(arr, new Comparator<car>(){

            @Override
            public int compare(car o1 /*this */, car o2 /*other */){
                return o1.price-o2.price;
            }
            
        });

        Arrays.sort(arr, new Comparator<car>(){

            @Override
            public int compare(car o1 /*this */, car o2 /*other */){
                return o2.speed-o1.speed;
            }

        });
        
        Display(arr);
    }
    public static void Display(car[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]+" ");
        }
    }

    public static <T extends Comparable<T>> void Sort(T [] arr){
        for(int turn = 1; turn <arr.length ; turn++){
            for(int i = 0  ; i<arr.length-turn ; i++){
                if(arr[i].compareTo(arr[i+1])>0){
                    //jiss reference variable k upar dot lagate h uska address this keyword paas jata h
                    //arr[i+1] comparable m that is o
                    T t = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = t;
                }
            }
        }
    }
    
}
