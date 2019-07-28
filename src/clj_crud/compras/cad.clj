(ns clj-crud.compras.cad
  (:require [clojure.java.jdbc :as j]
            [clj-crud.conector.conn :as db]
            ))

(defn cadastrar
  [descricao data_compra valor vencimento observacoes]
  (j/insert-multi! db/mysql-db-pessoal :gerenciador
                   [{:descricao descricao
                     :data_compra data_compra
                     :valor valor
                     :vencimento vencimento
                     :data_criacao (.format (java.text.SimpleDateFormat. "yyyy-MM-dd") (new java.util.Date))
                     :observacoes observacoes}]))


