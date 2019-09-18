(ns bankocr.parser.validations.account-number-test
  (:require [clojure.test :refer :all]
            [bankocr.parser.validations.account-number :as validater]))

(def valid-account-number '(3 4 5 8 8 2 8 6 5))
(def invalid-account-number '(3 4 5 8 8 2 8 6 0))

(deftest checksum?
  (testing "returns true if the account number is valid"
    (is (= true
           (validater/checksum? valid-account-number))))
  (testing "returns false if the account number is invalid"
    (is (= false
           (validater/checksum? invalid-account-number)))))

(deftest validate-account-number
  (testing "returns a conformed validated-account-number"
    (is (= valid-account-number
           (validater/validate-account-number valid-account-number)))
    (is (= :clojure.spec.alpha/invalid
           (validater/validate-account-number invalid-account-number)))))
