(ns clojure-town.handler
  (:use compojure.core hiccup.core)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clojure-town.views.markdown :refer :all]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] write)
  (POST "/" [] show)
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
