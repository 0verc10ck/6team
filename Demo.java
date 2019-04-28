package MAIN;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

import MAIN.FILTER.SearchingFilter;
import MAIN.MANAGEMENT.Manager;
import MAIN.MANAGEMENT.BOARD.Board;
import MAIN.MANAGEMENT.BOARD.Inquiry;
import MAIN.MANAGEMENT.BOARD.Report;
import MAIN.MANAGEMENT.BOARD.Suggestion;
import MAIN.TRANSACTION.Room;
import MAIN.TRANSACTION.USER.Consumer;
import MAIN.TRANSACTION.USER.Supplier;
import MAIN.TRANSACTION.USER.User;


public class Demo {
    private static User user;
    private static Manager manager;
    private static Demo demo;
    private static ArrayList<User> members;
    private static ArrayList<Room> rooms;
    private static ArrayList<Board> boardList;
    private Supplier supplier;
    private Consumer consumer;
    private static String fileName_mem;
    private static String fileName_room;
    private static String fileName_board;
    private static int roomcode=0;
    //private static ArrayList<Consumer> consumers;
    //private static ArrayList<Supplier> suppliers;

    
    public static void main(String[] args) throws IOException {
        demo = new Demo();
    	manager = new Manager();
//        user = new User();
        members = new ArrayList<>();
        rooms = new ArrayList<>();
        boardList = new ArrayList<>();
        fileName_mem = "MemberList.txt";
        fileName_room = "RoomList.txt";
        String fileName_load = "boardList.txt";
        //  consumers = new ArrayList<>();
        //  suppliers = new ArrayList<>();
        demo.load_Members();
        demo.load_Rooms();
        try {
            demo.Main_Menu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public void load_Members(){
        try{
        	
            File file = new File(fileName_mem);
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine())
            {
                //User temp_user = new User();
                String data = sc.nextLine();
                StringTokenizer tokens = new StringTokenizer(data);
                //System.out.println(data);

                String name = tokens.nextToken(" ");
                String id = tokens.nextToken(" ");
                String password = tokens.nextToken(" ");
                String contact = tokens.nextToken(" ");
                int occupation = Integer.parseInt(tokens.nextToken(" "));
                String preferredarea = tokens.nextToken(" ");
                Boolean pushagreement = Boolean.parseBoolean(tokens.nextToken(" "));
                double averagescore = Double.parseDouble(tokens.nextToken(" "));
                String userstate = tokens.nextToken(" ");
                int tranCnt = Integer.parseInt(tokens.nextToken(" "));

                if(userstate.equals("������")) {
                    Supplier sp = new Supplier(name,id,password,contact,occupation,preferredarea,pushagreement,averagescore,userstate,tranCnt);
                    //  suppliers.add(sp);
                    members.add(sp);
                } else {
                    Consumer cs = new Consumer(name,id,password,contact,occupation,preferredarea,pushagreement,averagescore,userstate,tranCnt);
                    //consumers.add(cs);
                    members.add(cs);
                }
            }

            sc.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void load_Board(){
        try{
        	
            File file = new File(fileName_board);
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine())
            {            
                String data = sc.nextLine();
                StringTokenizer tokens = new StringTokenizer(data);
                System.out.println(data);
                
                String answer = tokens.nextToken(" ");
                int boardCode = Integer.parseInt(tokens.nextToken(" "));
                String title = tokens.nextToken(" ");
                String id_writer = tokens.nextToken(" ");
        		String WriterDate = tokens.nextToken(" ");
                Boolean goPublic = Boolean.parseBoolean(tokens.nextToken(" "));
                String head = tokens.nextToken("|");
                String contents = tokens.nextToken("|");
                
            }

            sc.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void load_Rooms(){
        try{
            File file = new File(fileName_room);
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine())
            {
                //User temp_user = new User();
                String data = sc.nextLine();
                StringTokenizer tokens = new StringTokenizer(data);


                roomcode = Integer.parseInt(tokens.nextToken(" "));
                //String name = tokens.nextToken(" ");
                String id = tokens.nextToken(" ");
                String contacthome = tokens.nextToken(" ");
                int price  = Integer.parseInt(tokens.nextToken(" "));
                String uploaddate = tokens.nextToken(" ");
                String startdate = tokens.nextToken(" ");
                String terminatedate = tokens.nextToken(" ");
                String location = tokens.nextToken(" ");
                String option = tokens.nextToken(" ");
                Boolean tstate = Boolean.parseBoolean(tokens.nextToken(" "));
                String roomstruct = tokens.nextToken(" ");

                Room room = new Room(roomcode,contacthome,price,uploaddate,startdate,terminatedate,location,option,tstate,roomstruct,
                        null);

                rooms.add(room);

            }

            sc.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }





    public void Main_Menu() throws IOException {
        Scanner sc = new Scanner(System.in);


        while(true) {
            System.out.println("�޴��� �������ּ���.");
            System.out.println("0. ������ ���");
            System.out.println("1. �α���");
            System.out.println("2. ȸ�� ����");
            System.out.println("3. ����");
            System.out.print("��ȣ�Է�> ");
            int i = sc.nextInt();
            switch (i) {
                case 0:
                    manager.Login();
                    break;
                case 1:
                    user = Login();
                    if (user.getUserState().equals("������"))
                        Provider_Menu();
                    else
                        Consumer_Menu();
                    break;
                case 2:
                    registerMembers();
                    break;
                case 3:
                    sc.close();
                    System_Exit();
            }
        }


    }

    public void Consumer_Menu() {

        Scanner sc = new Scanner(System.in);

        System.out.println("�Һ��� �޴� ȭ��");
        System.out.println("�޴��� �������ּ���.");
        System.out.println("1. �� �˻��ϱ�");
        System.out.println("2. ���������� �����ϱ�");
        System.out.println("3. ���� �Ҹ� �̿��ϱ�");
        System.out.println("4. �����ϱ�");

        int i = sc.nextInt();

        switch (i){
            case 0 :
                break;
            case 1 :
                break;
            case 2 :
                enterConsumerPage();   //���������� ����
                break;
            case 3 :
                enterBoard();   //�Խ��� ����
                break;
            case 4 :
                sc.close();
                System_Exit();
        }


    }




    public void Provider_Menu() throws IOException {
        SearchingFilter temp;
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("������ �޴� ȭ��");
            System.out.println("�޴��� �������ּ���.");
            System.out.println("0. �� ����ϱ�");
            System.out.println("1. �� �˻��ϱ�");
            System.out.println("2. ���������� �����ϱ�");
            System.out.println("3. ���� �Ҹ� �̿��ϱ�");
            System.out.println("4. �����ϱ�");

            int i = sc.nextInt();

            switch (i) {
                case 0:
                    supplier.roomUpdate();
                    break;
                case 1:
                	//X
                    break;
                case 2:
                    enterSupplierPage();
                    break;
                case 3:
                    enterBoard();
                    break;
                case 4:
                    sc.close();
                    System_Exit();
            }

        }


    }

    public void enterBoard(){
        
        System.out.println("*************");
        System.out.println("1. �Խñ� �ۼ�");
        System.out.println("2. �Խñ� ��ȸ");
        System.out.println("*************");

        Scanner keyboard = new Scanner(System.in);
        System.out.print("��ȣ �Է�> ");
        int option = keyboard.nextInt();
        if(option == 1){
            System.out.println("1. �Ű�   2. ����   3. ����");
            System.out.print("��ȣ�Է�> ");
           option = keyboard.nextInt();
           switch(option){
           case 1:
              Report report = new Report();
              report.writePost();
              break;
           case 2:
              Inquiry inquiry = new Inquiry();
              inquiry.writePost();
              break;
           case 3:
              Suggestion suggestion = new Suggestion();
              suggestion.writePost();
              break;
           }
        }
        else if(option == 2){
           //�Խñ� ��ȸ
           
           //��ȸ�ϸ�� �۹�ȣ�� ������ ���� ��´�.
           for(int i = 0; i < boardList.size(); i++ ){
              Board b = boardList.get(i);
              System.out.printf("%d %s %s %s\n", 
                    b.getBoardCode(), b.getTitle(), b.getId_writer(), b.getWriteDate().toString());
              
              //Ȥ�� toString�ȵǸ�
              /*
               * DateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
               * Date nowDate = new Date();
               * String tempDate = sdFormat.format(nowDate);
               * */

           }
           
          
          System.out.print("��ȸ�� ��ȣ�Է�> ");
          int code = keyboard.nextInt();
          
           for(int i = 0; i < boardList.size(); i++ ){
              Board b = boardList.get(i);
              if(b.getBoardCode() == code){
                  if(b.isGoPublic()==false && b.getId_writer()!=user.getId()){
                	  System.out.println("����� �Խñ��Դϴ�.");
                	  break;
                  }
                 System.out.println("***************************************");
                 System.out.printf("�Խñ۹�ȣ: %d\n ����: %s\n �ۼ���: %s\n �ۼ��Ͻ�: %s\n", 
                        b.getBoardCode(), b.getTitle(), b.getId_writer(), b.getWriteDate().toString());
                 System.out.printf("����: \n%s\n", b.getContents());
                 System.out.println("***************************************");
                 
                 break;
              }

           }
        }
        else{
           System.out.println("�߸��� ��ȣ�� �Է��ϼ̽��ϴ�.");
        }
        
     }

    public User Login() {
        Scanner sc = new Scanner(System.in);
//        Demo demo = new Demo();
        Boolean flag;
        String id;
        String password;

        System.out.println("�� �־��!\n�α���");
        do {

            flag = false;
            System.out.print("���̵� : ");
            id = sc.nextLine();
            System.out.print("��й�ȣ : ");
            password = sc.nextLine();

            for(int i =0; i<members.size();i++)
            {
                if(id.equals(members.get(i).getId()))
                {
                    if(password.equals(members.get(i).getPassword()))
                    {
                        flag = true;
                        System.out.println("���ӵǾ����ϴ�.");
                        if(members.get(i).getUserState().equals("������")) {
                            supplier = new Supplier(members.get(i));
                            return supplier;
                        } else {
                            consumer = new Consumer(members.get(i));
                            return consumer;
                        }
                    }
                    else {
                        System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�!");
                        System.out.println("��� ��ȣ�� ���̵� �ٽ� �Է����ּ���!");
                        break;
                    }
                }
            }


        } while(!flag);

        return null;
    }

    public void registerMembers() {
 //       Demo demo = new Demo();
        //ArrayList<User> members = demo.getMembers();
        String pw_check;
        Boolean flag;
        String id;
        Scanner sc = new Scanner(System.in);

        System.out.println("�� �־��!\n ȸ������");
        System.out.print("�Ǹ� : ");
        String name = sc.nextLine();

        do {
            System.out.print("���̵� : ");
            id = sc.nextLine();

            flag=true;

            for(int i=0;i<members.size();i++)
            {
                if(id.equals(members.get(i).getId())) {
                    System.out.println("���̵� �ߺ�. �ٽ� �Է����ּ���!");
                    flag = false;
                    break;
                }
            }

        } while(!flag);
        System.out.println("�ߺ��� ���̵� �����ϴ�. ���� ��ϵǾ����ϴ�.");
        System.out.print("��й�ȣ : ");
        String password = sc.nextLine();
        do {
            System.out.print("��й�ȣ ��Ȯ�� : ");
            pw_check = sc.nextLine();
            if(password.equals(pw_check))
                System.out.println("��й�ȣ�� ��ġ�մϴ�");
            else
                System.out.println("��й�ȣ�� �ٸ��ϴ�. �ٽ� �Էº�Ź�帳�ϴ�.");
        } while(!password.equals(pw_check));
        System.out.print("�޴���ȭ��ȣ : ");
        String contact = sc.nextLine();
        System.out.println("����\n 1. �л� 2. ������ 3. ��Ÿ");
        int occupation = sc.nextInt();
        sc.nextLine();
        System.out.println("��ȣ���� ���� (�Ϲ� / ���� / ���� / ���� / �����幮 / ��ũ�빮 / ���幮 / �ַι� / ������ / �ʹ�)");
        String preferredarea = sc.nextLine();
        System.out.println("Ǫ�� �˸� ����? (O/X)");
        String check = sc.nextLine();
        Boolean pushagreement;
        if(check.equals("O"))
            pushagreement = true;
        else
            pushagreement = false;
        double averagescore = 5.0;
        System.out.print("���� : ������/������ ");
        //sc.nextLine();
        String userstate = sc.nextLine();

        if(userstate.equals("������")) {
            Supplier sp = new Supplier(name,id,password,contact,occupation,preferredarea,pushagreement,averagescore,userstate, 0);
            members.add(sp);
        } else {
            Consumer cs = new Consumer(name,id,password,contact,occupation,preferredarea,pushagreement,averagescore,userstate, 0);
            members.add(cs);
        }

    }

    public void enterConsumerPage(){
    	
    	System.out.println("*****************");
        System.out.println("������ ����������");
        System.out.println("�ɼ��� �������ּ���.");
        System.out.println("0. ��������");
        System.out.println("1. ���ɹ� ����");
        System.out.println("2. Ż��");
        System.out.println("3. �ŷ�����");
        System.out.println("4. �� �Խñ� ����");
    	System.out.println("*****************");
    	
    	Scanner keyboard = new Scanner(System.in);
    	int option = keyboard.nextInt();
    	switch(option){
    	case 0: 
    		selectEditOpt();
    		break;
    	case 1: 
    		
    		break;
    	case 2: 
    		
    		break;
    	case 3:
    		
    		break;
    	case 4:
    		//���� �� �Խñ� ����
    		manageMyBoard();
    		break;
    	default: 
    		break;
    	}
    	
    }
    

    public void enterSupplierPage(){

    	System.out.println("*****************");
        System.out.println("������ ����������");
        System.out.println("�ɼ��� �������ּ���.");
        System.out.println("0. ��������");
        System.out.println("1. �� ���");
        System.out.println("2. ���� �� ���");
        System.out.println("3. �ŷ� ����");
        System.out.println("4. �� �Խñ� ����");
    	System.out.println("*****************");
    	
    	Scanner keyboard = new Scanner(System.in);
    	int option = keyboard.nextInt();
    	switch(option){
    	case 0: 
    		selectEditOpt();
    		break;
    	case 1: 
    		
    		break;
    	case 2: 
    		
    		break;
    	case 3:
    		
    		break;
    	case 4:
    		//���� �� �Խñ� ����
    		manageMyBoard();
    		break;
    	default: 
    		break;
    	}
    }
    
    public void manageMyBoard(){//���� �ۼ��� �Խñ� ����
    	System.out.println("*********************");
    	System.out.println("0. �Խñ� ��ȸ");
    	System.out.println("1. �Խñ� ����");
    	System.out.println("2. �Խñ� ����");
    	System.out.println("*********************");
    	
    	Scanner keyboard = new Scanner(System.in);
    	int option = keyboard.nextInt();
    	switch(option){
    	case 0:
    		user.lookForBoard();
    		break;
    	case 1:
    		user.editMyBoard();
    		break;
    	case 2:
    		user.deleteMyBoard();
    		break;
  		default:
    			System.out.println("�߸������̽��ϴ�.");
    			break;
    	}
    }
    
    public void selectEditOpt(){

        System.out.println("********************");
        System.out.println("0. ��й�ȣ");
        System.out.println("1. ����ó");
        System.out.println("2. ����");
        System.out.println("3. ������ġ");
        System.out.println("4. �˸����ŵ��ǿ���");
        System.out.println("********************");

        Scanner keyboard = new Scanner(System.in);
        System.out.print("�ɼ��Է�> ");
        int option = keyboard.nextInt();
        keyboard.nextLine();
        switch(option){
            case 0:
                System.out.print("�� ��й�ȣ> ");
                String passwd = keyboard.nextLine();
                user.editPasswd(passwd);
                break;
            case 1:
                System.out.print("�� ����ó> ");
                String contact = keyboard.nextLine();
                user.editContact(contact);
                break;
            case 2:
                System.out.println("\n1. �л� 2. ������ 3. ��Ÿ");
                System.out.println("��ȣ�Է�> ");
                int job = keyboard.nextInt();
                user.editOccupation(job);
                break;
            case 3:
                System.out.println("��ȣ���� ���� (�Ϲ� / ���� / ���� / ���� / �����幮 / ��ũ�빮 / ���幮 / �ַι� / ������ / �ʹ�)");
                System.out.println("���� �Է�> ");
                String PreferredArea = keyboard.nextLine();
                user.editPreferredArea(PreferredArea);
                break;
            case 4:
                System.out.print("(true / false)> ");
                Boolean pAgreement = keyboard.nextBoolean();
                user.editPushAgreement(pAgreement);
                break;
            default:
                System.out.println("�߸� �����̽��ϴ�");
                break;
        }
    }

    public void System_Exit()
    {
        File file = new File(fileName_mem);

        try {
            FileWriter fw = new FileWriter(file);

            for(User for_user:members){
                String data = for_user.getName()+ " " + for_user.getId()+ " " + for_user.getPassword() + " " +
                        for_user.getContact() + " " + for_user.getOccupation() + " " + for_user.getPreferredArea() + " " +
                        for_user.getPushAgreement() +" "+ for_user.getAverageScore() + " " + for_user.getUserState()+"\n";
                fw.write(data);
                fw.flush();
            }
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        System.exit(0);
    }


    //////////////Getter, Setter ////////////////////////////
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void setConsumers(Consumer consumers) {
        this.consumer = consumers;
    }

    public static ArrayList<User> getMembers() {
        return members;
    }

    public static void setMembers(ArrayList<User> members) {
        Demo.members = members;
    }

    public static ArrayList<Room> getRooms() {
        return rooms;
    }

    public static void setRooms(ArrayList<Room> rooms) {
        Demo.rooms = rooms;
    }

    public static int getRoomcode() {
        return roomcode;
    }

    public static void setRoomcode(int roomcode) {
        Demo.roomcode = roomcode;
    }

	public ArrayList<Board> getBoardList() {
		return boardList;
	}
	
	public static void setBoardList(ArrayList<Board> boardList){
		Demo.boardList = boardList;
	}
}