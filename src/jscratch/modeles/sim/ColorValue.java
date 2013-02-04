package jscratch.modeles.sim;

import java.awt.Color;

/**
 * Enumération des couleurs NXC pour le capteur de couleur
 * @author Guillaume Delorme
 *
 */
public enum ColorValue {
	INPUT_BLACKCOLOR (1, new Color(0, 0, 0), "Noir"),
	INPUT_BLUECOLOR (2, new Color(0, 0, 255), "Bleu"),
	INPUT_GREENCOLOR (3, new Color(0, 255, 0), "Vert"),
	INPUT_YELLOWCOLOR (4, new Color(255, 255, 0), "Jaune"),
	INPUT_REDCOLOR (5, new Color(255, 0, 0), "Rouge"),
	INPUT_WHITECOLOR (6, new Color(255, 255, 255), "Blanc");
	
	private final int value;
	private final Color color;
	private final String name;
	
	ColorValue(int value, Color color, String name) {
		this.value = value;
		this.color = color;
		this.name = name;
	}
	
	public static ColorValue getSimilarColor(Color color2) {
		double diffPlusProche = Double.MAX_VALUE;
		ColorValue couleurPlusProche = null;
		
		for (ColorValue color1 : ColorValue.values()) {
			double diff = Math.pow(color2.getRed() - color1.getColor().getRed(), 2) + 
					Math.pow(color2.getGreen() - color1.getColor().getGreen(), 2) +
					Math.pow(color2.getBlue() - color1.getColor().getBlue(), 2);
			
			if (diff < diffPlusProche) {
				diffPlusProche = diff;
				couleurPlusProche = color1;
			}
		}
		
		return couleurPlusProche;		
	}

	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public String toString() {
		return name;
	}	
}