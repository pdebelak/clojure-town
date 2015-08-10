(ns clojure-town.views.game-of-life
  (:use compojure.core hiccup.core)
  (:use ring.util.anti-forgery)
  (:require [ring.util.response :as response]
            [clojure-town.views.layout :refer :all]
            [clojure-town.processors.game-of-life :refer :all]
            [clojure.data.json :as json]
            [clojure-town.processors.markdown :refer :all]))

(defn- render-life
  [board]
  (html (map (fn [row] [:div.row.life (map (fn [cell] (if (= cell 1) [:div.life-cell.alive] [:div.life-cell])) row)]) board)))

(defn- starting-board
  []
  (let [size 40]
  (take size (repeat (take size (repeat 0))))))

(defn life
  [request]
  (layout (html [:div#start-button.btn.btn-success "Start"] [:p "&nbsp;"]
                [:div.row [:div#life-container.col-sm-12
                           (render-life (starting-board))]]
                           (anti-forgery-field) [:script {:src "/life.js"}])))

(defn next-life
  [request]
  (render-life (next-step (json/read-str (get-in request [:params :board])))))
