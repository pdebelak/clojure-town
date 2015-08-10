(ns clojure-town.processors.game-of-life)

(defn- get-neighboring
  [index coll]
  (map (fn [index] (get coll index)) [(dec index) index (inc index)]))

(defn- neighbors
  [row col board]
  (flatten (map (fn [row] (get-neighboring col row)) (get-neighboring row board))))

(defn- alive?
  [cell]
  (= 1 cell))

(defn live-neighbors
  [row col board]
  (let [count-including-self (count (filter alive? (neighbors row col board)))]
    (if (alive? (get (get board row) col))
      (dec count-including-self)
      count-including-self)))

(defn next-step
  [board]
  (map-indexed (fn [row-index row]
         (map-indexed (fn [col-index col]
                (if (= (live-neighbors row-index col-index board) 2)
                  (if (alive? (get (get board row-index) col-index))
                    1 0)
                  (if (= (live-neighbors row-index col-index board) 3)
                    1 0))) row)) board))
