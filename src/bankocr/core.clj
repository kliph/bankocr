(ns bankocr.core
  (:require [bankocr.parser.core :as parser]
            [bankocr.parser.validations.account-number :as validater]))

(def parse-document parser/parse-document)
(def validate-account-number validater/validate-account-number)
