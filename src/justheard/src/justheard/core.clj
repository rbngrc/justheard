(ns justheard.core)

(def episodio
  {:id 1
   :titulo "El origen"
   :escuchado true})

(def episodios
  [{:id 1 :titulo "El origen"    :escuchado true}
   {:id 2 :titulo "La crisis"    :escuchado false}
   {:id 3 :titulo "El desenlace" :escuchado false}
   {:id 4 :titulo "El epílogo"   :escuchado true}])

(defn pendientes [lista]
  (remove :escuchado lista))

(defn cuantos-quedan [lista]
  (count (pendientes lista)))

(defn al-dia? [lista]
  (empty? (pendientes lista)))

(defn cuantos-escuchados [lista]
  (count (filter :escuchado lista)))

(defn marcar-escuchado [lista id]
  (map (fn [ep]
         (if (= (:id ep) id)
           (assoc ep :escuchado true)
           ep))
       lista))

(comment
  (+ 1 2)
  (str "Hola, " "Rubén")
  (count [10 20 30])
  (* 2 (+ 1 2))

  (:titulo episodio)
  (:escuchado episodio)
  (:duracion episodio)
  (assoc episodio :escuchado false)
  episodio

  (count episodios)
  (first episodios)
  (:titulo (first episodios))
  (map :titulo episodios)

  (map :escuchado episodios)
  (filter :escuchado episodios)
  (remove :escuchado episodios)

  (pendientes episodios)

  (cuantos-quedan episodios)
  (al-dia? episodios)
  (al-dia? [{:id 1 :escuchado true}])

  (cuantos-escuchados episodios)

  (= 1 1)
  (= 2 3)
  (= (:id episodio) 1)

  (if true "sí" "no")
  (if (:escuchado episodio) "escuchado" "pendiente")+

  (map (fn [ep] (str "▶ " (:titulo ep))) episodios)

  (map (fn [ep]
         (if (:escuchado ep) "✔" "·"))
       episodios)
  
  (marcar-escuchado episodios 2)
  episodios
  (cuantos-quedan (marcar-escuchado episodios 2))
  )