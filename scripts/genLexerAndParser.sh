#!/bin/bash
# Auteur : Adrien DUROY
# Ce script génère le code de l'analyseur lexical et du parser.

GRAMMAR="../grammaire/NXC.g"
if [ -f $GRAMMAR ]
then
	echo "Génération de l'analyseur lexical et du parser ..."
	java -cp ../lib/antlr-3.3.jar org.antlr.Tool $GRAMMAR
    echo "fait"
    rm -v NXC.tokens
	mv -v ../grammaire/NXC*.java ../src/jscratch/interpreteur/parser
else
	echo "Le fichier NXC.g contenant la grammaire est absent !" >&2
fi
