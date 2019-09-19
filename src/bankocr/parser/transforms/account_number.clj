(ns bankocr.parser.transforms.account-number)

(defn conformed-account-number->account-digits [conformed-account-number]
  (if (= conformed-account-number :clojure.spec.alpha/invalid)
    :clojure.spec.alpha/invalid
    (map (fn [conformed-account-character]
           (last conformed-account-character))
         conformed-account-number)))
