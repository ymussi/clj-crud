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

      (POST "/buscar" []
           :return FindUser
           :summary "Busca cadastro na base."
           :body [user FindUser]
           (ok (crud/buscar (:id user))))

      (POST "/cadastrar" []
            :return CadUser
            :summary "cadastrar um usuario"
            :body [user CadUser]
            (ok (crud/cadastrar  (:title user) (:description user))))

      (PUT "/editar" []
            :return Edituser
            :summary "Atualizar um cadastro."
            :body [user Edituser]
            (ok (crud/editar (:id user) (:title user) (:description user))))

      (DELETE "/deletar" []
            :return DeleteUser
            :summary "Deleta um usuario"
            :body [user DeleteUser]
            (ok (crud/deletar (:id user))))
      )))




