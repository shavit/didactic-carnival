(ns clojure-lisp.structure-test
  (:require [clojure.test :refer :all]
            [clojure-lisp.structure :refer :all]))

; (deftest test-parse-sentences
;   (testing "Tak 3,2,1"
;
;     (print (clojure-lisp.structure/tak 30 20 10))
;
;     (not
;       (=
;          (clojure-lisp.structure/tak 1 2 3) nil))
;     ))

(deftest test-un-LZ77
  (testing "un-LZ77"

    (not
      (=
        (clojure-lisp.structure/un-LZ77 "hello")
        nil))

    ))

(deftest test-compressing-byte-array
  (testing "Compressing byte array"

    (not
      (=
         (clojure-lisp.structure/compressing-byte-array "Hello")
          nil))
    ))
