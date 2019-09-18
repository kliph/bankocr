(ns bankocr.parser.spec
  (:require [clojure.spec.alpha :as s]))

(s/def ::optical-character-line (s/coll-of char?))
(s/def ::parsed-optical-character-triple (s/cat :top ::optical-character-line
                                                :middle ::optical-character-line
                                                :bottom ::optical-character-line))
(s/def ::optical-characters (s/coll-of ::parsed-optical-character-triple))

(s/def ::parsed-line-triple (s/cat :top string? :middle string? :bottom string?))
(s/def ::lines (s/coll-of ::parsed-line-triple))
