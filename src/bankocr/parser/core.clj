(ns bankocr.parser.core
  (:require [bankocr.parser.transforms.document :as doc]
            [bankocr.parser.transforms.account-number :as an]))

(defn parse-to-conformed-account-numbers
  "Accepts a `filename` such as `./resources/all-zeros.txt` and parses
  all of the Entries in that file, returning a collection of Account
  Numbers conforming to `:bankocr.parser.spec/account-number`"
  [filename]
  (let [document (slurp filename)]
    (->> document
         doc/document->conformed-account-numbers)))

(defn parse-document
  "Accepts a `filename` such as `./resources/all-zeros.txt` and parses
  all of the Entries in that file, returning a collection of Account
  Numbers"
  [filename]
  (->> filename
       parse-to-conformed-account-numbers
       (map an/conformed-account-number->account-digits)))
