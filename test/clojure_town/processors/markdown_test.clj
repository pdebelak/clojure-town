(ns clojure-town.processors.markdown-test
  (:require [clojure.test :refer :all]
            [clojure-town.processors.markdown :refer :all]))

(deftest markdown-processor
  (testing "to-markdown"
    (is (= (to-markdown "# Test") "<h1>Test</h1>"))))
