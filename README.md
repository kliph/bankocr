# bankocr

A Clojure library designed to solve the [Bank OCR problem](http://codingdojo.org/kata/BankOCR/#resources).

## Notable dependencies
- [Leiningen](https://leiningen.org/).  Please install it via the installation instructions [here](https://leiningen.org/#install).

## Glossary

### Document
A collection of scanned Account Numbers arranged as Entries in a text file.

### Entry
Each entry is 4 Lines long, and each line has 27 characters. The first 3 lines of each entry contain an Account Number written using pipes and underscores (an Optical Character), and the fourth line is blank.

### Line
A single line of the Document.

### Optical Characters
The scanned digits represented by pipes and underscores as a seven-segment display.

### Account Digits
A collection of 9 Account Digits.

### Account Number
A collection of 9 Account Characters that are either parsed Account Digits or illegible Optical Characters marked with `?`.

### Validated Account Number
An Account Number, containing only Account Digits, that has a valid checksum based on the algorithm outlined under User Story 2 [here](http://codingdojo.org/kata/BankOCR/#problem-description).

### Account Digit
A single digit of the account number within the range 0-9.

## Usage

### Writing documents per User Story 3
You can run the command by running `lein run -m bankocr.core/write-documents <filenames>` from the command line where `<filenames>` is a list of paths to the input files.

For example:

```sh
lein run -m bankocr.core/write-documents ./resources/all-zeros.txt ./resources/multiple-entries.txt
```

Will produce 2 files: `./resources/out/all-zeros.txt` and `./resources/out/multiple-entries.txt`.

## Running the tests

To run the tests once:
```sh
lein test
```

To run the tests continuously, refreshing when files change:
```sh
lein test-refresh
```
