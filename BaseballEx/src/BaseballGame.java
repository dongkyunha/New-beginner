import java.io.*;

public class BaseballGame {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int con = 1; // ��������� ��� �Ҳ����� ���.
		do {

			int zero, num; // zero �� 0�� �ְ� �Ҳ��� ���� �Ҳ���, num �� ���ڸ����� �Ҳ���...
			int counter = 0; // �� �Է��� ī����... ���°����...

			InputStreamReader ii = new InputStreamReader(System.in);
			BufferedReader wi = new BufferedReader(ii);

			System.out.println();
			System.out.println("\t�� ���ڸ��߱� �߱����� v1.0 ( by Dorichun ) ��");
			System.out.println("\t==============================================");
			System.out.println();

			System.out.print("'0'�� �ְ� �ҷ�.. ���� �ҷ�..( 1, �ְ� �Ѵ�  2, ���� �Ѵ� ).....? ");

			try { // �Է��� ���� ��� �߻��� ����ó��

				zero = Integer.parseInt(wi.readLine());

				if (zero == 1 || zero == 2) // ���� ����� ������ �����ϰ�...
				{
					if (zero == 1) // 0�� �ְ� �Ѵٸ�...
					{
						System.out.print("���ڸ��� �Ҳ��� ( �ּ� 3�ڸ����� �ִ� 10�ڸ� ).... ? ");
						num = Integer.parseInt(wi.readLine());
						while (num < 3 || num > 10) {
							System.out.print("�峭 ���� �ٽ� �Է��� !!! ");
							num = Integer.parseInt(wi.readLine());
						}
					} else // 0�� ���� �Ѵٸ�...
					{
						System.out.print("���ڸ��� �Ҳ��� ( �ּ� 3�ڸ����� �ִ� 9�ڸ� ).... ? ");
						num = Integer.parseInt(wi.readLine());
						while (num < 3 || num > 9) {
							System.out.print("�峭 ���� �ٽ� �Է��� !!! ");
							num = Integer.parseInt(wi.readLine());
						}
					}

					BBArray ba = new BBArray(zero, num); // ������ ������ �迭 �ʱ�ȭ
					int[] number = new int[num]; // �Է¹��� ���� ������ �迭
					while (BBArray.strike != num) {
						counter++; // �� �Է� ī����
						System.out.print(counter + " ��° ���� �Է� : ");
						String s = wi.readLine();
						if (s.length() != num) // �Է¹��� ���� ������ ���ų� ���ٸ�
						{
							System.out.println("�߸� �Է��ߴ�. �ٽ� �Է��ض�");
							counter--; // �Է��� �߸��Ǹ� ī���͸� �ǵ�����.
						} else // �Է¹��� ������ ������...
						{
							int doubleNum = 0; // �ߺ��� ���� üũ �ϱ� ���� ����
							for (int i = 1; i < num; i++) // �ߺ��� �� üũ
							{
								for (int j = 0; j < i; j++) {
									if (Integer.parseInt(s.substring(i, i + 1)) == Integer
											.parseInt(s.substring(j, j + 1))) {
										doubleNum++;
									}
								}
							}

							if (doubleNum == 0) // ���� �ߺ����� ������...
							{
								for (int i = 0; i < num; i++) {
									number[i] = Integer.parseInt(s.substring(i, i + 1)); // i ��° ���� �迭�� ����
								}
								ba.checkNum(number, num); // �迭���� �� ������ �Ѱ��ְ� üũ��
							} else // �ߺ��Ǿ�����...
							{
								System.out.println("�Ȱ������� �ߺ��Ǿ���. �ٽ� �Է��ض�");
								counter--;
							}
						}

					} // end while ( strike != num )

					System.out.println("\n\t������ ��~ " + counter + "������ ���� ������");
					System.out.print("\n\t��� �Ҳ��� (1. ���	2. �׸� ) ? : ");
					con = Integer.parseInt(wi.readLine()); // ���(1)? �׸�?

				} else // ���͸� ���� ������ ���д�.
				{
					System.out.println("\t\t >>> �峭 ġ��? ������ !!! <<<");
					con = 2; // �峭ġ�� �� ���Ѵ�.
				}

			} catch (NumberFormatException e) // �Է°��� �߸��Ǹ� ���޽��� ���� �ٽ� �Է¹޴´�
			{
				System.out.println("\n\t######## ���� �Էµ��� �ʾҽ��ϴ� ########");
//				e.printStackTrace();		//
			}
		} while (con == 1);
	} // end main()
}

//BBArray class

class BBArray {
	private int myArray[];

	public static int strike = 0, ball = 0;

//---	������
	public BBArray(int zero, int num) {
		strike = 0; // �������� �� ��� �� ���� ���� �����Ƿ� �������� �ʱ�ȭ
		myArray = new int[num];
		myArray[0] = (int) (Math.random() * 9) + 1; // ù��° �ڸ����� 1~9

		for (int i = 1; i < num; i++) // �ι�° �ڸ����� ������ �ڸ�������...
		{
			if (zero == 1) // 0�� �ְ� �� ���
			{
				myArray[i] = (int) (Math.random() * 10); // 0~9 ������ ��
				int j = 0;
				while (j < i) // i ��° ���� �̹� ���� �� ������ �˻�
				{
					if (myArray[i] == myArray[j]) // i ��° ���� �̹̳��� �����..
					{
						myArray[i] = (int) (Math.random() * 10); // �ٽ� ���� �����ϰ�
						j = 0; // �˻縦 �ٽ� �ؾ� �ϱ� ������ j ���� �ʱ�ȭ �Ѵ�.
					} else
						j++; // ���� �迭�� �˻��Ѵ�.
				} // end while ( j < i )

			} else // 0�� ���� �� ���
			{
				myArray[i] = (int) (Math.random() * 9) + 1; // 1~9 ������ ��
				int j = 0;
				while (j < i) // i ��° ���� �̹� ���� �� ������ �˻�
				{
					if (myArray[i] == myArray[j]) // i ��° ���� �̹̳��� �����..
					{
						myArray[i] = (int) (Math.random() * 9) + 1;
						j = 0;
					} else
						j++;
				} // end while ( j < i )
			} // end if ( zero ??? )
		} // end for
	} // end ������

	public void checkNum(int[] number, int num) // �Է°��� ��
	{
		strike = 0; // �������̹Ƿ� ���� ����� ���� �ʱ�ȭ
		ball = 0;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (i == j && myArray[i] == number[j]) // �ڸ����� ���ڰ� ������
				{
					strike++;
				} else if (i != j && myArray[i] == number[j]) // �ڸ����� Ʋ���� ���ڰ� ������
				{
					ball++;
				}
			}
		}
		System.out.println("Strike : " + strike + "\tBall : " + ball);
	} // end checkNum()
} // end BBArray class