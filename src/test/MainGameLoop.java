package test;

import org.lwjgl.glfw.GLFW;
import engine.Game;
import launcher.Launcher;

public class MainGameLoop {

	public final static String version = "0.1";
	private static Settings settings;
	private static Game game;
	private static Launcher launcher;

	//database root password: !7gTu_t.hRJtDWF

	public static void main(String[] args) {

		settings = new Settings();
		//		launcher = new Launcher();
		//
		//		while(!launcher.getStartGame()) {
		//			System.out.println(launcher.getStartGame());
		//		}
		//		
		//		launcher.close();

		//		game = new Game();
		//
		//		while (!GLFW.glfwWindowShouldClose(game.window))	{
		//
		//			game.update();
		//
		//			//			 Wenn game offen, dann spiel intro video.
		//			//			 wenn spacebar pressed, skip video
		//			//			 wenn video vorbei/skipped geh zu main menu		 
		//
		//		}	
		//		game.close();
	}
}