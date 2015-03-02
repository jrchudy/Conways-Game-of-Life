
public class ConwaysGame {

	// TODO: Menu buttons, modify settings from UI
	// TODO: Game of life resizing, rectangular instead of just square
	// TODO: Game modes
	// TODO: Add Cell objects instead of boolean cells.
	// -- Leads to cell types: walls, livable space,  cells that increase spawn likely-hood.
	// -- Coloring of cells
	
	
	static ConwaysBoard conwaysBoard;
	ConwaysPanel conwaysPanel;
	GameState currentState;
	
	public ConwaysGame(int boardSize, int cellSize){
		conwaysBoard = new ConwaysBoard(boardSize);
		conwaysBoard.initBoard();
		conwaysPanel = new ConwaysPanel(conwaysBoard.getBoard(), boardSize, cellSize);
		currentState = GameState.MENU;
	}
	
	public void play(GameMode mode, int turns) throws InterruptedException {
		switch(mode){
			case INFINITE:
				while (true) {
					takeTurn();
					Thread.sleep(1);
				}
			case TURN_LIMIT:
				break;
			default:
				break;
		}
	}
	
	public ConwaysBoard getConwaysBoard() {
		return conwaysBoard;
	}
	
	public ConwaysPanel getConwaysPanel() {
		return conwaysPanel;
	}
	
	public void takeTurn() {
		boolean[][] newBoard = conwaysBoard.processCells();

		conwaysPanel.reDrawTurn(newBoard);
		conwaysBoard.setBoard(newBoard);
	}
}
