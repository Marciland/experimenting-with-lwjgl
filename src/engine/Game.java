package engine;

import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.GL45;
import org.lwjgl.system.MemoryUtil;
import input.KeyboardHandler;
import test.MainGameLoop;

public class Game {

	private KeyboardHandler keyboardHandler = new KeyboardHandler();
	private int WIDTH = 1024;
	private int HEIGHT = 768;
	private final String title = "This is u - v." + MainGameLoop.version;
	public long window;

	public Game() {
		if(!glfwInit()) {
			System.out.println("Failed to initialize GLFW!");
		}else {
			System.out.println("Successfully initialized GLFW");
		}	
		createWindow();
	}

	private void createWindow() {
		glfwDefaultWindowHints();
		System.out.println("Normalized WindowHints!");		
		glfwWindowHint(GLFW_SAMPLES, 8);
		System.out.println("8 x Anti-Aliasing!");
		glfwWindowHint(GLFW_RESIZABLE, GL45.GL_FALSE);	
		System.out.println("Window not resizeable!");
		glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL45.GL_TRUE);	
		System.out.println("Now compatible with Mac!");
		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4); glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 5);
		System.out.println("Currently running OpenGL 4.5!");	
		window = glfwCreateWindow(WIDTH, HEIGHT, title, glfwGetPrimaryMonitor(), MemoryUtil.NULL);	
		if(window == MemoryUtil.NULL) {
			System.out.println("Failed to create game-window!");
		}
		glfwMakeContextCurrent(window);	
		glfwSetKeyCallback(window, keyboardHandler);
		System.out.println("Keyboard listens to game-window now!");
		//Key-events can be created and changed in KeyboardHandler.java
	}

	public void update() {
		glfwSwapBuffers(this.window);
		glfwPollEvents();
	}

	public void close() {
		glfwTerminate();		
	}
}