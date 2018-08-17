import java.io.*;

public class BaseballGame {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int con = 1; // 게임종료시 계속 할껀지를 물어봄.
		do {

			int zero, num; // zero 는 0을 넣고 할껀지 빼고 할껀지, num 은 몇자리수를 할껀지...
			int counter = 0; // 수 입력을 카운터... 몇번째인지...

			InputStreamReader ii = new InputStreamReader(System.in);
			BufferedReader wi = new BufferedReader(ii);

			System.out.println();
			System.out.println("\t♤ 숫자맞추기 야구게임 v1.0 ( by Dorichun ) ♤");
			System.out.println("\t==============================================");
			System.out.println();

			System.out.print("'0'을 넣고 할래.. 빼고 할래..( 1, 넣고 한다  2, 빼고 한다 ).....? ");

			try { // 입력을 안할 경우 발생할 예외처리

				zero = Integer.parseInt(wi.readLine());

				if (zero == 1 || zero == 2) // 값이 제대로 들어오면 실행하고...
				{
					if (zero == 1) // 0을 넣고 한다면...
					{
						System.out.print("몇자리수 할껀데 ( 최소 3자리에서 최대 10자리 ).... ? ");
						num = Integer.parseInt(wi.readLine());
						while (num < 3 || num > 10) {
							System.out.print("장난 말구 다시 입력해 !!! ");
							num = Integer.parseInt(wi.readLine());
						}
					} else // 0을 빼고 한다면...
					{
						System.out.print("몇자리수 할껀데 ( 최소 3자리에서 최대 9자리 ).... ? ");
						num = Integer.parseInt(wi.readLine());
						while (num < 3 || num > 9) {
							System.out.print("장난 말구 다시 입력해 !!! ");
							num = Integer.parseInt(wi.readLine());
						}
					}

					BBArray ba = new BBArray(zero, num); // 생성자 생성시 배열 초기화
					int[] number = new int[num]; // 입력받은 수를 저장할 배열
					while (BBArray.strike != num) {
						counter++; // 수 입력 카운터
						System.out.print(counter + " 번째 수를 입력 : ");
						String s = wi.readLine();
						if (s.length() != num) // 입력받을 수의 갯수가 많거나 적다면
						{
							System.out.println("잘못 입력했다. 다시 입력해라");
							counter--; // 입력이 잘못되면 카운터를 되돌린다.
						} else // 입력받을 갯수가 맞으면...
						{
							int doubleNum = 0; // 중복된 수를 체크 하기 위한 변수
							for (int i = 1; i < num; i++) // 중복된 수 체크
							{
								for (int j = 0; j < i; j++) {
									if (Integer.parseInt(s.substring(i, i + 1)) == Integer
											.parseInt(s.substring(j, j + 1))) {
										doubleNum++;
									}
								}
							}

							if (doubleNum == 0) // 수가 중복되지 않으면...
							{
								for (int i = 0; i < num; i++) {
									number[i] = Integer.parseInt(s.substring(i, i + 1)); // i 번째 수를 배열에 저장
								}
								ba.checkNum(number, num); // 배열값과 수 갯수를 넘겨주고 체크함
							} else // 중복되었으면...
							{
								System.out.println("똑같은수가 중복되었다. 다시 입력해라");
								counter--;
							}
						}

					} // end while ( strike != num )

					System.out.println("\n\t♡♡♡ 축~ " + counter + "번만에 성공 ♡♡♡");
					System.out.print("\n\t계속 할꺼냐 (1. 계속	2. 그만 ) ? : ");
					con = Integer.parseInt(wi.readLine()); // 계속(1)? 그만?

				} else // 엉터리 값이 들어오면 관둔다.
				{
					System.out.println("\t\t >>> 장난 치냐? 하지마 !!! <<<");
					con = 2; // 장난치면 겜 안한다.
				}

			} catch (NumberFormatException e) // 입력값이 잘못되면 경고메시지 띄우고 다시 입력받는다
			{
				System.out.println("\n\t######## 값이 입력되지 않았습니다 ########");
//				e.printStackTrace();		//
			}
		} while (con == 1);
	} // end main()
}

//BBArray class

class BBArray {
	private int myArray[];

	public static int strike = 0, ball = 0;

//---	생성자
	public BBArray(int zero, int num) {
		strike = 0; // 새게임을 할 경우 그 값이 남아 있으므로 이전값을 초기화
		myArray = new int[num];
		myArray[0] = (int) (Math.random() * 9) + 1; // 첫번째 자리수는 1~9

		for (int i = 1; i < num; i++) // 두번째 자리부터 마지막 자리까지는...
		{
			if (zero == 1) // 0을 넣고 할 경우
			{
				myArray[i] = (int) (Math.random() * 10); // 0~9 사이의 수
				int j = 0;
				while (j < i) // i 번째 수가 이미 나온 수 인지를 검사
				{
					if (myArray[i] == myArray[j]) // i 번째 수가 이미나온 수라면..
					{
						myArray[i] = (int) (Math.random() * 10); // 다시 랜덤 생성하고
						j = 0; // 검사를 다시 해야 하기 때문에 j 값을 초기화 한다.
					} else
						j++; // 다음 배열을 검사한다.
				} // end while ( j < i )

			} else // 0을 빼고 할 경우
			{
				myArray[i] = (int) (Math.random() * 9) + 1; // 1~9 사이의 수
				int j = 0;
				while (j < i) // i 번째 수가 이미 나온 수 인지를 검사
				{
					if (myArray[i] == myArray[j]) // i 번째 수가 이미나온 수라면..
					{
						myArray[i] = (int) (Math.random() * 9) + 1;
						j = 0;
					} else
						j++;
				} // end while ( j < i )
			} // end if ( zero ??? )
		} // end for
	} // end 생성자

	public void checkNum(int[] number, int num) // 입력값을 비교
	{
		strike = 0; // 누적값이므로 새로 사용할 때는 초기화
		ball = 0;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (i == j && myArray[i] == number[j]) // 자리수와 숫자가 같으면
				{
					strike++;
				} else if (i != j && myArray[i] == number[j]) // 자리수는 틀리고 숫자가 같으면
				{
					ball++;
				}
			}
		}
		System.out.println("Strike : " + strike + "\tBall : " + ball);
	} // end checkNum()
} // end BBArray class