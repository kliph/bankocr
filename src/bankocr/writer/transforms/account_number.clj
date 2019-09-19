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
