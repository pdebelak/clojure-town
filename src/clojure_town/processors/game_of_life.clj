(ns clojure-town.processors.game-of-life)

(defn- map-with-indices
  [coll]
  (map-indexed (fn [idx itm] [idx itm]) coll))

(defn- map-board-with-indices
  [board]
  (map-with-indices (map-with-indices board)))

(defn live-neighbors
  [row col board]
  0)

(defn next-step
  [board]
  [[0 0 0] [0 0 0] [0 0 0]])
