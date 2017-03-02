(ns clojure-lisp.structure)
(require '[clojure.string :as string])
(require '[clojure.set :as cset])

(defn tak
  "Tak https://en.wikipedia.org/wiki/Tak_(function)"
  [x y z]

  (if (> x y)
    (tak
      (tak (- x 1), y, z),
      (tak (- y 1), z, x),
      (tak (- z 1), x, y))
    z)

  )

; Take the source array as a vector of the elements distance
;   and length, and generates a repetition of a sub-vector of
;   the last distance characters from the source array until
;   the length is reached
; (defn expand
;   [the-vector
;     distance
;     length]
;
;   (let [end (count the-vector)
;     start (- end
;             distance)
;     pattern (subvec the-vector
;                     start
;                     end)
;     (into [] (take length
;       (cycle pattern)))
;   ])
;
;   )

(defn compressing-byte-array
  "Compressing byte array"
  [x]

  (string/split
    x #" "))


    (defn words
      [x]

      (string/split x #" "))
