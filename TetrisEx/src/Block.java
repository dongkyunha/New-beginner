//블록 클래스

class Block
{
	private int x;
	private int y;
	
	// 생성자
	public Block() {
	}
	public Block(int x, int y)
	{
		this.x = x;
		this.y = y;
		
	}
	// 해당 포인트맛큼 감산
	public void move(int xPlus, int yPlus)
	{
		this.x += xPlus;
		this.y += yPlus;
	}
	
	// X포인트 반환
	public int getX()
	{
		return this.x;
	}
	
	// Y포인트 반환
	public int getY()
	{
		return this.y;
	}
	
	// 자신 반환
	public Block getBlock()
	{
		return this;
	}

	// XY셋팅
	public void setXY(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
