import java.util.Scanner;

public class RoomInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("������� ���������� ���������: ");
        int entrancesQuantity = scanner.nextInt();

        System.out.print("������� ���������� ������: ");
        int floorsQuantity = scanner.nextInt();

        System.out.print("������� ����� ��������: ");
        int apartNumber = scanner.nextInt();

        scanner.close();

        //����� ���, ��� ������ ���������� �� ��������, ���������, ��� ��� ���� � ����
        //���� ��� - ������� ��������� � ��������� ����������
        int roomsPerFloor = 4;
        if ((apartNumber < 1) || (apartNumber > (roomsPerFloor * floorsQuantity * entrancesQuantity))) {
            System.out.println("����� �������� � ���� ���");
            return;
        }
        //���� �������� � ���� ����, �� ���������� ����������
        //������� ������������ ��������
        String apartLoc = null;
        switch (apartNumber % roomsPerFloor) {
            case 0 -> apartLoc = "������ �� �����, ������";
            case 1 -> apartLoc = "����� �� �����, �����";
            case 2 -> apartLoc = "����� �� �����, ������";
            case 3 -> apartLoc = "������ �� �����, �����";
        }
        // ������� ����� ��������
        int entranceNum;
        if (apartNumber % (roomsPerFloor * floorsQuantity) == 0) {
            entranceNum = apartNumber / (roomsPerFloor * floorsQuantity);
        } else {
            entranceNum = apartNumber / (roomsPerFloor * floorsQuantity) + 1;
        }
        //������� ����� �����
        int floorNum;
        if (apartNumber % roomsPerFloor == 0) {
            floorNum = apartNumber / roomsPerFloor;
            floorNum -= (entranceNum - 1) * floorsQuantity;
        } else {
            floorNum = apartNumber / roomsPerFloor+1;
            floorNum -= (entranceNum - 1) * floorsQuantity;
        }
        //������� ���������
        System.out.println(apartNumber + " �� - " + entranceNum + " �������, " + floorNum + " ����, " + apartLoc);
    }
}