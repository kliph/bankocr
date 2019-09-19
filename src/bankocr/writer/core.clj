(ns bankocr.writer.core
  (:require [bankocr.parser.core :as parser]
            [bankocr.writer.transforms.account-number :as an]))

(defn write-document!
  [filename]
  (let [lines (->> filename
                   parser/parse-to-conformed-account-numbers
                   (map an/conformed-account-number->writer-line))
        output-filename (.getName (clojure.java.io/file filename))
        output-path (str "./resources/out/" output-filename)]
    (spit output-path (clojure.string/join "\n" lines))))

(defn write-documents
  "Parses the files provided as `filenames` and writes an output file in
  `./resources/out/` containing parsed account numbers and metadata
  for each parsed file.  The output filenames will be identical to the
  input filenames."
  [filenames]
  (map write-document! filenames))
