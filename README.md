# Polynomial Roots Program

This is a small Java program that reads numbers (roots) from JSON files.  
Each root is given in some base (like binary, decimal, hex, etc).  
The program converts them to decimal, then forms a polynomial which has those roots, and finally gives the coefficients.

---

## Files in this repo
- `PolynomialSolver.java` → main code
- `input1.json` → first test input
- `input2.json` → second test input
- `output1.txt` → result for input1
- `output2.txt` → result for input2

---

## How to run

1. Compile the code (make sure you have the json jar file):
```bash
javac -cp .:json-20240303.jar PolynomialSolver.java
