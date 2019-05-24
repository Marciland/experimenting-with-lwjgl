package test;

import org.lwjgl.glfw.GLFW;
import engine.Game;
import launcher.Launcher;

public class MainGameLoop {

	public final static String version = "0.1";
	static Game game;
	static Launcher launcher;

	//database root password: !7gTu_t.hRJtDWF

	public static void main(String[] args) {

		launcher = new Launcher();

		while(!launcher.startGame) {
			System.out.println(launcher.startGame);
			try {
				Thread.sleep(20000);
			} catch (InterruptedException ignored) {}
		}

		game = new Game();

		while (!GLFW.glfwWindowShouldClose(game.window))	{

			game.update();

			//			 Wenn game offen, dann spiel intro video.
			//			 wenn spacebar pressed, skip video
			//			 wenn video vorbei/skipped geh zu main menu		 

		}	
		game.close();
		//--------------------------------------------------------------
	}
}