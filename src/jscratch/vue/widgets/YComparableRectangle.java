package jscratch.vue.widgets;

import java.awt.Rectangle;

/**
 *
 * @author Bastien Andru <bastien.andru@gmail.com>
 */
public class YComparableRectangle extends Rectangle implements Comparable<YComparableRectangle>{

	public YComparableRectangle(Rectangle r) {
		super(r);
	}

	public YComparableRectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	@Override
	public int compareTo(YComparableRectangle o) {
		if(this.getMinY() < o.getMinY()){
			return 1;
		}else if (this.getMinY() == o.getMinY()){
			return 0;
		} else{
			return -1;
		}
	}
	
	
}