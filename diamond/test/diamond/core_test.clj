(ns diamond.core-test
  (:require [clojure.test :refer :all]
            [diamond.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is not(= 0 1))))

; Defining character index
(deftest char-indexing
	(testing "A"
		(is (= 0 (char-index "A"))))
	(testing "B"
		(is (= 1 (char-index "B"))))
	(testing "Z"
		(is (= 25 (char-index "Z"))))
	)
;Test for the inner portion of the diamond
(deftest inner-part-building
	(testing "A"
		(is (= "A" (inner-part "A"))))
	(testing "B"
		(is (= "B-B" (inner-part "B"))))
	)
