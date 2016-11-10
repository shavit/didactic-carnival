(ns clojure-lisp.structure)

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
