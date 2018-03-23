/*
 이번 주의 로또 당첨번호 생성
로또 5장을 구매 //1장 1000원
번호는 6개
2장 이하 꽝
3개 5000원
4개 5만원
5개 50만원
6개 500만원

1,2,3,4,5 번째 당첨금액들을 각각 나타내기
5장의 총 금액 나타내기
*/

import java.util.Scanner;

public class LOTTO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		int [][] ticket = new int[5][6]; //로또 티켓 변수 총 5장을 살 것이다.
		int [] jackpot = new int [6];//당첨 번호
		int [] price = {0,0,0,0,0}; // 로또 당첨 비교
		int [] dollar = {0,0,0,0,0};//로또 각 금액
		int allprice=0;//총 티켓 가격
		int i=0;//반복문 돌려주는 역할
		int j=0;//반복문을 돌려주는 역할2
		int k=0;//반복문을 돌려주는 역할3
		
		///////////////////////////////////////////////////
		/*로또 티켓 5장의 입력*/
		
		System.out.println("「 절반의 행운,절반의 기부」나눔 LOTTO 제XXX회\n");
		System.out.println("로또 티켓을 총 5장 구매하셨습니다.\n");
		
		for(i=0;i<5;i++)
		{
			System.out.printf("%d번째 로또 티켓의 번호를 적어주세요(1~45) :",i+1);
			
			for(j=0;j<6;j++)
			{
				ticket[i][j] = in.nextInt();
			}
		}
		
		/////////////////////////////////////////////
		/*당첨 티켓의 숫자 넣기*/
		
		for(i=0; i<jackpot.length; i++)//당첨 숫자를 랜덤함수로 지정했습니다.
		{

			jackpot[i] = (int)(Math.random()*45)+1;
		
		}
		
		i=jackpot.length-1;// 이렇게 설정을 안하면 j값에 오류가 생겼습니다.
		
		for(j=i-1; j>=0; j--)
		{

			if(jackpot[i] ==jackpot[j])
			{

				i--;
				break;

			}  // 중복 값 제거

		}
		
		////////////////////////////////////////////////
		/*각 로또티켓들을 당첨숫자와 비교*/
		
		for(i=0;i<5;i++)//각 티켓(5장)
		{
			for(j=0;j<6;j++)//티켓에 적혀있는 숫자(6개)
			{
				for(k=0;k<6;k++)//당첨숫자(6개)
				{
					if(ticket[i][j]==jackpot[k])//티켓과 당첨숫자가 같을때 price[i]값을 올립니다.(최소 0 최대 6)
					{
						price[i]++;
					}
					
				}
				
			}
			
		}
		
		/////////////////////////////////////////////////
		/*티켓 당첨 값 통계 내기*/
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
		/*티켓 5장에 대한 총액을 계산*/
		
		for(i=0;i<5;i++)
		{
			allprice+=dollar[i];
		}
		
		///////////////////////////////////////////////
		/*출력파트*/
		
		System.out.println("\n 「절반의 행운,절반의 기부」나눔 LOTTO 제XXX회\n로또 티켓을 총 5장 구매하셨습니다.(1장당 1000원입니다.)\n");
		System.out.println("당첨 번호는\t");
		for(i=0;i<6;i++)
		{
			System.out.printf("%d\t",jackpot[i]);
		}
		System.out.println("입니다.\n");
		
		
		for(i=0;i<5;i++)
		{
			System.out.printf("%d번째 로또 티켓은 총 %d개를 맞추셨습니다.\n",i+1,price[i]);
			System.out.printf("따라서 %d번째 로또 티켓의 총가격은 %d원 입니다.\n",i+1,dollar[i]);
			System.out.printf("따라서 %d번째 로또 티켓의 순이익은 %d원 입니다.\n\n",i+1,dollar[i]-1000);
		}
		
		System.out.printf("총 5장 구매한 로또의 총가격은 %d원 입니다.\n",allprice-5000);

		

	}

}