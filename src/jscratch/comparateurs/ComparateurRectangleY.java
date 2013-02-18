package jscratch.comparateurs;

import java.awt.Rectangle;
import java.util.Comparator;

/**
 * @since 1.0
 * @version 1.0
 */
public class ComparateurRectangleY implements Comparator<Rectangle> {

	@Override
	public int compare(Rectangle o1, Rectangle o2) {
		return (int)(o2.getMinY() - o1.getMinY());
	}
}