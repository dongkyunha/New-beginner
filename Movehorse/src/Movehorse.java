public class Movehorse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] horse = new String[5][100];
		
		
		horse[0][0]="*";
		horse[1][0]="££";
		horse[2][0]="£À";
		horse[3][0]="¡Ý";
		horse[4][0]="¢¾";
		
		for (int i = 0; i < 5; i++) {
			System.out.print(horse[i][0]);
			for(int j=1; j<100;j++) {
				horse[i][j] = " ";
				System.out.print(horse[i][j]);
			}
			System.out.println();
		}
		for (int i = 0; i < horse.length; i++) {
			int idx = ((int)(Math.random() * 5))+1;

			String tmp = horse[1][i];
			horse[1][i] = horse[1][idx];
			horse[1][idx] = tmp;
			
			idx = ((int)(Math.random() * 5))+1;
			
			tmp = horse[2][i];
			horse[2][i] = horse[2][idx];
			horse[2][idx] = tmp;
			
			idx = ((int)(Math.random() * 5))+1;
			
			tmp = horse[3][i];
			horse[3][i] = horse[3][idx];
			horse[3][idx] = tmp;
			
			idx = ((int)(Math.random() * 5))+1;
			
			tmp = horse[4][i];
			horse[4][i] = horse[4][idx];
			horse[4][idx] = tmp;

		}
	}

}
