(ns clj-crud.cad
  (:require [clojure.java.jdbc :as j]
            [clj-crud.conector.conn :as db]))


(defn cadastrar
  [title description]
  (j/insert-multi! db/mysql-db :items
                 [{:title title :description description}]))

(defn consultar []
  (j/query db/mysql-db '["select * from clojure.items"]))

(defn editar
  [id title description]
  (j/update! db/mysql-db :items
             {:title title :description description}
             ["id = ?" id]))

(defn deletar
  [id]
  (j/delete! db/mysql-db :items
             ["id = ?" id]))
