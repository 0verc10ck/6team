package MAIN.FILTER;

import MAIN.Demo;
import MAIN.TRANSACTION.Room;
import MAIN.TRANSACTION.USER.User;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchingFilter {
    private String location;
    private int upperPrice;
    private int lowerPrice;
    private String roomStructure;
    private Boolean completeState;
    private ArrayList<String> filter_list;
    SearchingFilter select_filter = new SearchingFilter();
    private ArrayList<Wish> Wish_list;
    //method
    public void filtering(SearchingFilter filter){
        Demo temp_demo = new Demo();
        ArrayList<Room> temp_room = temp_demo.getRooms();
        ArrayList<Room> filter_room = new ArrayList<>();

        if(filter_list.get(1).equals("O")){
            for(Room for_room : temp_room){
                String check = select_filter.getLocation();
                int cnt = 0;
                int l = check.length();

                for(int i=0; i < l; i++){
                    if(check.charAt(i) != for_room.getLocation().charAt(i))
                        cnt++;
                }
                if (cnt == l) continue;
                else filter_room.add(for_room);
            }
        }

        if(filter_list.get(2).equals("O")){
            int upper = select_filter.getUpperPrice();
            int lower = select_filter.getLowerPrice();

            for(Room for_room : filter_room){
               if(for_room.getPrice() > upper || for_room.getPrice()<lower)
                   filter_room.remove(for_room);
            }
        }

        if(filter_list.get(3).equals("O")){
            for(Room for_room : filter_room){
                if(!for_room.getRoomStructure().equals(select_filter.getRoomStructure()))
                    filter_room.remove(for_room);
            }
        }


        if(filter_list.get(4).equals("O")){
            for(Room for_room : filter_room){
                if(!for_room.getRoomStructure().equals(select_filter.getCompleteState()))
                    filter_room.remove(for_room);
            }
        }

        if(filter_room.size() == 0)
            System.out.println("�ش�Ǵ� ���� �����ϴ�");
        else{
            for(Room for_room : filter_room){
                String output =
                        for_room.getRoomCode() + " " + for_room.getPrice() + " " + 
                                for_room.getUploadDate() + " " + for_room.getStartDate() + " " + 
                                for_room.getTerminateDate() + " " +
                        for_room.getLocation() + " " + for_room.getOption() + " " + for_room.gettState() 
                                + " " + for_room.getRoomStructure()+"\n";
            }
        }
  
    }

    //location | price | roomStructure | tState
    public SearchingFilter selectFilter(){
        SearchingFilter select_filter = new SearchingFilter();
        filter_list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("�˻��ϰ� ���� ���͸� �������ּ���.");
        System.out.println("��ȣ������ �����Ͻðڽ��ϱ�? (O/X)");

        String select = sc.nextLine();

        if(select.equals("O")) {
            filter_list.add(select);
            System.out.println("��ȣ���� ���� (�Ϲ� / ���� / ���� / ���� / �����幮 / ��ũ�빮 / ���幮 / �ַι� / ������ / �ʹ�)");
            select_filter.setLocation(sc.nextLine());
        } else {
            filter_list.add(select);
            System.out.println("��ȣ������ �������� �����̽��ϴ�.");
        }

        System.out.println("�� ������ �����Ͻðڽ��ϱ�? (O/X)");
        select = sc.nextLine();
        if(select.equals("O")) {
            filter_list.add(select);
            System.out.println("�˻��ϰ� ���� �ְ� ������ �����ϼ���.");
            select_filter.setUpperPrice(sc.nextInt());
            System.out.println("�˻��ϰ� ���� ���� ������ �����ϼ���.");
            select_filter.setLowerPrice(sc.nextInt());
            sc.nextLine();
        } else {
            filter_list.add(select);
            System.out.println("�� ������ �������� �����̽��ϴ�.");
        }

        System.out.println("�� ������ �����Ͻðڽ��ϱ�? (O/X)");
        select = sc.nextLine();
        if(select.equals("O")) {
            filter_list.add(select);
            System.out.println("�˻��ϰ� ���� �� ������ �����ϼ���. ���� : (����/����)");
            select_filter.setRoomStructure(sc.nextLine());
        } else {
            filter_list.add(select);
            System.out.println("�� ������ �������� �����̽��ϴ�.");
        }

        System.out.println("�ŷ� �Ϸ�� �浵 ���ðڽ��ϱ�? (O/X)");
        select = sc.nextLine();
        if(select.equals("O")) {
            filter_list.add(select);
            select_filter.setCompleteState(true);
        } else {
            filter_list.add(select);
            select_filter.setCompleteState(false);
            System.out.println("�ŷ� �Ϸ�� �� ���⸦ �������� �����̽��ϴ�.");
        }

        return select_filter;
    }

    public void sorting(){

    }

    public void printMessage(){

    }

    public void addWish(){

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getUpperPrice() {
        return upperPrice;
    }

    public void setUpperPrice(int upperPrice) {
        this.upperPrice = upperPrice;
    }

    public int getLowerPrice() {
        return lowerPrice;
    }

    public void setLowerPrice(int lowerPrice) {
        this.lowerPrice = lowerPrice;
    }

    public String getRoomStructure() {
        return roomStructure;
    }

    public void setRoomStructure(String roomStructure) {
        this.roomStructure = roomStructure;
    }

    public Boolean getCompleteState() {
        return completeState;
    }

    public void setCompleteState(Boolean completeState) {
        this.completeState = completeState;
    }
}