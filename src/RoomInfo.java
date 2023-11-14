import java.util.Scanner;

public class RoomInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������� ���������� ���������: ");
        int entrancesQuantity = scanner.nextInt();

        System.out.println("������� ���������� ������: ");
        int floorsQuantity= scanner.nextInt();
        scanner.close();

        int apartNum = 0;
        int maxApart = 4*floorsQuantity*entrancesQuantity;
        while ((apartNum>maxApart)|(apartNum==0)) {
            System.out.println("������� ����� �������� �� 1 �� "+maxApart+" :");
            apartNum = scanner.nextInt();
        }
        //������� ������������ ��������
        String apartLoc = null;
        switch (apartNum % 4) {
            case 0 -> apartLoc = "������ �� �����, ������";
            case 1 -> apartLoc = "����� �� �����, �����";
            case 2 -> apartLoc = "����� �� �����, ������";
            case 3 -> apartLoc = "������ �� �����, �����";
        }
        // ������� ����� ��������
        int entranceNum;
        if (apartNum%(4*floorsQuantity)==0)
            entranceNum = apartNum/(4*floorsQuantity);
        else
            entranceNum = apartNum/(4*floorsQuantity)+1;
        //������� ����� �����
        int floorNum;
        if (apartNum%4!=0) {
            floorNum = apartNum / 4 + 1;
        }
        else {
            floorNum = apartNum / 4;
            floorNum -= (entranceNum - 1) * floorsQuantity;
        }
        //������� ���������
        System.out.println(apartNum+" �� - "+entranceNum+" �������, "+floorNum+" ����, "+apartLoc);
    }
}