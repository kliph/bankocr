(ns bankocr.parser.transforms.optical-character-test
  (:require [clojure.test :refer :all]
            [bankocr.parser.transforms.optical-character :as oc]))

(def conformed-optical-characters '({:top (\space \_ \space)
                                     :middle (\| \space \|)
                                     :bottom (\| \_ \|)}
                                    {:top (\space \_ \space)
                                     :middle (\| \space \|)
                                     :bottom (\| \_ \|)}
                                    {:top (\space \_ \space)
                                     :middle (\| \space \|)
                                     :bottom (\| \_ \|)}
                                    {:top (\space \_ \space)
                                     :middle (\| \space \|)
                                     :bottom (\| \_ \|)}
                                    {:top (\space \_ \space)
                                     :middle (\| \space \|)
                                     :bottom (\| \_ \|)}
                                    {:top (\space \_ \space)
                                     :middle (\| \space \|)
                                     :bottom (\| \_ \|)}
                                    {:top (\space \_ \space)
                                     :middle (\| \space \|)
                                     :bottom (\| \_ \|)}
                                    {:top (\space \_ \space)
                                     :middle (\| \space \|)
                                     :bottom (\| \_ \|)}
                                    {:top (\space \_ \space)
                                     :middle (\| \space \|)
                                     :bottom (\| \_ \|)}))

(def conformed-zero (first conformed-optical-characters))

(def string-zero [" _ "
                  "| |"
                  "|_|"])

(def conformed-account-number '([:digit 0]
                                [:digit 0]
                                [:digit 0]
                                [:digit 0]
                                [:digit 0]
                                [:digit 0]
                                [:digit 0]
                                [:digit 0]
                                [:digit 0]))

(deftest strings->optical-character
  (testing "transforms a vector of strings to a conformed optical character"
    (is (= conformed-zero
           (oc/strings->optical-character string-zero)))))

(deftest optical-character->account-digit
  (testing "transforms an optical character to an account digit"
    (is (= 0
           (oc/optical-character->account-digit conformed-zero)))))

(deftest optical-characters->account-number
  (is (= conformed-account-number
         (oc/optical-characters->account-number conformed-optical-characters))))
