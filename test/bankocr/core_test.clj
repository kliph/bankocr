(ns bankocr.core-test
  (:require [clojure.test :refer :all]
            [bankocr.core :as ocr]))

(deftest parse-document
  (testing "reads an account number of all zeros"
    (is (= (ocr/parse-document "./resources/all-zeros.txt")
           '(0 0 0 0 0 0 0 0 0)))))
