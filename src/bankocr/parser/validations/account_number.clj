(ns bankocr.parser.validations.account-number
  (:require [clojure.spec.alpha :as s]))

(defn calc-single-digit [accumulator digit remaining-digits]
  (+ accumulator
     (* digit
        (inc (count remaining-digits)))))

(defn checksum?
  "Predicate checking whether a conformed Account Number has a valid checksum."
  [account-number]
  (let [computed-sum (loop [acc 0
                            [digit & remaining-digits] account-number]
                       (if (empty? remaining-digits)
                         (calc-single-digit acc digit remaining-digits)
                         (recur (calc-single-digit acc digit remaining-digits)
                                remaining-digits)))]
    (zero? (mod computed-sum
                11))))

(defn validate-account-number
  "Takes a conformed Account Number and returns a Valid Accounted Number
  conforming to `:bankocr.parser.spec/validated-account-number`"
  [account-number]
  (s/conform :bankocr.parser.spec/validated-account-number account-number))
