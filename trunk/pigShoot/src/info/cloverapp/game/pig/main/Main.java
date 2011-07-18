
package info.cloverapp.game.pig.main;

import info.cloverapp.game.pig.scene.impl.Gate;
import info.cloverapp.game.pig.window.Window;

public class Main {

	public static void main(String[] args) {

		// step.1 scene
		Window window = new Window();

		window.setScene(new Gate());

		window.start();
	}
}
