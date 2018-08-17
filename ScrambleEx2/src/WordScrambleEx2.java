import java.util.*;

public class WordScrambleEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW", "APPLE", "WATER", "WHITE" };
		boolean onAir = true;
		while (onAir) {
			String answer = getAnswer(strArr);
			String question = getScrambledWord(answer);
			Scanner s = new Scanner(System.in);
			while (true) {
				System.out.println("Question : " + question);
				System.out.print("Your Answer is:");
				String myAnswer = s.next().toUpperCase(); // �ҹ��ڷ� �Է½� �빮�ڷ� ����

				if (myAnswer.equals("q") || myAnswer.equals("Q")) {
					System.out.println("���α׷��� ����Ǿ����ϴ�.");
					onAir = false; // q,Q �Է½� ù��° while�� Ż��
					break;
				} else if (myAnswer.equals(answer)) {
					System.out.println("�����Դϴ�.");
					break;
				} else {
					System.out.println(myAnswer + "�� ������ �ƴմϴ�. �ٽ� �Է����ּ���");
					continue;
				}
			} // �ι�° while��
			continue;
		} // ù��° while��
	}

	public static String getAnswer(String[] strArr) {
		int idx = (int) (Math.random() * strArr.length);
		return strArr[idx];
	}

	public static String getScrambledWord(String str) {
		char[] chArr = str.toCharArray();

		for (int i = 0; i < str.length(); i++) {

			int idx = (int) (Math.random() * str.length());

			char tmp = chArr[i];
			chArr[i] = chArr[idx];
			chArr[idx] = tmp;
		}

		return new String(chArr);
	} // scramble(String str)

}
