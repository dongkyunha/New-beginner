
public class Fightertest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fighter f = new Fighter();
		
		if(f instanceof Unit) {
			System.out.println("f�� UnitŬ������ �ڼ��Դϴ�.");
		}
		if(f instanceof Fightable) {
			System.out.println("f�� Fightable�������̽��� �����Ͽ����ϴ�.");
		}
		if(f instanceof Movable) {
			System.out.println("f�� Movable�������̽��� �����Ͽ����ϴ�.");
		}
		if(f instanceof Attackable) {
			System.out.println("f�� Attackable�������̽��� �����Ͽ����ϴ�.");
		}
		if(f instanceof Object) {
			System.out.println("f�� ObjectŬ������ �ڼ��Դϴ�.");
		}
	}

}

class Fighter extends Unit implements Fightable{
	public void move(int x,int y) {
		
	}
	public void attack(Unit u) {
		
	}
}

class Unit {
	int currentHP;
	int x;
	int y;
}

interface Fightable extends Movable, Attackable {
}

interface Movable {
	void move(int x,int y);
}

interface Attackable {
	void attack(Unit u);
}
