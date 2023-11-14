import java.util.Scanner;

public class RoomInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество подъездов: ");
        int entrancesQuantity = scanner.nextInt();

        System.out.print("Введите количество этажей: ");
        int floorsQuantity = scanner.nextInt();

        int apartNum = 0;
        int maxApartQuantity = 4 * floorsQuantity * entrancesQuantity;

        while ((apartNum > maxApartQuantity) | (apartNum == 0)) {
            System.out.print("Введите номер квартиры от 1 до " + maxApartQuantity + " :");
            apartNum = scanner.nextInt();
        }
        scanner.close();

        //Находим расположение квартиры
        String apartLoc = null;
        switch (apartNum % 4) {
            case 0 -> apartLoc = "Справа от лифта, вправо";
            case 1 -> apartLoc = "Слева от лифта, влево";
            case 2 -> apartLoc = "Слева от лифта, вправо";
            case 3 -> apartLoc = "Справа от лифта, влево";
        }
        // Находим номер подъезда
        int entranceNum;
        if (apartNum % (4 * floorsQuantity) == 0) {
            entranceNum = apartNum / (4 * floorsQuantity);
        }
        else {
            entranceNum = apartNum / (4 * floorsQuantity) + 1;
        }
        //Находим номер этажа
        int floorNum;
        if (apartNum % 4 != 0) {
            floorNum = apartNum / 4 + 1;
        } else {
            floorNum = apartNum / 4;
            floorNum -= (entranceNum - 1) * floorsQuantity;
        }
        //Выводим результат
        System.out.println(apartNum + " кв - " + entranceNum + " подъезд, " + floorNum + " этаж, " + apartLoc);
    }
}