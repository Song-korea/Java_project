package testProject;

import java.awt.Color;
import java.util.HashMap;

public class Ball {
	
	HashMap<String, Color> map = new  HashMap<String, Color>();
	
	public Ball() {

		map.put("Red", Color.RED);
		map.put("Green", Color.GREEN);
		
		
		String colorName = "Green";
//		System.out.println(String.valueOf(Color.RED.getRGB()));
		String colorS = Integer.toString(Color.RED.getRGB());
		Color c = new Color(Integer.parseInt(colorS));
		System.out.println(colorS);
		System.out.println(c);
		
		System.out.println(convertTypeColorToString(Color.GREEN));

	}
	private String convertTypeColorToString(Color color) {
		String colorName = null;
		
		if(Color.BLACK.equals(color))
			colorName = "black";
		else if(Color.BLUE.equals(color))
			colorName = "blue";
		else if(Color.RED.equals(color))
			colorName = "red";
		else if(Color.GREEN.equals(color))
			colorName = "green";
		else if(Color.CYAN.equals(color))
			colorName = "cyan";
		else if(Color.GRAY.equals(color))
			colorName = "gray";
		else if(Color.MAGENTA.equals(color))
			colorName = "magenta";
		else if(Color.ORANGE.equals(color))
			colorName = "orange";
		else if(Color.WHITE.equals(color))
			colorName = "white";
		else if(Color.PINK.equals(color))
			colorName = "pink";
		else
			colorName = "null";
		
		return colorName;
	}
	
	

	public static void main(String[] args) {
		new Ball();
		
	}
}
