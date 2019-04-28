package MAIN.TRANSACTION.USER;

import java.util.ArrayList;
import java.util.Scanner;

import MAIN.Demo;
import MAIN.FILTER.SearchingFilter;
import MAIN.FILTER.Wish;
import MAIN.MANAGEMENT.BOARD.Board;
import MAIN.TRANSACTION.Review;

public class User {

    //Basic variable
    private String name;
    private String id;
    private String password;
    private String contact;
    private int occupation;
    private String preferredArea;
    private Boolean pushAgreement;
    private double averageScore;
    private String UserState;
    private int transCount;
    private ArrayList<Wish> wishRoom;
    private ArrayList<Review> review;
    private Array<SearchingFilter> sf;

    //Additional variable
    Scanner sc = new Scanner(System.in);
    Demo demo;
    ArrayList<User> userList = demo.getMembers();
    //ArrayList<Board> boardList = demo.getBoardList();

    //Constructor
    public User(){
    	
    }

    public User(String name, String id, String password, String contact,
            int occupation, String preferredArea, Boolean pushAgreement, double averageScore, String userState, int TransCnt) {
    this.name = name;
    this.id = id;
    this.password = password;
    this.contact = contact;
    this.occupation = occupation;
    this.preferredArea = preferredArea;
    this.pushAgreement = pushAgreement;
    this.averageScore = averageScore;
    this.UserState = userState;
    this.transCount = TransCnt;
}


public User(User user)
{
    this.name = user.getName();
    this.id = user.getId();
    this.password = user.getPassword();
    this.contact = user.getContact();
    this.occupation = user.getOccupation();
    this.preferredArea = user.getPreferredArea();
    this.pushAgreement = user.getPushAgreement();
    this.averageScore =  user.getAverageScore();
    this.UserState = user.getUserState();
    this.transCount = user.getTransCount();
}


    //method

    public void convertUserState(String userState) {
        if (getUserState().equals(userState)) {
            System.out.println("error");
        } else {
            for (int i = 0; i <= userList.size(); i++) {
                if (userList.get(i).getId().equals(this.id)) {
                    userList.get(i).setUserState(userState);
                    break;
                }
            }
            System.out.println("USER STATE CHANGE!");
        }
    }

    public void deactivateAccount() {
        for (int i = 0; i <= userList.size(); i++) {
            if (userList.get(i).getId().equals(this.id)) {
                userList.remove(userList.get(i));
                break;
            }
        }
    }

    //ADD WISH ROOM TO WISHLIST
    public void addToWishRoom(Wish room) {
        wishRoom.add(room);
    }

    //LOOK FOR ROOM WISHLIST
    public void lookForWishRoom() {
        Scanner input = new Scanner(System.in);
        System.out.println("WishRoom List");

        printWishRoomCode();

        System.out.print("Enter the roomCode you want to search > ");
        int search_room = input.nextInt();
        
        for (int i = 0; i < wishRoom.size(); i++) {
           Wish proom = wishRoom.get(i);
            if (search_room == proom.getroomCode()) {
                proom.print_info();
            }
        }
    }

    // DELETE THE ONE ROOM OF WISHLIST()
    public void deleteWishRoom() {
        int i, delete_roomCode;
        Scanner input = new Scanner(System.in);
        System.out.println("WishRoom List");
        printWishRoomCode();

        System.out.print("Enter the roomCode you want to delete > ");
        int delete_room = input.nextInt();
        for(i=0; i<wishRoom.size(); i++) {
            Wish proom = wishRoom.get(i);
            if(delete_room == proom.getroomCode()) {
                break;
            }
        }

        if(i==wishRoom.size()) {
            System.out.printf("Room %d is not exists in wishlist!\n", delete_room);
        }
        else {
            wishRoom.remove(i);
            System.out.printf("Room %d deleted\n", delete_room);
        }
    }


    public void printWishRoomCode() {
        int i;
        for(i=0; i<wishRoom.size(); i++) {
            Wish room = wishRoom.get(i);
            System.out.printf("%d / ", room.getroomCode());
        }
    }

    public void updateUserList(){
    	
    	//��������� ����Ʈ�� �����Ѵ�
        for (int i = 0; i <= userList.size(); i++) {
            if (userList.get(i).getId().equals(this.id)) {
            	userList.remove(i);
            	userList.add(this);
            	break;
            }
        }
        
        
    }
    
    
    public void editPushAgreement(boolean pAgreement){
    	setPushAgreement(pushAgreement);
    	if(pushAgreement==true)
    		System.out.println("�˸� ������ ���ǵǾ����ϴ�.");
    	else
    		System.out.println("�˸� ������ �źεǾ����ϴ�.");
    	
    	updateUserList();
    }
    
    public void editPreferredArea(String PreferredArea){
    	setPreferredArea(PreferredArea);
    	System.out.println("���������� ����Ǿ����ϴ�.");
    	
    	updateUserList();

    }
    
    public void editOccupation(int job){
    	setOccupation(job);
    	System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
    	
    	updateUserList();

    }
    
    public void editContact(String contact){
    	if(contact.equals(this.contact)){
    		System.out.println("���� ������� ��ȣ�Դϴ�.");
    	}
    	else{
    		setContact(contact);
    		System.out.println("��ȣ ������ �Ϸ�Ǿ����ϴ�.");
    	}
    	
    	updateUserList();

    }
    
    public void editPasswd(String pass){
    	if(pass.equals(this.password)){
    		System.out.println("���� ������� ��й�ȣ�Դϴ�.");
    	}
    	else{
    		setPassword(pass);
    		System.out.println("��й�ȣ�� ����Ǿ����ϴ�.");
    	}
    	
    	updateUserList();

    }



//    private void editPush(){
//
//    }

//    public void searchRoom(){
//    	
//    }

//    public void writeScore(){
//
//    }
//
//    public void writeReview(){
//
//    }
    
    public void deleteMyBoard(){
    	ArrayList<Board> boardList = demo.getBoardList();
    	int i;
    	System.out.println("***************************************");
    	System.out.println("�� �� ��� >");
    	for(i=0; i<boardList.size(); i++){
    		Board b = boardList.get(i);
    		if(b.getId_writer().equals(id)){
				System.out.printf("\n�Խñ۹�ȣ: %d\n ����: %s\n �ۼ���: %s\n �ۼ��Ͻ�: %s\n", 
    					b.getBoardCode(), b.getTitle(), b.getId_writer(), b.getWriteDate().toString());
    		}
    	}
    	System.out.println("***************************************\n");
    	System.out.print("������ �� ��ȣ >");
    	Scanner keyboard = new Scanner(System.in);
    	int code = keyboard.nextInt();
    	for(i=0; i<boardList.size(); i++){
    		Board b = boardList.get(i);
    		if(b.getBoardCode()==code){//�۹�ȣ�� ID��� ��ġ�ؾ���.
    			if(b.getId_writer()!=this.id){
    				System.out.println("������ �Խñ��� �ƴմϴ�.");
    				break;
    			}
    			boardList.remove(i);
    			System.out.printf("\n�Խñ� %d�� �����Ǿ����ϴ�.\n",code);
    			break;
    		}
    	}
    	if(i==boardList.size()){
    		System.out.println("������ �Խñ��� �������� �ʽ��ϴ�.\n");
    	}
    }
    
    public void editMyBoard(){
    	ArrayList<Board> boardList = demo.getBoardList();
    	int i;
    	System.out.println("***************************************");
    	System.out.println("�� �� ��� >");
    	for(i=0; i<boardList.size(); i++){
    		Board b = boardList.get(i);
    		if(b.getId_writer().equals(id)){
				System.out.printf("\n�Խñ۹�ȣ: %d\n ����: %s\n �ۼ���: %s\n �ۼ��Ͻ�: %s\n", 
    					b.getBoardCode(), b.getTitle(), b.getId_writer(), b.getWriteDate().toString());
    		}
    	}
    	System.out.println("***************************************\n");
    	System.out.print("\n������ �� ��ȣ >");
    	Scanner keyboard = new Scanner(System.in);
    	int code = keyboard.nextInt();
    	for(i=0; i<boardList.size(); i++){
    		Board b = boardList.get(i);
    		if(b.getBoardCode()==code){//�۹�ȣ�� ID��� ��ġ�ؾ���.
    			if(b.getId_writer()!=this.id){
    				System.out.println("������ �Խñ��� �ƴմϴ�.");
    				break;
    			}
    			System.out.print("������ ���� > ");
    			String line = keyboard.nextLine();
    			b.setTitle(line);
    			System.out.print("������ ���� > ");
    			line = keyboard.nextLine();
    			b.setContents(line);
    			System.out.println("\n������ �Ϸ�Ǿ����ϴ�.");
    			break;
    		}
    	}
    	if(i==boardList.size()){
    		System.out.println("������ �Խñ��� �������� �ʽ��ϴ�.\n");
    	}
    }

    public void lookForBoard(){
    	ArrayList<Board> boardList = demo.getBoardList();
    	int i;
		System.out.println("***************************************");
    	for(i=0; i<boardList.size(); i++){
    		Board b = boardList.get(i);
    		if(b.getId_writer().equals(id)){
				System.out.printf("\n�Խñ۹�ȣ: %d\n ����: %s\n �ۼ���: %s\n �ۼ��Ͻ�: %s\n", 
    					b.getBoardCode(), b.getTitle(), b.getId_writer(), b.getWriteDate().toString());
				System.out.printf("����: \n%s\n", b.getContents());
    		}
    	}
		System.out.println("***************************************");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getOccupation() {
        return occupation;
    }

    public void setOccupation(int occupation) {
        this.occupation = occupation;
    }

    public String  getPreferredArea() {
        return preferredArea;
    }

    public void setPreferredArea(String preferredArea) {
        this.preferredArea = preferredArea;
    }

    public Boolean getPushAgreement() {
        return pushAgreement;
    }

    public void setPushAgreement(Boolean pushAgreement) {
        this.pushAgreement = pushAgreement;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public String getUserState() {
        return UserState;
    }

    public void setUserState(String userState) {
        UserState = userState;
    }

    public ArrayList<Review> getReview() {
        return review;
    }

    public void setReview(ArrayList<Review> review) {
        this.review = review;
    }
    
    public int getTransCount() {
        return transCount;
    }

    public void setTransCount(int transCount) {
        this.transCount = transCount;
    }
    
}
