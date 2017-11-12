(ns text-tokenization.lines_of_tokens_test
  (:require [clojure.test :refer :all])
  (:require [text-tokenization.lines-of-tokens :refer :all]))

(def test-matrix-1 '(("a" "b") ("c" "d")))
(def test-matrix-numbers '((1 2) (3 4)))


(deftest get-token-at-test
  (testing
    "In a matrix of Strings, it should return the string value at a cell"
    (is (= (get-token-at 1 1 test-matrix-1) "d"))))

(deftest cell-out-of-matrix-returns-empty-string-x-outside-range-test
  (testing
    "Throws OutOfBounds exception when getting cell outside ranges of matrix"
    (is (= (get-token-at 10 1 test-matrix-1) ""))))

(deftest cell-out-of-matrix-returns-empty-string-y-outside-range-test
  (testing
    "Throws OutOfBounds exception when getting cell outside ranges of matrix"
    (is (= (get-token-at 1 10 test-matrix-1) ""))))


(deftest get-token-at-gets-Number-value-test
  (testing
    "Throws OutOfBounds exception when getting cell outside ranges of matrix"
    (is (= (get-token-at 1 1 test-matrix-numbers) 4))))

(deftest to-lines-of-tokens-test
  (testing
    "A two lines text with 2 words in each row is converted to a matrix 2 by 2"
    (is (= (to-lines-of-tokens "one two \n three four") '(("one" "two") ("three" "four"))))))

(deftest to-lines-of-tokens-filters-out-spaces-test
  (testing
    "A two lines text with 2 numbers in each row is converted to a matrix 2 by 2"
    (is (= (to-lines-of-tokens "   1   2  \n  3  4   ") (list (list "1" "2") (list "3" "4"))))))

(deftest to-lines-of-tokens-with-different-amount-of-words-per-line-test
  (testing
    "A two lines text with 1 number in first row and 2 numbers in each row is converted to a matrix."
    (is (= (to-lines-of-tokens "1\n3 4") (list (list "1") (list "3" "4"))))))

(deftest to-lines-of-tokens-with-different-amount-of-words-per-line-filters-out-spaces-test
  (testing
    "A two lines text with 1 number in first row and 2 numbers in each row is converted to a matrix."
    (is (= (to-lines-of-tokens " 1 \n 3 4 ") (list (list "1") (list "3" "4"))))))

(deftest to-lines-of-tokens-test-with-empty-string
  (testing
    "Should return empty list for empty string"
    (is (empty? (to-lines-of-tokens "")))))