import java.util.*;

public class gameCPU {
	StringBuilder gameString;
	int rows[][][], cols[][][], diags[][][];
	int[] slot0;
	int[] slot1;
	int[] slot2;
	int[] slot3;
	int[] slot4;
	int[] slot5;
	int[] slot6;
	int[] slot7;
	int[] slot8;
	
	public gameCPU(String s) {
		this.gameString = new StringBuilder(s);
		slot0 = new int[] {0, gameString.charAt(0) - '0'}; 
		slot1 = new int[] {1, gameString.charAt(1) - '0'};
		slot2 = new int[] {2, gameString.charAt(2) - '0'};
		slot3 = new int[] {3, gameString.charAt(3) - '0'};
		slot4 = new int[] {4, gameString.charAt(4) - '0'};
		slot5 = new int[] {5, gameString.charAt(5) - '0'};
		slot6 = new int[] {6, gameString.charAt(6) - '0'};
		slot7 = new int[] {7, gameString.charAt(7) - '0'};
		slot8 = new int[] {8, gameString.charAt(8) - '0'};
		
		this.rows = new int[][][]{
				{slot0, slot1, slot2},
				{slot3, slot4, slot5},
				{slot6, slot7, slot8},
				{slot0, slot3, slot6},
				{slot1, slot4, slot7},
				{slot2, slot5, slot8},
				{slot0, slot4, slot8},
				{slot2, slot4, slot6}
			};
	}
	
	public String[] makeMove() {
		int loc = winMove();
		if(loc > -1) {
			System.out.println("changed String");
			gameString.setCharAt(loc, '2');
			
			return new String[] {""+loc, gameString.toString()};
		}else {
			int firstAvail = nonWinMove();
			System.out.println("using firstAvailable");
			if(firstAvail > -1) {
				System.out.println("changed string");
				gameString.setCharAt(firstAvail, '2');
			}
				
			return new String[] {""+firstAvail, gameString.toString()};
		}
		
		
	}
	public int nonWinMove() {
		if(canLose()) {
			return blockX();
		}else {
			for(int i = 0; i < rows.length; i++) {
				for(int j = 0; j < rows[i].length; j++) {
					if(rows[i][j][1] == 0) {
						System.out.println("first avail returned");
						return rows[i][j][0];
					}
				}
			}
		}
		System.out.println("No first available found");
		return -1;
	}
	public int blockX() {
		int count = 0;
		for(int i = 0; i < rows.length; i++) {
			count = 0;
			for(int j = 0; j < rows[i].length; j++) {
				if(rows[i][j][1] == 1) {
					count++;
				}
			}
			if(count == 2) {
				if(openSlot(i)) {
					return findSlot(i);
				}else {
					continue;
				}
			}
		}
		System.out.println("Nothing to block");
		return -1;
	}
	public boolean canLose() {
		int count = 0;
		for(int i = 0; i < rows.length; i++) {
			count = 0;
			for(int j = 0; j < rows[i].length; j++) {
				if(rows[i][j][1] == 1) {
					count++;
				}
			}
			if(count == 2) {
				System.out.println("looking for slot");
				if(openSlot(i)) {
					return true;
				}
				
			}
		}
		System.out.println("can't lose");
		return false;
	}
	public int winMove() throws ArrayIndexOutOfBoundsException{
		for(int i = 0; i < rows.length; i++) {
			if(canWin(rows[i])) {
				System.out.println("winmove");
				return findSlot(i);
			}else {
				continue;
			}
		}
		System.out.println("No win move");
		return -1;
		
		
		
	}
	public int findSlot(int row) {
		for(int i = 0; i < rows[row].length; i++) {
			if (rows[row][i][1] == 0) {
				System.out.println("found slot");
				return rows[row][i][0];
			}
		}
		System.out.println("Not slot found");
		return -1;
	}
	public boolean openSlot(int row) {
		for(int i = 0; i < rows[row].length; i++) {
			if(rows[row][i][1] == 0) {
				System.out.println("slot exists");
				return true;
			}
		}
		System.out.println("No slot exists");
		return false;
	}
	
	public boolean canWin(int[][] row) {
		int count = 0;
		for(int i = 0; i < row.length; i++) {
			if (row[i][1] == 2) {
				count++;
			}
		}
		if(count == 2) {
			System.out.println("can win");
			return true;
		}
		return false;
		
	}
	
	
}
