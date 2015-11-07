(ns diamond.core-test
  (:require [clojure.test :refer :all]
            [diamond.core :refer :all]))

; Defining letter position
(deftest position-of-a
  (is (= 1 (position-of \a))))

(deftest position-of-z
  (is (= 26 (position-of \z))))

;(deftest no-dashes
; (is (= () (dashes 0))))

;(defttest one-dash
;  (is (= (seq "-") (dashes 1))))

;(deftest five-dahses
;  (is (= (seq "-----") (dashes 5))))




; Defining character index
;(deftest char-indexing
;	(testing "a"
;		(is (= 1 (char-index "a"))))
;	(testing "b"
;		(is (= 2 (char-index "b"))))
;	(testing "z"
;		(is (= 26 (char-index "z"))))
;	)

;Test for the inner portion of the diamond
;(deftest inner-part-building
;	(testing "a"
;		(is (= "a" (inner-part "a"))))
;	(testing "b"
;		(is (= "b-b" (inner-part "b"))))
;	)
