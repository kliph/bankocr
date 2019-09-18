(ns bankocr.parser.transforms.line
  (:require [bankocr.parser.spec :as spec]
            [clojure.spec.alpha :as s]))

(defn split-entries [lines]
  (partition-by #(= "" %) lines))

(defn remove-blanks [lines]
  (filterv #(not= '("") %) lines))

(defn line->optical-characters [{top :top middle :middle bottom :bottom}]
  (let [partitioned-top (partition 3 top)
        partitioned-middle (partition 3 middle)
        partitioned-bottom (partition 3 bottom)
        optical-characters (partition 3 (interleave partitioned-top
                                                    partitioned-middle
                                                    partitioned-bottom))]
    (s/conform ::spec/optical-characters optical-characters)))

(defn lines->optical-characters
  "Takes a collection of `lines` and returns a parsed collection of
  Optical Characters conforming to
  `:bankocr.parser.spec/optical-characters`"
  [lines]
  (map #(line->optical-characters %) lines))
