(ns bankocr.writer.transforms.account-number-test
  (:require [clojure.test :refer :all]
            [bankocr.writer.transforms.account-number :as an]))


(def valid-conformed-account-number
  '([:digit 0]
    [:digit 0]
    [:digit 0]
    [:digit 0]
    [:digit 0]
    [:digit 0]
    [:digit 0]
    [:digit 5]
    [:digit 1]))

(def invalid-conformed-account-number
  '([:digit 6]
    [:digit 6]
    [:digit 4]
    [:digit 3]
    [:digit 7]
    [:digit 1]
    [:digit 4]
    [:digit 9]
    [:digit 5]))

(def single-illegible-conformed-account-number
  '([:digit 4]
    [:digit 9]
    [:digit 0]
    [:digit 0]
    [:digit 6]
    [:digit 7]
    [:digit 7]
    [:digit 1]
    [:illegible \?]))

(def multiple-illegible-conformed-account-number
  '([:digit 1]
    [:digit 2]
    [:digit 3]
    [:digit 4]
    [:illegible \?]
    [:digit 6]
    [:digit 7]
    [:digit 8]
    [:illegible \?]))

(deftest conformed-account-number->status
  (testing "returns an empty string when the conformed account number is valid"
    (is (= ""
           (an/conformed-account-number->status
            valid-conformed-account-number))))
  (testing "returns ILL when the conformed account number has illegible characters"
    (is (= "ILL"
           (an/conformed-account-number->status
            single-illegible-conformed-account-number)))
    (is (= "ILL"
           (an/conformed-account-number->status
            multiple-illegible-conformed-account-number))))
  (testing "returns ERR when the the conformed account number is not valid"
    (is (= "ERR"
           (an/conformed-account-number->status
            invalid-conformed-account-number)))))

(deftest contains-illegible?
  (testing "returns false when a conformed account number does not contain an illegible character"
    (is (= false
           (an/contains-illegible? valid-conformed-account-number))))
  (testing "returns true when a conformed account number contains illegible characters"
    (is (= true
           (an/contains-illegible? single-illegible-conformed-account-number)))
    (is (= true
           (an/contains-illegible? multiple-illegible-conformed-account-number)))))

(deftest conformed-account-number->writer-line
  (testing "returns the correct string for a valid conformed account number"
    (is (= "000000051 "
           (an/conformed-account-number->writer-line valid-conformed-account-number)))
    (is (= "49006771? ILL"
           (an/conformed-account-number->writer-line single-illegible-conformed-account-number)))
    (is (= "1234?678? ILL"
           (an/conformed-account-number->writer-line multiple-illegible-conformed-account-number)))))
