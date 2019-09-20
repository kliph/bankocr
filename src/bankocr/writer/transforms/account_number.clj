(ns bankocr.writer.transforms.account-number
  (:require [bankocr.parser.transforms.account-number :as an]
            [clojure.spec.alpha :as s]))

(defn contains-illegible?
  [conformed-account-number]
  (let [any? (comp boolean some)]
    (any? #{:illegible}
          (map (fn [account-number]
                 (first account-number))
               conformed-account-number))))

(defn conformed-account-number->status
  "Takes a conformed Account Number and returns one of three possible statuses:
  ILL if the Account Number contains illegible Account Characters
  An empty string if the Account Number is valid
  ERR otherwise."
  [conformed-account-number]
  (cond
    (contains-illegible? conformed-account-number) "ILL"
    (s/valid?
     :bankocr.parser.spec/validated-conformed-account-number
     conformed-account-number) ""
    :else "ERR"))

(defn conformed-account-number->writer-line
  "Takes a conformed account number and returns a string containing the
  formatted account number and status.  These tuples constitute a
  single line of the writer's output files"
  [conformed-account-number]
  (str
   (apply str
          (an/conformed-account-number->account-digits conformed-account-number))
   " "
   (conformed-account-number->status conformed-account-number)))
