(ns diamond.core)

(require '[clojure.string :as string])

(defn char-index [letter] (- (int (first (char-array letter))) 65))

(defn inner-part [letter] 
	(let [index (char-index letter)]
		(cond (= 0 index) letter
			:else (str letter (string/join "" (repeat (- (* 2 index) 1) "-")) letter))))
