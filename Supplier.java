package MAIN.TRANSACTION.USER;

import java.io.IOException;
import java.util.ArrayList;

import MAIN.Demo;
import MAIN.TRANSACTION.Room;
import MAIN.TRANSACTION.Transaction;

public class Supplier extends User {
    ArrayList<Room> myRoom = new ArrayList<Room>();
    Demo demo = new Demo();
    ArrayList<Room> temp_room = new ArrayList<Room>();
    ArrayList<Transaction> transactionList = new ArrayList<Transaction>();

    //Constructor
    public Supplier(String name, String id, String password, String contact, int occupation,
                    String preferredArea, Boolean pushAgreement, double averageScore, String userState, int transCnt) {
        super(name, id, password, contact, occupation, preferredArea, pushAgreement, averageScore, userState, transCnt);
    }

    public Supplier(User user) {
        super(user);
    }

    //method
    public void roomUpdate() throws IOException {
        Boolean check;
        String contactHome;
        int price;
        String uploadDate;
        String startDate;
        String terminateDate;
        String location;
        String option;
        Boolean tState;
        String roomStructure;
        Boolean permissionCheck;
        long Date;
        temp_room = demo.getRooms();

        System.out.println("�������� �Է����ּ���");

        System.out.print("������ ����ó : ");
        contactHome = sc.nextLine();
        System.out.print("�Ϸ� ���� ���� : ");
        price = sc.nextInt();
        sc.nextLine();
        System.out.print("�뿩 ���� ������ : ");
        startDate = sc.nextLine();
        System.out.print("�ٿ� ���� ������ : ");
        terminateDate = sc.nextLine();
        System.out.print("��ġ : ");
        location = sc.nextLine();
        System.out.print("�� ���� : ");
        roomStructure = sc.nextLine();
        System.out.print("�� �ɼ� : ");
        option = sc.nextLine();
        tState = false;
        permissionCheck = false;
        Date = System.currentTimeMillis();
        uploadDate = Long.toString(Date);
        Room temp = new Room(contactHome,price,uploadDate,startDate,terminateDate,location,option,tState,roomStructure,permissionCheck);
        check = temp.callPermission();
        if(check == true) {
            System.out.println("���� ��ϵǾ����ϴ�");
            myRoom.add(temp);
            temp_room.add(temp);
            demo.setRoomcode(demo.getRoomcode()+1);
            demo.setRooms(temp_room);
            temp.recordInformation(super.getId());
        }
        else{
            System.out.println("�� ����� �����߽��ϴ�");
        }


    }

    public void myRoomEdit(){

    }

    public void myRoomDelete(){

    }

    public Boolean tComplete(){
        return true;
    }

}