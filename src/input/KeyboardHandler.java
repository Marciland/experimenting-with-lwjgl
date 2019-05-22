package input;

import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.GLFWKeyCallback;

public class KeyboardHandler extends GLFWKeyCallback{

	public static boolean[] keys = new boolean[65536];
	// The GLFWKeyCallback class is an abstract method that
	// can't be instantiated by itself and must instead be extended
	@Override
	public void invoke(long window, int key, int scancode, int action, int mods) {
		keys[key] = action != GLFW_RELEASE;
		if (action == GLFW_PRESS) {
			if (key == GLFW_KEY_UP) {

			}
			if (key == GLFW_KEY_DOWN) {

			}
			if (key == GLFW_KEY_LEFT) {

			}
			if (key == GLFW_KEY_RIGHT) {

			}
			if (key == GLFW_KEY_ENTER) {

			}
			if (key == GLFW_KEY_SPACE) {

			}
			if (key == GLFW_KEY_ESCAPE) {

			}
			if (key == GLFW_KEY_0) {

			}
			if (key == GLFW_KEY_1) {

			}
			if (key == GLFW_KEY_2) {

			}
			if (key == GLFW_KEY_3) {

			}
			if (key == GLFW_KEY_4) {

			}
			if (key == GLFW_KEY_5) {

			}
			if (key == GLFW_KEY_6) {

			}
			if (key == GLFW_KEY_7) {

			}
			if (key == GLFW_KEY_8) {

			}
			if (key == GLFW_KEY_9) {

			}
		}
	}
}