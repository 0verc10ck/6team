package MAIN.FILTER;


import java.util.ArrayList;

public class Wish {
   private int roomCode;
   private String contactHome;
   private int price;
   private String uploadDate;
   private String startDate;
   private String terminateDate;
   private ArrayList<Boolean> location;
   private ArrayList<Boolean> option;
   private boolean tState;
    private String roomStructure;
   
   
   public Wish() {
      
   }
   
   public Wish(int roomCode, String contactHome, int price, String uploadDate, String startDate, String terminateDate, ArrayList<Boolean> location, ArrayList<Boolean> option, boolean tstate) {
      
   }
   
   public int getroomCode() {
      return roomCode;
   }
   
   public void setroomCode(int roomCode) {
      this.roomCode = roomCode;
   }
   
   public String getcontactHome() {
      return contactHome;
   }
   
   public void setroomCode(String contactHome) {
      this.contactHome = contactHome;
   }
   
   public int getPrice() {
      return price;
   }
   
   public void setPrice(int price) {
      this.price = price;
   }
   
   public String getUploadeDate() {
      return uploadDate;
   }
   
   public void setUploadeDate(String uploadDate) {
      this.uploadDate = uploadDate;
   }
   
   public String getStartDate() {
      return startDate;
   }
   
   public void setStartDate(String startDate) {
      this.startDate = startDate;
   }
   
   public String getTerminateDate() {
      return terminateDate;
   }
   
   public void setTerminateDate(String terminateDate) {
      this.terminateDate = terminateDate;
   }
   
   public ArrayList<Boolean> getLocation(){
      return location;
   }
   
   public void setLocation(ArrayList<Boolean> location) {
      this.location = location;
   }
   
   public ArrayList<Boolean> getOption(){
      return option;
   }
   
   public void setOption(ArrayList<Boolean> option) {
      this.option = option;
   }
   
   public boolean gettState() {
      return tState;
   }
   
   public void settState(boolean tState) {
      this.tState = tState;
   }
   
    public String getRoomStructure() {
        return roomStructure;
    }
   
    public void setRoomStructure(String roomStructure) {
        this.roomStructure = roomStructure;
    }
    
    public void print_info(){

           System.out.println("***************************************");
           System.out.printf("���ȣ: %d\n", getroomCode());
           System.out.printf("������ ����ó: %s\n", getcontactHome());
           System.out.printf("����: %d", getPrice());
           System.out.printf("���ε� ��¥: %s\n", getUploadeDate());
           System.out.printf("�뿩������: %s\n", getStartDate());
           System.out.printf("�뿩������: %s\n", getTerminateDate());
           System.out.printf("��ġ: %s\n", getLocation());
           System.out.printf("�ɼ�: %s\n", getOption());
           System.out.printf("�汸��: %s\n", getRoomStructure());
           System.out.println("***************************************");

        }
}
