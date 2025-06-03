#!/bin/bash -ex

javac -d bin src/assignment4/Sort.java
javac -d bin -cp bin src/assignment4/SortDriver.java
java -cp bin assignment4.SortDriver ordered.txt
