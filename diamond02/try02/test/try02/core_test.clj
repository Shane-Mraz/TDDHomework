(ns try02.core-test
  (:require [clojure.test :refer :all]
            [try02.core :refer :all]))

(deftest char-indexing
  (testing "A"
    (is (= 0 (char-index "A"))))
  (testing "B"
    (is (= 1 (char-index "B"))))
  (testing "C"
    (is (= 2 (char-index "C"))))
  (testing "Z"
    (is (= 25 (char-index "Z")))))