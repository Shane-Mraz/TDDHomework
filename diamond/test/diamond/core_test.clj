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
	
	)