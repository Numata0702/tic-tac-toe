
public class TicTacToe {
	public static void main(String[] args) {
		int[][] field_number = {
				{ 0, 0, 0, 0, 0, 0 },
				{ 0, 4, 0, 3, 0, 8 },
				{ 0, 0, 0, 0, 0, 0 },
				{ 0, 9, 0, 5, 0, 1 },
				{ 0, 0, 0, 0, 0, 0 },
				{ 0, 2, 0, 7, 0, 6 }, };

		String[][] field = {
				{ "  ", "1", " ", "2", " ", "3" },
				{ "a ", " ", "|", " ", "|", " " },
				{ "  ", "-", "+", "-", "+", "-" },
				{ "b ", " ", "|", " ", "|", " " },
				{ "  ", "-", "+", "-", "+", "-" },
				{ "c ", " ", "|", " ", "|", " " }, };

		int[][] maruBatuList = { { 100, 100, 100, 100, 100 }, // ○（turn/2の余りが０）の時は上の行
				{ 100, 100, 100, 100, 100 }, // ×（turn/2余りが１）の時は下の行
		};

		int turn = 0;
		boolean win = false;
		int abcNumber;

		while (win == false) {
			System.out.println(maru_ka_batu_ka(turn) + "のターン");
			System.out.println("どこに" + maru_ka_batu_ka(turn) + "を置きますか？");
			show(field);
			System.out.println(" ");
			System.out.println("a,　b,　c のどれかを入力してください");
			String abc = new java.util.Scanner(System.in).nextLine();
			if (abc.equals("a")) {
				abcNumber = 1;
			} else if (abc.equals("b")) {
				abcNumber = 3;
			} else if (abc.equals("c")) {
				abcNumber = 5;
			} else {
				System.out.println("指定された文字以外が入力されました\n");
				continue;
			}

			System.out.println("1,　2,　3　のどれかを入力してください");
			int suuzi = new java.util.Scanner(System.in).nextInt();
			System.out.println();

			if (suuzi == 1) {
			} else if (suuzi == 2) {
				suuzi = 3;
			} else if (suuzi == 3) {
				suuzi = 5;
			} else {
				System.out.println("指定された番号以外が入力されました\n");
				continue;
			}

			if (field[abcNumber][suuzi] != " ") {
				System.out.println("すでに〇か×が入っています");
				continue;
			}

			field[abcNumber][suuzi] = maru_ka_batu_ka(turn);

			maruBatuList[turn % 2][turn / 2] = field_number[abcNumber][suuzi];

			for (int i = 0; i < 2; i++) {
				for (int j = i + 1; j < 3; j++) {
					for (int k = j + 1; k < 4; k++) {
						int sum = maruBatuList[turn % 2][i] + maruBatuList[turn % 2][j] + maruBatuList[turn % 2][k];
						if (sum == 15) {
							win = true;
							show(field);
							System.out.println(maru_ka_batu_ka(turn) + "の勝ちです！");
							break;

						}

					}
				}
			}

			turn += 1;

			if (turn == 9) {
				show(field);
				System.out.println("引き分けです！");
				win = true;
			}
		}

	}

	public static String maru_ka_batu_ka(int turn) {
		String kigou;
		if (turn % 2 == 0) {
			kigou = "o";
		} else {
			kigou = "x";
		}
		return kigou;
	}

	public static void show(String field[][]) {
		for (int i = 0; i < field.length; i++) {

			for (int j = 0; j < (field[i].length); j++) {

				System.out.print(field[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
