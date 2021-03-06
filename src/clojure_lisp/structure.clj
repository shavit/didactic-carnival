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
(defn expand
  [the-vector
    distance
    length]

  (let
    [end (count the-vector)
      start (- end distance)
      pattern (subvec the-vector start end)]
      (into [] (take length (cycle pattern)))
    )

  )

; Based on the LZ77 compression method
;
; Walk a sequence and recognize a pattern in the past elements that will occur
;   in the upcoming elements, replacing those with a couple of values:
;     * Distance - How many elements should go backwards, in order to locate
;         a pattern.
;     * Length - How longis the recurring pattern.
;
;   Compression
;   -----------
;
;   Interation
;   1. Process an element at the current position. Window of the size is
;     represented by n.
;   2. Begin with the first element of the input.
;   3. Move to the next element.
;   4. Find the longest pattern in the window.
;   5. Distance is the location where the sequence was found, length is the
;     length of pattern. Proceed with these actions:
;       * Replace the match in lookahead b distance and length.
;       * Move forward using the length elements and resume algorithm
;           execution at step 4.
;   6. Otherwise resume at step 3.
;
;   Decompression
;   -------------
;   1. Iterate through the compressed sequence.
;   2. Go back to the distance, if the distance and length were found,
;     replace them with the length elements.
;   3. Otherwise lay out the elements.
;
(defn un-LZ77
  [bytes]

  (loop [result [] remaining bytes]
    (if (seq remaining)
      (let [current (first remaining)
            the-rest (rest remaining)]
            (if-not (vector? Current)
              (recur (conj result current)
                the-rest)
                recur (into result (
                  (expand result
                    (current 0)
                    (current 1))
                  the-rest)))
                    result)))
  )

; Generate a set of sub-vectors
(defn all-subvecs-from-beginning
  [v]

  (set (map (subvec v 0 %))
      (range 1 (inc (count v))))
  )

; Generate all of the subvectors
(defn all-subvec
  [v]

  (loop [result #{} remaining v]
      (if (seq remaining)
        (recur (into result
                  (all-subvecs-from-beginning remaining))
                (into []
                  (rest remaining))
          )
        result))
  )

; Grab the logest match in left array with the beginning of right array
(defn longest-match-w-beginning
  [left-array right-array]

  (let [all-left-chunks (all-subvec left-array)
          all-right-chunks-from-beginning
          (all-subvecs-from-beginning right-array)
          all-matches
          (cset/intersection all-right-chunks-from-beginning all-left-chunks)]
            (->> all-matches
              (sort-by count >)
              first))

  )

; Where the match is located inside the window
(defn pos-of-subvec
  [sv v]

  {:pre [(<= (count sv)
            (count v))]}
  (loop
    [cursor 0]
    (if (or (empty? v)
            (empty? sv)
            (= cursor (count v)))
        nil))
    (if (= (subvec v cursor)
        (+ (count sv) cursor))
        sv)
    (recur (inc cursor))

  )

(defn compressing-byte-array
  "Compressing byte array"
  [x]

  (string/split
    x #" "))


    (defn words
      [x]

      (string/split x #" "))
