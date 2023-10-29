#!/bin/bash
gradle build
java -cp lib/build/libs/lib.jar fr/univartois/butinfo/sae301/main/Main "$1"