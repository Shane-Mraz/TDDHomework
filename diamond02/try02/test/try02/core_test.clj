(ns try02.core-test
  (:require [clojure.test :refer :all]
            [try02.core :refer :all]))

(deftest char-indexing
  (testing "A"
    (is (= 0 (char-index "A"))))
  (testing "B"
    (is (= 1 (char-index "B"))))
  (testing "C"
    (is (= 2 (char-index "C")))))

(deftest inner-part-building
  (testing "A"
    (is (= "A" (inner-part "A"))))
  (testing "B"
    (is (= "B-B" (inner-part "B")))))

(deftest outer-part-building
  (testing "A for A diamond"
    (is (= "" (outer-part "A" "A"))))
  (testing "A for B diamond"
  	(is (= "-" (outer-part "A" "B")))))

