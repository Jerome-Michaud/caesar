/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution ce dernier. 

CAESAR est régi par la licence CeCILL soumise au droit français et
respectant les principes de diffusion des logiciels libres. Vous pouvez
utiliser, modifier et/ou redistribuer ce programme sous les conditions
de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA 
sur le site "http://www.cecill.info".

En contrepartie de l'accessibilité au code source et des droits de copie,
de modification et de redistribution accordés par cette licence, il n'est
offert aux utilisateurs qu'une garantie limitée.  Pour les mêmes raisons,
seule une responsabilité restreinte pèse sur l'auteur du programme,  le
titulaire des droits patrimoniaux et les concédants successifs.

A cet égard  l'attention de l'utilisateur est attirée sur les risques
associés au chargement,  à l'utilisation,  à la modification et/ou au
développement et à la reproduction du logiciel par l'utilisateur étant 
donné sa spécificité de logiciel libre, qui peut le rendre complexe à 
manipuler et qui le réserve donc à des développeurs et des professionnels
avertis possédant  des  connaissances  informatiques approfondies.  Les
utilisateurs sont donc invités à charger  et  tester  l'adéquation  du
logiciel à leurs besoins dans des conditions permettant d'assurer la
sécurité de leurs systèmes et ou de leurs données et, plus généralement, 
à l'utiliser et l'exploiter dans les mêmes conditions de sécurité. 

Le fait que vous puissiez accéder à cet en-tête signifie que vous avez 
pris connaissance de la licence CeCILL, et que vous en avez accepté les
termes.
 */
package jscratch.vue.widgets.modeles.zones;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import org.jdom2.Document;


public class JNumberTextField extends JTextField {

	private static final char DOT = '.';
	private static final char NEGATIVE = '-';
	private static final String BLANK = "";
	private static final int DEF_PRECISION = 2;
	public static final int NUMERIC = 2;
	public static final int DECIMAL = 3;
	public static final String FM_NUMERIC = "0123456789";
	public static final String FM_DECIMAL = FM_NUMERIC + DOT;
	private int maxLength = 0;
	private int format = NUMERIC;
	private String negativeChars = BLANK;
	private String allowedChars = null;
	private boolean allowNegative = false;
	private int precision = 0;
	protected PlainDocument numberFieldFilter;

	public JNumberTextField() {
		this(10, NUMERIC);
	}

	public JNumberTextField(int maxLen) {
		this(maxLen, NUMERIC);
	}

	public JNumberTextField(int maxLen, int format) {
		setAllowNegative(true);
		setMaxLength(maxLen);
		setFormat(format);

		numberFieldFilter = new JNumberFieldFilter(this);
		super.setDocument(numberFieldFilter);
	}

	public void setMaxLength(int maxLen) {
		if (maxLen > 0) {
			maxLength = maxLen;
		} else {
			maxLength = 0;
		}
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setPrecision(int precision) {
		if (format == NUMERIC) {
			return;
		}

		if (precision >= 0) {
			this.precision = precision;
		} else {
			this.precision = DEF_PRECISION;
		}
	}

	public int getPrecision() {
		return precision;
	}

	public Number getNumber() {
		Number number = null;

		if (format == NUMERIC) {
			number = new Integer(getText());
		} else {
			number = new Double(getText());
		}

		return number;
	}

	public void setNumber(Number value) {
		setText(String.valueOf(value));
	}

	public int getInt() {
		return Integer.parseInt(getText());
	}

	public void setInt(int value) {
		setText(String.valueOf(value));
	}

	public float getFloat() {
		return (new Float(getText())).floatValue();
	}

	public void setFloat(float value) {
		setText(String.valueOf(value));
	}

	public double getDouble() {
		return (new Double(getText())).doubleValue();
	}

	public void setDouble(double value) {
		setText(String.valueOf(value));
	}

	public int getFormat() {
		return format;
	}

	public void setFormat(int format) {
		switch (format) {
			case NUMERIC:
			default:
				this.format = NUMERIC;
				this.precision = 0;
				this.allowedChars = FM_NUMERIC;
				break;

			case DECIMAL:
				this.format = DECIMAL;
				this.precision = DEF_PRECISION;
				this.allowedChars = FM_DECIMAL;
				break;
		}
	}

	public void setAllowNegative(boolean value) {
		allowNegative = value;

		if (value) {
			negativeChars = "" + NEGATIVE;
		} else {
			negativeChars = BLANK;
		}
	}

	public boolean isAllowNegative() {
		return allowNegative;
	}

	public void setDocument(Document document) {
	}

	class JNumberFieldFilter extends PlainDocument {

		private JNumberTextField appelant;
		public JNumberFieldFilter(JNumberTextField appelant) {
			super();
			this.appelant = appelant;
		}

		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			String text = getText(0, offset) + str + getText(offset, (getLength() - offset));

			if (str == null || text == null) {
				return;
			}

			for (int i = 0; i < str.length(); i++) {
				if ((allowedChars + negativeChars).indexOf(str.charAt(i)) == -1) {
					return;
				}
			}

			int precisionLength = 0, dotLength = 0, minusLength = 0;
			int textLength = text.length();

			try {
				if (format == NUMERIC) {
					if (!((text.equals(negativeChars)) && (text.length() == 1))) {
						new Long(text);
					}
				} else if (format == DECIMAL) {
					if (!((text.equals(negativeChars)) && (text.length() == 1))) {
						new Double(text);
					}

					int dotIndex = text.indexOf(DOT);
					if (dotIndex != -1) {
						dotLength = 1;
						precisionLength = textLength - dotIndex - dotLength;

						if (precisionLength > precision) {
							return;
						}
					}
				}
			} catch (Exception ex) {
				return;
			}

			if (text.startsWith("" + NEGATIVE)) {
				if (!allowNegative) {
					return;
				} else {
					minusLength = 1;
				}
			}

			if (maxLength < (textLength - dotLength - precisionLength - minusLength)) {
				return;
			}

			super.insertString(offset, str, attr);
		}
	}
}