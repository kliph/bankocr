(ns bankocr.parser.core
  (:require [bankocr.parser.transforms.document :as doc]
            [bankocr.parser.transforms.line :as line]
            [bankocr.parser.transforms.optical-character :as oc]))

(defn parse-document
  "Accepts a `filename` such as `./resources/all-zeros.txt` and parses
  all of the Entries in that file, returning a collection of Account
  Numbers"
  [filename]
  (let [document (slurp filename)]
    (->> document
         doc/document->lines
         line/lines->optical-characters
         (map oc/optical-characters->account-number))))

