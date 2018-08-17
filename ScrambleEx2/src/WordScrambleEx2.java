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
				String myAnswer = s.next().toUpperCase(); // 소문자로 입력시 대문자로 변경

				if (myAnswer.equals("q") || myAnswer.equals("Q")) {
					System.out.println("프로그램이 종료되었습니다.");
					onAir = false; // q,Q 입력시 첫번째 while문 탈출
					break;
				} else if (myAnswer.equals(answer)) {
					System.out.println("정답입니다.");
					break;
				} else {
					System.out.println(myAnswer + "는 정답이 아닙니다. 다시 입력해주세요");
					continue;
				}
			} // 두번째 while문
			continue;
		} // 첫번째 while문
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
