#!/bin/bash
# Construit la javadoc de CAESAR
cd $(dirname $0)
mkdir -p ../doc/javadoc
javadoc -charset "utf-8" -d ../doc/javadoc -sourcepath ../src/ -subpackages nxtim:jscratch
