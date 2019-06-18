package day02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Cell{		// ��Ԫ��
	int row;	// ����
	int col;	// ����
	Cell from;	// ��ʼ��
	public Cell(int row,int col,Cell from){
		this.row = row;
		this.col = col;
		this.from = from;
	}
}
public class Ⱦɫ���Թ�{
	static char[][] maze = {
			{'#','#','#','#','B','#','#','#','#','#','#','#'},
			{'#','#','#','#','.','.','.','.','#','#','#','#'},
			{'#','#','#','#','.','#','#','#','#','.','.','#'},
			{'#','.','.','.','.','#','#','#','#','#','.','#'},
			{'#','.','#','#','#','#','#','.','#','#','.','#'},
			{'#','.','#','#','#','#','#','.','#','#','.','#'},
			{'#','.','#','#','.','.','.','.','.','.','.','#'},
			{'#','.','#','#','.','#','#','#','.','#','.','#'},
			{'#','.','.','.','.','#','#','#','.','#','.','#'},
			{'#','#','.','#','.','#','#','#','.','#','.','A'},
			{'#','#','.','#','#','#','.','.','.','#','#','#'},
			{'#','#','#','#','#','#','#','#','#','#','#','#'}
	};
	// ��ʾ�Թ�
	public static void show(){
		for(int i=0;i<maze.length;i++){
			for(int j=0;j<maze[i].length;j++){
				System.out.print(" "+maze[i][j]);
			}
			System.out.println();
		}
	}
	// Ⱦɫ
	public static Cell colorCell(Set<Cell> from,Set<Cell> desc){
		Iterator<Cell> iter = from.iterator();
		while(iter.hasNext()){
			Cell a = iter.next();
			Cell c[] = new Cell[4];
			c[0] = new Cell(a.row-1,a.col,a); // ������
			c[1] = new Cell(a.row+1,a.col,a); // ������
			c[2] = new Cell(a.row,a.col-1,a); // ������
			c[3] = new Cell(a.row,a.col+1,a); // ������
			for(int i=0;i<4;i++){
				if(c[i].row<0 || c[i].row>=maze.length) continue;
				if(c[i].col<0 || c[i].col>=maze[0].length) continue;
				
				char x = maze[c[i].row][c[i].col];	// ȡ�õ�Ԫ���Ӧ�ַ�
				if(x=='B') return a;
				if(x=='.'){
					maze[c[i].row][c[i].col] = '?';	// Ⱦɫ
					desc.add(c[i]);
				}
			}
		}
		return null;
	}
	// 
	public static void resolve(){
		Set<Cell> set = new HashSet<Cell>();
		set.add(new Cell(9,11,null));
		for(;;){
			Set<Cell> set1 = new HashSet<Cell>();
			// ����  a.from.from.from.....<-(set.get(0).from)==null<-���
			Cell a = colorCell(set,set1);	
			if(a!=null){	// �ҵ���
				System.out.println("�ҵ���!");
				while(a!=null){	// ��ǰa�����a.from һֱ��ǰ��
					maze[a.row][a.col] = '+';	// Ⱦɫ·��
					a = a.from;
				}
				break;
			}
			if(set1.isEmpty()){	// ��������һֱ��û��·��,��ʱ set1Ϊ��
				System.out.println("�޽�!");
				break;
			}
			set = set1;	// �����
		}
	}
	public static void main(String[] args){
		show();
		resolve();
		show();
	}
}
