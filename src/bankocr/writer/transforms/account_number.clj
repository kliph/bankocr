(ns bankocr.writer.transforms.account-number)

(defn contains-illegible?
  [conformed-account-number]
  (let [any? (comp boolean some)]
    (any? #{:illegible}
          (map (fn [account-number]
                 (first account-number))
               conformed-account-number))))

(defn conformed-account-number->status
  [conformed-account-number]
  (if (contains-illegible? conformed-account-number)
    "ILL"
    ""))
