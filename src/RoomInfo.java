import java.util.Scanner;

public class RoomInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество подъездов: ");
        int entrancesQuantity = scanner.nextInt();

        System.out.print("Введите количество этажей: ");
        int floorsQuantity = scanner.nextInt();

        System.out.print("Введите номер квартиры: ");
        int apartNumber = scanner.nextInt();

        scanner.close();

        //Перед тем, как искать информацию по квартире, проверяем, что она есть в доме
        //Если нет - выводим сообщение и завершаем выполнение
        int roomsPerFloor = 4;
        if ((apartNumber < 1) || (apartNumber > (roomsPerFloor * floorsQuantity * entrancesQuantity))) {
            System.out.println("Такой квартиры в доме нет");
            return;
        }
        //Если квартира в доме есть, то продолжаем выполнение
        //Находим расположение квартиры
        String apartLoc = null;
        switch (apartNumber % roomsPerFloor) {
            case 0 -> apartLoc = "Справа от лифта, вправо";
            case 1 -> apartLoc = "Слева от лифта, влево";
            case 2 -> apartLoc = "Слева от лифта, вправо";
            case 3 -> apartLoc = "Справа от лифта, влево";
        }
        // Находим номер подъезда
        int entranceNum;
        if (apartNumber % (roomsPerFloor * floorsQuantity) == 0) {
            entranceNum = apartNumber / (roomsPerFloor * floorsQuantity);
        } else {
            entranceNum = apartNumber / (roomsPerFloor * floorsQuantity) + 1;
        }
        //Находим номер этажа
        int floorNum;
        if (apartNumber % roomsPerFloor == 0) {
            floorNum = apartNumber / roomsPerFloor;
            floorNum -= (entranceNum - 1) * floorsQuantity;
        } else {
            floorNum = apartNumber / roomsPerFloor+1;
            floorNum -= (entranceNum - 1) * floorsQuantity;
        }
        //Выводим результат
        System.out.println(apartNumber + " кв - " + entranceNum + " подъезд, " + floorNum + " этаж, " + apartLoc);
    }
}