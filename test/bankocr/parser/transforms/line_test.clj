(ns bankocr.parser.transforms.line-test
  (:require [clojure.test :refer :all]
            [bankocr.parser.transforms.line :as line]))

(defonce conformed-line {:top    " _  _  _  _  _  _  _  _  _ "
                         :middle "| || || || || || || || || |"
                         :bottom "|_||_||_||_||_||_||_||_||_|"})

(defonce lines [conformed-line])

(deftest line->optical-characters
  (testing "transforms a line to conformed optical characters"
    (is (= '({:top (\space \_ \space)
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
              :bottom (\| \_ \|)})
           (line/line->optical-characters conformed-line)))))

