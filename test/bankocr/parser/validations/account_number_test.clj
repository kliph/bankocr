(ns bankocr.parser.validations.account-number-test
  (:require [clojure.test :refer :all]
            [bankocr.parser.validations.account-number :as validater]))

(def valid-account-digits '(3 4 5 8 8 2 8 6 5))
(def invalid-account-digits '(3 4 5 8 8 2 8 6 0))

(def valid-conformed-account-number '([:digit 3]
                                      [:digit 4]
                                      [:digit 5]
                                      [:digit 8]
                                      [:digit 8]
                                      [:digit 2]
                                      [:digit 8]
                                      [:digit 6]
                                      [:digit 5]))

(def invalid-conformed-account-number '([:digit 3]
                                        [:digit 4]
                                        [:digit 5]
                                        [:digit 8]
                                        [:digit 8]
                                        [:digit 2]
                                        [:digit 8]
                                        [:digit 6]
                                        [:digit 0]))

(deftest checksum?
  (testing "returns true if the account digits are valid"
    (is (= true
           (validater/checksum? valid-account-digits))))
  (testing "returns false if the account digits are invalid"
    (is (= false
           (validater/checksum? invalid-account-digits)))))

(deftest validate-account-number
  (testing "returns a the digits for a validated-account-number"
    (is (= valid-account-digits
           (validater/validate-account-number valid-conformed-account-number))))
  (testing "returns invalid for invalid account numbers"
    (is (= :clojure.spec.alpha/invalid
           (validater/validate-account-number invalid-conformed-account-number)))))
