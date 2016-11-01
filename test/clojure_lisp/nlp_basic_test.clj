(ns clojure-lisp.nlp_basic-test
  (:require [clojure.test :refer :all]
            [clojure-lisp.nlp_basic :refer :all]))

(deftest parse-sentences
  (testing "Simple sentences parser"
    (not
      (=
         (clojure-lisp.nlp_basic/parse-all) nil))
    ))
