package MAIN.TRANSACTION;

import java.util.Scanner;

public class HouseHolder {
    private String contact;

    public HouseHolder(String contact) {
        this.contact = contact;
    }
    //method

    public Boolean requestPermit(){
        Scanner sc = new Scanner(System.in);

        String answer;
        System.out.println("************************************");
        System.out.println("���� '4��8�� �汸�ϱ�' �ý��ۿ� ��ϵǾ����ϴ�");
        System.out.println("����� �㰡 �Ͻðڽ��ϱ� (����/����) ?");
        answer = sc.nextLine();
        System.out.println("************************************");
        if (answer.equals("����"))
            return true;
        else
            return false;
    }
}