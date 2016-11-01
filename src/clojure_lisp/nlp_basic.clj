(ns clojure-lisp.nlp_basic)

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
  ])

(defn parse-noun
  [noun]

  ; (filter
  ;   (fn [x]
  ;     (some #{noun} nouns)) nouns)
  (list
    (some #{noun} nouns))
  noun)

(defn parse-verb
  [verb]

  ; (filter
  ;   (fn [x]
  ;     (some #{verb} verbs)) verbs)
  (list
    (some #{verb} verbs))
  verb)

(defn parse-word
  [words]

  (println words)
  )

; A sentence is always consists of a noun phrase, followed by a noun.
(defn sentence
  [x]

  (list
    (parse-noun "ticket")
    (parse-verb "bar"))

  )

; Parse messagse
(defn parse-all
  "Parse sentences in a certain topic"
  []

  (doseq [i messages] (sentence i))
)
