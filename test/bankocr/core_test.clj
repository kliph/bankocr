(ns bankocr.core-test
  (:require [clojure.test :refer :all]
            [bankocr.core :as ocr]))

(deftest parse-document
  (testing "parses an Account Number of all zeros"
    (is (= (first (ocr/parse-document "./resources/all-zeros.txt"))
           '(0 0 0 0 0 0 0 0 0))))
  (testing "parses an Account number of all ones"
    (is (= (first (ocr/parse-document "./resources/all-ones.txt"))
           '(1 1 1 1 1 1 1 1 1))))
  (testing "parses an Account number of all twos"
    (is (= (first (ocr/parse-document "./resources/all-twos.txt"))
           '(2 2 2 2 2 2 2 2 2))))
  (testing "parses an Account number of all threes"
    (is (= (first (ocr/parse-document "./resources/all-threes.txt"))
           '(3 3 3 3 3 3 3 3 3))))
  (testing "parses an Account number of all fours"
    (is (= (first (ocr/parse-document "./resources/all-fours.txt"))
           '(4 4 4 4 4 4 4 4 4))))
  (testing "parses an Account number of all fives"
    (is (= (first (ocr/parse-document "./resources/all-fives.txt"))
           '(5 5 5 5 5 5 5 5 5))))
  (testing "parses an Account number of all sixes"
    (is (= (first (ocr/parse-document "./resources/all-sixes.txt"))
           '(6 6 6 6 6 6 6 6 6))))
  (testing "parses an Account number of all sevens"
    (is (= (first (ocr/parse-document "./resources/all-sevens.txt"))
           '(7 7 7 7 7 7 7 7 7))))
  (testing "parses an Account number of all eights"
    (is (= (first (ocr/parse-document "./resources/all-eights.txt"))
           '(8 8 8 8 8 8 8 8 8))))
  (testing "parses an Account number of all nines"
    (is (= (first (ocr/parse-document "./resources/all-nines.txt"))
           '(9 9 9 9 9 9 9 9 9))))
  (testing "parses a Document with multiple Account Number Entries"
    (is (= (ocr/parse-document "./resources/multiple-entries.txt")
           '((0 0 0 0 0 0 0 0 0)
             (0 0 0 0 0 0 0 0 0)))))
  (testing "parses all valid non-zero digits"
    (is (= (first (ocr/parse-document "./resources/all-non-zero-digits.txt"))
           '(1 2 3 4 5 6 7 8 9))))
  (testing "parses use case 3-1"
    (is (= (first (ocr/parse-document "./resources/use-case-3-1.txt"))
           '(0 0 0 0 0 0 0 5 1))))
  (testing "parses use case 3-2"
    (is (= (first (ocr/parse-document "./resources/use-case-3-2.txt"))
           '(4 9 0 0 6 7 7 1 \?))))
  (testing "parses use case 3-3"
    (is (= (first (ocr/parse-document "./resources/use-case-3-3.txt"))
           '(1 2 3 4 \? 6 7 8 \?)))))

(deftest write-documents
  (testing "takes a list of files and writes one file each in the appropriate format"))
