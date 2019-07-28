(ns clj-crud.compras.schemas
  (:require [schema.core :as s]))

(s/defschema CadConta
  {:descricao s/Str
   :data_compra s/Str
   :valor s/Num
   :vencimento s/Str
   :observacoes s/Str})
