(ns bankocr.parser.transforms.document-test
  (:require [clojure.test :refer :all]
            [bankocr.parser.transforms.document :as doc]))

(def document (slurp "./resources/all-zeros.txt"))

(deftest document->lines
  (testing "transforms a document to conformed lines"
    (is (= [{:top    " _  _  _  _  _  _  _  _  _ "
             :middle "| || || || || || || || || |"
             :bottom "|_||_||_||_||_||_||_||_||_|"}]
           (doc/document->lines document)))))
