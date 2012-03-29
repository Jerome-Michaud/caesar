/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.tools;

import vue.widget.Widget;

import java.awt.Point;
import java.awt.Rectangle;

    public class Action {
		private Point translate;
		private Rectangle rect;
        private Widget comp;

	public Rectangle getRect() {
		return rect;
	}

	public Point getTranslate() {
		return translate;
	}

	public void setRect(Rectangle rec) {
		this.rect = rec;
	}

	public void setTranslate(Point translate) {
		this.translate = translate;
	}
        private int val;

        public Action(Widget comp, int val) {
            this.comp = comp;
            this.val = val;
        }

        public Widget getComp() {
            return comp;
        }

        public int getVal() {
            return val;
        }
    }
