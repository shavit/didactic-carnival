(ns clojure-lisp.nlp_basic)
(require '[clojure.string :as string])

(def messages
  [
    "Find a cheap flight from Paris to London"
    "Find a cheap flight from London to Paris"
    "Find a flight today from Paris to NYC"
    "Can you find today a flight to JFK from Miami?"
  ])

; First word is the part of speech
(def nouns
  ["noun"
  "plan"
  "plane"
  "ticket"
  "tickets"
  "flight"
  "flights"
  "booking"
  "airport"
  "airports"
  "city"
  "country"
  "state"
  ])

; First word is the part of speech
(def verbs
  ["verb"
  "fly"
  "booking"
  "book"
  "schedule"
  "hold"
  "accept"
  "cancel"
  "fast"
  "cheap"
  "today"
  "tomorrow"
  "find"
  ])

(defn parse-noun
  "Decide if it is a noun"
  [noun]

  (filter
    (fn [x]
      (= x noun))
    nouns))


(defn parse-verb
  "Decide if it is a verb"
  [verb]

  (filter
    (fn [x]
      (= x verb))
    verbs))

(defn words
  [x]

  (string/split x #" "))

; A sentence is always consists of a noun phrase, followed by a noun.
(defn sentence
  "Parse a sentence into lists of verbs and nouns"
  [x]

  ; (printf "Sentence: %s" x)

  (list
    (map
      (fn [word]
        (parse-noun word))
      (words x))
    (map
      (fn [word]
        (parse-verb word))
      (words x))
    )

  )

; Parse messagse
(defn parse-all
  "Parse sentences in a certain topic"
  []

  ; (doseq [i messages] (sentence i))
  ; (println
    (for
      [i messages]
      (sentence i))
    ; )
)

; Generate random sentences from the messages/
(defn generate-something
  []

  (println
    (let
      [maps
        (for
          [messages messages] (fn [x]
            (for
              [p
                (partition 2 1 (remove
                  #(= "" %) x))
              ]
              {(first p) [(second p)]})
            ))
      ]
      maps)
  )

  [])

; (defn generate-something
;    []

; (let
;   [maps
;     (for
;       [line
;         (string/split messages #"\s+")
;         m (let
;             [l (str line ".")
;             words
;             (cons :start (string/split l #"\s+"))]
;           (for
;             [p (partition 2 1 (remove #(= "" %) words))]
;             {(first p) [(second p)]}))]
;     m)
;   ]
;
