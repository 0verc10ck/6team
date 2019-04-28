package MAIN.MANAGEMENT.BOARD;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import MAIN.MANAGEMENT.Answer;
import MAIN.TRANSACTION.USER.User;

public class Board {

	private Answer answer;
	private int boardCode;
    private String title;
    private String id_writer;
    private Date writeDate;
    private String contents;
    private boolean goPublic;
    private String head;
    
    private User user;
    
    public Board() {
    	setBoardCode(0);
    	setTitle("");
    	setId_writer("");
    	setWriteDate(null);
    	setContents("");
    	setGoPublic(true);
    	setHead("����");
    	
    	answer = null;
    }


    public void writePost(){
    	
    	Scanner keyboard = new Scanner(System.in);

		System.out.print("����: ");
		setTitle(keyboard.nextLine());
		
		System.out.println("�����Է�(Enter������):");
		setContents(keyboard.nextLine());
    	
		System.out.print("�������μ���(O/X) : ");
		String P = keyboard.nextLine();
		if(P.equals("X"))
			setGoPublic(false);
		else
			setGoPublic(true);
    	
    }
    
    //�亯 ã�Ƽ� ���
    public void lookForAnswer() throws IOException
    {
        int code, ocode;
        String temp;

        Scanner in = new Scanner(System.in);
        Scanner Afile = null;

        try
        {
            Afile = new Scanner(new FileInputStream("answer.txt"));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File Not Found");
            System.exit(0);
        }

        System.out.println("����� ������� �Խñ� ��ȣ�� �Է��ϼ��� > ");
        ocode = in.nextInt(); //ã�� �Խñ� ��ȣ

        while(Afile.hasNext())
        {
            code = Afile.nextInt(); //�Խñ۹�ȣ ��¥ �亯 ������ ���Ͽ� �����
            if(code == ocode)
            {
                System.out.println("�Խñ� ��ȣ	: " + code);
                System.out.println("�Խ� ��¥	: " + Afile.nextLine());
                System.out.println("�亯");
                System.out.println(Afile.nextLine());
                return;
            }
            temp = Afile.nextLine();
            temp = Afile.nextLine();
        }
        System.out.println("�ش� �Խñۿ� �亯�� �����ϴ�");

        return;

    }

    public void editPost(){

    }

    public void deletePost(){

    }
    
	public int getBoardCode() {
		return boardCode;
	}
	public String getTitle() {
		return title;
	}
	public String getId_writer() {
		return id_writer;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public String getContents() {
		return contents;
	}
	public boolean isGoPublic() {
		return goPublic;
	}
	public String getHead() {
		return head;
	}
    public void setBoardCode(int boardCode) {
		this.boardCode = boardCode;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setId_writer(String id_writer) {
		this.id_writer = id_writer;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public void setGoPublic(boolean goPublic) {
		this.goPublic = goPublic;
	}
	public void setHead(String head) {
		this.head = head;
	}
    
}