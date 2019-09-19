(ns bankocr.writer.core-test
  (:require [clojure.test :refer :all]
            [bankocr.writer.core :as writer]))

(deftest write-document!
  (with-redefs [spit (fn [path body] [path body])]
    (is (= ["./resources/out/multiple-entries.txt"
            "000000000 \n000000000 "]
           (writer/write-document! "./resources/multiple-entries.txt")))
    (is (= ["./resources/out/use-case-3-3.txt"
            "1234?678? ILL"]
           (writer/write-document! "./resources/use-case-3-3.txt")))
    (is (= ["./resources/out/all-sevens.txt"
            "777777777 ERR"]
           (writer/write-document! "./resources/all-sevens.txt")))))
