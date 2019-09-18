(ns bankocr.parser.transforms.optical-character
  (:require [bankocr.parser.spec :as spec]
            [clojure.spec.alpha :as s]))

(defn strings->optical-character [strings]
  (s/conform ::spec/parsed-optical-character-triple
             (map #(->> %
                        (partition 3)
                        first)
                  strings)))

(def characters {(strings->optical-character
                  [" _ "
                   "| |"
                   "|_|"]) 0})

(defn optical-character->account-digit [optical-character]
  (get characters optical-character))

(defn optical-characters->account-number [optical-characters]
  (s/conform ::spec/account-number
             (map optical-character->account-digit optical-characters)))
