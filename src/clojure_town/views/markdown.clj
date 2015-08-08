(ns clojure-town.views.markdown
  (:use compojure.core hiccup.core)
  (:use ring.util.anti-forgery)
  (:use markdown.core)
  (:require [ring.util.response :as response]
            [clojure-town.views.layout :refer :all]))

(defn write
  [request]
  (layout (html [:div.row [:div.col-sm-6 [:form { :method "POST" :action "/" } (anti-forgery-field)
  [:div.form-group [:label {:for "text"} "Type text here:"]
  [:textarea#md.form-control {:name "text" :autofocus true :rows 15}]]]]
  [:div#md-target.col-sm-6 ]])))

(defn show
  [request]
  (md-to-html-string (get-in request [:params :text])))
