import java.util.*;

public class TicTac {
	private int[][] a = new int[3][3];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to TicTacToe. The board looks like this");
		TicTac a = new TicTac();
		a.print();
		Scanner input = new Scanner(System.in);
		int chance = 1;
		while (!a.hasWon() && !a.hasFilled()) {
			if (chance % 2 == 1) {
				System.out.println("What is Player 1 move?");
				String in = input.nextLine();
				int x = Integer.parseInt(in.substring(0, in.indexOf(','))) - 1;
				int y = Integer.parseInt(in.substring(in.indexOf(',') + 1)) - 1;
				while (a.getMat()[x][y] != 0 || x<0 || x>2 || y<0 || y>2) {
					System.out.println("Try again. The Box is already filled.");
					in = input.nextLine();
					x = Integer.parseInt(in.substring(0, in.indexOf(','))) - 1;
					y = Integer.parseInt(in.substring(in.indexOf(',') + 1)) - 1;
				}
				a.fill(x + 1, y + 1, 1);
				a.print();
				chance++;
				continue;
			}
			System.out.println("What is Player 2 move?");
			String in = input.nextLine();
			int x = Integer.parseInt(in.substring(0, in.indexOf(','))) - 1;
			int y = Integer.parseInt(in.substring(in.indexOf(',') + 1)) - 1;
			while (a.getMat()[x][y] != 0|| x<0 || x>2 || y<0 || y>2) {
				System.out.println("Try again. The Box is already filled.");
				in = input.nextLine();
				x = Integer.parseInt(in.substring(0, in.indexOf(','))) - 1;
				y = Integer.parseInt(in.substring(in.indexOf(',') + 1)) - 1;
			}
			a.fill(x + 1, y + 1, 2);
			a.print();
			chance++;

		}
		if (!a.hasWon()) {
			System.out.println("It was a draw");
			return;
		}
		if (chance % 2 == 0) {
			System.out.println("Player 1 won");
			return;
		} else {
			System.out.println("Player 2 won");
			return;
		}
	}

	public void fill(int x, int y, int player) {
		if (a[x - 1][y - 1] != 0) {
			System.out.println("The box is already filled");
		} else {
			this.a[x - 1][y - 1] = player;
		}
	}

	public void print() {
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				if (a[i][j] == 0) {
					System.out.print("e ");
				} else {
					System.out.print(a[i][j] + " ");
				}
			}

			System.out.println();

		}
	}

	public boolean hasFilled() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (a[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean hasWon() {
		if (a[0][0] != 0) {
			if ((a[0][0] == a[1][1]) && (a[1][1] == a[2][2])) {
				return true;
			}
		}
		if (a[2][0] != 0) {
			if ((a[2][0] == a[1][1]) && (a[1][1] == a[0][2])) {
				return true;
			}
		}
		return won(0, 0);
	}

	public boolean right(int x, int y) {
		if (x == 2) {
			return true;
		}
		if (y == 3) {
			return false;
		}
		if (a[x][y] != 0) {
			return (a[x][y] == a[x + 1][y] && right(x + 1, y)) || right(x, y + 1);
		}
		return right(0, y + 1);
	}

	public boolean up(int x, int y) {
		if (y == 2) {
			return true;
		}
		if (x == 3) {
			return false;
		}
		if (a[x][y] != 0) {
			return (a[x][y] == a[x][y + 1] && up(x, y + 1)) || up(x + 1, y);
		}
		return up(x + 1, 0);

	}

	public boolean won(int x, int y) {
		return up(0, 0) || right(0, 0);
	}

	public int[][] getMat() {
		return a;
	}
}
