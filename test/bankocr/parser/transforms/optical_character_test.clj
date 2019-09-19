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

(def conformed-junk (oc/strings->optical-character [" _ "
                                                    " _ "
                                                    " _|"]))

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

(deftest optical-character->account-character
  (testing "transforms an optical character to an account digit"
    (is (= 0
           (oc/optical-character->account-character conformed-zero))))
  (testing "transforms an optical character to an illegible account character"
    (is (= \?
           (oc/optical-character->account-character conformed-junk)))))

(deftest optical-characters->conformed-account-number
  (is (= conformed-account-number
         (oc/optical-characters->conformed-account-number conformed-optical-characters))))
