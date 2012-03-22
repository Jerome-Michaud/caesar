/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue.Tools;

import Vue.Widget.Widget;

/**
 *
 * @author Bastien
 */

    public class Action {

        private Widget comp;
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
