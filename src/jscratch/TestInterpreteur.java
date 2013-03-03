package jscratch;

import jscratch.interpreteur.ExplorerASTNXC;
import jscratch.interpreteur.MonteurNXTIM;
import jscratch.interpreteur.parser.NXCParser;
import jscratch.traduction.VisiteurNXC;
import org.antlr.runtime.tree.Tree;

/**
 *
 * @author Adrien DUROY
 */
public class TestInterpreteur {
    public static void main(String args[]) {
        String code1 = "task main() {\n" +
    			"long nb = 15;\n" +
    			"int i;\n" +
    			//"for(i = 0; i < 2; i = i + 1) {\n" +
				//"while(i < 2) {\n" +
    			"do {\n" +
				//"if(i < 2) {\n" +
    				"OnFwd(OUT_A, (90.1 + nb)/2);\n" +
    				"Wait(3);\n" +
    			//"} else if(i == 1) {i = 1;} else {}\n" +
				//"}\n" +
    			"} while(i < 2);\n" +
    			"Off(OUT_A);\n" +
    			"}";
        Tree tree = NXCParser.parseCode(code1);
        if(tree != null) {
			MonteurNXTIM monteur = new MonteurNXTIM();
            ExplorerASTNXC explorer = new ExplorerASTNXC(monteur);
            explorer.explore(tree);
			VisiteurNXC v = VisiteurNXC.getInstance();
			monteur.getModele().accepte(v);
			System.out.println(v.getTraduction());
        }
    }
}
