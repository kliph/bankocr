(ns bankocr.parser.transforms.document
  (:require [bankocr.parser.transforms.line :as line]
            [bankocr.parser.transforms.optical-character :as oc]
            [bankocr.parser.spec :as spec]
            [clojure.spec.alpha :as s]))

(defn document->lines
  "Accepts a `document` which is then divided into Entries with blank
  lines removed.  Returns a collection of Lines conforming to
  `:bankocr.parser.spec/lines`"
  [document]
  (->> document
       clojure.string/split-lines
       line/split-entries
       line/remove-blanks
       (s/conform ::spec/lines)))

(defn document->conformed-account-numbers
  "Accepts a `document` which is then divided into Entries with blank
  lines removed.  Returns a collection of Account Numbers conforming to
  `:bankocr.parser.spec/account-number`"
  [document]
  (->> document
       document->lines
       line/lines->optical-characters
       (map oc/optical-characters->conformed-account-number)))
