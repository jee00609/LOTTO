/*
 �̹� ���� �ζ� ��÷��ȣ ����
�ζ� 5���� ���� //1�� 1000��
��ȣ�� 6��
2�� ���� ��
3�� 5000��
4�� 5����
5�� 50����
6�� 500����

1,2,3,4,5 ��° ��÷�ݾ׵��� ���� ��Ÿ����
5���� �� �ݾ� ��Ÿ����
*/

import java.util.Scanner;

public class LOTTO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		int [][] ticket = new int[5][6]; //�ζ� Ƽ�� ���� �� 5���� �� ���̴�.
		int [] jackpot = new int [6];//��÷ ��ȣ
		int [] price = {0,0,0,0,0}; // �ζ� ��÷ ��
		int [] dollar = {0,0,0,0,0};//�ζ� �� �ݾ�
		int allprice=0;//�� Ƽ�� ����
		int i=0;//�ݺ��� �����ִ� ����
		int j=0;//�ݺ����� �����ִ� ����2
		int k=0;//�ݺ����� �����ִ� ����3
		
		///////////////////////////////////////////////////
		/*�ζ� Ƽ�� 5���� �Է�*/
		
		System.out.println("�� ������ ���,������ ��Ρ����� LOTTO ��XXXȸ\n");
		System.out.println("�ζ� Ƽ���� �� 5�� �����ϼ̽��ϴ�.\n");
		
		for(i=0;i<5;i++)
		{
			System.out.printf("%d��° �ζ� Ƽ���� ��ȣ�� �����ּ���(1~45) :",i+1);
			
			for(j=0;j<6;j++)
			{
				ticket[i][j] = in.nextInt();
			}
		}
		
		/////////////////////////////////////////////
		/*��÷ Ƽ���� ���� �ֱ�*/
		
		for(i=0; i<jackpot.length; i++)//��÷ ���ڸ� �����Լ��� �����߽��ϴ�.
		{

			jackpot[i] = (int)(Math.random()*45)+1;
		
		}
		
		i=jackpot.length-1;// �̷��� ������ ���ϸ� j���� ������ ������ϴ�.
		
		for(j=i-1; j>=0; j--)
		{

			if(jackpot[i] ==jackpot[j])
			{

				i--;
				break;

			}  // �ߺ� �� ����

		}
		
		////////////////////////////////////////////////
		/*�� �ζ�Ƽ�ϵ��� ��÷���ڿ� ��*/
		
		for(i=0;i<5;i++)//�� Ƽ��(5��)
		{
			for(j=0;j<6;j++)//Ƽ�Ͽ� �����ִ� ����(6��)
			{
				for(k=0;k<6;k++)//��÷����(6��)
				{
					if(ticket[i][j]==jackpot[k])//Ƽ�ϰ� ��÷���ڰ� ������ price[i]���� �ø��ϴ�.(�ּ� 0 �ִ� 6)
					{
						price[i]++;
					}
					
				}
				
			}
			
		}
		
		/////////////////////////////////////////////////
		/*Ƽ�� ��÷ �� ��� ����*/
		for(i=0;i<5;i++)
		{
			if((price[i]==0)||(price[i]==1)||(price[i]==2))
			{
				dollar[i]=0;
			}
			
			if(price[i]==3)
			{
				dollar[i]=5000;
			}
			
			if(price[i]==4)
			{
				dollar[i]=50000;
			}
			if(price[i]==5)
			{
				dollar[i]=500000;
			}
			if(price[i]==6)
			{
				dollar[i]=5000000;
			}
	
			
		}
		///////////////////////////////////////////////
		/*Ƽ�� 5�忡 ���� �Ѿ��� ���*/
		
		for(i=0;i<5;i++)
		{
			allprice+=dollar[i];
		}
		
		///////////////////////////////////////////////
		/*�����Ʈ*/
		
		System.out.println("\n �������� ���,������ ��Ρ����� LOTTO ��XXXȸ\n�ζ� Ƽ���� �� 5�� �����ϼ̽��ϴ�.(1��� 1000���Դϴ�.)\n");
		System.out.println("��÷ ��ȣ��\t");
		for(i=0;i<6;i++)
		{
			System.out.printf("%d\t",jackpot[i]);
		}
		System.out.println("�Դϴ�.\n");
		
		
		for(i=0;i<5;i++)
		{
			System.out.printf("%d��° �ζ� Ƽ���� �� %d���� ���߼̽��ϴ�.\n",i+1,price[i]);
			System.out.printf("���� %d��° �ζ� Ƽ���� �Ѱ����� %d�� �Դϴ�.\n",i+1,dollar[i]);
			System.out.printf("���� %d��° �ζ� Ƽ���� �������� %d�� �Դϴ�.\n\n",i+1,dollar[i]-1000);
		}
		
		System.out.printf("�� 5�� ������ �ζ��� �Ѱ����� %d�� �Դϴ�.\n",allprice-5000);

		

	}

}