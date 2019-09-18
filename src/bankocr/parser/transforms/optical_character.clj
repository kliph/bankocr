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
                   "|_|"]) 0
                 (strings->optical-character
                  ["   "
                   "  |"
                   "  |"]) 1
                 (strings->optical-character
                  [" _ "
                   " _|"
                   "|_ "]) 2
                 (strings->optical-character
                  [" _ "
                   " _|"
                   " _|"]) 3
                 (strings->optical-character
                  ["   "
                   "|_|"
                   "  |"]) 4
                 (strings->optical-character
                  [" _ "
                   "|_ "
                   " _|"]) 5
                 (strings->optical-character
                  [" _ "
                   "|_ "
                   "|_|"]) 6
                 (strings->optical-character
                  [" _ "
                   "  |"
                   "  |"]) 7
                 (strings->optical-character
                  [" _ "
                   "|_|"
                   "|_|"]) 8
                 (strings->optical-character
                  [" _ "
                   "|_|"
                   " _|"]) 9})

(defn optical-character->account-digit [optical-character]
  (get characters optical-character))

(defn optical-characters->account-number [optical-characters]
  (s/conform ::spec/account-number
             (map optical-character->account-digit optical-characters)))
