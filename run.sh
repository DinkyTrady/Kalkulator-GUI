#!/usr/bin/env bash

# This file only can run on UNIX based system such as Linux, MacOS, and Android
javac -d out app/src/Main.java
java -cp out src/Main
