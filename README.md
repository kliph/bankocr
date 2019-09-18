# bankocr

A Clojure library designed to solve the [Bank OCR problem](http://codingdojo.org/kata/BankOCR/#resources).

## Glossary

### Document
A collection of scanned Account Numbers arranged as Entries in a text file.

### Entry
Each entry is 4 Lines long, and each line has 27 characters. The first 3 lines of each entry contain an Account Number written using pipes and underscores (an Optical Character), and the fourth line is blank.

### Line
A single line of the Document.

### Optical Characters
The scanned digits represented by pipes and underscores as a seven-segment display.

### Account Number
A collection of 9 Account Digits.

### Account Digit
A single digit of the account number within the range 0-9.

## Usage

## Running the tests

To run the tests once:
```sh
lein test
```

To run the tests continuously, refreshing when files change:
```sh
lein test-refresh
```
