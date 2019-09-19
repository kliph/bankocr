(ns bankocr.parser.validations.account-number
  (:require [clojure.spec.alpha :as s]))

(defn account-number->weights [account-number]
  (map-indexed (fn [idx digit]
                 (let [weight (- 9 idx)]
                   (* weight digit)))
               account-number))

(defn checksum?
  "Predicate checking whether a conformed Account Number has a valid checksum."
  [account-number]
  (let [weights (account-number->weights account-number)
        computed-sum (reduce + weights)]
    (zero? (mod computed-sum
                11))))

(defn validate-account-number
  "Takes a conformed Account Number and returns a Valid Accounted Number
  conforming to `:bankocr.parser.spec/validated-account-number`"
  [account-number]
  (s/conform :bankocr.parser.spec/validated-account-number account-number))
