(ns bankocr.core)

(defn parse-document [filename]
  (let [document (slurp filename)]
    document))
