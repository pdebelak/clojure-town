(ns clojure-town.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [clojure-town.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (re-find #"DID YOU SAY SOMETHING ABOUT ME\?" (:body response)))))

  (testing "post name route"
    (let [response (app (mock/request :post "/" {:text "Peter" :__anti-forgery-token "value"}))]
      (is (= (:status response) 302))))

  (testing "name route"
    (let [response (app (mock/request :get "/Peter"))]
      (is (= (:status response) 200))
      (is (re-find #"DID YOU SAY SOMETHING ABOUT PETER\?" (:body response)))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid/route"))]
      (is (= (:status response) 404)))))
