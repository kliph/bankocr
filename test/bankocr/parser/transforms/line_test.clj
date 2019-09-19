(ns bankocr.parser.transforms.line-test
  (:require [clojure.test :refer :all]
            [bankocr.parser.transforms.line :as line]))

(def conformed-line {:top    " _  _  _  _  _  _  _  _  _ "
                     :middle "| || || || || || || || || |"
                     :bottom "|_||_||_||_||_||_||_||_||_|"})

(def lines [conformed-line
            conformed-line])

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

(deftest line->optical-characters
  (testing "transforms a line to conformed optical characters"
    (is (= conformed-optical-characters
           (line/line->optical-characters conformed-line)))))

(deftest lines->optical-characters
  (testing "transforms lines to a vector of conformed optical characters"
    (is (= [conformed-optical-characters
            conformed-optical-characters]
           (line/lines->optical-characters lines)))))
