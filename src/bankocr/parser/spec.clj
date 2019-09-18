(ns bankocr.parser.spec
  (:require [clojure.spec.alpha :as s]
            [bankocr.parser.validations.account-number :refer [checksum?]]))

(defmacro base-account-number
  "Helper macro for generating account number specs. Allows for extended
  functionality on top of the basic account number spec, such as
  validating a checksum."
  [& additional-predicates]
  `(s/and
    (s/coll-of ::account-digit)
    #(= 9 (count %))
    ~@additional-predicates))

(s/def ::account-number (base-account-number))
(s/def ::validated-account-number (base-account-number #(checksum? %)))
(s/def ::account-digit (s/and number? #(>= % 0) #(<= % 9)))

(s/def ::optical-character-line (s/coll-of char?))
(s/def ::parsed-optical-character-triple (s/cat :top ::optical-character-line
                                                :middle ::optical-character-line
                                                :bottom ::optical-character-line))
(s/def ::optical-characters (s/coll-of ::parsed-optical-character-triple))

(s/def ::parsed-line-triple (s/cat :top string? :middle string? :bottom string?))
(s/def ::lines (s/coll-of ::parsed-line-triple))
