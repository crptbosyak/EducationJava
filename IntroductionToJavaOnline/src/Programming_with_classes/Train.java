package Programming_with_classes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Train implements Comparable {
    @Override
    public String toString() {
        return "Train{" +
                "nameOfLastStation='" + nameOfLastStation + '\'' +
                ", num=" + num +
                ", time=" + time +
                '}';
    }

    String nameOfLastStation = "";
    int num;
    int time;

    public Train(String nameOfLastStation, int num, int time) {
        this.nameOfLastStation = nameOfLastStation;
        this.num = num;
        this.time = time;
    }

    @Override
    public int compareTo(Object o) {
        Train tr = (Train) o;

        return this.num - tr.num;
    }

    public void trains(int count) {
        Train[] trains = new Train[count];
        trains[0] = new Train("lasvegas", 2, 1210);
        trains[1] = new Train("amsterdam", 3, 1320);
        trains[2] = new Train("dusseldorf", 6, 1700);
        trains[3] = new Train("dusseldorf", 1, 1632);
        trains[4] = new Train("koln", 4, 1014);
        Arrays.sort(trains);
        for (int i = 0; i < trains.length; i++) {
            System.out.println(" Train num: " + trains[i].num + " / time: " + trains[i].time + " / Last Station : " + trains[i].nameOfLastStation);
        }

        System.out.println("withdraw the train by number");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < trains.length; i++) {
            if (trains[i].num == n) {
                System.out.println("\n Train num: " + trains[i].num + " / time: " + trains[i].time + " / Last Station : " + trains[i].nameOfLastStation);
            }
        }
        System.out.println("\n");
        Arrays.sort(trains, new SortStation());
        for (int i = 0; i < trains.length; i++) {
            System.out.println(i+" "+trains[i]);
//            System.out.println(" Train num: " + trains[i].num + " / time: " + trains[i].time + " / Last Station : " + trains[i].nameOfLastStation);
        }



    }

    class SortStation implements Comparator<Train> {


        @Override
        public int compare(Train o1, Train o2) {
            if(o1.nameOfLastStation.equals(o2.nameOfLastStation)){
                return o1.time-o2.time;
            }
            if(o1.nameOfLastStation.compareTo(o2.nameOfLastStation)>0){
                return 1;
            }
            if (o1.nameOfLastStation.compareTo(o2.nameOfLastStation)<0){
                return -1;
                 }
            else {return 0;}
        }

    }
}

//Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
//Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
//номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.

//Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
//назначения должны быть упорядочены по времени отправления.