class outer{
	class inner{
		int iv=100;
	}
	static class Staticinner{
		int iv=300;
		static int cv = 400;
	}
	void myMethod() {
		class LocalInner {
			int iv = 200;
		}
	}
}


public class Exercise10_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//outer Ŭ������ ����Ŭ���� inner�� ������� ����ϱ�
		outer vv = new outer();
		outer.inner Iv = vv.new inner();
		System.out.println("Iv.iv : " + Iv.iv); //outer.inner �� 100
		//��ƴ�
		
		vv.myMethod(); //????
		
		outer.Staticinner si = new outer.Staticinner();
		System.out.println("si.iv : " + si.iv); // outer.Staticinner �� : 300
		
		System.out.println("si.cv : " + si.cv); //�ǳ�
	}

}
