(ns bankocr.parser.validations.account-number
  (:require [bankocr.parser.transforms.account-number :as account-number]
            [clojure.spec.alpha :as s]))

(defn account-digits->weights [account-digits]
  (map-indexed (fn [idx digit]
                 (let [weight (- 9 idx)]
                   (* weight digit)))
               account-digits))

(defn checksum?
  "Predicate checking whether a sequence of Account Digits has a valid checksum."
  [account-digits]
  (let [weights (account-digits->weights
                 account-digits)
        computed-sum (reduce + weights)]
    (zero? (mod computed-sum
                11))))

(defn validate-account-number
  "Takes a conformed Account Number and returns a sequence of digits for
  the Valid Accounted Number conforming to
  `:bankocr.parser.spec/validated-account-number`"
  [conformed-account-number]
  (s/conform :bankocr.parser.spec/validated-account-number
             (account-number/conformed-account-number->account-digits conformed-account-number)))
