
import java.awt.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class ConwaysPanel extends JPanel{
	
	static ConwaysGame _conwaysGame;
	boolean[][] _gameBoard;
	static int _xDimension, _yDimension, _boardSize, _cellSize;
	static final int _pixelBuffer = 10;
	static final int _scalar = 5;
	
	
	public ConwaysPanel (ConwaysGame game, boolean[][] board, int boardSize, int cellSize){
		_conwaysGame = game;
		_gameBoard = board;
		_boardSize = boardSize;
		_cellSize = cellSize;
		_xDimension = (boardSize * _scalar) + (_pixelBuffer * 2);
		_yDimension = (boardSize * _scalar) + (_pixelBuffer * 2);
		setPreferredSize(new Dimension(_xDimension, _yDimension));
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, _xDimension, _yDimension);
		drawGameView(_gameBoard, g);
	}
	
	public void drawGameView(boolean[][] board, Graphics g) {
		for(int x=0; x<_boardSize; x++) {
			for(int y=0; y<_boardSize; y++) {
				if(board[x][y]) {
					g.setColor(Color.white);
					g.fillRect((x*_scalar)+_pixelBuffer, (y*_scalar)+_pixelBuffer, _scalar, _scalar);
				}
			}
		}
	}
	
	public void reDrawTurn(boolean[][] newBoard) {
		_gameBoard = newBoard;
		repaint();
	}

}
