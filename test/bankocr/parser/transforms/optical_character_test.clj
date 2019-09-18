(ns bankocr.parser.transforms.optical-character-test
  (:require [clojure.test :refer :all]
            [bankocr.parser.transforms.optical-character :as oc]))

(defonce conformed-zero {:top '(\space \_ \space)
                         :middle '(\| \space \|)
                         :bottom '(\| \_ \|)})

(defonce string-zero [" _ "
                      "| |"
                      "|_|"])

(deftest strings->optical-character
  (testing "transforms a vector of strings to a conformed optical character"
    (is (= conformed-zero
           (oc/strings->optical-character string-zero)))))

(deftest optical-character->account-digit
  (testing "transforms an optical character to an account digit"
    (is (= 0
           (oc/optical-character->account-digit conformed-zero)))))
