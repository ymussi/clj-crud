(defproject clj-crud "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [metosin/compojure-api "1.1.11"]
                 [org.clojure/java.jdbc "0.6.0"]
                 [mysql/mysql-connector-java "5.1.46"]]
  :ring {:handler clj-crud.api/app}
  :uberjar-name "server.jar"
  :target-path "target/%s"
  :profiles {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]]
                   :plugins [[lein-ring "0.12.5"]]}})
