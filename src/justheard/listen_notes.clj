(ns justheard.listen-notes
  (:require [babashka.http-client :as http]
            [clojure.data.json :as json]))

(def url-base "https://listen-api.listennotes.com/api/v2")

(defn api-key []
  (System/getenv "LISTEN_NOTES_API_KEY"))

(defn buscar-podcasts [termino]
  (let [respuesta (http/get (str url-base "/search")
                            {:headers      {"X-ListenAPI-Key" (api-key)}
                             :query-params {"q"    termino
                                            "type" "podcast"}})]
    (json/read-str (:body respuesta) :key-fn keyword)))

(comment
  (some? (api-key))
  (def resultado (buscar-podcasts "fitness revolucionario"))
  (keys resultado)
  (:total resultado)
  (map :title_original (:results resultado)))