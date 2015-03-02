
public class Runner {

	public static void main(String args[]) throws InterruptedException{
		// Make sure that (int_1 * int_2) < width/height of your display's resolution
		ConwaysGame game = new ConwaysGame(200, 5);
		
		DisplayWindow displayWindow = new DisplayWindow();
		displayWindow.addPanel(game.getConwaysPanel());
		displayWindow.showFrame();
		// 0 is ignored for case infinite, any number is ignored
		game.play(GameMode.INFINITE, 0);
	}
	
}
