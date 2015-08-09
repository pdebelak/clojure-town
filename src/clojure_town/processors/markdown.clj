(ns clojure-town.processors.markdown
  (:use markdown.core))

(defn to-markdown
  [text]
  (md-to-html-string text))
