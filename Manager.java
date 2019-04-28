//package MAIN;
//import MAIN.TRANSACTION.USER.*;
package MAIN.MANAGEMENT;

import java.io.*;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import MAIN.Demo;
import MAIN.TRANSACTION.USER.User;

public class Manager {

    private final String id="admin";
    private final String password="1111";
    public int answer_code = 0;
    Scanner sc = new Scanner(System.in);
    //method
    public void editUserScore(){
    	double Score, sub;
    	String line, repline, token, target_id;
    	boolean flag = false;
    	int tokens, i;
    	
    	String fileName = "MemberList.txt";
    	
    	File inputFile = new File(fileName);
    	File outputFile = new File(fileName+".temp");
    	
    	FileInputStream fileInputStream = null;
    	FileOutputStream fileOutputStream = null;
    	BufferedReader bufferedReader = null;
    	BufferedWriter bufferedWriter = null;
    	
    	try {
    		fileInputStream = new FileInputStream(inputFile);
    		fileOutputStream = new FileOutputStream(outputFile);
    		bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
    		bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
    	
    	User user = new User();	
    	
    	System.out.println("������ ȸ���� ID�� �Է��ϼ��� : ");
    	target_id = sc.nextLine();
    	
    	if((user = offerUserInfo(target_id)) != null)
    	{
	    	Score = user.getAverageScore();
	    	System.out.println("������ ������ �Է��ϼ��� : ");
	    	sub = sc.nextInt();
	    	user.setAverageScore(Score - sub);
	    	
	    	while((line = bufferedReader.readLine()) != null)
	    	{
	    		StringTokenizer st = new StringTokenizer(line," ");
	    		
	    		tokens = st.countTokens();
	    		
	    		for(i=0;i<tokens;i++)
	    		{
	    			token = st.nextToken();
	    			if(i==1 && token == target_id)
	    			{
	    				//continue;
	    				flag = true;
	    				continue;
	    			}
	    			//else break;
	    			
	    			if(i == tokens - 2)
	    			{
	    				//�ٲ� �ٷ� ���
	    				repline = line.replace(String.valueOf(Score), String.valueOf(Score - sub));
	    				
	    				bufferedWriter.write(repline);
	    				bufferedWriter.newLine();
	    			}
	    		}
	    		if(flag == false)
	    		{
	    			//���� �ٷ� ���
	    			bufferedWriter.write(line);
	    			bufferedWriter.newLine();
	    		}
	    		flag = false;
	    		
	    	}
    	}
    	}catch(IOException ex){
    		ex.printStackTrace();
    	}
    	
    	//close
    	try{
    		bufferedReader.close();
    	}catch(IOException ex1){
    		ex1.printStackTrace();
    	}
    	
    	try{
    		bufferedWriter.close();
    	}catch(IOException ex2){
    		ex2.printStackTrace();
    	}
    	
    	//���� ���� ����� �ٲ� ���Ϸ� ��ü
    	inputFile.delete();
    	outputFile.renameTo(new File(fileName));
    	
    }

    public User offerUserInfo(String target_id){
    	Boolean flag = false;
    	int i;
        User user = new User();
        Demo demo = new Demo();
        ArrayList<User> members = demo.getMembers();
        
        String id;
        
        for(i=0;i<members.size();i++)
        {
            if(target_id.equals(members.get(i).getId())) {
                flag = true;
                break;
            }
        }
        if(flag== true)
        {
        	user = members.get(i);
        	return user;
        }
        else
        {
        	System.out.println("�ش� ȸ�� ����, �ٽ� �õ� ���ּ���.");
        	return null;
        }
    }

    public void addToBlackList() throws IOException{ //���Ͽ� user ���� �߰�
    	String FileName = "blacklist.txt";
    	String target_id;
    	String reason;
    	User user = new User();
    	
    	System.out.println("������Ʈ�� �߰��� ȸ���� ID�� �Է��ϼ��� : ");
    	target_id = sc.nextLine();
    	user = offerUserInfo(target_id);
        
    	System.out.println("�� ���� : ");
    	reason = sc.nextLine();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileName, true));
        bufferedWriter.write(user.getId() + "\n" );
        bufferedWriter.write(user.getName() + "\n" );
        bufferedWriter.write(user.getContact() + "\n" );
        bufferedWriter.write( reason + "\n\n" );

        bufferedWriter.close();
    }

    public Answer writeAnswer() throws IOException{
    	String FileName = "answer.txt";
    	Answer a = new Answer();
        
        a.answer_code += 1; //�亯�� ��ȣ
        System.out.println("�亯�� �ۼ� ��¥  (ex.20171214) : ");
        a.date = sc.nextInt();
        sc.nextLine();
        
        System.out.println("���� �亯 �ۼ� : ");
        a.content = sc.nextLine();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileName, true));
        bufferedWriter.write(a.answer_code + "\n" );
        bufferedWriter.write(a.date + "\n" );
        bufferedWriter.write(a.content + "\n" );
        
        bufferedWriter.close();
        
        return a;
    }
    
    public int Login() throws IOException{
        String ID;
        String Password;
        String check;
        //Demo new_demo = new Demo();
        while(true){
            System.out.print("���̵� : ");
            ID = sc.nextLine();
            System.out.print("��й�ȣ : ");
            Password = sc.nextLine();
            if(ID.equals(id)&&Password.equals(password)) {
                System.out.println("������ ���� �����Ͽ����ϴ�.");
                //Manager_Menu();
                return 1;
                //break;
            }
            if(!ID.equals(id)) System.out.println("������ ���̵� Ʋ�Ƚ��ϴ�.");
            else if(!Password.equals(password)) System.out.println("������ ��� ��ȣ�� Ʋ�Ƚ��ϴ�.");
            else if(!ID.equals(id)|| !Password.equals(password))
                System.out.println("������ ���̵�� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
            System.out.println("���Ḧ ���Ͻø� 'q', ��� �α��� �Ͻ÷��� 'c'�� �����ּ��� : ");
            check = sc.nextLine();
            if(check.equals('c')) continue;
            else if(check.equals('q')) break;
        }
        return 0;
    }
    
    public void Manager_Menu() throws IOException
    {
    	Scanner sc = new Scanner(System.in);

        System.out.println("������ �޴� ȭ��");
        System.out.println("�޴��� �������ּ���.");
        System.out.println("1. �Ű� ȸ�� ���� �����ϱ� ");
        System.out.println("2. ������Ʈ �߰��ϱ�");
        System.out.println("3. �亯����");
        System.out.println("4. �����ϱ�");

        int i = sc.nextInt();

        switch (i){
            case 0 :
                break;
            case 1 :
            	//manager.editUserScore();
            	editUserScore();
                break;
            case 2 :
            	//manager.addToBlackList();
            	addToBlackList();
                break;
            case 3 :
            	//manager.writeAnswer();
            	writeAnswer();
                break;
            case 4 :
                sc.close();
                //System_Exit();
        }
    }
}

