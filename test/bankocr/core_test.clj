(ns bankocr.core-test
  (:require [clojure.test :refer :all]
            [bankocr.core :as ocr]))

(deftest parse-document
  (testing "parses an Account Number of all zeros"
    (is (= (first (ocr/parse-document "./resources/all-zeros.txt"))
           '(0 0 0 0 0 0 0 0 0))))
  (testing "parses a Document with multiple Account Number Entries"
    (is (= (ocr/parse-document "./resources/multiple-entries.txt")
           '((0 0 0 0 0 0 0 0 0)
             (0 0 0 0 0 0 0 0 0)))))
  (testing "parses all valid non-zero digits"
    (is (= (first (ocr/parse-document "./resources/all-non-zero-digits.txt"))
           '(1 2 3 4 5 6 7 8 9)))))
