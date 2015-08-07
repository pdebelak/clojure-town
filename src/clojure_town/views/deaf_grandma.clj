(ns clojure-town.views.deaf-grandma
  (:use compojure.core hiccup.core)
  (:require [clojure-town.views.layout :refer :all]))

(defn passed-text
  [request]
  (let [text (get (get request :params) :text)]
    (if text
      text
      "me")))

(defn wat
  [request]
  (layout (clojure.string/upper-case (str "did you say something about " (passed-text request) "?"))))
