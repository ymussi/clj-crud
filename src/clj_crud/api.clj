(ns clj-crud.api
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [schema.core :as s]
            [clj-crud.cad :as crud]
            [clj-crud.schemas :refer :all]
           ))

(def app
  (api
    {:swagger
     {:ui "/"
      :spec "/swagger.json"
      :data {:info {:title "CRUD-API"
                    :description "Compojure Api example"}
             :tags [{:name "api", :description "some apis"}]}}}

    (context "/api" []
      :tags ["api"]

      (GET "/consultar" []
           :summary "consultar cadastros na base."
           (ok (crud/consultar)))

      (POST "/cadastrar" []
            :return CadUser
            :summary "cadastrar um usuario"
            :body [user CadUser]
            (ok (crud/cadastrar  (:title user) (:description user))))
      )))




