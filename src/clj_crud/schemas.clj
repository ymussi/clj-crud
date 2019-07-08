(ns clj-crud.schemas
  (:require [schema.core :as s]))

(s/defschema CadUser
  {:title s/Str
   :description s/Str})

(s/defschema Edituser
  {:id s/Int
   :title s/Str
   :description s/Str})

(s/defschema DeleteUser
  {:id s/Int})

(s/defschema FindUser
  {:id s/Int})

