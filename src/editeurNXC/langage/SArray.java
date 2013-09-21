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
package editeurNXC.langage;

/**
 *
 * @author Newbo.O
 */
public class SArray extends SType {
    private final SType eltType;
    protected SType[] values;
    
    public SArray(SType parType) {
        this.eltType = parType;
    }
    
    public SArray(SType parType, long parSize) {
        this.eltType = parType;
        this.values = new SType[(int)parSize];
        for (int i = 0; i < parSize; ++i)
            this.values[i] = parType.clone();
    }

    public SType getElementType() {
        return this.eltType;
    }

    public SType getElement(int parIndex) {
        return this.values[parIndex];
    }

    @Override
    public boolean hasSameType(SType parOther) {
        return parOther instanceof SArray && this.eltType.hasSameType(((SArray)parOther).eltType);
    }

    @Override
    public SArray clone() {
        if (this.values == null)
            return new SArray(this.eltType);
        
        int locLen = this.values.length;
        SArray locClone = new SArray(this.eltType, locLen);
        for (int i = 0; i < locLen; ++i)
            locClone.values[i] = this.values[i].clone();
        return locClone;
    }
}