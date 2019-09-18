(ns bankocr.parser.spec
  (:require [clojure.spec.alpha :as s]))

(s/def ::parsed-line-triple (s/cat :top string? :middle string? :bottom string?))
(s/def ::lines (s/coll-of ::parsed-line-triple))
