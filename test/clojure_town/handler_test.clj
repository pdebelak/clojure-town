(ns clojure-town.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [clojure-town.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (re-find #"DID YOU SAY SOMETHING ABOUT ME\?" (:body response)))))

  (testing "name route"
    (let [response (app (mock/request :get "/?text=Peter"))]
      (is (= (:status response) 200))
      (is (re-find #"DID YOU SAY SOMETHING ABOUT PETER\?" (:body response)))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid/route"))]
      (is (= (:status response) 404)))))
