(ns diamond.core)

(require '[clojure.string :as string])

(defn char-index [letter] (- (int (first (char-array letter))) 65))

;(defn print-diamond [letter] (doall (map println (diamond letter))))