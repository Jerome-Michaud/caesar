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
package editeurNXC.langage;

/**
 *
 * @author Newbo.O
 */
public class SInteger extends SNumeric {
    public static final SInteger TRUE = new SInteger(true);
    public static final SInteger FALSE = new SInteger(false);
    public static final SInteger DEFAULT_S8 = new SInteger(STypeSize.S8);
    public static final SInteger DEFAULT_U8 = new SInteger(STypeSize.U8);
    public static final SInteger DEFAULT_S16 = new SInteger(STypeSize.S16);
    public static final SInteger DEFAULT_U16 = new SInteger(STypeSize.U16);
    public static final SInteger DEFAULT_S32 = new SInteger(STypeSize.S32);
    public static final SInteger DEFAULT_U32 = new SInteger(STypeSize.U32);
    private long value;

    public SInteger(STypeSize parSize) {
        super(parSize);
    }
    
    public SInteger(long parValue, STypeSize parSize) {
        super(parSize);
        this.value = computeRealValue(parValue, parSize);
    }

    private static long computeRealValue(long parValue, STypeSize parSize) {
        switch (parSize) {
            case S8:    return (parValue&0x80) == 0 ? parValue&0xFF : parValue|~0xFFL;
            case U8:    return parValue&0xFF;
            case S16:   return (parValue&0x8000) == 0 ? parValue&0xFFFF : parValue|~0xFFFFL;
            case U16:   return parValue&0xFFFF;
            case S32:   return (parValue&0x80000000) == 0 ? parValue&0xFFFFFFFF : parValue|~0xFFFFFFFFL;
            case U32:   return parValue&0xFFFFFFFF;
            default:    return 0;
        }
    }

    public SInteger(boolean parValue) {
        super(STypeSize.U8);
        this.value = parValue ? 1 : 0;
    }

    @Override
    public float getFloatValue() {
        return (float) this.value;
    }

    @Override
    public long getLongValue() {
        return this.value;
    }

    @Override
    public boolean getBoolValue() {
        return this.value != 0;
    }

    @Override
    public void setValue(SType parValue) {
        assert(parValue instanceof SNumeric);
        this.value = computeRealValue(((SNumeric) parValue).getLongValue(), this.size);
    }

    @Override
    public SInteger clone() {
        return new SInteger(this.value, this.size);
    }
}