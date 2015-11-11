(ns try02.core-test
  (:require [clojure.test :refer :all]
            [try02.core :refer :all]))

(deftest char-indexing
  (testing "a"
    (is (= 0 (char-index "a"))))
  (testing "b"
    (is (= 1 (char-index "b"))))
  (testing "c"
    (is (= 2 (char-index "c")))))

(deftest inner-part-building
  (testing "a"
    (is (= "a" (inner-part "a"))))
  (testing "b"
    (is (= "b-b" (inner-part "b")))))

(deftest outer-part-building
  (testing "a for a diamond"
    (is (= "" (outer-part "a" "a"))))
  (testing "a for b diamond"
  	(is (= "-" (outer-part "a" "b")))))

;(deftest line-building
;  (testing "a for a diamond"
;    (is (= "a" (line-for "a" "a"))))
;  (testing "a for b diamond"
;   (is (= "-a-" (line-for "a" "b"))))
;  )
