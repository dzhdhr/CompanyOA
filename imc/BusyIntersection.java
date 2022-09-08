package imc;

import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class BusyIntersection {
    // 1 for first 0 for main
    public static List<Integer> busyIntersect(int[]car, int []street){
        int[] ret = new int [car.length];
        Queue<Integer> Q= new LinkedList<>();
        PriorityQueue<Integer> mainStreet = new PriorityQueue<>(
                (a,b)->{
                    if (car[a]==car[b])return Integer.compare(a,b);
                    return Integer.compare(car[a],car[b]);
                }
        );
        PriorityQueue<Integer>firstStreet = new PriorityQueue<>(
                (a,b)->{
                    if (car[a]==car[b])return Integer.compare(a,b);
                    return Integer.compare(car[a],car[b]);
                }
        );
        for (int i  = 0;i<car.length;i++){
            if (street[i]==0){
                mainStreet.offer(i);
            }
            else {
                firstStreet.offer(i);
            }
        }
        // 0 for no cross in last second
        // 1 for main cross in last second
        // 2 for 1 first crossing in last second
        int status = 0;
        int currentSecond = 0;
        while (!firstStreet.isEmpty()&&!mainStreet.isEmpty()){

            int firstStreetCar = car[firstStreet.peek()];
            int mainStreetCar = car[mainStreet.peek()];
            System.out.printf("next first arrive %d. next main arrive %d\n",firstStreetCar,mainStreetCar);
            if (firstStreetCar<=currentSecond&&mainStreetCar<=currentSecond){ //arrive at same time
                if(status==1){ //main cross last
                    //status = 1;
                    int nextCar = mainStreet.poll();
                    System.out.println("main last");
                    ret[nextCar] = currentSecond;
                }else if(status==2){ // first cross last
                    //status = 2;
                    int nextCar = firstStreet.poll();
                    System.out.println("first last");
                    ret[nextCar] = currentSecond;
                }else { //no car cross
                    status=2;
                    int nextCar = firstStreet.poll();
                    System.out.println("no car last");
                    ret[nextCar] = currentSecond;

                }
            } else if (firstStreetCar<=currentSecond) { // first street array at correct second
                System.out.println("only first");
                status = 2;
                int nextCar = firstStreet.poll();
                ret[nextCar] = currentSecond;
            }else if (mainStreetCar<=currentSecond){ // main street array at correct second
                System.out.println("only main");
                status = 1;
                int nextCar = mainStreet.poll();
                ret[nextCar] = currentSecond;
            }else{//no car pass
                status=0;
            }
            currentSecond++;

        }
        System.out.println(currentSecond);
        while (!firstStreet.isEmpty()){
            int first = firstStreet.peek();
            if (car[first]<=currentSecond){
                int nextCar = firstStreet.poll();
                ret[nextCar] = currentSecond;
            }
            currentSecond++;
        }
        while (!mainStreet.isEmpty()){
            int mainstreet = mainStreet.peek();
            if (car[mainstreet]<=currentSecond){
                int nextCar = mainStreet.poll();
                ret[nextCar] = currentSecond;
            }
            currentSecond++;

        }
        System.out.println(currentSecond);
        return Arrays.stream(ret).boxed().toList();

    }

    public static void main(String[] args) {
        System.out.println(busyIntersect(new int[]{0,1000000000},new int[]{0,1}));
    }
}
