package engine;

import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.GL45;
import org.lwjgl.system.MemoryUtil;
import input.KeyboardHandler;
import test.MainGameLoop;

public class Game {

	private KeyboardHandler keyboardHandler = new KeyboardHandler();
	private int WIDTH;
	private int HEIGHT;
	private final String title = "This is u - v." + MainGameLoop.version;
	public long window;

	public Game() {
		WIDTH = ;
		HEIGHT = ;
		if(!glfwInit()) {
			System.out.println("Failed to initialize GLFW!");
		}	
		createWindow();
	}

	private void createWindow() {
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_SAMPLES, 8);
		glfwWindowHint(GLFW_RESIZABLE, GL45.GL_FALSE);	
		glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL45.GL_TRUE);	
		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4); glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 5);	
		window = glfwCreateWindow(WIDTH, HEIGHT, title, glfwGetPrimaryMonitor(), MemoryUtil.NULL);	
		if(window == MemoryUtil.NULL) {
			System.out.println("Failed to create game-window!");
		}
		glfwMakeContextCurrent(window);	
		glfwSetKeyCallback(window, keyboardHandler);
		//Key-events can be created and changed in KeyboardHandler.java
	}

	public void update() {
		glfwSwapBuffers(window);
		glfwPollEvents();
	}

	public void close() {
		glfwTerminate();		
	}
}