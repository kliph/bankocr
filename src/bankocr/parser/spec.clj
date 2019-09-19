(ns bankocr.parser.spec
  (:require [clojure.spec.alpha :as s]
            [bankocr.parser.validations.account-number :refer [checksum?]]))

(s/def ::account-number (s/and
                         (s/coll-of ::account-character)
                         #(= 9 (count %))))
(s/def ::validated-account-number (s/and (s/coll-of ::account-digit)
                                         #(= 9 (count %))
                                         #(checksum? %)))
(s/def ::account-digit (s/and number? #(>= % 0) #(<= % 9)))
(s/def ::account-character (s/or :digit ::account-digit
                                 :illegible #{\?}))


(s/def ::optical-character-line (s/coll-of char?))
(s/def ::parsed-optical-character-triple (s/cat :top ::optical-character-line
                                                :middle ::optical-character-line
                                                :bottom ::optical-character-line))
(s/def ::optical-characters (s/coll-of ::parsed-optical-character-triple))

(s/def ::parsed-line-triple (s/cat :top string? :middle string? :bottom string?))
(s/def ::lines (s/coll-of ::parsed-line-triple))
