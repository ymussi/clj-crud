(ns clj-crud.api
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [schema.core :as s]
            [ring.util.http-response :refer :all]
            [org.httpkit.server :as httpkit]
            [clj-crud.cad :as crud]
            [clj-crud.compras.cad :as gerenciador]
            [clj-crud.schemas :refer :all]
            [clj-crud.compras.schemas :refer :all]
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
           :summary "Busca cadastro na base."
           :body [user FindUser]
           (ok (crud/buscar (:id user))))

      (POST "/cadastrar" []
            :summary "cadastrar um usuario"
            :body [user CadUser]
            (ok (crud/cadastrar  (:title user) (:description user))))

      (PUT "/editar" []
            :summary "Atualizar um cadastro."
            :body [user Edituser]
            (ok (crud/editar (:id user) (:title user) (:description user))))

      (DELETE "/deletar" []
            :summary "Deleta um usuario"
            :body [user DeleteUser]
            (ok (crud/deletar (:id user))))
      )

    (context "/gerenciador" []
      :tags ["gerenciador"]

      (POST "/cadastrar" []
            :summary "Cadstrar Contas"
            :body [contas CadConta]
            (ok (gerenciador/cadastrar (:descricao contas)
                                       (:data_compra contas)
                                       (:valor contas)
                                       (:vencimento contas)
                                       (:observacoes contas)))))))

(defn -main []
  (httpkit/run-server #'app {:port 17000})
  (println "Server started on: localhost:17000"))