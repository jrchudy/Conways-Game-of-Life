import java.util.Random;


public class ConwaysBoard {
	
	private static int _boardSize;
	boolean[][] _board;
	Random _rand;
	
	public ConwaysBoard (int size) {
		_boardSize = size;
		_rand = new Random();
	}
	
	public void initBoard() {
		_board = new boolean[_boardSize][_boardSize];
		for(int x=0; x<_boardSize; x++){
			for(int y=0; y<_boardSize; y++){
				int random = _rand.nextInt(100);
				if(random <= 30) {
					_board[x][y] = true;
				} else {
					_board[x][y] = false;
				}
			}
		}
	}
	
	// Runs an iteration of the simulation and returns the state of the simulation as a new board
	public boolean[][] processCells() {
		boolean[][] boardManip = new boolean[_boardSize][_boardSize];
		for(int x=0; x<_boardSize; x++){
			for(int y=0; y<_boardSize; y++){
				int neighbors = 0;
				if(_board[modifyArrayIndex(x-1)][modifyArrayIndex(y-1)]) { neighbors++; }
				if(_board[modifyArrayIndex(x-1)][modifyArrayIndex(y)]) { neighbors++; }
				if(_board[modifyArrayIndex(x-1)][modifyArrayIndex(y+1)]) { neighbors++; }
				if(_board[modifyArrayIndex(x)][modifyArrayIndex(y-1)]) { neighbors++; }
				if(_board[modifyArrayIndex(x)][modifyArrayIndex(y+1)]) { neighbors++; }
				if(_board[modifyArrayIndex(x+1)][modifyArrayIndex(y-1)]) { neighbors++; }
				if(_board[modifyArrayIndex(x+1)][modifyArrayIndex(y)]) { neighbors++; }
				if(_board[modifyArrayIndex(x+1)][modifyArrayIndex(y+1)]) { neighbors++; }
				if(_board[modifyArrayIndex(x)][modifyArrayIndex(y)]) {
					if(neighbors == 2 || neighbors == 3) {
						boardManip[x][y] = true; 
					} else {
						boardManip[x][y] = false;
					}
				} else {
					if(neighbors == 3) {
						boardManip[x][y] = true;
					// As if the virgin mary was given a child (1 in 1 Million)
					// TODO: Make this less likely over time
					} else if(neighbors == 1 && _rand.nextInt(1000000) <= 1){
						boardManip[x][y] = true;
					} else {
						boardManip[x][y] = false;
					}
				}
				neighbors = 0;
				
			}
		}
		return boardManip;
	}
	
	public boolean isAlive(int neighbors, boolean alive){
		if(alive) {
			if(neighbors == 2 || neighbors == 3){
				return true;
			} else {
				return false;
			}
		} else {
			if(neighbors == 3){
				return true;
			} else {
				return false;
			}
		}
	}
	
	public int modifyArrayIndex(int index){
		if(index < 0) {
			return _boardSize-1;
		} else if(index>=_boardSize) {
			return 0;
		} else {
			return index;
		}
	}
	
	public boolean[][] getBoard() {
		return _board;
	}
	
	public void setBoard(boolean[][] newBoard) {
		_board = newBoard;
	}
	
	public int getBoardSize() {
		return _boardSize;
	}
	
	public void setBoardSize() {
		
	}

}
