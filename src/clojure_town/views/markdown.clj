(ns clojure-town.views.markdown
  (:use compojure.core hiccup.core)
  (:use ring.util.anti-forgery)
  (:require [ring.util.response :as response]
            [clojure-town.views.layout :refer :all]
            [clojure-town.processors.markdown :refer :all]))

(defn write
  [request]
  (layout (html [:div.row [:div.col-sm-6 [:form { :method "POST" :action "/" } (anti-forgery-field)
  [:div.form-group [:label {:for "text"} "Type text here:"]
  [:div#editor.form-control]]]]
  [:div#md-target.col-sm-6 ]])))

(defn show
  [request]
  (to-markdown (get-in request [:params :text])))
