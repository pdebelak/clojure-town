(ns clojure-town.views.layout
  (:use compojure.core hiccup.core hiccup.page))

(defn layout
  [content]
  (html5 [:head
         [:meta {:charset "utf-8"}]
         [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge"}]
         [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
         [:title "Clojure Town"]]
         [:link {:rel "stylesheet" :href "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"}]
         [:body
         [:div.container
         [:header
         [:h1 "Clojure Town"]
         content]]
         [:script {:src "submit.js"}]]))
