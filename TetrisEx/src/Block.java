//��� Ŭ����

class Block
{
	private int x;
	private int y;
	
	// ������
	public Block() {
	}
	public Block(int x, int y)
	{
		this.x = x;
		this.y = y;
		
	}
	// �ش� ����Ʈ��ŭ ����
	public void move(int xPlus, int yPlus)
	{
		this.x += xPlus;
		this.y += yPlus;
	}
	
	// X����Ʈ ��ȯ
	public int getX()
	{
		return this.x;
	}
	
	// Y����Ʈ ��ȯ
	public int getY()
	{
		return this.y;
	}
	
	// �ڽ� ��ȯ
	public Block getBlock()
	{
		return this;
	}

	// XY����
	public void setXY(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
