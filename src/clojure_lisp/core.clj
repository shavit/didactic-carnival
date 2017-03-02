(ns clojure-lisp.core)

(defn start-app
  [args]
  (println "Starting app"))

(defn -main
  "Starting the app with argumens"
  [& args]
  (start-app args)
  )
