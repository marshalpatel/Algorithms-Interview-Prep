package marshal.practice.com;

import java.util.LinkedList;
import java.util.Queue;

public class WordSearch {

	public static void wordSearch() {

		char[][] board = {{'A','B','C','E'},
						  {'S','F','E','S'},
						  {'A','D','E','E'}};
		
		/*char[][] board = {{'b','a','b'},
				  		 {'b','b','a'},
				  		 {'b','b','b'}};*/
		
		boolean[][] visited = new boolean[board.length][board[0].length];
		
		System.out.println(wordSearch(board,"ABCESEEEFS",visited));
	}

	public static boolean wordSearch(char[][] board, String word,boolean[][] visited) {

		boolean result = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				if (board[i][j] == word.charAt(0) && !result) {
					visited[i][j] = true;
					//result = BFS(board, word, i, j,visited);
					//reset visited
//					for(int m = 0;m<board.length;m++){
//						for(int n=0;n<board[0].length;n++){
//							visited[i][j]=false;
//						}
//					}
				}

			}
		}

		return result;

	}
	
	public static boolean DFS(char[][] board, String word, int r, int c,boolean[][] visited,int index){
		
		if(index==word.length())
			return true;
		if (r - 1 >= 0 && index < word.length()){
			
		}
		if (c + 1 < board[0].length && index < word.length()) {
			
		}
		
		if(r - 1 >= 0 && index < word.length()){
			
		}
		
		if(r + 1 < board.length && index < word.length()){
			
		}
		
		return false;
		
	}

	/*public static boolean BFS(char[][] board, String word, int r, int c,boolean[][] visited) {

		Queue<Integer> row = new LinkedList<Integer>();
		Queue<Integer> col = new LinkedList<Integer>();
		row.offer(r);
		col.offer(c);
		int index = 0;

		while (!row.isEmpty()) {

			int tr = row.poll();
			int tc = col.poll();
			if (index < word.length() && word.charAt(index) == board[tr][tc]) {
				System.out.println(board[tr][tc]);
				index++;
				if (tc - 1 >= 0 && index < word.length()) {
					if (board[tr][tc - 1] == word.charAt(index) && !visited[tr][tc-1]) {
						visited[tr][tc-1]=true;
						row.offer(tr);
						col.offer(tc - 1);
					}

				}
				if (tc + 1 < board[0].length && index < word.length()) {
					if (board[tr][tc + 1] == word.charAt(index) && !visited[tr][tc + 1]) {
						visited[tr][tc + 1]=true;
						row.offer(tr);
						col.offer(tc + 1);
					}

				}
				if (tr - 1 >= 0 && index < word.length()) {
					if (board[tr - 1][tc] == word.charAt(index) && !visited[tr-1][tc]) {
						visited[tr-1][tc]=true;
						row.offer(tr - 1);
						col.offer(tc);
					}

				}
				if (tr + 1 < board.length && index < word.length()) {
					if (board[tr + 1][tc] == word.charAt(index) && !visited[tr+1][tc]) {
						visited[tr+1][tc] = true;
						row.offer(tr + 1);
						col.offer(tc);
					}

				}
				// tc < board[0].length && tr-1>=0 && tr+1<board.length){

			}
		}

		if (index == word.length())
			return true;
		else
			return false;
	}*/

}
