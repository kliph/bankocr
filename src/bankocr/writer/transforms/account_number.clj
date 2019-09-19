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
  [conformed-account-number]
  (cond
    (contains-illegible? conformed-account-number) "ILL"
    (s/valid?
     :bankocr.parser.spec/validated-account-number
     (an/conformed-account-number->account-digits conformed-account-number)) ""
    :else "ERR"))
