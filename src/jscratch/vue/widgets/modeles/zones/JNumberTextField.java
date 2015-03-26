/*
Copyright (C) Université du Maine (2013) 

contributeurs : Adrien Duroy, Bastien Andru, Quentin Gosselin, Guillaume Delorme,
 Nicolas Detan, Zubair Parwany, Houda Chouket, Bastien Aubry,
 Vincent Besnard, Ivan Melnychenko, Gwendal Martin

ad.duroy@gmail.com

Ce fichier est une partie du logiciel CAESAR.

CAESAR est un programme informatique servant à construire un programme
pour un robot NXT et à effectuer une simulation de l'exécution de ce dernier. 

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
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;


public class JNumberTextField extends JTextField {

	private static final char DOT = '.';
	private static final char NEGATIVE = '-';
	private static final char TAB1 = '[';
	private static final char TAB2 = ']';
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
	private boolean allowChar = false;
	private int precision = 0;
	protected PlainDocument numberFieldFilter;
	
	private static char CHAR1 = 'a';
	private static char CHAR2 = 'b';
	private static char CHAR3 = 'c';
	private static char CHAR4 = 'd';
	private static char CHAR5 = 'e';
	private static char CHAR6 = 'f';
	private static char CHAR7 = 'g';
	private static char CHAR8 = 'h';
	private static char CHAR9 = 'i';
	private static char CHAR10 = 'j';
	private static char CHAR11 = 'k';
	private static char CHAR12 = 'l';
	private static char CHAR13 = 'm';
	private static char CHAR14 = 'n';
	private static char CHAR15 = 'o';
	private static char CHAR16 = 'p';
	private static char CHAR17 = 'x';
	private static char CHAR18 = 'u';
	private static char CHAR19 = 'v';
	private static char CHAR20 = 'w';
	private static char CHAR21 = 'x';
	private static char CHAR22 = 'y';
	private static char CHAR23 = 'z';
	private static char CHAR24 = 'q';
	private static char CHAR25 = 'r';
	private static char CHAR26 = 's';
	private static char CHAR27 = 't';
	private static char CHAR28 = ' ';
	private static char CHAR29 = '[';
	private static char CHAR30 = ']';
	
	private String TypeChar = BLANK;
	private String TypeChar2 = BLANK;
	private String TypeChar3 = BLANK;
	private String TypeChar4 = BLANK;
	private String TypeChar5 = BLANK;
	private String TypeChar6 = BLANK;
	private String TypeChar7 = BLANK;
	private String TypeChar8 = BLANK;
	private String TypeChar9 = BLANK;
	private String TypeChar10 = BLANK;
	private String TypeChar11 = BLANK;
	private String TypeChar12 = BLANK;
	private String TypeChar13 = BLANK;
	private String TypeChar14 = BLANK;
	private String TypeChar15 = BLANK;
	private String TypeChar16 = BLANK;
	private String TypeChar17 = BLANK;
	private String TypeChar18 = BLANK;
	private String TypeChar19 = BLANK;
	private String TypeChar20 = BLANK;
	private String TypeChar21 = BLANK;
	private String TypeChar22 = BLANK;
	private String TypeChar23 = BLANK;
	private String TypeChar24 = BLANK;
	private String TypeChar25 = BLANK;
	private String TypeChar26 = BLANK;
	private String TypeChar27 = BLANK;
	private String TypeChar28 = BLANK;
	private String TypeChar29 = BLANK;
	private String TypeChar30 = BLANK;
	private String TypeDOT = BLANK;
	

	public JNumberTextField() {
		this(10, NUMERIC);
	}

	public JNumberTextField(int maxLen) {
		this(maxLen, NUMERIC);
	}

	public JNumberTextField(int maxLen, int format) {
		setAllowNegative(true);
		setChar(true);
		setChar1(true);
		setChar2(true);
		setChar3(true);
		setChar4(true);
		setChar5(true);
		setChar6(true);
		setChar7(true);
		setChar8(true);
		setChar9(true);
		setChar10(true);
		setChar10(true);
		setChar11(true);
		setChar12(true);
		setChar13(true);
		setChar15(true);
		setChar14(true);
		setChar16(true);
		setChar17(true);
		setChar18(true);
		setChar19(true);
		setChar20(true);
		setChar21(true);
		setChar22(true);
		setChar22(true);
		setChar23(true);
		setChar24(true);
		setChar25(true);
		setChar26(true);
		setChar27(true);
		setDot(true);
		setTab1(true);
		setTab2(true);
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
	public void setDot(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeDOT = "" + DOT;	
		} else {
			TypeDOT = BLANK;
		}
	}
	public void setTab1(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar29 = "" + TAB1;	
		} else {
			TypeChar29 = BLANK;
		}
	}
	
	public void setTab2(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar30 = "" + TAB2;	
		} else {
			TypeChar30 = BLANK;
		}
	}
	
	public void setChar(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar = "" + CHAR1;	
		} else {
			TypeChar = BLANK;
		}
	}
	public void setChar1(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar2 = "" + CHAR2;	
		} else {
			TypeChar2 = BLANK;
		}
	}
	public void setChar2(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar3 = "" + CHAR3;	
		} else {
			TypeChar3 = BLANK;
		}
	}
	public void setChar3(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar4 = "" + CHAR4;	
		} else {
			TypeChar4 = BLANK;
		}
	}
	public void setChar4(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar5 = "" + CHAR5;	
		} else {
			TypeChar5 = BLANK;
		}
	}
	public void setChar5(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar6 = "" + CHAR6;	
		} else {
			TypeChar6 = BLANK;
		}
	}
	public void setChar6(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar7 = "" + CHAR7;	
		} else {
			TypeChar7 = BLANK;
		}
	}
	public void setChar7(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar8 = "" + CHAR8;	
		} else {
			TypeChar8 = BLANK;
		}
	}
	public void setChar8(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar9 = "" + CHAR9;	
		} else {
			TypeChar9 = BLANK;
		}
	}
	public void setChar9(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar10 = "" + CHAR10;	
		} else {
			TypeChar10 = BLANK;
		}
	}
	public void setChar10(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar11 = "" + CHAR11;	
		} else {
			TypeChar11 = BLANK;
		}
	}
	public void setChar11(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar12 = "" + CHAR12;	
		} else {
			TypeChar12 = BLANK;
		}
	}
	public void setChar12(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar13 = "" + CHAR13;	
		} else {
			TypeChar13 = BLANK;
		}
	}
	public void setChar13(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar14 = "" + CHAR14;	
		} else {
			TypeChar14 = BLANK;
		}
	}
	public void setChar14(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar15 = "" + CHAR15;	
		} else {
			TypeChar15 = BLANK;
		}
	}
	public void setChar15(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar16 = "" + CHAR16;	
		} else {
			TypeChar16 = BLANK;
		}
	}
	public void setChar16(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar17 = "" + CHAR17;	
		} else {
			TypeChar17 = BLANK;
		}
	}
	public void setChar17(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar18 = "" + CHAR18;	
		} else {
			TypeChar18 = BLANK;
		}
	}
	public void setChar18(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar19 = "" + CHAR19;	
		} else {
			TypeChar19 = BLANK;
		}
	}
	public void setChar19(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar20 = "" + CHAR20;	
		} else {
			TypeChar20 = BLANK;
		}
	}
	public void setChar20(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar21 = "" + CHAR21;	
		} else {
			TypeChar21 = BLANK;
		}
	}
	public void setChar21(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar22 = "" + CHAR22;	
		} else {
			TypeChar22 = BLANK;
		}
	}
	public void setChar22(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar23 = "" + CHAR23;	
		} else {
			TypeChar23 = BLANK;
		}
	}
	public void setChar23(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar24 = "" + CHAR24;	
		} else {
			TypeChar24 = BLANK;
		}
	}
	public void setChar24(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar25 = "" + CHAR25;	
		} else {
			TypeChar25 = BLANK;
		}
	}
	public void setChar25(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar26 = "" + CHAR26;	
		} else {
			TypeChar26 = BLANK;
		}
	}
	public void setChar26(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar27 = "" + CHAR27;	
		} else {
			TypeChar27 = BLANK;
		}
	}
	public void setChar27(boolean value) {
		allowChar = value;
	
		if (value) {
			TypeChar28 = "" + CHAR28;	
		} else {
			TypeChar28 = BLANK;
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

		@Override
		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			String text = getText(0, offset) + str + getText(offset, (getLength() - offset));
			
			if (str == null || text == null) {
				return;
			}

			for (int i = 0; i < str.length(); i++) {
				if ((allowedChars + negativeChars + TypeChar + TypeDOT + TypeChar2 + TypeChar6 + TypeChar3 + TypeChar4 + TypeChar5 + TypeChar7 + TypeChar8 + TypeChar9 + TypeChar10 + TypeChar11 + TypeChar12 + TypeChar13 + TypeChar14
						+ TypeChar15 + TypeChar16 + TypeChar17 + TypeChar18 + TypeChar19 + TypeChar20 + TypeChar21 + TypeChar22 + TypeChar23 +TypeChar24 + TypeChar25 + TypeChar26 + TypeChar27 + TypeChar28 + TypeChar29 + TypeChar30).indexOf(str.charAt(i)) == -1) {
					return;
				} 
			}
			
			

			int precisionLength = 0, dotLength = 0, minusLength = 0;
			int textLength = text.length();

/*			try {
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
			}*/

			if (text.startsWith("" + NEGATIVE)) {
				if (!allowNegative) {
					return;
				} else {
					minusLength = 1;
				}
			}
			
			if (text.endsWith("" + DOT)) {
				if (!allowNegative) {
					return;
				} else {
					super.insertString(offset, "\u200e.", attr);
					return;
				}
			} 
			
			if (maxLength < (textLength - dotLength - precisionLength - minusLength)) {
				return;
			}

			super.insertString(offset, str, attr);
		}
	}
}