(ns clojure-lisp.interpretation-test
  (:require [clojure.test :refer :all]
            [clojure-lisp.core :refer :all]))

(deftest quoting-test
  (testing "Experssion without quotes is an expression"
    (not
      (= "1" 1))))

(deftest alternatives-test
  (testing "Experssion without quotes is an expression"
    (is
      (=
         (clojure-lisp.core/foo "Say") "Say"))
    ))
