(ns clojure-lisp.nlp_basic-test
  (:require [clojure.test :refer :all]
            [clojure-lisp.nlp_basic :refer :all]))

(deftest test-parse-sentences
  (testing "Simple sentences parser"
    (not
      (=
         (clojure-lisp.nlp_basic/parse-all) nil))
    ))

(deftest test-generate-something
  (testing "Should generate random sentences"
    (not
      (=
         (clojure-lisp.nlp_basic/generate-something) nil))
    ))
