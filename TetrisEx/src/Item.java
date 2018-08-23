import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

//������ Ŭ����
public class Item
{
	JPanel[] panel; // �ǳ�
	Block[] block; // ��������Ʈ
	Block[][] block_info; // �� ������ ����Ʈ����
	// ���ǹ迭 0~3 ���� 0-0�� 1-90�� 2-180�� 3-270��
	// ���� �迭�� �ǳ� ����
	Block currentXY;
	int cnt; // ���ǳڰ���
	int angle; // �Ѱ�������
	int current_angle; // ���簢����
	int xCnt; // ���ΰ�
	Color color; // ��
	int area; // ����
	public Item(int area, int angle, int cnt, int xCnt)
	{
		this.angle = angle;
		this.cnt = cnt;
		this.panel = new JPanel[cnt]; // �ǳڰ��� ����
		this.block = new Block[cnt]; // ����Ʈ ����
		this.block_info = new Block[angle][cnt]; // ����Ʈ ����, ��������
		this.area = area;
		this.currentXY = new Block(0, 0); // ���簪
		this.xCnt = xCnt;
		for (int i = 0; i < cnt; i++) // �гλ���
		{
			this.panel[i] = new JPanel();
		}
	}

	public void setDefaultRandom()
	{
		this.current_angle = (int) (Math.random() * this.angle);
		this.block = this.block_info[this.current_angle];
	}

	// �����̳ʿ� ���
	public void setItem(Container c)
	{
		for (int i = 0; i < panel.length; i++)
		{
			panel[i].setBackground(this.color); // ����
			panel[i].setSize(area, area); // ����
			panel[i].setLocation(((block[i].getX()) * area) - 100, ((block[i].getY()) * area) - 100); // �⺻��ġ �Ⱥ��̴°��� ����
			panel[i].setBorder(new SoftBevelBorder(BevelBorder.RAISED));
			c.add(panel[i]); // �����̳ʿ� ���
		}
	}

	// ������ġ����
	public void setNextLocation()
	{
		for (int i = 0; i < panel.length; i++)
		{
			int x = block[i].getX() + (xCnt - 3);
			int y = block[i].getY() + 1;
			panel[i].setLocation(x * area, y * area);
		}
		this.currentXY.setXY((xCnt - 3), 1);
	}

	// ������ġ����
	public void setDefaultLocation()
	{
		for (int i = 0; i < panel.length; i++)
		{
			int x = block[i].getX() + (int) (xCnt / 2 - 2);
			int y = block[i].getY() + 2;
			panel[i].setLocation(x * area, y * area);
		}
		this.currentXY.setXY((int) (xCnt / 2 - 2), 2);
	}

	// ������ ��ġ����
	public void setReadyLocation()
	{
		for (int i = 0; i < panel.length; i++)
		{
			panel[i].setLocation(((block[i].getX()) * area) - 100, ((block[i].getY()) * area) - 100);
		}
	}

	// ������ġ����
	public void setCurrentXY(int x, int y)
	{
		this.currentXY.move(x, y);
	}

	// ������ġ��ȯ
	public Block getCurrentXY()
	{
		return this.currentXY;
	}

	// ���� ����Ʈ ����
	public Block[] getBlock()
	{
		Block[] temp = new Block[cnt];
		for (int i = 0; i < block.length; i++)
		{
			int x = block[i].getX() + this.currentXY.getX();
			int y = block[i].getY() + this.currentXY.getY();
			temp[i] = new Block(x, y);
		}
		return temp;
	}

	// ���������ϰ����� ����Ʈ���� ��ȯ
	public Block[] getNextBlock()
	{
		int nextAngle;
		if (this.angle == 1)
			return getBlock(); // ������1�����̸� ����
		else if (this.angle - 1 == this.current_angle)
			nextAngle = 0; // �������ޱ��̸� 1���ޱ۷�
		else
			nextAngle = this.current_angle + 1; // �������� ����
		Block[] temp = new Block[cnt];
		for (int i = 0; i < block.length; i++)
		{
			int x = block_info[nextAngle][i].getX() + this.currentXY.getX();
			int y = block_info[nextAngle][i].getY() + this.currentXY.getY();
			temp[i] = new Block(x, y);
		}
		return temp;
	}

	// ����ޱ۸���
	public int getCurrentAngle()
	{
		return this.current_angle;
	}

	// ������Ʈ
	public void moveRotate()
	{
		if (this.angle == 1)
			return; // ������1�����̸� ����
		if (this.current_angle + 1 == this.angle) // �ְ����� ó��������
		{
			this.block = this.block_info[0];
			this.current_angle = 0;
		}
		else
		{
			this.current_angle++;
			this.block = this.block_info[this.current_angle];
		}
		this.setMove();
	}

	// ������ ����Ʈ ������ �ǳڿ� �����Ͽ� ��������
	public void setMove()
	{
		for (int i = 0; i < panel.length; i++)
		{
			// �������� x,y���� ����x,y����Ʈ���� ���Ѱ��� ��area���� ���Ѵ�.
			int x = this.block[i].getX() + this.currentXY.getX();
			int y = this.block[i].getY() + this.currentXY.getY();
			panel[i].setLocation(x * area, y * area);
		}
	}

	// �Ʒ��� ��ĭ ������
	public void moveDown()
	{
		this.currentXY.move(0, 1);
		this.setMove();
	}

	// ���������� ��ĭ ������
	public void moveRight()
	{
		this.currentXY.move(1, 0);
		this.setMove();
	}

	// �������� ��ĭ ������
	public void moveLeft()
	{
		this.currentXY.move(-1, 0);
		this.setMove();
	}

	// ���� �� ����
	public Color getColor()
	{
		return this.color;
	}

	// ���� �� ����
	public void setColor(Color c)
	{
		this.color = c;
		for (int i = 0; i < panel.length; i++)
		{
			panel[i].setBackground(this.color);
		}
	}
}
