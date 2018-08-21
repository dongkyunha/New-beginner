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
			//outer 클래스의 내부클래스 inner의 멤버변수 출력하기
		outer vv = new outer();
		outer.inner Iv = vv.new inner();
		System.out.println("Iv.iv : " + Iv.iv); //outer.inner 값 100
		//어렵다
		
		vv.myMethod(); //????
		
		outer.Staticinner si = new outer.Staticinner();
		System.out.println("si.iv : " + si.iv); // outer.Staticinner 값 : 300
		
		System.out.println("si.cv : " + si.cv); //되네
	}

}
