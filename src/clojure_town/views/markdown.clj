(ns clojure-town.views.markdown
  (:use compojure.core hiccup.core)
  (:use ring.util.anti-forgery)
  (:use markdown.core)
  (:require [ring.util.response :as response]
            [clojure-town.views.layout :refer :all]))

(defn write
  [request]
  (layout (html [:div.row [:div.col-sm-8 [:form { :method "POST" :action "/" } (anti-forgery-field)
  [:div.form-group [:label {:for "text"} "Type text here:"]
  [:textarea.form-control {:name "text" :autofocus true :rows 15}]]
  [:input.btn.btn-success {:type "submit"}]]]
  [:div.col-sm-4 [:p "Practice your markdown here"]]])))

(defn show
  [request]
  (layout (html [:p [:a {:href "/"} "Markdown again"]]
  (md-to-html-string (get-in request [:params :text])))))
