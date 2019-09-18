(ns bankocr.parser.transforms.document
  (:require [bankocr.parser.transforms.line :as line]
            [bankocr.parser.spec :as spec]
            [clojure.spec.alpha :as s]))

(defn document->lines
  "Accepts a `document` which is then divided into Entries with blank
  lines removed.  Returns a collection of Lines conforming to
  `::bankocr.parser.spec/lines`"
  [document]
  (->> document
       clojure.string/split-lines
       line/split-entries
       line/remove-blanks
       (s/conform ::spec/lines)))
