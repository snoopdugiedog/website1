(defn cljs-home [path]
  (if-let [home (get (System/getenv) "CLOJURESCRIPT_HOME")]
    (str home path)
    (throw (Exception. "You must set the $CLOJURESCRIPT_HOME variable!"))))

(defproject website1 "0.1.0-SNAPSHOT"
            :description "FIXME: write this!"
            :dependencies [[org.clojure/clojure "1.3.0"]
                           [noir "1.2.1"]]
            :main website1.server
            :extra-classpath-dirs ~(map cljs-home
                                        ["/lib/*" "src/clj" "/src/cljs"]))

