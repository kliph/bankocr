(ns bankocr.parser.validations.account-number)

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
