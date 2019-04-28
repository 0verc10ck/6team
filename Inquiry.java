package MAIN.MANAGEMENT.BOARD;

import java.io.*;
import java.util.*;

public class Inquiry extends Board{

    public Inquiry(){
    	super.setTitle("");
    	super.setId_writer("");
    	super.setWriteDate(null);
    	super.setContents(null);
    	super.setGoPublic(goPublic);
    	super.setHead("");
    	super.setBoardCode(0);
    }

    public Inquiry(String title, String id_writer, 
    		Date writeDate, String contents, 
    		boolean goPublic, String head){
    	
    	super.setTitle(title);
    	super.setId_writer(id_writer);
    	super.setWriteDate(writeDate);
    	super.setContents(contents);
    	super.setGoPublic(goPublic);
    	super.setHead(head);
//    	super.setBoardCode();

    }
    
    public void setInquiry(String id, Date wdate) throws IOException
    {
        int n;
        Inquiry i = new Inquiry();
        Scanner in = new Scanner(System.in);

        i.boardCode += 1;

        System.out.println("�Խñ� ������ �Է��ϼ��� > ");
        i.title = in.nextLine();

        i.id_writer = id;

        i.writeDate = wdate;

        System.out.println("�Խñ� ������ �Է��ϼ��� > ");
        i.contents = in.nextLine();

        System.out.println("�Խñ� �������θ� �Է��ϼ���(1:����, 0: �����) > ");
        i.goPublic = in.nextBoolean();

        i.head = "����";

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("board.txt",true));
        bufferedWriter.write(i.boardCode + "\n");
        bufferedWriter.write(i.title + "\n");
        bufferedWriter.write(i.id_writer + "\n");
        bufferedWriter.write(i.writeDate + "\n");
        bufferedWriter.write(i.contents + "\n");
        bufferedWriter.write(i.goPublic + "\n");
        bufferedWriter.write(i.head + "\n");
		/*
		 �Խñ� ��ȣ / ���� / id / ��¥ / ���� / �������� / ���Ӹ�
		 */
    }



}