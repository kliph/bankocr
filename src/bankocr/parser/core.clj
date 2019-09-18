(ns bankocr.parser.core
  (:require [bankocr.parser.transforms.document :as doc]
            [bankocr.parser.transforms.line :as line]
            [bankocr.parser.transforms.optical-character :as oc]))

(defn parse-document [filename]
  (let [document (slurp filename)]
    (->> document
         doc/document->lines
         line/lines->optical-characters
         (map oc/optical-characters->account-number))))

