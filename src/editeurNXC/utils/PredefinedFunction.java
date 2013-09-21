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
package editeurNXC.utils;

import editeurNXC.langage.SFloat;
import editeurNXC.langage.SMutex;
import editeurNXC.langage.SInteger;
import editeurNXC.langage.SNumeric;
import editeurNXC.langage.SType;
import editeurNXC.langage.STypeSize;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * classe listant les fonctions predefinies du langage NXC
 * le fichier sert notamment pour la coloration syntaxique dans notre cas.
 * fichier récupérer de l'ancien projet
 *
 * @author MARTIN Gwendal
 */
public abstract class PredefinedFunction<T extends SType> {

	private static final Map<String, PredefinedFunction> functions = new HashMap<String, PredefinedFunction>();
	protected final List<SType> parameters;
	protected final T returnType;

	protected PredefinedFunction(List<SType> parParams, T parRetType) {
		this.parameters = new LinkedList<SType>(parParams);
		this.returnType = parRetType;
	}

	public static PredefinedFunction getFunction(String parName) {
		return functions.get(parName);
	}

	public boolean nbArgsOK(int parNbArgs) {
		return this.parameters.size() == parNbArgs;
	}

	public boolean argsTypesOK(List<SType> parArgs) {
		for (int i = 0; i < this.parameters.size(); ++i) {
			if (!this.parameters.get(i).hasSameType(parArgs.get(i))) {
				return false;
			}
		}
		return true;
	}

	public T returnType() {
		return this.returnType;
	}

	public abstract T eval(List<SType> parArgs) throws InterruptedException;

	static {
		PredefinedFunction locFunc;
		List<SType> locParamsTypes = new LinkedList<SType>();

		// TODO: add NXC functions
        /*
		 * cmath API functions
		 */
		locParamsTypes.add(SFloat.DEFAULT_FLOAT);
		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.sqrt(((SNumeric) parArgs.get(0)).getFloatValue()));
			}
		};
		functions.put("sqrt", locFunc);
		functions.put("Sqrt", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.cos(((SNumeric) parArgs.get(0)).getFloatValue()));
			}
		};
		functions.put("cos", locFunc);
		functions.put("Cos", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.sin(((SNumeric) parArgs.get(0)).getFloatValue()));
			}
		};
		functions.put("sin", locFunc);
		functions.put("Sin", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.tan(((SNumeric) parArgs.get(0)).getFloatValue()));
			}
		};
		functions.put("tan", locFunc);
		functions.put("Tan", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.acos(((SNumeric) parArgs.get(0)).getFloatValue()));
			}
		};
		functions.put("acos", locFunc);
		functions.put("Acos", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.asin(((SNumeric) parArgs.get(0)).getFloatValue()));
			}
		};
		functions.put("asin", locFunc);
		functions.put("Asin", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.atan(((SNumeric) parArgs.get(0)).getFloatValue()));
			}
		};
		functions.put("atan", locFunc);
		functions.put("Atan", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.cosh(((SNumeric) parArgs.get(0)).getFloatValue()));
			}
		};
		functions.put("cosh", locFunc);
		functions.put("Cosh", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.sinh(((SNumeric) parArgs.get(0)).getFloatValue()));
			}
		};
		functions.put("sinh", locFunc);
		functions.put("Sinh", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.tanh(((SNumeric) parArgs.get(0)).getFloatValue()));
			}
		};
		functions.put("tanh", locFunc);
		functions.put("Tanh", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.exp(((SNumeric) parArgs.get(0)).getFloatValue()));
			}
		};
		functions.put("exp", locFunc);
		functions.put("Exp", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.log(((SNumeric) parArgs.get(0)).getFloatValue()));
			}
		};
		functions.put("log", locFunc);
		functions.put("Log", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.log10(((SNumeric) parArgs.get(0)).getFloatValue()));
			}
		};
		functions.put("log10", locFunc);
		functions.put("Log10", locFunc);

		locFunc = new PredefinedFunction<SInteger>(locParamsTypes, SInteger.DEFAULT_S32) {
			@Override
			public SInteger eval(List<SType> parArgs) throws InterruptedException {
				return new SInteger(((SNumeric) parArgs.get(0)).getLongValue(), STypeSize.S32);
			}
		};
		functions.put("trunc", locFunc);
		functions.put("Trunc", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				float locValue = ((SNumeric) parArgs.get(0)).getFloatValue();
				return new SFloat(locValue - (long) locValue);
			}
		};
		functions.put("frac", locFunc);
		functions.put("Frac", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.ceil(((SNumeric) parArgs.get(0)).getFloatValue()));
			}
		};
		functions.put("ceil", locFunc);
		functions.put("Ceil", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.floor(((SNumeric) parArgs.get(0)).getFloatValue()));
			}
		};
		functions.put("floor", locFunc);
		functions.put("Floor", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.cos(((SNumeric) parArgs.get(0)).getFloatValue() * Math.PI / 180));
			}
		};
		functions.put("cosd", locFunc);
		functions.put("CosD", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.sin(((SNumeric) parArgs.get(0)).getFloatValue() * Math.PI / 180));
			}
		};
		functions.put("sind", locFunc);
		functions.put("SinD", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.tan(((SNumeric) parArgs.get(0)).getFloatValue() * Math.PI / 180));
			}
		};
		functions.put("tand", locFunc);
		functions.put("TanD", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.acos(((SNumeric) parArgs.get(0)).getFloatValue()) * 180 / Math.PI);
			}
		};
		functions.put("acosd", locFunc);
		functions.put("AcosD", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.asin(((SNumeric) parArgs.get(0)).getFloatValue()) * 180 / Math.PI);
			}
		};
		functions.put("asind", locFunc);
		functions.put("AsinD", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.atan(((SNumeric) parArgs.get(0)).getFloatValue()) * 180 / Math.PI);
			}
		};
		functions.put("atand", locFunc);
		functions.put("AtanD", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.cosh(((SNumeric) parArgs.get(0)).getFloatValue() * Math.PI / 180));
			}
		};
		functions.put("coshd", locFunc);
		functions.put("CoshD", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.sinh(((SNumeric) parArgs.get(0)).getFloatValue() * Math.PI / 180));
			}
		};
		functions.put("sinhd", locFunc);
		functions.put("SinhD", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.tanh(((SNumeric) parArgs.get(0)).getFloatValue() * Math.PI / 180));
			}
		};
		functions.put("tanhd", locFunc);
		functions.put("TanhD", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.abs(((SNumeric) parArgs.get(0)).getFloatValue()));
			}
		};
		functions.put("abs", locFunc);

		locFunc = new PredefinedFunction<SInteger>(locParamsTypes, SInteger.DEFAULT_S8) {
			@Override
			public SInteger eval(List<SType> parArgs) throws InterruptedException {
				return new SInteger(((SNumeric) parArgs.get(0)).getFloatValue() < 0 ? -1 : 1, STypeSize.S8);
			}
		};
		functions.put("sign", locFunc);

		locFunc = new PredefinedFunction<SInteger>(locParamsTypes, SInteger.DEFAULT_U8) {
			@Override
			public SInteger eval(List<SType> parArgs) throws InterruptedException {
				return new SInteger(((SNumeric) parArgs.get(0)).getFloatValue() == Float.NaN);
			}
		};
		functions.put("isNAN", locFunc);

		locParamsTypes.add(SFloat.DEFAULT_FLOAT);
		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.atan2(((SNumeric) parArgs.get(0)).getFloatValue(), ((SNumeric) parArgs.get(1)).getFloatValue()));
			}
		};
		functions.put("atan2", locFunc);
		functions.put("Atan2", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.atan2(((SNumeric) parArgs.get(0)).getFloatValue(), ((SNumeric) parArgs.get(1)).getFloatValue()) * 180 / Math.PI);
			}
		};
		functions.put("atan2d", locFunc);
		functions.put("Atan2d", locFunc);

		locFunc = new PredefinedFunction<SFloat>(locParamsTypes, SFloat.DEFAULT_FLOAT) {
			@Override
			public SFloat eval(List<SType> parArgs) throws InterruptedException {
				return new SFloat(Math.pow(((SNumeric) parArgs.get(0)).getFloatValue(), ((SNumeric) parArgs.get(1)).getFloatValue()));
			}
		};
		functions.put("pow", locFunc);
		functions.put("Pow", locFunc);

		locParamsTypes.clear();
		locParamsTypes.add(SInteger.DEFAULT_S32);
		locParamsTypes.add(SInteger.DEFAULT_S32);
		locParamsTypes.add(SInteger.DEFAULT_S32);
		locFunc = new PredefinedFunction<SInteger>(locParamsTypes, SInteger.DEFAULT_S32) {
			@Override
			public SInteger eval(List<SType> parArgs) throws InterruptedException {
				return new SInteger(((SNumeric) parArgs.get(0)).getLongValue() * ((SNumeric) parArgs.get(1)).getLongValue() / ((SNumeric) parArgs.get(2)).getLongValue(), STypeSize.S32);
			}
		};
		functions.put("muldiv32", locFunc);
		functions.put("MulDiv32", locFunc);

		locParamsTypes.clear();
		locParamsTypes.add(SInteger.DEFAULT_U8);
		locFunc = new PredefinedFunction<SInteger>(locParamsTypes, SInteger.DEFAULT_U8) {
			@Override
			public SInteger eval(List<SType> parArgs) throws InterruptedException {
				return new SInteger((((SNumeric) parArgs.get(0)).getLongValue() >> 4) * 10
						+ ((SNumeric) parArgs.get(0)).getLongValue() & 0xFF, STypeSize.U8);
			}
		};
		functions.put("bcd2dec", locFunc);
		/*
		 * End of cmath API functions
		 */

		/*
		 * cstdlib API functions
		 */
		locParamsTypes.clear();
		locParamsTypes.add(SInteger.DEFAULT_U16);
		locFunc = new PredefinedFunction<SInteger>(locParamsTypes, SInteger.DEFAULT_S16) {
			private final Random random = new Random();

			@Override
			public boolean nbArgsOK(int parNbArgs) {
				return parNbArgs < 2;
			}

			@Override
			public boolean argsTypesOK(List<SType> parArgs) {
				if (parArgs.isEmpty()) {
					return true;
				}
				return parArgs.get(0) instanceof SInteger;
			}

			@Override
			public SInteger eval(List<SType> parArgs) throws InterruptedException {
				if (parArgs.isEmpty()) {
					return new SInteger(this.random.nextInt(), STypeSize.S16);
				} else {
					SInteger locArg = (SInteger) this.parameters.get(0).clone();
					locArg.setValue(parArgs.get(0));
					return new SInteger(this.random.nextInt((int) locArg.getLongValue()), STypeSize.U16);
				}
			}
		};
		functions.put("Random", locFunc);
		/*
		 * End of cstdlib API functions
		 */


		/*
		 * Command module functions
		 */
		locParamsTypes.clear();
		locFunc = new PredefinedFunction<SType>(locParamsTypes, SType.VOID) {
			@Override
			public SType eval(List<SType> parArgs) throws InterruptedException {
				//MessageDispatcher.instance().dispatch(new StopProgramMessage());
				return this.returnType;
			}
		};
		functions.put("StopAllTasks", locFunc);

		locParamsTypes.add(SMutex.DEFAULT_MUTEX);
		locFunc = new PredefinedFunction<SType>(locParamsTypes, SType.VOID) {
			@Override
			public SType eval(List<SType> parArgs) throws InterruptedException {
				((SMutex) parArgs.get(0)).lock();
				return this.returnType;
			}
		};
		functions.put("Acquire", locFunc);

		locFunc = new PredefinedFunction<SType>(locParamsTypes, SType.VOID) {
			@Override
			public SType eval(List<SType> parArgs) throws InterruptedException {
				((SMutex) parArgs.get(0)).unlock();
				return this.returnType;
			}
		};
		functions.put("Release", locFunc);

		locParamsTypes.clear();
		locParamsTypes.add(new SInteger(STypeSize.U32));
		locFunc = new PredefinedFunction<SType>(locParamsTypes, SType.VOID) {
			@Override
			public SType eval(List<SType> parArgs) throws InterruptedException {
				Thread.sleep(((SNumeric) parArgs.get(0)).getLongValue());
				return this.returnType;
			}
		};
		functions.put("Wait", locFunc);

		locFunc = new PredefinedFunction<SType>(locParamsTypes, SType.VOID) {
			@Override
			public SType eval(List<SType> parArgs) throws InterruptedException {
				System.out.println(((SNumeric) parArgs.get(0)).getLongValue());
				return this.returnType;
			}
		};
		functions.put("Print", locFunc);
		/*
		 * End of Command module functions
		 */


	}
}

abstract class MotorPredefinedFunction<T extends SType> extends PredefinedFunction<T> {

	protected MotorPredefinedFunction(List<SType> parParams, T parRetType) {
		super(parParams, parRetType);
	}

	public int convertMotorIndex(int parIndex) {
		switch (parIndex) {
			case 0:
				return 1;
			case 1:
				return 2;
			case 2:
				return 4;
			case 3:
				return 3;
			case 4:
				return 5;
			case 5:
				return 6;
			case 6:
				return 7;
		}
		return parIndex;
	}
}
