(ns diamond.core)

(require '[clojure.string :as string])

(def alphabet "abcdefghijklmnopqrstuvwxyz")

(defn position-of [letter] (inc (- (int letter) (int \a))))

(defn dashes [n] (repeat n \-))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn drop-first-column [sequence-of-sequences-of-chars]
  (map rest sequence-of-sequences-of-chars))

(defn drop-first-row [sequence-of-sequences-of-chars]
  (drop 1 sequence-of-sequences-of-chars))

(defn reverse-every-row [sequence-of-sequences-of-chars]
  (map reverse sequence-of-sequences-of-chars))

(defn core-letter-pattern-for [letter]
  (concat
    (dashes (dec (position-of letter)))
    (list letter)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn core-right-quadrant-pattern-for [letter]
  (map core-letter-pattern-for (take (position-of letter) alphabet)))

(defn trailing-dashes-appender-for [max-dash-count]
  (fn [index line]
    (concat
      line
      (dashes (dec (- max-dash-count index))))))

(defn flip-bottom-up [top-half-of-diamond]
  (reverse top-half-of-diamond))

(defn join-together-side-by-side [top-left-quadrant top-right-quadrant]
  (map concat top-left-quadrant top-right-quadrant))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn create-top-right-quadrant-for [letter]
  (let [number-of-letters (position-of letter)]
    (map-indexed (trailing-dashes-appender-for number-of-letters) (core-right-quadrant-pattern-for letter))))

(defn drop-first-column-and-reverse-every-row-of [top-right-quadrant]
  (->> top-right-quadrant
       drop-first-column
       reverse-every-row))

(defn flip-bottom-up-and-drop-first-row-of [top-half-of-diamond]
  (drop-first-row (flip-bottom-up top-half-of-diamond)))

(defn put-one-on-top-of-the-other [top-half-of-diamond bottom-half-of-diamond]
  (concat top-half-of-diamond bottom-half-of-diamond))

(defn strings-for [sequences-of-chars]
  (map #(apply str %) sequences-of-chars))

(defn display [sequence-of-sequences-of-chars]
  (doseq [line (strings-for sequence-of-sequences-of-chars)]
    (println line)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn print-diamond [letter]
  (let [top-right-quadrant (create-top-right-quadrant-for letter)
        top-left-quadrant (drop-first-column-and-reverse-every-row-of top-right-quadrant)
        top-half-of-diamond (join-together-side-by-side top-left-quadrant top-right-quadrant)
        bottom-half-of-diamond (flip-bottom-up-and-drop-first-row-of top-half-of-diamond)
        diamond (put-one-on-top-of-the-other top-half-of-diamond bottom-half-of-diamond)]
    (display diamond)))

(defn -main []
  (print-diamond \E))