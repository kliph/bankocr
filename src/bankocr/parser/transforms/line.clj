(ns bankocr.parser.transforms.line)

(defn split-entries [lines]
  (partition-by #(= "" %) lines))

(defn remove-blanks [lines]
  (filterv #(not= '("") %) lines))

