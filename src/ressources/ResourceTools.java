package ressources;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Pierre Laumiere
 */
public class ResourceTools {

    public static Image getImage(String name) {
        URL url = ResourceTools.class.getResource(name);

        if (url != null) {
            try {
                return ImageIO.read(url);
            } catch (IOException ex) {
                Logger.getLogger(ResourceTools.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public static Icon getIcon(String name) {
        URL url = ResourceTools.class.getResource(name);
        if (url != null) {
            return new ImageIcon(url);
        }
        return null;
    }
}