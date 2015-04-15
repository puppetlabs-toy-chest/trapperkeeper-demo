(def ks-version "1.0.0")
(def tk-version "1.0.0")
(def tk-jetty9-version "1.0.0")

(defproject trapperkeeper-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :pedantic? :abort

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.2.0" :exclusions [clj-time]]
                 [cheshire  "5.3.1"]
                 [org.clojure/tools.logging "0.3.1"]
                 [puppetlabs/trapperkeeper ~tk-version]
                 [puppetlabs/trapperkeeper-webserver-jetty9 ~tk-jetty9-version]]

  :profiles {:dev {:source-paths  ["dev"]
                   :dependencies [[puppetlabs/trapperkeeper ~tk-version :classifier "test" :scope "test"]
                                  [puppetlabs/trapperkeeper-rpc "1.0.0" :exclusions [org.apache.httpcomponents/httpclient puppetlabs/trapperkeeper]]
                                  [puppetlabs/kitchensink ~ks-version :classifier "test" :scope "test"]
                                  [clj-http "0.9.2"]
                                  [org.clojure/tools.namespace "0.2.10"]
                                  [ring-mock "0.1.5"]]}}

  :repl-options {:init-ns user}

  :aliases {"tk" ["trampoline" "run" "--config" "dev-resources/config.conf"]}

  :main puppetlabs.trapperkeeper.main

  )
