(ns clojure-town.processors.game-of-life-test
  (:require [clojure.test :refer :all]
            [clojure-town.processors.game-of-life :refer :all]))

(deftest game-of-life
  (testing "next-step"
    (is (= (next-step [[0 0 0] [0 0 0] [0 0 0]]) [[0 0 0] [0 0 0] [0 0 0]]))
    ;; (is (= (next-step [[1 1 1] [0 0 0] [0 0 0]]) [[0 1 0] [0 1 0] [0 0 0]]))
    )
  (testing "live-neighbors"
    (is (= (live-neighbors 0 0 [[0 0 0] [0 0 0] [0 0 0]]) 0))
    (is (= (live-neighbors 0 0 [[1 0 0] [0 0 0] [0 0 0]]) 0))
    (is (= (live-neighbors 0 0 [[0 1 0] [0 0 0] [0 0 0]]) 1))
    )
  )
