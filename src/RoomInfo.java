import java.util.Scanner;

public class RoomInfo {

    public static void main(String[] args) {

        int floorsNums, floorNum;
        int entrancesNums, entranceNum;
        int apartNum = 0;
        String apartLoc = null;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество подъездов: ");
        entrancesNums = scanner.nextInt();

        System.out.println("Введите количество этажей: ");
        floorsNums = scanner.nextInt();


        int maxApart = 4*floorsNums*entrancesNums;
        while ((apartNum>maxApart)|(apartNum==0)) {
            System.out.println("Введите номер квартиры от 1 до "+maxApart+" :");
            apartNum = scanner.nextInt();
        }

        //Находим расположение квартиры
        switch (apartNum % 4) {
            case 1 -> apartLoc = "Слева от лифта, влево";
            case 2 -> apartLoc = "Слева от лифта, вправо";
            case 3 -> apartLoc = "Справа от лифта, влево";
            case 0 -> apartLoc = "Справо от лифта, вправо";
        }

        // Находим номер подъезда
        if (apartNum%(4*floorsNums)==0)
            entranceNum = apartNum/(4*floorsNums);
        else
            entranceNum = apartNum/(4*floorsNums)+1;

        //Находим номер этажа
        if (apartNum%4!=0)
            floorNum = apartNum/4+1;
        else
            floorNum = apartNum/4;
        floorNum -= (entranceNum-1)*floorsNums;

        //Выводим результат
        System.out.println(apartNum+" кв - "+entranceNum+" подъезд, "+floorNum+" этаж, "+apartLoc);
    }
}
