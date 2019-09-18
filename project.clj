(defproject bankocr "0.1.0-SNAPSHOT"
  :description "A Clojure library designed to solve http://codingdojo.org/kata/BankOCR/"
  :url "https:/github.com/kliph/bankocr"
  :license {:name "Apache-2.0"
            :url "https://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :repl-options {:init-ns bankocr.core}
  :profiles {:dev {:plugins [[com.jakemccrary/lein-test-refresh "0.24.1"]]}})
