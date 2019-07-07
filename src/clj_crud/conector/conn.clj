(ns clj-crud.conector.conn
  (:require [clojure.java.jdbc :as j]
            [clojure.string :as str]))

; create a db connection
(def mysql-db {:dbtype "mysql"
               :dbname "clojure"
               :user "root"
               :password ""})


(defn cadastrar
  [title description]
  (j/insert-multi! mysql-db :items
                 [{:title title :description description}]))

(defn consultar []
  (j/query mysql-db '["select * from clojure.items"]))

(defn editar
  [id title description]
  (j/update! mysql-db :items
             {:title title :description description}
             ["id = ?" id]))

(defn deletar
  [id]
  (j/delete! mysql-db :items
             ["id = ?" id]))

